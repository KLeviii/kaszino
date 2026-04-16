public class Nyerogep {
    private String[] szimbolumok;
    private int jackpotHuzas;

    public Nyerogep(int azonosito, String nev, double minimumTet, double maximumTet, String[] szimbolumok) {
        super(azonosito, nev, minimumTet, maximumTet);
        this.szimbolumok = szimbolumok;
        this.jackpotHuzas = 0;
    }

    private String huzosSzimbolum() {
        int index = (int) (Math.random() * szimbolumok.length);
        return szimbolumok[index];
    }

    @Override
    public double jatszik(double tet) {
        if (!tetEllenorzes(tet)) {
            return 0.0;
        }
        osszesBevet += tet;
        jatszottKorok++;
        String s1 = huzosSzimbolum();
        String s2 = huzosSzimbolum();
        String s3 = huzosSzimbolum();
        double nyeremeny = 0.0;
        if (s1.equals(s2) && s2.equals(s3)) {
            if (s1.equals("JACKPOT")) {
                nyeremeny = tet * 50;
                jackpotHuzas++;
            } else {
                nyeremeny = tet * 10;
            }
        } else if (s1.equals(s2) || s1.equals(s3) || s2.equals(s3)) {
            nyeremeny = tet * 2;
        }
        osszesKifizetes += nyeremeny;
        System.out.printf("[ %s | %s | %s ] → +%.1f Ft%n", s1, s2, s3, nyeremeny);
        return nyeremeny;
    }

    @Override
    public String getAdatlap() {
        return super.getAdatlap() + String.format("\nJackpot húzások száma: %d", jackpotHuzas);
    }



}











