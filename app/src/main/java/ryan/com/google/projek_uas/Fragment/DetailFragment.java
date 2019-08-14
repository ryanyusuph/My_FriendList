package ryan.com.google.projek_uas.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import ryan.com.google.projek_uas.R;
import ryan.com.google.projek_uas.RealmHelper;

import ryan.com.google.projek_uas.Fragment.TemanFragment;

public class DetailFragment extends Fragment implements View.OnClickListener {

    /*
  NIM    : 10116109
  Nama   : Ryan Yusup Hendriawan
  Kelas  : IF-3
  Tanggal Penulisan : 8 - 14 Agustus 2019
 */

    EditText etNim, etNama, etKelas, etTelepon, etEmail, etSosmed;
    String nim, nama, kelas, telepon, email, sosmed;
    Integer id;
    Button btn_ubah, btn_hapus, btn_kembali;
    RealmHelper realmHelper;
    Realm realm;


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View ciewna = inflater.inflate(R.layout.fragment_detail, container, false);

        // Set up
        Realm.init(this.getActivity());
        RealmConfiguration configuration = new RealmConfiguration.Builder().build();
        realm = Realm.getInstance(configuration);
        realmHelper = new RealmHelper(realm);

        // Inisialisasi
        etNim = ciewna.findViewById(R.id.etNim);
        etNama = ciewna.findViewById(R.id.etNama);
        etKelas = ciewna.findViewById(R.id.etKelas);
        etTelepon = ciewna.findViewById(R.id.etTelepon);
        etEmail = ciewna.findViewById(R.id.etEmail);
        etSosmed = ciewna.findViewById(R.id.etSosmed);
        btn_ubah = ciewna.findViewById(R.id.btnUpdate);
        btn_hapus = ciewna.findViewById(R.id.btnHapus);
        btn_kembali = ciewna.findViewById(R.id.btnCancel);

        Bundle data = this.getArguments();
        if (data != null) {
            id = data.getInt("id", 0);
            nim = (data.getString("nim", "nimnya"));
            nama = data.getString("nama", "namanya");
            kelas = data.getString("kelas", "kelasnya");
            telepon = data.getString("telepon", "teleponnya");
            email = data.getString("email", "emailnya");
            sosmed = data.getString("sosmed", "sosmednya");

            this.etNim.setText(data.getString("nim", "nimnya"));
            this.etNama.setText(data.getString("nama", "namanya"));
            this.etKelas.setText(kelas);
            this.etTelepon.setText(telepon);
            this.etEmail.setText(email);
            this.etSosmed.setText(sosmed);
        }
            btn_kembali.setOnClickListener(this);
            btn_hapus.setOnClickListener(this);
            btn_ubah.setOnClickListener(this);

        return ciewna;
    }

    @Override
    public void onClick(View v) {

        if (v == btn_ubah){

            if (etNim.getText().length() < 1 ) {
                etNim.setError("NIM Tidak Boleh Kosong ! ");
                etNim.requestFocus();;
            } else if(etNim.getText().toString().length() > 8 ){
                etNim.setError("NIM Tidak Boleh Lebih dari 8 digit ! ");
                etNim.requestFocus();
            } else if(etNama.getText().toString().length() < 1  ){
                etNama.setError("Nama Tidak Boleh Kosong ! ");
                etNama.requestFocus();
            } else if(etKelas.getText().toString().length() < 1 ){
                etKelas.setError("Kelas Tidak Boleh Kosong ! ");
                etKelas.requestFocus();
            } else if(etTelepon.getText().toString().length() < 1 ){
                etTelepon.setError("No Telepon Tidak Boleh Kosong ! ");
                etTelepon.requestFocus();
            } else if(etEmail.getText().toString().length() < 1 ) {
                etEmail.setError("Email Tidak Boleh Kosong ! ");
                etEmail.requestFocus();
            } else if(etSosmed.getText().toString().length() < 1 ) {
                etSosmed.setError("Sosial Media Tidak Boleh Kosong ! ");
                etSosmed.requestFocus();;
            }

            else {

                realmHelper.update(id, Integer.parseInt(etNim.getText().toString()), etNama.getText().toString(), etKelas.getText().toString(), etTelepon.getText().toString(), etEmail.getText().toString(), etSosmed.getText().toString());
                Toast.makeText(DetailFragment.this.getActivity(), "Update Success", Toast.LENGTH_SHORT).show();
                etNim.setText("");
                etNama.setText("");
                etKelas.setText("");
                etTelepon.setText("");
                etEmail.setText("");
                etSosmed.setText("");
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.tempat_fragment,new TemanFragment()).commit();
            }
        }else if (v == btn_hapus) {
            realmHelper.delete(id);
            Toast.makeText(DetailFragment.this.getActivity(), "Delete Success", Toast.LENGTH_SHORT).show();
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.tempat_fragment,new TemanFragment()).commit();
        }else if (v == btn_kembali) {
//            startActivity(new Intent(DetailFragment.this.getActivity(), TemanFragment.class));
//            getActivity().finish();
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.tempat_fragment,new TemanFragment()).commit();
        }
    }

}


