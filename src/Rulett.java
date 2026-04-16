public class Rulett extends Jatek {

    private int utolsoSzam;
    private String utolsoSzin;

    public Rulett(int azonosito, String nev, double minimumTet, double maximumTet) {
        super(azonosito, nev, minimumTet, maximumTet);
        this.utolsoSzam = 0;
        this.utolsoSzin = "zold";
    }

    private void forgat() {
        this.utolsoSzam = (int) (Math.random() * 37); // 0-36
        if (utolsoSzam == 0) {
            this.utolsoSzin = "zold";
        } else if (utolsoSzam % 2 == 0) {
            this.utolsoSzin = "fekete";
        } else {
            this.utolsoSzin = "piros";
        }
    }

    @Override
    public double jatszik(double tet) {
        if (!tetEllenorzes(tet)) {
            return 0.0;
        }
        osszesBevet += tet;
        jatszottKorok++;
        forgat();
        String fogadottSzin = Math.random() < 0.5 ? "piros" : "fekete";
        double nyeremeny = 0.0;
        if (fogadottSzin.equals(utolsoSzin)) {
            nyeremeny = tet * 2;
        }
        osszesKifizetes += nyeremeny;
        System.out.printf("Fogadott szín: %s, Kijött szín és szám: %s %d, Nyeremény: %.1f Ft%n", fogadottSzin, utolsoSzin, utolsoSzam, nyeremeny);
        return nyeremeny;

    }

    public double szamraFogadas(int fogadottSzam, double tet) {
        if (!tetEllenorzes(tet)) {
            return 0.0;
        }
        osszesBevet += tet;
        jatszottKorok++;
        forgat();
        double nyeremeny = 0.0;
        if (fogadottSzam == utolsoSzam) {
            nyeremeny = tet * 36;
        }
        osszesKifizetes += nyeremeny;
        System.out.printf("Fogadott szám: %d, Kijött szín és szám: %s %d, Nyeremény: %.1f Ft%n", fogadottSzam, utolsoSzin, utolsoSzam, nyeremeny);
        return nyeremeny;
    }

    @Override
    public String getAdatlap() {
        return super.getAdatlap() + String.format("\nUtolsó forgatás eredménye: %s %d", utolsoSzin, utolsoSzam);
    }



}
