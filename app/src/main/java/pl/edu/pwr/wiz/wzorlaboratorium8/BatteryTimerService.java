package pl.edu.pwr.wiz.wzorlaboratorium8;

import android.app.IntentService;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;

public class BatteryTimerService extends IntentService {
    private Integer timer = 200;
    final static int ONGOING_NOTIFICATION_ID = 1; // nie może być równe 0

    public BatteryTimerService() {
        super("BatteryTimerService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        while(timer > 0) {
            /* Tworzymy PendingIntent, który wywoła naszą aktywność w razie kliknięcia w notyfikację */
            Intent notificationIntent = new Intent(this, MainActivity.class);
            PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);

            /* Budujemy notyfikację */
            Notification notification = new Notification.Builder(this)
                    .setContentTitle("Czas ładowania")
                    .setContentText("Pozostało: " + timer.toString() + "s")
                    .setSmallIcon(R.drawable.ic_av_timer_black_24dp)
                    .setContentIntent(pendingIntent)
                    .build();

            startForeground(ONGOING_NOTIFICATION_ID, notification);

            try {
                Thread.sleep(5000);
                timer -= 5;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

    }
}
