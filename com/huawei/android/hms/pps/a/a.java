package com.huawei.android.hms.pps.a;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes6.dex */
public final class a implements ServiceConnection {
    public boolean a = false;
    public final LinkedBlockingQueue<IBinder> b = new LinkedBlockingQueue<>(1);

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            Log.d("PPSSerivceConnection", "onServiceConnected " + System.currentTimeMillis());
            this.b.put(iBinder);
        } catch (InterruptedException e) {
            Log.w("PPSSerivceConnection", "onServiceConnected InterruptedException " + System.currentTimeMillis());
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        Log.d("PPSSerivceConnection", "onServiceDisconnected " + System.currentTimeMillis());
    }
}
