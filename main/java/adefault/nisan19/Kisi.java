package adefault.nisan19;

/**
 * Created by sammas on 19.04.2017.
 */

public class Kisi {
    private String  isim;
    private boolean kadinMi;
    private String  yas;

    public Kisi(String isim,String yas, boolean kadinMi) {
        super();
        this.isim = isim;
        this.yas=yas;
        this.kadinMi = kadinMi;
    }

    @Override
    public String toString() {
        return isim+"\t"+yas;
    }

    public String getIsim() {
        return isim;
    }


    public String getYas() {
        return yas;
    }
    public void setIsim(String isim) {
        this.isim = isim;
    }
    public void setYas(String yas) {
        this.yas = yas;
    }

    public boolean isKadinMi() {
        return kadinMi;
    }

    public void setKadinMi(boolean kadinMi) {
        this.kadinMi = kadinMi;
    }

}
