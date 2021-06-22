package d.q.a.a.a.b.h;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.RemoteException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: b  reason: collision with root package name */
    public com.yxcorp.kuaishou.addfp.a.b.b f71469b;

    /* renamed from: c  reason: collision with root package name */
    public Context f71470c;

    /* renamed from: a  reason: collision with root package name */
    public com.yxcorp.kuaishou.addfp.a.b.g.a f71468a = null;

    /* renamed from: d  reason: collision with root package name */
    public CountDownLatch f71471d = new CountDownLatch(1);

    /* renamed from: e  reason: collision with root package name */
    public ServiceConnection f71472e = new b(this);

    public final String a() {
        try {
            if (this.f71468a != null) {
                return this.f71468a.a();
            }
            return null;
        } catch (RemoteException unused) {
            return null;
        }
    }

    public final void c(Context context) {
        ServiceConnection serviceConnection = this.f71472e;
        if (serviceConnection == null || context == null) {
            return;
        }
        context.unbindService(serviceConnection);
    }

    public final void d(Context context, com.yxcorp.kuaishou.addfp.a.b.b bVar) {
        try {
            this.f71469b = bVar;
            this.f71470c = context;
            Intent intent = new Intent();
            intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
            if (!context.bindService(intent, this.f71472e, 1)) {
                d.q.a.a.c.b.b.e("sumsang off");
                e(false);
                return;
            }
            this.f71471d.await(2000L, TimeUnit.MILLISECONDS);
            if (this.f71468a != null) {
                e(true);
            } else {
                e(false);
            }
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
            e(false);
        }
    }

    public final void e(boolean z) {
        try {
            if (z) {
                this.f71469b.a(this.f71468a);
            } else {
                this.f71469b.e();
            }
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
        }
    }

    public final boolean f() {
        return this.f71468a != null;
    }
}
