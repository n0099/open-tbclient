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
    private com.yxcorp.kuaishou.addfp.a.b.b qmD;
    public a qmQ = null;
    private String b = null;
    private CountDownLatch e = new CountDownLatch(1);
    private ServiceConnection qmH = new e(this);

    private void a(boolean z) {
        try {
            if (z) {
                this.qmD.a(this.qmQ);
            } else {
                this.qmD.e();
            }
        } catch (Throwable th) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(th);
        }
    }

    public final String a() {
        try {
            if (this.qmQ != null) {
                return this.qmQ.a();
            }
        } catch (RemoteException e) {
        }
        return null;
    }

    public final void a(Context context) {
        if (this.qmH == null || context == null) {
            return;
        }
        context.unbindService(this.qmH);
    }

    public final void a(Context context, com.yxcorp.kuaishou.addfp.a.b.b bVar) {
        try {
            this.qmD = bVar;
            this.d = context;
            Intent intent = new Intent();
            intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
            if (context.bindService(intent, this.qmH, 1)) {
                this.e.await(2000L, TimeUnit.MILLISECONDS);
                if (this.qmQ != null) {
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
        return this.qmQ != null;
    }
}
