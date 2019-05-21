package ryan.com.google.projek_uts;

public class ScreenItem {
    /*
      NIM    : 10116109
      Nama   : Ryan Yusup Hendriawan
      Kelas  : IF-3
      Tanggal Pembuatan : 20 - 21 Mei 2019
     */

    String Title,Description;
    int ScreenImg;

    public ScreenItem(String title, String description, int screenImg) {
        Title = title;
        Description = description;
        ScreenImg = screenImg;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setScreenImg(int screenImg) {
        ScreenImg = screenImg;
    }

    public String getTitle() {
        return Title;
    }

    public String getDescription() {
        return Description;
    }

    public int getScreenImg() {
        return ScreenImg;
    }

}
