public class Kund {

    private int antalVaraKopt;
    private double totalAntalVara;

    public Kund (){
        antalVaraKopt = 0;
        totalAntalVara = 0.0;
    }

    public int getAntalVaraKopt () {
        return antalVaraKopt;
    }

    public double getTotalAntalVara () {
        return totalAntalVara;
    }

    public void kopaVara (Vara vara) {
        antalVaraKopt++;
        totalAntalVara += vara.getPris();
    }
}
