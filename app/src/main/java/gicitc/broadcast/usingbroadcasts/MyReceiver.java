package gicitc.broadcast.usingbroadcasts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"Got a new message: "+intent.getAction(),Toast.LENGTH_LONG).show();
    }

}
