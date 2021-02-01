package com.yxcorp.kuaishou.addfp.a.b.c;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private Context f14352a;
    private CountDownLatch d = new CountDownLatch(1);
    private ServiceConnection plS = new f(this);
    private com.yxcorp.kuaishou.addfp.a.b.b qlC;
    private a qlH;

    public e(Context context, com.yxcorp.kuaishou.addfp.a.b.b bVar) {
        this.f14352a = null;
        try {
            this.f14352a = context;
            this.qlC = bVar;
            Intent intent = new Intent();
            intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
            if (this.f14352a.bindService(intent, this.plS, 1)) {
                com.yxcorp.kuaishou.addfp.android.b.b.b("bindService Successful!");
                this.d.await(2000L, TimeUnit.MILLISECONDS);
                if (this.qlH != null) {
                    a(true);
                } else {
                    a(false);
                }
            } else {
                a(false);
                com.yxcorp.kuaishou.addfp.android.b.b.b("bindService Failed!");
            }
        } catch (Throwable th) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(th);
            a(false);
        }
    }

    private void a(boolean z) {
        try {
            if (z) {
                this.qlC.a(this.qlH);
            } else {
                this.qlC.e();
            }
        } catch (Throwable th) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(th);
        }
    }

    public final String a() {
        try {
            if (this.qlH != null) {
                return this.qlH.a();
            }
        } catch (Throwable th) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(th);
        }
        return null;
    }

    public final String b() {
        try {
            if (this.qlH != null) {
                return this.qlH.b();
            }
        } catch (Throwable th) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(th);
        }
        return null;
    }

    public final boolean c() {
        try {
            if (this.qlH == null) {
                return false;
            }
            return this.qlH.c();
        } catch (Throwable th) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(th);
            return false;
        }
    }

    public final String d() {
        String packageName = this.f14352a.getPackageName();
        if (packageName == null || packageName.equals("")) {
            com.yxcorp.kuaishou.addfp.android.b.b.b("empty pkg");
        } else {
            try {
                if (this.qlH != null) {
                    return this.qlH.a(packageName);
                }
            } catch (Throwable th) {
                com.yxcorp.kuaishou.addfp.android.b.b.a(th);
            }
        }
        return null;
    }

    public final String e() {
        String packageName = this.f14352a.getPackageName();
        if (packageName == null || packageName.equals("")) {
            com.yxcorp.kuaishou.addfp.android.b.b.b("empty pkg");
        } else {
            try {
                if (this.qlH != null) {
                    return this.qlH.b(packageName);
                }
            } catch (Throwable th) {
                com.yxcorp.kuaishou.addfp.android.b.b.a(th);
            }
        }
        return null;
    }

    public final void f() {
        try {
            this.f14352a.unbindService(this.plS);
            com.yxcorp.kuaishou.addfp.android.b.b.b("unBind Service");
        } catch (Throwable th) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(th);
        }
        this.qlH = null;
    }
}
