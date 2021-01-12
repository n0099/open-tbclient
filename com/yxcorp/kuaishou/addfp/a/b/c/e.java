package com.yxcorp.kuaishou.addfp.a.b.c;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private Context f14350a;
    private CountDownLatch d = new CountDownLatch(1);
    private ServiceConnection pbC = new f(this);
    private a qbC;
    private com.yxcorp.kuaishou.addfp.a.b.b qbx;

    public e(Context context, com.yxcorp.kuaishou.addfp.a.b.b bVar) {
        this.f14350a = null;
        try {
            this.f14350a = context;
            this.qbx = bVar;
            Intent intent = new Intent();
            intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
            if (this.f14350a.bindService(intent, this.pbC, 1)) {
                com.yxcorp.kuaishou.addfp.android.b.b.b("bindService Successful!");
                this.d.await(2000L, TimeUnit.MILLISECONDS);
                if (this.qbC != null) {
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
                this.qbx.a(this.qbC);
            } else {
                this.qbx.e();
            }
        } catch (Throwable th) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(th);
        }
    }

    public final String a() {
        try {
            if (this.qbC != null) {
                return this.qbC.a();
            }
        } catch (Throwable th) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(th);
        }
        return null;
    }

    public final String b() {
        try {
            if (this.qbC != null) {
                return this.qbC.b();
            }
        } catch (Throwable th) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(th);
        }
        return null;
    }

    public final boolean c() {
        try {
            if (this.qbC == null) {
                return false;
            }
            return this.qbC.c();
        } catch (Throwable th) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(th);
            return false;
        }
    }

    public final String d() {
        String packageName = this.f14350a.getPackageName();
        if (packageName == null || packageName.equals("")) {
            com.yxcorp.kuaishou.addfp.android.b.b.b("empty pkg");
        } else {
            try {
                if (this.qbC != null) {
                    return this.qbC.a(packageName);
                }
            } catch (Throwable th) {
                com.yxcorp.kuaishou.addfp.android.b.b.a(th);
            }
        }
        return null;
    }

    public final String e() {
        String packageName = this.f14350a.getPackageName();
        if (packageName == null || packageName.equals("")) {
            com.yxcorp.kuaishou.addfp.android.b.b.b("empty pkg");
        } else {
            try {
                if (this.qbC != null) {
                    return this.qbC.b(packageName);
                }
            } catch (Throwable th) {
                com.yxcorp.kuaishou.addfp.android.b.b.a(th);
            }
        }
        return null;
    }

    public final void f() {
        try {
            this.f14350a.unbindService(this.pbC);
            com.yxcorp.kuaishou.addfp.android.b.b.b("unBind Service");
        } catch (Throwable th) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(th);
        }
        this.qbC = null;
    }
}
