public class Vara {

    private String namn;
    private double pris;

    private int antal;

    public Vara(String namn, double pris, int antal) {
        this.namn = namn;
        this.pris = pris;
        this.antal = antal;
    }

    public void setAntal (int antal) {
        this.antal = antal - 1;
    }
    public String getNamn(){
        return namn;
    }

    public double getPris() {
        return pris;
    }

    public int getAntal(){
        return antal;
    }
}
class RabattVara extends Vara {
    private double rabattProcent;
    private int antal;
    public RabattVara(String namn, double pris, double rabattProcent, int antal) {
        super(namn, pris, antal);
        this.antal = antal;
        this.rabattProcent = rabattProcent;
    }

    public int getAntal() {
        return antal;
    }

    public void setAntal (int antal) {
        this.antal = antal - 1;
    }

    @Override
    public double getPris() {
        double rabatteratPris = super.getPris() * (1.0 - rabattProcent);
        return rabatteratPris;
    }
}