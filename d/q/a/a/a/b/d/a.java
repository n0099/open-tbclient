package d.q.a.a.a.b.d;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f66820a;

    /* renamed from: b  reason: collision with root package name */
    public com.yxcorp.kuaishou.addfp.a.b.c.a f66821b;

    /* renamed from: c  reason: collision with root package name */
    public com.yxcorp.kuaishou.addfp.a.b.b f66822c;

    /* renamed from: d  reason: collision with root package name */
    public CountDownLatch f66823d = new CountDownLatch(1);

    /* renamed from: e  reason: collision with root package name */
    public ServiceConnection f66824e = new b(this);

    public a(Context context, com.yxcorp.kuaishou.addfp.a.b.b bVar) {
        this.f66820a = null;
        try {
            this.f66820a = context;
            this.f66822c = bVar;
            Intent intent = new Intent();
            intent.setClassName("com.zui.deviceidservice", "com.zui.deviceidservice.DeviceidService");
            if (!this.f66820a.bindService(intent, this.f66824e, 1)) {
                d(false);
                d.q.a.a.c.b.b.e("bindService Failed!");
                return;
            }
            d.q.a.a.c.b.b.e("bindService Successful!");
            this.f66823d.await(2000L, TimeUnit.MILLISECONDS);
            if (this.f66821b != null) {
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
            if (this.f66821b != null) {
                return this.f66821b.a();
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
                this.f66822c.a(this.f66821b);
            } else {
                this.f66822c.e();
            }
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
        }
    }

    public final String e() {
        try {
            if (this.f66821b != null) {
                return this.f66821b.b();
            }
            return null;
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
            return null;
        }
    }

    public final boolean f() {
        try {
            if (this.f66821b == null) {
                return false;
            }
            return this.f66821b.c();
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
            return false;
        }
    }

    public final String g() {
        String packageName = this.f66820a.getPackageName();
        if (packageName == null || packageName.equals("")) {
            d.q.a.a.c.b.b.e("empty pkg");
            return null;
        }
        try {
            if (this.f66821b != null) {
                return this.f66821b.a(packageName);
            }
            return null;
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
            return null;
        }
    }

    public final String h() {
        String packageName = this.f66820a.getPackageName();
        if (packageName == null || packageName.equals("")) {
            d.q.a.a.c.b.b.e("empty pkg");
            return null;
        }
        try {
            if (this.f66821b != null) {
                return this.f66821b.b(packageName);
            }
            return null;
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
            return null;
        }
    }

    public final void i() {
        try {
            this.f66820a.unbindService(this.f66824e);
            d.q.a.a.c.b.b.e("unBind Service");
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
        }
        this.f66821b = null;
    }
}
