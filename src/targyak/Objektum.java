package targyak;

public abstract class Objektum {

    String nev;
    boolean vanPapir;

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public boolean isVanPapir() {
        return vanPapir;
    }

    public void setVanPapir(boolean vanPapir) {
        this.vanPapir = vanPapir;
    }
}
