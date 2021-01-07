package com.yxcorp.kuaishou.addfp.a.b.c;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private Context f14650a;
    private CountDownLatch d = new CountDownLatch(1);
    private ServiceConnection pgf = new f(this);
    private com.yxcorp.kuaishou.addfp.a.b.b qfY;
    private a qgd;

    public e(Context context, com.yxcorp.kuaishou.addfp.a.b.b bVar) {
        this.f14650a = null;
        try {
            this.f14650a = context;
            this.qfY = bVar;
            Intent intent = new Intent();
            intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
            if (this.f14650a.bindService(intent, this.pgf, 1)) {
                com.yxcorp.kuaishou.addfp.android.b.b.b("bindService Successful!");
                this.d.await(2000L, TimeUnit.MILLISECONDS);
                if (this.qgd != null) {
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
                this.qfY.a(this.qgd);
            } else {
                this.qfY.e();
            }
        } catch (Throwable th) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(th);
        }
    }

    public final String a() {
        try {
            if (this.qgd != null) {
                return this.qgd.a();
            }
        } catch (Throwable th) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(th);
        }
        return null;
    }

    public final String b() {
        try {
            if (this.qgd != null) {
                return this.qgd.b();
            }
        } catch (Throwable th) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(th);
        }
        return null;
    }

    public final boolean c() {
        try {
            if (this.qgd == null) {
                return false;
            }
            return this.qgd.c();
        } catch (Throwable th) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(th);
            return false;
        }
    }

    public final String d() {
        String packageName = this.f14650a.getPackageName();
        if (packageName == null || packageName.equals("")) {
            com.yxcorp.kuaishou.addfp.android.b.b.b("empty pkg");
        } else {
            try {
                if (this.qgd != null) {
                    return this.qgd.a(packageName);
                }
            } catch (Throwable th) {
                com.yxcorp.kuaishou.addfp.android.b.b.a(th);
            }
        }
        return null;
    }

    public final String e() {
        String packageName = this.f14650a.getPackageName();
        if (packageName == null || packageName.equals("")) {
            com.yxcorp.kuaishou.addfp.android.b.b.b("empty pkg");
        } else {
            try {
                if (this.qgd != null) {
                    return this.qgd.b(packageName);
                }
            } catch (Throwable th) {
                com.yxcorp.kuaishou.addfp.android.b.b.a(th);
            }
        }
        return null;
    }

    public final void f() {
        try {
            this.f14650a.unbindService(this.pgf);
            com.yxcorp.kuaishou.addfp.android.b.b.b("unBind Service");
        } catch (Throwable th) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(th);
        }
        this.qgd = null;
    }
}
