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
/* loaded from: classes5.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static volatile a f30399c;

    /* renamed from: a  reason: collision with root package name */
    public Context f30400a;

    /* renamed from: b  reason: collision with root package name */
    public IBinderPool f30401b;

    /* renamed from: d  reason: collision with root package name */
    public CountDownLatch f30402d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f30403e = new Object();

    /* renamed from: f  reason: collision with root package name */
    public long f30404f = 0;

    /* renamed from: g  reason: collision with root package name */
    public ServiceConnection f30405g = new ServiceConnection() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.a.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            a.this.f30401b = IBinderPool.Stub.asInterface(iBinder);
            try {
                a.this.f30401b.asBinder().linkToDeath(a.this.f30406h, 0);
            } catch (RemoteException e2) {
                u.c("MultiProcess", "onServiceConnected throws :", e2);
            }
            a.this.f30402d.countDown();
            u.b("MultiProcess", "onServiceConnected - binderService consume time ：" + (System.currentTimeMillis() - a.this.f30404f));
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            u.c("MultiProcess", "BinderPool......onServiceDisconnected");
        }
    };

    /* renamed from: h  reason: collision with root package name */
    public IBinder.DeathRecipient f30406h = new IBinder.DeathRecipient() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.a.2
        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            u.d("MultiProcess", "binder died.");
            a.this.f30401b.asBinder().unlinkToDeath(a.this.f30406h, 0);
            a.this.f30401b = null;
            a.this.a();
        }
    };

    public a(Context context) {
        this.f30400a = context.getApplicationContext();
        a();
    }

    public static a a(Context context) {
        if (f30399c == null) {
            synchronized (a.class) {
                if (f30399c == null) {
                    f30399c = new a(context);
                }
            }
        }
        return f30399c;
    }

    public IBinder a(int i2) {
        try {
            if (this.f30401b != null) {
                return this.f30401b.queryBinder(i2);
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
        this.f30402d = new CountDownLatch(1);
        this.f30400a.bindService(new Intent(this.f30400a, BinderPoolService.class), this.f30405g, 1);
        this.f30404f = System.currentTimeMillis();
        try {
            this.f30402d.await();
        } catch (InterruptedException e2) {
            u.c("MultiProcess", "connectBinderPoolService throws: ", e2);
        }
    }
}
