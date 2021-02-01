package com.yxcorp.kuaishou.addfp.a.b.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public final class e {

    /* renamed from: b  reason: collision with root package name */
    private Context f14344b;
    private CountDownLatch d = new CountDownLatch(1);
    private ServiceConnection plS = new f(this);
    public b qlB;
    private com.yxcorp.kuaishou.addfp.a.b.b qlC;

    public e(Context context) {
        this.f14344b = context;
    }

    private void a(boolean z) {
        try {
            if (z) {
                this.qlC.a(this.qlB);
            } else {
                this.qlC.e();
            }
        } catch (Throwable th) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(th);
        }
    }

    public final void a() {
        if (this.plS == null || this.f14344b == null) {
            return;
        }
        this.f14344b.unbindService(this.plS);
    }

    public final void a(com.yxcorp.kuaishou.addfp.a.b.b bVar) {
        try {
            this.qlC = bVar;
            Intent intent = new Intent("com.asus.msa.action.ACCESS_DID");
            ComponentName componentName = new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService");
            Intent intent2 = new Intent(intent);
            intent2.setComponent(componentName);
            if (this.f14344b.bindService(intent2, this.plS, 1)) {
                this.d.await(2000L, TimeUnit.MILLISECONDS);
                if (this.qlB != null) {
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
