package d.q.a.a.a.b.d;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f67549a;

    /* renamed from: b  reason: collision with root package name */
    public com.yxcorp.kuaishou.addfp.a.b.c.a f67550b;

    /* renamed from: c  reason: collision with root package name */
    public com.yxcorp.kuaishou.addfp.a.b.b f67551c;

    /* renamed from: d  reason: collision with root package name */
    public CountDownLatch f67552d = new CountDownLatch(1);

    /* renamed from: e  reason: collision with root package name */
    public ServiceConnection f67553e = new b(this);

    public a(Context context, com.yxcorp.kuaishou.addfp.a.b.b bVar) {
        this.f67549a = null;
        try {
            this.f67549a = context;
            this.f67551c = bVar;
            Intent intent = new Intent();
            intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
            if (!this.f67549a.bindService(intent, this.f67553e, 1)) {
                d(false);
                d.q.a.a.c.b.b.e("bindService Failed!");
                return;
            }
            d.q.a.a.c.b.b.e("bindService Successful!");
            this.f67552d.await(2000L, TimeUnit.MILLISECONDS);
            if (this.f67550b != null) {
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
            if (this.f67550b != null) {
                return this.f67550b.a();
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
                this.f67551c.a(this.f67550b);
            } else {
                this.f67551c.e();
            }
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
        }
    }

    public final String e() {
        try {
            if (this.f67550b != null) {
                return this.f67550b.b();
            }
            return null;
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
            return null;
        }
    }

    public final boolean f() {
        try {
            if (this.f67550b == null) {
                return false;
            }
            return this.f67550b.c();
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
            return false;
        }
    }

    public final String g() {
        String packageName = this.f67549a.getPackageName();
        if (packageName == null || packageName.equals("")) {
            d.q.a.a.c.b.b.e("empty pkg");
            return null;
        }
        try {
            if (this.f67550b != null) {
                return this.f67550b.a(packageName);
            }
            return null;
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
            return null;
        }
    }

    public final String h() {
        String packageName = this.f67549a.getPackageName();
        if (packageName == null || packageName.equals("")) {
            d.q.a.a.c.b.b.e("empty pkg");
            return null;
        }
        try {
            if (this.f67550b != null) {
                return this.f67550b.b(packageName);
            }
            return null;
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
            return null;
        }
    }

    public final void i() {
        try {
            this.f67549a.unbindService(this.f67553e);
            d.q.a.a.c.b.b.e("unBind Service");
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
        }
        this.f67550b = null;
    }
}
