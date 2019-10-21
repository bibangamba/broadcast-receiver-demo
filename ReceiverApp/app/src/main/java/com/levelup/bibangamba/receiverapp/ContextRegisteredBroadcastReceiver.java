package com.levelup.bibangamba.receiverapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class ContextRegisteredBroadcastReceiver extends BroadcastReceiver {
    public static final String ACTION_RECOMMEND = "com.random.action.RECOMMEND";
    public static final String LISTEN_RECOMMENDATION = "listen";
    public static final String WATCH_RECOMMENDATION = "watch";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction() != null && intent.getAction().equals(ACTION_RECOMMEND)) {
            Bundle bundle = intent.getExtras();
            String listenRecommendation;
            String watchRecommendation;
            if (bundle != null) {
                listenRecommendation = bundle.getString(LISTEN_RECOMMENDATION);
                watchRecommendation = bundle.getString(WATCH_RECOMMENDATION);

                Intent i = new Intent(context, MainActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.putExtra(LISTEN_RECOMMENDATION, listenRecommendation);
                i.putExtra(WATCH_RECOMMENDATION, watchRecommendation);
                context.startActivity(i);

                Log.d("####################", "#########################################");
                Log.d("ContextBR", "My recommendations are, Listen to: "
                        + listenRecommendation + " and watch: "
                        + watchRecommendation);
            }
        }
    }
}
