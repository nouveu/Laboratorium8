package pl.edu.pwr.wiz.wzorlaboratorium8;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

public class BatteryBroadcastReceiver extends BroadcastReceiver {
    final static String TAG = "BatteryBR";

    @Override
    public void onReceive(Context context, Intent intent) {
        int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
        int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);

        float batteryPct = (level / (float)scale) * 100;

        Log.i(TAG, "Aktualny poziom baterii (" + level + "/" + scale +"): " + batteryPct + "%.");

        View rootView = ((Activity)context).getWindow().getDecorView().findViewById(android.R.id.content);
        ProgressBar progressBar = (ProgressBar) rootView.findViewById(R.id.stan_progressbar);

        progressBar.setProgress(Math.round(batteryPct));
        progressBar.setVisibility(View.VISIBLE);
    }
}
