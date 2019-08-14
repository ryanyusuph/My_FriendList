package ryan.com.google.projek_uas;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import ryan.com.google.projek_uas.Fragment.HomeFragment;
import ryan.com.google.projek_uas.Fragment.KontakFragment;
import ryan.com.google.projek_uas.Fragment.TemanFragment;

public class MainActivity extends AppCompatActivity {
    /*
      NIM    : 10116109
      Nama   : Ryan Yusup Hendriawan
      Kelas  : IF-3
      Tanggal Penulisan : 8 - 14 Agustus 2019
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavna = findViewById(R.id.bottom_navigation);
        bottomNavna.setOnNavigationItemSelectedListener(navListen);

        getSupportFragmentManager().beginTransaction().replace(R.id.tempat_fragment,new HomeFragment()).commit();

    }

     private BottomNavigationView.OnNavigationItemSelectedListener navListen =
             new BottomNavigationView.OnNavigationItemSelectedListener() {
                 @Override
                 public boolean onNavigationItemSelected(@NonNull MenuItem itemna) {
                     Fragment selectedFragment = null;

                     switch(itemna.getItemId()){
                         case R.id.nav_kontak:
                             selectedFragment = new KontakFragment();
                             break;
                         case R.id.nav_home:
                             selectedFragment = new HomeFragment();
                             break;
                         case R.id.nav_teman:
                             selectedFragment = new TemanFragment();
                             break;
                     }
                     getSupportFragmentManager().beginTransaction().replace(R.id.tempat_fragment,selectedFragment).commit();
                     return true;
                 }

             };
}
