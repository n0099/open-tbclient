package d.q.a.a.a.b.d;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f71439a;

    /* renamed from: b  reason: collision with root package name */
    public com.yxcorp.kuaishou.addfp.a.b.c.a f71440b;

    /* renamed from: c  reason: collision with root package name */
    public com.yxcorp.kuaishou.addfp.a.b.b f71441c;

    /* renamed from: d  reason: collision with root package name */
    public CountDownLatch f71442d = new CountDownLatch(1);

    /* renamed from: e  reason: collision with root package name */
    public ServiceConnection f71443e = new b(this);

    public a(Context context, com.yxcorp.kuaishou.addfp.a.b.b bVar) {
        this.f71439a = null;
        try {
            this.f71439a = context;
            this.f71441c = bVar;
            Intent intent = new Intent();
            intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
            if (!this.f71439a.bindService(intent, this.f71443e, 1)) {
                d(false);
                d.q.a.a.c.b.b.e("bindService Failed!");
                return;
            }
            d.q.a.a.c.b.b.e("bindService Successful!");
            this.f71442d.await(2000L, TimeUnit.MILLISECONDS);
            if (this.f71440b != null) {
                d(true);
            } else {
                d(false);
            }
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
            d(false);
        }
    }

    public final String b() {
        try {
            if (this.f71440b != null) {
                return this.f71440b.a();
            }
            return null;
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
            return null;
        }
    }

    public final void d(boolean z) {
        try {
            if (z) {
                this.f71441c.a(this.f71440b);
            } else {
                this.f71441c.e();
            }
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
        }
    }

    public final String e() {
        try {
            if (this.f71440b != null) {
                return this.f71440b.b();
            }
            return null;
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
            return null;
        }
    }

    public final boolean f() {
        try {
            if (this.f71440b == null) {
                return false;
            }
            return this.f71440b.c();
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
            return false;
        }
    }

    public final String g() {
        String packageName = this.f71439a.getPackageName();
        if (packageName == null || packageName.equals("")) {
            d.q.a.a.c.b.b.e("empty pkg");
            return null;
        }
        try {
            if (this.f71440b != null) {
                return this.f71440b.a(packageName);
            }
            return null;
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
            return null;
        }
    }

    public final String h() {
        String packageName = this.f71439a.getPackageName();
        if (packageName == null || packageName.equals("")) {
            d.q.a.a.c.b.b.e("empty pkg");
            return null;
        }
        try {
            if (this.f71440b != null) {
                return this.f71440b.b(packageName);
            }
            return null;
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
            return null;
        }
    }

    public final void i() {
        try {
            this.f71439a.unbindService(this.f71443e);
            d.q.a.a.c.b.b.e("unBind Service");
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
        }
        this.f71440b = null;
    }
}
