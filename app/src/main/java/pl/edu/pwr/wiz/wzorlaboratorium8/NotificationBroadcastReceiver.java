package pl.edu.pwr.wiz.wzorlaboratorium8;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class NotificationBroadcastReceiver extends BroadcastReceiver {

    public static final String MY_NOTIFICATION_ACTION = "pl.edu.pwr.wiz.wzorlaboratorium8.NOTIFICATION"; // TODO ############# DEL nazwa akcji jak w manifeście
    public static final String EXTRA_DATA_KEY = "data";

    @Override
    public void onReceive(Context context, Intent intent) {

        /* TODO Pobierać dane z intencji i wyświetlać notyfikację systemową z przesłanym tekstem */
        String data = intent.getStringExtra(EXTRA_DATA_KEY);
        Toast.makeText(context, data, Toast.LENGTH_SHORT).show(); // TODO ################### DEL snackbar potrzebuje widoku (view), skad go pobrac? zamiast tego jest toast

    }
}