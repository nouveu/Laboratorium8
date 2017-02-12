package pl.edu.pwr.wiz.wzorlaboratorium8;

import android.app.IntentService;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;

/**
 * Przykładowa usługa odliczająca czas w notifikacji
 */

public class TimerService extends IntentService {
    private Integer timer = 0;
    final static int ONGOING_NOTIFICATION_ID = 1; // nie może być równe 0

    /* Konstruktor jest wymagany i podajemy w nim nazwę wątku, który ma zostać stworzony
       na potrzeby tej usługi
     */
    public TimerService() {
        super("TimerService");
    }

    /* Funkcja do obsługi intencji - wymagana */
    @Override
    protected void onHandleIntent(Intent intent) {
        /* Nieskonczona petla, dzialamy dopoki ktos nas nie zatrzyma */
        while(true) {
            /* Tworzymy PendingIntent, który wywoła naszą aktywność w razie kliknięcia w notyfikację */
            Intent notificationIntent = new Intent(this, MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);

            /* Budujemy notyfikację */
            Notification notification = new Notification.Builder(this)
                    .setContentTitle(getText(R.string.counter_title))
                    .setContentText(getText(R.string.counter_body) + timer.toString() + "s")
                    .setSmallIcon(R.drawable.ic_av_timer_black_24dp)
                    .setContentIntent(pendingIntent)
                    .build();

            /* Startujemy na pierwszym planie, aby nie dało jej się zamknąć */
            startForeground(ONGOING_NOTIFICATION_ID, notification);

            try {
                Thread.sleep(5000);
                timer += 5; // dodajemy 5 sekund
            } catch (InterruptedException e) {
                // Restore interrupt status.
                Thread.currentThread().interrupt();
            }
        }

    }
}
