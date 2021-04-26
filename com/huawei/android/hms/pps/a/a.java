package com.huawei.android.hms.pps.a;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes6.dex */
public final class a implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    public boolean f32351a = false;

    /* renamed from: b  reason: collision with root package name */
    public final LinkedBlockingQueue<IBinder> f32352b = new LinkedBlockingQueue<>(1);

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            Log.d("PPSSerivceConnection", "onServiceConnected " + System.currentTimeMillis());
            this.f32352b.put(iBinder);
        } catch (InterruptedException unused) {
            Log.w("PPSSerivceConnection", "onServiceConnected InterruptedException " + System.currentTimeMillis());
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        Log.d("PPSSerivceConnection", "onServiceDisconnected " + System.currentTimeMillis());
    }
}
