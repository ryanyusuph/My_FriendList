package ryan.com.google.projek_uas.Fragment;



import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import ryan.com.google.projek_uas.LoginActivity;
import ryan.com.google.projek_uas.Preferences;
import ryan.com.google.projek_uas.R;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class HomeFragment extends Fragment {
    /*
      NIM    : 10116109
      Nama   : Ryan Yusup Hendriawan
      Kelas  : IF-3
      Tanggal Penulisan : 8 - 14 Agustus 2019
     */

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        Button btnlogout = (Button) view.findViewById(R.id.btn_logout);


        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Preferences.clearLoggedInUser(getActivity().getBaseContext());
                startActivity(new
                        Intent(getActivity().getBaseContext(),LoginActivity.class));
                getActivity().finish();
            }
        });
        return view;
    }

}
