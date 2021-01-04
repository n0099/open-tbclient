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
    private Context f14641b;
    private CountDownLatch d = new CountDownLatch(1);
    private ServiceConnection pgf = new f(this);
    public b qep;
    private com.yxcorp.kuaishou.addfp.a.b.b qeq;

    public e(Context context) {
        this.f14641b = context;
    }

    private void a(boolean z) {
        try {
            if (z) {
                this.qeq.a(this.qep);
            } else {
                this.qeq.e();
            }
        } catch (Throwable th) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(th);
        }
    }

    public final void a() {
        if (this.pgf == null || this.f14641b == null) {
            return;
        }
        this.f14641b.unbindService(this.pgf);
    }

    public final void a(com.yxcorp.kuaishou.addfp.a.b.b bVar) {
        try {
            this.qeq = bVar;
            Intent intent = new Intent("com.asus.msa.action.ACCESS_DID");
            ComponentName componentName = new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService");
            Intent intent2 = new Intent(intent);
            intent2.setComponent(componentName);
            if (this.f14641b.bindService(intent2, this.pgf, 1)) {
                this.d.await(2000L, TimeUnit.MILLISECONDS);
                if (this.qep != null) {
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
