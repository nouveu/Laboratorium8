package pl.edu.pwr.wiz.wzorlaboratorium8;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class PowerConnectionBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        String action = intent.getAction();

        if (action.equals(Intent.ACTION_POWER_CONNECTED)) {
            context.startService(new Intent(context, BatteryTimerService.class));
        }
        else {
            context.stopService(new Intent(context, BatteryTimerService.class));
        }
    }
}
