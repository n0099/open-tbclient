package d.b.i0.u2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes4.dex */
public class b extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals("android.intent.action.SCREEN_ON")) {
            a.j().f62791e = 1;
        } else if (action.equals("android.intent.action.SCREEN_OFF")) {
            a.j().f62791e = 1;
            a.j().f62790d.d();
        } else if (action.equals("android.intent.action.USER_PRESENT")) {
            a.j().f62791e = 0;
        }
    }
}
