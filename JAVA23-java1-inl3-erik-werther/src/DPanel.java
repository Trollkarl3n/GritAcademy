import javax.swing.*;
import java.awt.*;

public class DPanel extends JPanel {
    private JLabel dateLabel;       // Etikett för att visa datumet
    private JLabel dayLabel;        // Etikett för att visa dagen
    JTextArea eventTextArea;        // Textruta för att visa och redigera händelser

    // Konstruktor för DayPanel, tar emot ett datum som parameter
    public DPanel(String date, String day) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Skapa en etikett för att visa datumet i mitten av toppen
        dateLabel = new JLabel(date, SwingConstants.CENTER);

        dayLabel = new JLabel(day, SwingConstants.CENTER);

        // Skapa en textruta för att visa och redigera händelser
        eventTextArea = new JTextArea();

        // Skapa ett rullningsfält för textrutan
        JScrollPane scrollPane = new JScrollPane(eventTextArea);

        // Lägg till komponenterna i panelen
        add(dateLabel, BorderLayout.SOUTH);
        add(dayLabel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    // Return dateLable
    public String getDate() {
        return dateLabel.getText();
    }

    // Return dayLabel
    public String getDay() {
        return dayLabel.getText();
    }

    // Return eventTextArea
    public String getEvent() {
        return eventTextArea.getText();
    }

    public void setBackground(boolean isToday) {
        if(isToday) {
            setBackground(Color.CYAN);
        } else {
            setBackground(Color.WHITE);
        }
    }
}
