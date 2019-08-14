package ryan.com.google.projek_uas;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MyApplication extends Application {
    /*
  NIM    : 10116109
  Nama   : Ryan Yusup Hendriawan
  Kelas  : IF-3
  Tanggal Penulisan : 8 - 14 Agustus 2019
 */
    @Override
    public void onCreate() {
        super.onCreate();

        Realm.init(this);
        RealmConfiguration configuration = new RealmConfiguration.Builder()
                .name("teman.db")
                .schemaVersion(0)
                .build();
        Realm.setDefaultConfiguration(configuration);
    }

}
