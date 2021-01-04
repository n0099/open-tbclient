package com.yxcorp.kuaishou.addfp.a.b.c;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private Context f14649a;
    private CountDownLatch d = new CountDownLatch(1);
    private ServiceConnection pgf = new f(this);
    private com.yxcorp.kuaishou.addfp.a.b.b qeq;
    private a qev;

    public e(Context context, com.yxcorp.kuaishou.addfp.a.b.b bVar) {
        this.f14649a = null;
        try {
            this.f14649a = context;
            this.qeq = bVar;
            Intent intent = new Intent();
            intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
            if (this.f14649a.bindService(intent, this.pgf, 1)) {
                com.yxcorp.kuaishou.addfp.android.b.b.b("bindService Successful!");
                this.d.await(2000L, TimeUnit.MILLISECONDS);
                if (this.qev != null) {
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
                this.qeq.a(this.qev);
            } else {
                this.qeq.e();
            }
        } catch (Throwable th) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(th);
        }
    }

    public final String a() {
        try {
            if (this.qev != null) {
                return this.qev.a();
            }
        } catch (Throwable th) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(th);
        }
        return null;
    }

    public final String b() {
        try {
            if (this.qev != null) {
                return this.qev.b();
            }
        } catch (Throwable th) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(th);
        }
        return null;
    }

    public final boolean c() {
        try {
            if (this.qev == null) {
                return false;
            }
            return this.qev.c();
        } catch (Throwable th) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(th);
            return false;
        }
    }

    public final String d() {
        String packageName = this.f14649a.getPackageName();
        if (packageName == null || packageName.equals("")) {
            com.yxcorp.kuaishou.addfp.android.b.b.b("empty pkg");
        } else {
            try {
                if (this.qev != null) {
                    return this.qev.a(packageName);
                }
            } catch (Throwable th) {
                com.yxcorp.kuaishou.addfp.android.b.b.a(th);
            }
        }
        return null;
    }

    public final String e() {
        String packageName = this.f14649a.getPackageName();
        if (packageName == null || packageName.equals("")) {
            com.yxcorp.kuaishou.addfp.android.b.b.b("empty pkg");
        } else {
            try {
                if (this.qev != null) {
                    return this.qev.b(packageName);
                }
            } catch (Throwable th) {
                com.yxcorp.kuaishou.addfp.android.b.b.a(th);
            }
        }
        return null;
    }

    public final void f() {
        try {
            this.f14649a.unbindService(this.pgf);
            com.yxcorp.kuaishou.addfp.android.b.b.b("unBind Service");
        } catch (Throwable th) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(th);
        }
        this.qev = null;
    }
}
