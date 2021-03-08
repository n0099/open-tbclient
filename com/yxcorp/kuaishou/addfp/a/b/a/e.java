package com.yxcorp.kuaishou.addfp.a.b.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public final class e {
    private Context b;
    private CountDownLatch d = new CountDownLatch(1);
    private ServiceConnection poA = new f(this);
    public b qmC;
    private com.yxcorp.kuaishou.addfp.a.b.b qmD;

    public e(Context context) {
        this.b = context;
    }

    private void a(boolean z) {
        try {
            if (z) {
                this.qmD.a(this.qmC);
            } else {
                this.qmD.e();
            }
        } catch (Throwable th) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(th);
        }
    }

    public final void a() {
        if (this.poA == null || this.b == null) {
            return;
        }
        this.b.unbindService(this.poA);
    }

    public final void a(com.yxcorp.kuaishou.addfp.a.b.b bVar) {
        try {
            this.qmD = bVar;
            Intent intent = new Intent("com.asus.msa.action.ACCESS_DID");
            ComponentName componentName = new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService");
            Intent intent2 = new Intent(intent);
            intent2.setComponent(componentName);
            if (this.b.bindService(intent2, this.poA, 1)) {
                this.d.await(2000L, TimeUnit.MILLISECONDS);
                if (this.qmC != null) {
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
