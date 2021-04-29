package targyak;

public abstract class Objektum {

    String nev;
    boolean vanPapir;

    /**
     *
     * @return nevet visszateriti
     */
    public String getNev() {
        return nev;
    }

    /**
     *
     * @param nev beallitja
     */
    public void setNev(String nev) {
        this.nev = nev;
    }

    /**
     *
     * @return ha true van papir, maskepp nincs
     */
    public boolean isVanPapir() {
        return vanPapir;
    }

    /**
     *
     * @param vanPapir beallitja van e papir az objektumon
     */
    public void setVanPapir(boolean vanPapir) {
        this.vanPapir = vanPapir;
    }
}
