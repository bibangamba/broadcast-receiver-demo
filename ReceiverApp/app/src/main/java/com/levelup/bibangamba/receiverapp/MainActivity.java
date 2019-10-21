package com.levelup.bibangamba.receiverapp;

import android.content.IntentFilter;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.levelup.bibangamba.receiverapp.databinding.ActivityMainBinding;

import static com.levelup.bibangamba.receiverapp.ContextRegisteredBroadcastReceiver.ACTION_RECOMMEND;
import static com.levelup.bibangamba.receiverapp.ContextRegisteredBroadcastReceiver.LISTEN_RECOMMENDATION;
import static com.levelup.bibangamba.receiverapp.ContextRegisteredBroadcastReceiver.WATCH_RECOMMENDATION;

public class MainActivity extends AppCompatActivity {

    ContextRegisteredBroadcastReceiver mContextRegisteredBroadcastReceiver;
    ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mContextRegisteredBroadcastReceiver = new ContextRegisteredBroadcastReceiver();
        IntentFilter filter = new IntentFilter(ACTION_RECOMMEND);
        this.registerReceiver(mContextRegisteredBroadcastReceiver, filter);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            mBinding.descriptionTV.setText(R.string.recommendation_received);
            mBinding.recommendationTV.setText(
                    String.format("My recommendations are, Listen to: %s and watch: %s",
                            bundle.getString(LISTEN_RECOMMENDATION),
                            bundle.getString(WATCH_RECOMMENDATION))
            );
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mContextRegisteredBroadcastReceiver);
    }
}
