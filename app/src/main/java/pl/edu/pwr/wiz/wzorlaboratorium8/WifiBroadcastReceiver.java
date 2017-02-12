package pl.edu.pwr.wiz.wzorlaboratorium8;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.util.Log;

public class WifiBroadcastReceiver extends BroadcastReceiver {
    final static String TAG = "WifiBroadcastReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        /* Sprawdzamy jaką akcje otrzymaliśmy (nasz BroadcastReceiver może obsługiwać więcej niż jedną */
        Log.d(TAG, "Akcja intencji (ID): " + intent.getAction().toString());

        if (intent.getAction() == WifiManager.WIFI_STATE_CHANGED_ACTION) {
            /* Więcej o WifiManager - https://developer.android.com/reference/android/net/wifi/WifiManager.html */
            /* Pobieramy stan WiFi - https://developer.android.com/reference/android/net/wifi/WifiManager.html#EXTRA_WIFI_STATE */
            Integer wifi_state = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE, WifiManager.WIFI_STATE_UNKNOWN);
            Log.d(TAG, "Stan wifi: " + wifi_state.toString());

            if (wifi_state == WifiManager.WIFI_STATE_ENABLED) {
                Log.i(TAG, "Wifi włączone");
            } else if (wifi_state == WifiManager.WIFI_STATE_DISABLED) {
                Log.i(TAG, "Wifi wyłączone");
            } else {
                Log.i(TAG, "Wifi w trakcie zmiany stanu lub stan nieznany");
            }
        }
    }
}