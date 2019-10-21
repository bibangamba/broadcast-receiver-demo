package com.levelup.bibangamba.senderapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.levelup.bibangamba.senderapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    public static final String ACTION_RECOMMEND = "com.random.action.RECOMMEND";
    public static final String LISTEN_RECOMMENDATION = "listen";
    public static final String WATCH_RECOMMENDATION = "watch";
    ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mBinding.sendButton.setOnClickListener(v -> {
            Intent intent = new Intent(ACTION_RECOMMEND);
            intent.putExtra(LISTEN_RECOMMENDATION, "Triggered - Jhene Aiko");
            intent.putExtra(WATCH_RECOMMENDATION, "Goblin - Kim Go-eun");
            intent.setPackage("com.levelup.bibangamba.receiverapp");
            sendBroadcast(intent);
            mBinding.statusTV.setText(getString(R.string.broadcast_sent));
        });
    }
}
