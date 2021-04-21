package d.r.a.a.a.b.d;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f68441a;

    /* renamed from: b  reason: collision with root package name */
    public com.yxcorp.kuaishou.addfp.a.b.c.a f68442b;

    /* renamed from: c  reason: collision with root package name */
    public com.yxcorp.kuaishou.addfp.a.b.b f68443c;

    /* renamed from: d  reason: collision with root package name */
    public CountDownLatch f68444d = new CountDownLatch(1);

    /* renamed from: e  reason: collision with root package name */
    public ServiceConnection f68445e = new b(this);

    public a(Context context, com.yxcorp.kuaishou.addfp.a.b.b bVar) {
        this.f68441a = null;
        try {
            this.f68441a = context;
            this.f68443c = bVar;
            Intent intent = new Intent();
            intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
            if (!this.f68441a.bindService(intent, this.f68445e, 1)) {
                d(false);
                d.r.a.a.c.b.b.e("bindService Failed!");
                return;
            }
            d.r.a.a.c.b.b.e("bindService Successful!");
            this.f68444d.await(2000L, TimeUnit.MILLISECONDS);
            if (this.f68442b != null) {
                d(true);
            } else {
                d(false);
            }
        } catch (Throwable th) {
            d.r.a.a.c.b.b.c(th);
            d(false);
        }
    }

    public final String b() {
        try {
            if (this.f68442b != null) {
                return this.f68442b.a();
            }
            return null;
        } catch (Throwable th) {
            d.r.a.a.c.b.b.c(th);
            return null;
        }
    }

    public final void d(boolean z) {
        try {
            if (z) {
                this.f68443c.a(this.f68442b);
            } else {
                this.f68443c.e();
            }
        } catch (Throwable th) {
            d.r.a.a.c.b.b.c(th);
        }
    }

    public final String e() {
        try {
            if (this.f68442b != null) {
                return this.f68442b.b();
            }
            return null;
        } catch (Throwable th) {
            d.r.a.a.c.b.b.c(th);
            return null;
        }
    }

    public final boolean f() {
        try {
            if (this.f68442b == null) {
                return false;
            }
            return this.f68442b.c();
        } catch (Throwable th) {
            d.r.a.a.c.b.b.c(th);
            return false;
        }
    }

    public final String g() {
        String packageName = this.f68441a.getPackageName();
        if (packageName == null || packageName.equals("")) {
            d.r.a.a.c.b.b.e("empty pkg");
            return null;
        }
        try {
            if (this.f68442b != null) {
                return this.f68442b.a(packageName);
            }
            return null;
        } catch (Throwable th) {
            d.r.a.a.c.b.b.c(th);
            return null;
        }
    }

    public final String h() {
        String packageName = this.f68441a.getPackageName();
        if (packageName == null || packageName.equals("")) {
            d.r.a.a.c.b.b.e("empty pkg");
            return null;
        }
        try {
            if (this.f68442b != null) {
                return this.f68442b.b(packageName);
            }
            return null;
        } catch (Throwable th) {
            d.r.a.a.c.b.b.c(th);
            return null;
        }
    }

    public final void i() {
        try {
            this.f68441a.unbindService(this.f68445e);
            d.r.a.a.c.b.b.e("unBind Service");
        } catch (Throwable th) {
            d.r.a.a.c.b.b.c(th);
        }
        this.f68442b = null;
    }
}
