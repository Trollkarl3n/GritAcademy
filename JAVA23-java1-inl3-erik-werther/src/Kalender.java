import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Kalender extends JFrame {
    private JPanel weekPanel;
    private DPanel[] dayPanels;

    // Konstruktor för Programmet
    public Kalender() {
        setTitle("Veckoprogram");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        // Skapa en panel för veckodagarna med en GridLayout
        weekPanel = new JPanel();
        weekPanel.setLayout(new GridLayout(1, 7));

        // Skapa en array för DayPanel för varje dag i veckan
        dayPanels = new DPanel[7];

        // Uppdatera programmet med dagarna i veckan och markera dagens datum
        updateProgram();
        highlightCurrentDay();

        // Skapa en timer för att kontinuerligt markera dagens datum
        Timer timer = new Timer(1000, e -> highlightCurrentDay());
        timer.start();

        // Lägg till veckopanel i fönstret
        add(weekPanel);

        // Skapa och lägg till en knapp för att lägga till evenemang
        JButton addEventButton = new JButton("Lägg till event");
        addEventButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addEvent();
            }
        });
        add(addEventButton, BorderLayout.SOUTH);

        // Visa fönstret
        setVisible(true);
    }

    // Uppdatera programmet med dagarna i veckan
    private void updateProgram() {
        weekPanel.removeAll();

        // Skapa en instans av Calendar för att hantera datum
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);

        // Skapa formatter för datum och dag
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat dayFormat = new SimpleDateFormat("EEE");

        // Loopa över varje dag i veckan
        for (int i = 0; i < 7; i++) {
            // Hämta datum och dag för den aktuella dagen
            String date = dateFormat.format(cal.getTime());
            String day = dayFormat.format(cal.getTime());

            // Skapa och lägg till DayPanel för den aktuella dagen i veckopanelen
            dayPanels[i] = new DPanel(date, day);
            weekPanel.add(dayPanels[i]);

            // Gå till nästa dag i veckan
            cal.add(Calendar.DAY_OF_WEEK, 1);
        }
    }

    // Markera dagens datum med en färg
    private void highlightCurrentDay() {
        // Skapa en instans av Calendar för att hantera datum
        Calendar cal = Calendar.getInstance();

        // Hämta index för den aktuella dagen i veckan (justerat för 0-baserat index)
        int currentDay = cal.get(Calendar.DAY_OF_WEEK) - 2;

        // Loopa över varje DayPanel och markera dagens datum med en färg
        for (int i = 0; i < dayPanels.length; i++) {
            dayPanels[i].setBackground(i == currentDay);
        }
    }

    // Metod för att lägga till evenemang för en specifik dag
    private void addEvent() {
        // Fråga användaren att ange datum för evenemanget
        String selectedDate = JOptionPane.showInputDialog("Ange datum för ditt event (yyyy-MM-dd):");

        // Sök efter rätt DayPanel baserat på det angivna datumet
        for (DPanel dayPanel : dayPanels) {
            if (dayPanel.getDate().equals(selectedDate)) {
                // Fråga användaren att ange evenemanget
                String event = JOptionPane.showInputDialog("Lägg till ditt event:");
                // Lägg till evenemanget i textrutan för den valda dagen
                dayPanel.eventTextArea.append(event + "\n");
                break;
            }
        }
    }
}