import java.util.Random;

public class Kaszino {
    private JatekGep[] gepek;
    private int darabszam;

    public Kaszino(int maxGepek) {
        this.gepek = new JatekGep[maxGepek];
        this.darabszam = 0;
    }

    public void gepFelvet(JatekGep g) {
        if (!(darabszam < gepek.length)) {
            throw new IllegalStateException("A kaszinó megtelt, nem vehető fel több gép");
        }
        gepek[darabszam] = g;
        darabszam++;
    }

    public void szimulacio(int korok) {
        Random r = new Random();
        int i = 0;
        for (JatekGep jatekGep : gepek) {
            i++;
            double tet = r.nextDouble(jatekGep.minimumTet, jatekGep.maximumTet);
            jatekGep.jatszik(tet);
            System.out.println("Szimuláció: " + jatekGep.nev + " – " + i + ". kör");
        }
    }

    public void jelentes() {
        for (JatekGep jatekGep : gepek) {
            System.out.println(jatekGep.getAdatlap());
            System.out.println(jatekGep.getStatisztika());
            System.out.println(osszProfit());
        }
    }

    public JatekGep legjobbanJovedelmez() {
        JatekGep max = gepek[0];
        for (JatekGep jatekGep : gepek) {
            max = (jatekGep.getProfit() > max.getProfit()) ? jatekGep : max;
        }
        if (max == null) {
            System.out.println("A kaszinóban nincs egy gép sem");
            return null;
        }
        return max;
    }

    public void vesztesGepek() {
        for (JatekGep jatekGep : gepek) {
            if (jatekGep.getProfit() < 0) {
                System.out.println(jatekGep.getAdatlap());
            }
        }
    }

    public double osszProfit() {
        double sum = 0;
        for (JatekGep jatekGep : gepek) {
            sum += jatekGep.getProfit();
        }
        return sum;
    }


}
