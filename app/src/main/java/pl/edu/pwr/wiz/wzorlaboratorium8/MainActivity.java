package pl.edu.pwr.wiz.wzorlaboratorium8;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private BroadcastReceiver br;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* TODO dodać obsługę pola TextView, Button'a i przesłania Intencji do NotificationBroadcastReceiver'a */
    }

    @Override
    protected void onResume() {
        super.onResume();

        /* Rejestrujemy nasłuch na stany baterii
           https://developer.android.com/reference/android/content/Intent.html#ACTION_BATTERY_CHANGED
           https://developer.android.com/reference/android/os/BatteryManager.html
        */
        br = new BatteryBroadcastReceiver();

        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_BATTERY_CHANGED);
        this.registerReceiver(br, filter);
    }

    @Override
    protected void onPause() {
        /* Wyrejestrowujemy nasłuch na stany baterii */
        this.unregisterReceiver(br);

        super.onPause();
    }

    /* Funkcja uruchamia usługę timera */
    public void startTimer(View view) {
        Intent intent = new Intent(this, TimerService.class);
        startService(intent);
    }

    /* Funkcja zatrzymuje usługę timera */
    public void stopTimer(View view) {
        Intent intent = new Intent(this, TimerService.class);
        stopService(intent);
    }
}
