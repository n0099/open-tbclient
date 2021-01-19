package com.yxcorp.kuaishou.addfp.a.b.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public final class e {

    /* renamed from: b  reason: collision with root package name */
    private Context f14342b;
    private CountDownLatch d = new CountDownLatch(1);
    private ServiceConnection pbD = new f(this);
    public b qbx;
    private com.yxcorp.kuaishou.addfp.a.b.b qby;

    public e(Context context) {
        this.f14342b = context;
    }

    private void a(boolean z) {
        try {
            if (z) {
                this.qby.a(this.qbx);
            } else {
                this.qby.e();
            }
        } catch (Throwable th) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(th);
        }
    }

    public final void a() {
        if (this.pbD == null || this.f14342b == null) {
            return;
        }
        this.f14342b.unbindService(this.pbD);
    }

    public final void a(com.yxcorp.kuaishou.addfp.a.b.b bVar) {
        try {
            this.qby = bVar;
            Intent intent = new Intent("com.asus.msa.action.ACCESS_DID");
            ComponentName componentName = new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService");
            Intent intent2 = new Intent(intent);
            intent2.setComponent(componentName);
            if (this.f14342b.bindService(intent2, this.pbD, 1)) {
                this.d.await(2000L, TimeUnit.MILLISECONDS);
                if (this.qbx != null) {
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
