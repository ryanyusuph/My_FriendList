package ryan.com.google.projek_uas.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import ryan.com.google.projek_uas.R;

public class KontakFragment extends Fragment {
    /*
      NIM    : 10116109
      Nama   : Ryan Yusup Hendriawan
      Kelas  : IF-3
      Tanggal Penulisan : 8 - 14 Agustus 2019
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_kontak, container, false);
        Button btnpanggil = (Button) view.findViewById(R.id.panggil);
        Button btnig = (Button) view.findViewById(R.id.ig);
        Button btnfb = (Button) view.findViewById(R.id.fb);
        Button btnemail = (Button) view.findViewById(R.id.email);

        btnpanggil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = getString(R.string.no_telp);
                String dial = "tel:" + phone;
                Intent intent=new Intent(Intent.ACTION_DIAL, Uri.parse(dial));
                startActivity(intent);
            }
        });
        btnig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urlig ="https://www.instagram.com/ryanyusup";
                Intent bukaig=new Intent(Intent.ACTION_VIEW);
                bukaig.setData(Uri.parse(urlig));
                startActivity(bukaig);
            }
        });
        btnfb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urlfb ="https://www.facebook.com/ryanyusuf.hendriawan";
                Intent bukafb=new Intent(Intent.ACTION_VIEW);
                bukafb.setData(Uri.parse(urlfb));
                startActivity(bukafb);
            }
        });
        btnemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setData(Uri.parse("mailto:"));
                String[] to = {"awanyusup95@gmail.com"};
                intent.putExtra(Intent.EXTRA_EMAIL,to);
                intent.putExtra(Intent.EXTRA_SUBJECT,"Subject Pesan ");
                intent.putExtra(Intent.EXTRA_TEXT,"Isi Pesan ");
                //intent.setType("message/rfc822");
                //Intent chooserIntent = Intent.createChooser(intent, "Send Email");
                startActivity(intent.setType("message/rfc822"));
            }
        });

        return view;

    }
}
