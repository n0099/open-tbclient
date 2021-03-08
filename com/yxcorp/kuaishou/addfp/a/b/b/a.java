package com.yxcorp.kuaishou.addfp.a.b.b;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public final class a {
    private Context b;
    private com.yxcorp.kuaishou.addfp.a.b.b qmF;
    private d qmG = null;
    private CountDownLatch d = new CountDownLatch(1);
    private long e = 0;
    private ServiceConnection qmH = new b(this);

    public a(Context context) {
        this.b = context;
    }

    private void a(boolean z) {
        try {
            if (z) {
                this.qmF.a(this.qmG);
            } else {
                this.qmF.e();
            }
        } catch (Throwable th) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(th);
        }
    }

    public final void a() {
        if (this.qmH == null || this.b == null) {
            return;
        }
        this.b.unbindService(this.qmH);
    }

    public final void a(com.yxcorp.kuaishou.addfp.a.b.b bVar) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            this.qmF = bVar;
            this.b.getPackageManager().getPackageInfo("com.huawei.hwid", 0);
            Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            intent.setPackage("com.huawei.hwid");
            this.e = System.currentTimeMillis();
            com.yxcorp.kuaishou.addfp.android.b.b.b("hua wei lala  : " + this.e);
            if (this.b.bindService(intent, this.qmH, 1)) {
                this.d.await(2000L, TimeUnit.MILLISECONDS);
                if (this.qmG != null) {
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
