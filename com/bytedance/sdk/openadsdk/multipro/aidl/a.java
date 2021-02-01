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
    private static volatile a c;

    /* renamed from: a  reason: collision with root package name */
    private Context f7346a;

    /* renamed from: b  reason: collision with root package name */
    private IBinderPool f7347b;
    private CountDownLatch d;
    private final Object e = new Object();
    private long f = 0;
    private ServiceConnection g = new ServiceConnection() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.a.1
        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            u.c("MultiProcess", "BinderPool......onServiceDisconnected");
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            a.this.f7347b = IBinderPool.Stub.asInterface(iBinder);
            try {
                a.this.f7347b.asBinder().linkToDeath(a.this.h, 0);
            } catch (RemoteException e) {
                u.c("MultiProcess", "onServiceConnected throws :", e);
            }
            a.this.d.countDown();
            u.b("MultiProcess", "onServiceConnected - binderService consume time ：" + (System.currentTimeMillis() - a.this.f));
        }
    };
    private IBinder.DeathRecipient h = new IBinder.DeathRecipient() { // from class: com.bytedance.sdk.openadsdk.multipro.aidl.a.2
        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            u.d("MultiProcess", "binder died.");
            a.this.f7347b.asBinder().unlinkToDeath(a.this.h, 0);
            a.this.f7347b = null;
            a.this.a();
        }
    };

    private a(Context context) {
        this.f7346a = context.getApplicationContext();
        a();
    }

    public static a a(Context context) {
        if (c == null) {
            synchronized (a.class) {
                if (c == null) {
                    c = new a(context);
                }
            }
        }
        return c;
    }

    public IBinder a(int i) {
        try {
            if (this.f7347b == null) {
                return null;
            }
            return this.f7347b.queryBinder(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a() {
        u.c("MultiProcess", "BinderPool......connectBinderPoolService");
        this.d = new CountDownLatch(1);
        this.f7346a.bindService(new Intent(this.f7346a, BinderPoolService.class), this.g, 1);
        this.f = System.currentTimeMillis();
        try {
            this.d.await();
        } catch (InterruptedException e) {
            u.c("MultiProcess", "connectBinderPoolService throws: ", e);
        }
    }
}
