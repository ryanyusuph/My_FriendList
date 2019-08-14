package ryan.com.google.projek_uas.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import ryan.com.google.projek_uas.R;
import ryan.com.google.projek_uas.RealmHelper;


public class TemanFragment extends Fragment {
    /*
      NIM    : 10116109
      Nama   : Ryan Yusup Hendriawan
      Kelas  : IF-3
      Tanggal Penulisan : 8 - 14 Agustus 2019
     */
    Realm realm;
    RealmHelper realmHelper;
    RecyclerView recyclerView;
    Teman_Adapter temanAdapter;
    List<teman> teman_models;
    Button btn_linkna ;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View ciewna= inflater.inflate(R.layout.fragment_teman,container,false);

        btn_linkna = ciewna.findViewById(R.id.btn_link_tambah);

        recyclerView = (RecyclerView)ciewna.findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setLayoutManager(layoutManager);

        // Setup Realm
        Realm.init(this.getActivity());
        RealmConfiguration configuration = new RealmConfiguration.Builder().build();
        realm = Realm.getInstance(configuration);

        realmHelper = new RealmHelper(realm);
        teman_models = new ArrayList<>();
        teman_models = realmHelper.getAllTeman();
        show();

        btn_linkna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.tempat_fragment,new FormFragment()).commit();
            }
        });

        return ciewna;
    }

    @Override
    public void onResume() {
             super.onResume();
              temanAdapter.notifyDataSetChanged();
             show();
    }

    public void show(){
        temanAdapter = new Teman_Adapter(this.getActivity(), teman_models);
        recyclerView.setAdapter(temanAdapter);
    }


}




