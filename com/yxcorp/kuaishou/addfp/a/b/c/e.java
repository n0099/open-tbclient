package com.yxcorp.kuaishou.addfp.a.b.c;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private Context f8602a;
    private CountDownLatch d = new CountDownLatch(1);
    private ServiceConnection poA = new f(this);
    private com.yxcorp.kuaishou.addfp.a.b.b qmD;
    private a qmJ;

    public e(Context context, com.yxcorp.kuaishou.addfp.a.b.b bVar) {
        this.f8602a = null;
        try {
            this.f8602a = context;
            this.qmD = bVar;
            Intent intent = new Intent();
            intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
            if (this.f8602a.bindService(intent, this.poA, 1)) {
                com.yxcorp.kuaishou.addfp.android.b.b.b("bindService Successful!");
                this.d.await(2000L, TimeUnit.MILLISECONDS);
                if (this.qmJ != null) {
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
                this.qmD.a(this.qmJ);
            } else {
                this.qmD.e();
            }
        } catch (Throwable th) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(th);
        }
    }

    public final String a() {
        try {
            if (this.qmJ != null) {
                return this.qmJ.a();
            }
        } catch (Throwable th) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(th);
        }
        return null;
    }

    public final String b() {
        try {
            if (this.qmJ != null) {
                return this.qmJ.b();
            }
        } catch (Throwable th) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(th);
        }
        return null;
    }

    public final boolean c() {
        try {
            if (this.qmJ == null) {
                return false;
            }
            return this.qmJ.c();
        } catch (Throwable th) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(th);
            return false;
        }
    }

    public final String d() {
        String packageName = this.f8602a.getPackageName();
        if (packageName == null || packageName.equals("")) {
            com.yxcorp.kuaishou.addfp.android.b.b.b("empty pkg");
        } else {
            try {
                if (this.qmJ != null) {
                    return this.qmJ.a(packageName);
                }
            } catch (Throwable th) {
                com.yxcorp.kuaishou.addfp.android.b.b.a(th);
            }
        }
        return null;
    }

    public final String e() {
        String packageName = this.f8602a.getPackageName();
        if (packageName == null || packageName.equals("")) {
            com.yxcorp.kuaishou.addfp.android.b.b.b("empty pkg");
        } else {
            try {
                if (this.qmJ != null) {
                    return this.qmJ.b(packageName);
                }
            } catch (Throwable th) {
                com.yxcorp.kuaishou.addfp.android.b.b.a(th);
            }
        }
        return null;
    }

    public final void f() {
        try {
            this.f8602a.unbindService(this.poA);
            com.yxcorp.kuaishou.addfp.android.b.b.b("unBind Service");
        } catch (Throwable th) {
            com.yxcorp.kuaishou.addfp.android.b.b.a(th);
        }
        this.qmJ = null;
    }
}
