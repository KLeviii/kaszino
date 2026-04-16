public class JatekGep {
    protected int azonosito;
    protected String nev;
    protected double minimumTet;
    protected double maximumTet;
    protected double osszesBevet;
    protected double osszesKifizetes;
    protected int jatszottKorok;

    public JatekGep(int azonosito, String nev, double minimumTet, double maximumTet) {
        this.azonosito = azonosito;
        this.nev = nev;
        this.minimumTet = minimumTet;
        this.maximumTet = maximumTet;
        this.osszesBevet = 0.0;
        this.osszesKifizetes = 0.0;
        this.jatszottKorok = 0;
    }

    public boolean tetEllnorzes(double tet) {
        if (tet > minimumTet && tet < maximumTet) {
            return true;
        }
        System.out.println("Érvénytelen tét: " + tet + " [min: " + minimumTet + " – " + maximumTet + " : 100.0])");
        return false;
    }
}
