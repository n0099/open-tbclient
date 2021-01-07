package com.yxcorp.kuaishou.addfp.a.b.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public final class e {

    /* renamed from: b  reason: collision with root package name */
    private Context f14642b;
    private CountDownLatch d = new CountDownLatch(1);
    private ServiceConnection pgf = new f(this);
    public b qfX;
    private com.yxcorp.kuaishou.addfp.a.b.b qfY;

    public e(Context context) {
        this.f14642b = context;
    }

    private void a(boolean z) {
        try {
            if (z) {
                this.qfY.a(this.qfX);
            } else {
                this.qfY.e();
            }
        } catch (Throwable th) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(th);
        }
    }

    public final void a() {
        if (this.pgf == null || this.f14642b == null) {
            return;
        }
        this.f14642b.unbindService(this.pgf);
    }

    public final void a(com.yxcorp.kuaishou.addfp.a.b.b bVar) {
        try {
            this.qfY = bVar;
            Intent intent = new Intent("com.asus.msa.action.ACCESS_DID");
            ComponentName componentName = new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService");
            Intent intent2 = new Intent(intent);
            intent2.setComponent(componentName);
            if (this.f14642b.bindService(intent2, this.pgf, 1)) {
                this.d.await(2000L, TimeUnit.MILLISECONDS);
                if (this.qfX != null) {
                    a(true);
                } else {
                    a(false);
                }
            } else {
                a(false);
            }
        } catch (Throwable th) {
            a(false);
        }
    }
}
