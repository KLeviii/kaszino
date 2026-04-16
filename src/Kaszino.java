public class Kaszino {
    private JatekGep[] gepek;
    private int darabszam;

    public Kaszino(int maxGepek) {
        this.gepek = new JatekGep[maxGepek];
        this.darabszam = 0;
    }

    public void gepFelvet(JatekGep g) {
        if (!(darabszam < gepek.length)) {
            throw new IllegalStateException("A kaszinó megtelt, nem vehető fel több gép")
        }
        gepek[darabszam] = g;
        darabszam++;
    }
}
