import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Anropar SwingUtilities.invokeLater för att säkerställa att Swing-komponenter skapas och visas på rätt sätt
        SwingUtilities.invokeLater(Kalender::new);
    }
}