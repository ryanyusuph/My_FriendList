package ryan.com.google.projek_uas.Fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ryan.com.google.projek_uas.R;


public class Teman_Adapter extends RecyclerView.Adapter<Teman_Adapter.MyViewHolder> {
    /*
  NIM    : 10116109
  Nama   : Ryan Yusup Hendriawan
  Kelas  : IF-3
  Tanggal Penulisan : 8 - 14 Agustus 2019
 */
    private List<teman> teman_models;
    Context context;
    FragmentManager fragmentManager;

    public Teman_Adapter(Context context, List<teman> teman_models){
        this.context = context;
        this.teman_models = teman_models;
    }

    @Override
    public Teman_Adapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.customlayout, parent, false);

        return new MyViewHolder(v);

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(Teman_Adapter.MyViewHolder holder, int position) {

        final teman model = teman_models.get(position);
        holder.nim.setText(model.getNim().toString());
        holder.nama.setText(model.getNama());
        holder.kelas.setText(model.getKelas());
        holder.telepon.setText(model.getTelepon());
        holder.email.setText(model.getEmail());
        holder.sosmed.setText(model.getSosmed());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle data = new Bundle();
                Fragment fragment = new DetailFragment();
                data.putInt("id", model.getId());
                data.putString("nim", model.getNim().toString());
                data.putString("nama", model.getNama());
                data.putString("kelas", model.getKelas());
                data.putString("telepon", model.getTelepon());
                data.putString("email", model.getEmail());
                data.putString("sosmed", model.getSosmed());

                fragment.setArguments(data);

                //getSupportFragmentManager().beginTransaction().replace(R.id.tempat_fragment,new DetailFragment()).commit();
                FragmentManager fragmentManager = ((FragmentActivity) v.getContext()).getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.tempat_fragment, fragment).commit();

            }
        });
    }

    @Override
    public int getItemCount() {
        return teman_models.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView nim, nama, kelas, telepon, email , sosmed;

        public MyViewHolder(View itemView){
            super(itemView);
            nim = itemView.findViewById(R.id.tvNim);
            nama = itemView.findViewById(R.id.tvNama);
            kelas = itemView.findViewById(R.id.tvKelas);
            telepon = itemView.findViewById(R.id.tvTelepon);
            email = itemView.findViewById(R.id.tvEmail);
            sosmed = itemView.findViewById(R.id.tvSosmed);

        }
    }

}
