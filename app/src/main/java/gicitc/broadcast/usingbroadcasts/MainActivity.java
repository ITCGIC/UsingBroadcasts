package gicitc.broadcast.usingbroadcasts;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.net.ServerSocket;

public class MainActivity extends AppCompatActivity {
    private MyReceiver myReceiver = new MyReceiver();
    private IntentFilter filter = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        filter = new IntentFilter(Intent.ACTION_BATTERY_LOW);
        filter.addAction(Intent.ACTION_BATTERY_OKAY);
        filter.addAction("gicitc.action.ACTION_INPUT");
        //filter.addAction(Intent.ACTION_BATTERY_CHANGED);
    }



    @Override
    protected void onStart() {
        super.onStart();
        registerReceiver(myReceiver,filter);

    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(myReceiver);
    }

    public void sendMessage(View view) {
        Intent intent = new Intent("gicitc.action.ACTION_INPUT");
        intent.putExtra("ContentText","Who are you?");
        sendBroadcast(intent);
    }
}
