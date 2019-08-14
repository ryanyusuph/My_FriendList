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

public class FormFragment extends Fragment implements View.OnClickListener {
        /*
      NIM    : 10116109
      Nama   : Ryan Yusup Hendriawan
      Kelas  : IF-3
      Tanggal Penulisan : 8 - 14 Agustus 2019
     */

    public Button btn_Simpan, btn_Tampil;
    EditText nim, nama, kelas, telepon, email, sosmed;
    String sNama, sKelas, sTelepon, sEmail ,sSosmed;
    Integer sNim;
    Realm realm;
    RealmHelper realmHelper;
    teman teman_model;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View ciewna = inflater.inflate(R.layout.fragment_form, container, false);

        //Inisialisasi
        btn_Simpan = ciewna.findViewById(R.id.btnSimpan);
        btn_Tampil = ciewna.findViewById(R.id.btnTampil);
        nim = ciewna.findViewById(R.id.nim);
        nama = ciewna.findViewById(R.id.nama);
        kelas = ciewna.findViewById(R.id.kelas);
        telepon = ciewna.findViewById(R.id.telepon);
        email = ciewna.findViewById(R.id.email);
        sosmed = ciewna.findViewById(R.id.sosmed);

        //Set up Realm
        Realm.init(this.getActivity());
        RealmConfiguration configuration = new RealmConfiguration.Builder().build();
        realm = Realm.getInstance(configuration);

        btn_Simpan.setOnClickListener(this);
        btn_Tampil.setOnClickListener(this);

        nim.requestFocus();
        return ciewna;
    }

    @Override
    public void onClick(View v) {
        if (v == btn_Simpan) {

            if (nim.getText().length() < 1) {
                nim.setError("NIM Tidak Boloh Kosong ! ");
                nim.requestFocus();
            } else if (nim.getText().toString().length() > 8) {
                nim.setError("NIM Tidak Boloh Lebih dari 8 digit ! ");
                nim.requestFocus();
            } else if (nama.getText().toString().length() < 1) {
                nama.setError("Nama Tidak Boleh Kosong ! ");
                nama.requestFocus();
            } else if (kelas.getText().toString().length() < 1) {
                kelas.setError("Kelas Tidak Boloh Kosong ! ");
                kelas.requestFocus();
            } else if (telepon.getText().toString().length() < 1) {
                telepon.setError("No Telepon Tidak Boloh Kosong ! ");
                telepon.requestFocus();
            } else if (email.getText().toString().length() < 1) {
                email.setError("Email Tidak Boloh Kosong ! ");
                email.requestFocus();
            } else if (sosmed.getText().toString().length() < 1) {
                sosmed.setError("Sosial Media Tidak Boloh Kosong ! ");
                sosmed.requestFocus();
            } else {
                sNim = Integer.parseInt(nim.getText().toString());
                sNama = nama.getText().toString();
                sKelas = kelas.getText().toString();
                sTelepon = telepon.getText().toString();
                sEmail = email.getText().toString();
                sSosmed = sosmed.getText().toString();

                if (!sNim.equals("") && !sNama.isEmpty() && !sKelas.isEmpty() && !sTelepon.isEmpty() && !sEmail.isEmpty() && !sSosmed.isEmpty()) {
                    teman_model = new teman();
                    teman_model.setNim(sNim);
                    teman_model.setNama(sNama);
                    teman_model.setKelas(sKelas);
                    teman_model.setTelepon(sTelepon);
                    teman_model.setEmail(sEmail);
                    teman_model.setSosmed(sSosmed);

                    realmHelper = new RealmHelper(realm);
                    realmHelper.save(teman_model);

                    Toast.makeText(this.getActivity(), "Berhasil Disimpan!", Toast.LENGTH_SHORT).show();

                    nim.setText("");
                    nama.setText("");
                    kelas.setText("");
                    telepon.setText("");
                    email.setText("");
                    sosmed.setText("");
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.tempat_fragment,new TemanFragment()).commit();
                } else {
                    Toast.makeText(this.getActivity(), "Terdapat inputan yang kosong", Toast.LENGTH_SHORT).show();
                }
            }
        }else if (v == btn_Tampil){

            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.tempat_fragment,new TemanFragment()).commit();

        }
    }

}
