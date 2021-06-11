package com.win.opensdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
/* loaded from: classes7.dex */
public class g1 implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    public Context f40720a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f40721b = false;

    /* renamed from: c  reason: collision with root package name */
    public final BlockingQueue f40722c = new LinkedBlockingQueue();

    public g1(Context context) {
        this.f40720a = context;
    }

    public IBinder a() {
        if (this.f40721b) {
            throw new IllegalStateException("Binder already consumed");
        }
        IBinder iBinder = (IBinder) this.f40722c.take();
        if (iBinder != null) {
            this.f40721b = true;
        }
        return iBinder;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        try {
            this.f40722c.put(iBinder);
            String a2 = ((a) b.a(iBinder)).a();
            if (TextUtils.isEmpty(a2)) {
                return;
            }
            s1.f(this.f40720a, a2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        } catch (InterruptedException e3) {
            e3.printStackTrace();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
    }
}
