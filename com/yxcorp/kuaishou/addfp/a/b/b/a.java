package com.yxcorp.kuaishou.addfp.a.b.b;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public final class a {

    /* renamed from: b  reason: collision with root package name */
    private Context f14343b;
    private com.yxcorp.kuaishou.addfp.a.b.b qbA;
    private d qbB = null;
    private CountDownLatch d = new CountDownLatch(1);
    private long e = 0;
    private ServiceConnection f = new b(this);

    public a(Context context) {
        this.f14343b = context;
    }

    private void a(boolean z) {
        try {
            if (z) {
                this.qbA.a(this.qbB);
            } else {
                this.qbA.e();
            }
        } catch (Throwable th) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(th);
        }
    }

    public final void a() {
        if (this.f == null || this.f14343b == null) {
            return;
        }
        this.f14343b.unbindService(this.f);
    }

    public final void a(com.yxcorp.kuaishou.addfp.a.b.b bVar) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            this.qbA = bVar;
            this.f14343b.getPackageManager().getPackageInfo("com.huawei.hwid", 0);
            Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            intent.setPackage("com.huawei.hwid");
            this.e = System.currentTimeMillis();
            com.yxcorp.kuaishou.addfp.android.b.b.b("hua wei lala  : " + this.e);
            if (this.f14343b.bindService(intent, this.f, 1)) {
                this.d.await(2000L, TimeUnit.MILLISECONDS);
                if (this.qbB != null) {
                    com.yxcorp.kuaishou.addfp.android.b.b.b("lalala " + Long.toString(System.currentTimeMillis() - currentTimeMillis));
                    a(true);
                } else {
                    a(false);
                }
            } else {
                a(false);
            }
        } catch (Throwable th) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(th);
            a(false);
        }
    }
}
