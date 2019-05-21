package ryan.com.google.projek_uts.Fragment;



import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ryan.com.google.projek_uts.R;

public class HomeFragment extends Fragment {
    /*
      NIM    : 10116109
      Nama   : Ryan Yusup Hendriawan
      Kelas  : IF-3
      Tanggal Pembuatan : 20 - 21 Mei 2019
     */

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home,container,false);



    }
}
