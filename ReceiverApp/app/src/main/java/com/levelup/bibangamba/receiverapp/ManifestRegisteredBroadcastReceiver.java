package com.levelup.bibangamba.receiverapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class ManifestRegisteredBroadcastReceiver extends BroadcastReceiver {
    public static final String ACTION_RECOMMEND = "com.random.action.RECOMMEND";
    public static final String LISTEN_RECOMMENDATION = "listen";
    public static final String WATCH_RECOMMENDATION = "watch";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(ACTION_RECOMMEND)) {
            Bundle bundle = intent.getExtras();
            String listenRecommendation;
            String watchRecommendation;
            if (bundle != null) {
                listenRecommendation = bundle.getString(LISTEN_RECOMMENDATION);
                watchRecommendation = bundle.getString(WATCH_RECOMMENDATION);

                Toast.makeText(context, "My recommendations are, Listen to: "
                        + listenRecommendation + " and watch: "
                        + watchRecommendation, Toast.LENGTH_SHORT).show();

                Log.d("####################", "#########################################");

                Log.d("ManifestBR", "My recommendations are, Listen to: "
                        + listenRecommendation + " and watch: "
                        + watchRecommendation);
            }
        }

    }
}
