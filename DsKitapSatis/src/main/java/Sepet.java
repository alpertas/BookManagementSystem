
public class Sepet {
    private int id;
    private String kullanici_adi;
    private String kitap_ad;
    private String kitap_yazar;
    private String kitap_tip;
    private String kitap_yayinevi;
    private int fiyat;  
    private int stok;
    private int adet;

    public Sepet(int id, String kullanici_adi, String kitap_ad, String kitap_yazar, String kitap_tip, String kitap_yayinevi, int fiyat, int stok, int adet) {
        this.id = id;
        this.kullanici_adi = kullanici_adi;
        this.kitap_ad = kitap_ad;
        this.kitap_yazar = kitap_yazar;
        this.kitap_tip = kitap_tip;
        this.kitap_yayinevi = kitap_yayinevi;
        this.fiyat = fiyat;
        this.stok = stok;
        this.adet = adet;
    }

    public int getAdet() {
        return adet;
    }

    public void setAdet(int adet) {
        this.adet = adet;
    }

    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKullanici_adi() {
        return kullanici_adi;
    }

    public void setKullanici_adi(String kullanici_adi) {
        this.kullanici_adi = kullanici_adi;
    }

    public String getKitap_ad() {
        return kitap_ad;
    }

    public void setKitap_ad(String kitap_ad) {
        this.kitap_ad = kitap_ad;
    }

    public String getKitap_yazar() {
        return kitap_yazar;
    }

    public void setKitap_yazar(String kitap_yazar) {
        this.kitap_yazar = kitap_yazar;
    }

    public String getKitap_tip() {
        return kitap_tip;
    }

    public void setKitap_tip(String kitap_tip) {
        this.kitap_tip = kitap_tip;
    }

    public String getKitap_yayinevi() {
        return kitap_yayinevi;
    }

    public void setKitap_yayinevi(String kitap_yayinevi) {
        this.kitap_yayinevi = kitap_yayinevi;
    }

    public int getFiyat() {
        return fiyat;
    }

    public void setFiyat(int fiyat) {
        this.fiyat = fiyat;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }
    
}
