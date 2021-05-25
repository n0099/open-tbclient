package com.bytedance.sdk.openadsdk.multipro.aidl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.bytedance.sdk.openadsdk.IBinderPool;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static volatile a f29573c;

    /* renamed from: a  reason: collision with root package name */
    public Context f29574a;

    /* renamed from: b  reason: collision with root package name */
    public IBinderPool f29575b;

    /* renamed from: d  reason: collision with root package name */
    public CountDownLatch f29576d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f29577e = new Object();

    /* renamed from: f  reason: collision with root package name */
    public long f29578f = 0;

    /* renamed from: g  reason: collision with root package name */
    public ServiceConnection f29579g = new ServiceConnection() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.a.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            a.this.f29575b = IBinderPool.Stub.asInterface(iBinder);
            try {
                a.this.f29575b.asBinder().linkToDeath(a.this.f29580h, 0);
            } catch (RemoteException e2) {
                u.c("MultiProcess", "onServiceConnected throws :", e2);
            }
            a.this.f29576d.countDown();
            u.b("MultiProcess", "onServiceConnected - binderService consume time ：" + (System.currentTimeMillis() - a.this.f29578f));
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            u.c("MultiProcess", "BinderPool......onServiceDisconnected");
        }
    };

    /* renamed from: h  reason: collision with root package name */
    public IBinder.DeathRecipient f29580h = new IBinder.DeathRecipient() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.a.2
        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            u.d("MultiProcess", "binder died.");
            a.this.f29575b.asBinder().unlinkToDeath(a.this.f29580h, 0);
            a.this.f29575b = null;
            a.this.a();
        }
    };

    public a(Context context) {
        this.f29574a = context.getApplicationContext();
        a();
    }

    public static a a(Context context) {
        if (f29573c == null) {
            synchronized (a.class) {
                if (f29573c == null) {
                    f29573c = new a(context);
                }
            }
        }
        return f29573c;
    }

    public IBinder a(int i2) {
        try {
            if (this.f29575b != null) {
                return this.f29575b.queryBinder(i2);
            }
            return null;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a() {
        u.c("MultiProcess", "BinderPool......connectBinderPoolService");
        this.f29576d = new CountDownLatch(1);
        this.f29574a.bindService(new Intent(this.f29574a, BinderPoolService.class), this.f29579g, 1);
        this.f29578f = System.currentTimeMillis();
        try {
            this.f29576d.await();
        } catch (InterruptedException e2) {
            u.c("MultiProcess", "connectBinderPoolService throws: ", e2);
        }
    }
}
