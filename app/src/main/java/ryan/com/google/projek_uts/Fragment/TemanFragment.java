package ryan.com.google.projek_uts.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import ryan.com.google.projek_uts.MainActivity;
import ryan.com.google.projek_uts.R;

public class TemanFragment extends Fragment {
    /*
  NIM    : 10116109
  Nama   : Ryan Yusup Hendriawan
  Kelas  : IF-3
  Tanggal Pembuatan : 20 - 21 Mei 2019
 */
    private RecyclerView recyclerView;
    private AdapterRecyclerView adapter;
    private ArrayList<teman> temanArrayList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View ciewna= inflater.inflate(R.layout.fragment_teman,container,false);

        addData();

        recyclerView = (RecyclerView)ciewna.findViewById(R.id.recycler_view);

        adapter = new AdapterRecyclerView(temanArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);

        return ciewna;
    }


    private void addData() {
        temanArrayList = new ArrayList<>();
        temanArrayList.add(new teman("Ryan Yusup H.", "Panorama Lembang No.97", "085795709878"));
        temanArrayList.add(new teman("M. Rahmat", "Sukajaya no.43", "08882368234"));
        temanArrayList.add(new teman("M. Abdul Aziz", "Denser no. 41", "0874567154"));
        temanArrayList.add(new teman("Syaban Ramadhan", "Panorama Lembang no 11 ", "08512413413"));
        temanArrayList.add(new teman("Naufal Ashil R.", "Jl. Srikandi no.2 ", "08423538253"));
        temanArrayList.add(new teman("Diki Rizal Pambudi", "Citalaksana no.11 ", "0873452345253"));
        temanArrayList.add(new teman("Yunus Zakaria", "Jayagiri no.4 ", "081102368253"));
        temanArrayList.add(new teman("Hamka Nazarudin", "Jl. Gunung Sari no.9 ", "08912391253"));
    }

}
