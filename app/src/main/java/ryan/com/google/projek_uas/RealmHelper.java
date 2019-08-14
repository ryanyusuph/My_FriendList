package ryan.com.google.projek_uas;

import android.util.Log;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import ryan.com.google.projek_uas.Fragment.teman;

public class RealmHelper {
    /*
  NIM    : 10116109
  Nama   : Ryan Yusup Hendriawan
  Kelas  : IF-3
  Tanggal Penulisan : 8 - 14 Agustus 2019
 */

    Realm realm;

    public  RealmHelper(Realm realm){
        this.realm = realm;
    }

    // untuk menyimpan data
    public void save(final teman teman_model){
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                if (realm != null){
                    Log.e("Created", "Database was created");
                    Number currentIdNum = realm.where(teman.class).max("id");
                    int nextId;
                    if (currentIdNum == null){
                        nextId = 1;
                    }else {
                        nextId = currentIdNum.intValue() + 1;
                    }
                    teman_model.setId(nextId);
                    teman model = realm.copyToRealm(teman_model);
                }else{
                    Log.e("ppppp", "execute: Database not Exist");
                }
            }
        });
    }

    // untuk memanggil semua data
    public List<teman> getAllTeman(){
        RealmResults<teman> results = realm.where(teman.class).findAll();
        return results;
    }

    // untuk meng-update data
    public void update(final Integer id, final Integer nim, final String nama,final String kelas, final String telepon, final String email, final String sosmed){
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                teman modelna = realm.where(teman.class)
                        .equalTo("id", id)
                        .findFirst();
                modelna.setNim(nim);
                modelna.setNama(nama);
                modelna.setKelas(kelas);
                modelna.setTelepon(telepon);
                modelna.setEmail(email);
                modelna.setSosmed(sosmed);
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                Log.e("pppp", "onSuccess: Update Successfully");
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                error.printStackTrace();
            }
        });
    }


    // untuk menghapus data
    public void delete(Integer id){
        final RealmResults<teman> modelna = realm.where(teman.class).equalTo("id", id).findAll();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                modelna.deleteFromRealm(0);
            }
        });
    }


}
