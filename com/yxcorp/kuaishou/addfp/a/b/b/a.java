package com.yxcorp.kuaishou.addfp.a.b.b;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: b  reason: collision with root package name */
    private Context f14345b;
    private com.yxcorp.kuaishou.addfp.a.b.b qme;
    private d qmf = null;
    private CountDownLatch d = new CountDownLatch(1);
    private long e = 0;
    private ServiceConnection f = new b(this);

    public a(Context context) {
        this.f14345b = context;
    }

    private void a(boolean z) {
        try {
            if (z) {
                this.qme.a(this.qmf);
            } else {
                this.qme.e();
            }
        } catch (Throwable th) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(th);
        }
    }

    public final void a() {
        if (this.f == null || this.f14345b == null) {
            return;
        }
        this.f14345b.unbindService(this.f);
    }

    public final void a(com.yxcorp.kuaishou.addfp.a.b.b bVar) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            this.qme = bVar;
            this.f14345b.getPackageManager().getPackageInfo("com.huawei.hwid", 0);
            Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            intent.setPackage("com.huawei.hwid");
            this.e = System.currentTimeMillis();
            com.yxcorp.kuaishou.addfp.android.b.b.b("hua wei lala  : " + this.e);
            if (this.f14345b.bindService(intent, this.f, 1)) {
                this.d.await(2000L, TimeUnit.MILLISECONDS);
                if (this.qmf != null) {
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
