package com.yxcorp.kuaishou.addfp.a.b.g;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.RemoteException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public final class d {
    private Context d;
    private com.yxcorp.kuaishou.addfp.a.b.b qlC;
    public a qlO = null;

    /* renamed from: b  reason: collision with root package name */
    private String f14365b = null;
    private CountDownLatch e = new CountDownLatch(1);
    private ServiceConnection f = new e(this);

    private void a(boolean z) {
        try {
            if (z) {
                this.qlC.a(this.qlO);
            } else {
                this.qlC.e();
            }
        } catch (Throwable th) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(th);
        }
    }

    public final String a() {
        try {
            if (this.qlO != null) {
                return this.qlO.a();
            }
        } catch (RemoteException e) {
        }
        return null;
    }

    public final void a(Context context) {
        if (this.f == null || context == null) {
            return;
        }
        context.unbindService(this.f);
    }

    public final void a(Context context, com.yxcorp.kuaishou.addfp.a.b.b bVar) {
        try {
            this.qlC = bVar;
            this.d = context;
            Intent intent = new Intent();
            intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
            if (context.bindService(intent, this.f, 1)) {
                this.e.await(2000L, TimeUnit.MILLISECONDS);
                if (this.qlO != null) {
                    a(true);
                } else {
                    a(false);
                }
            } else {
                com.yxcorp.kuaishou.addfp.android.b.b.b("sumsang off");
                a(false);
            }
        } catch (Throwable th) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(th);
            a(false);
        }
    }

    public final boolean b() {
        return this.qlO != null;
    }
}
