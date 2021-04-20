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
    public com.yxcorp.kuaishou.addfp.a.b.b f68324b;

    /* renamed from: c  reason: collision with root package name */
    public Context f68325c;

    /* renamed from: a  reason: collision with root package name */
    public com.yxcorp.kuaishou.addfp.a.b.g.a f68323a = null;

    /* renamed from: d  reason: collision with root package name */
    public CountDownLatch f68326d = new CountDownLatch(1);

    /* renamed from: e  reason: collision with root package name */
    public ServiceConnection f68327e = new b(this);

    public final String a() {
        try {
            if (this.f68323a != null) {
                return this.f68323a.a();
            }
            return null;
        } catch (RemoteException unused) {
            return null;
        }
    }

    public final void c(Context context) {
        ServiceConnection serviceConnection = this.f68327e;
        if (serviceConnection == null || context == null) {
            return;
        }
        context.unbindService(serviceConnection);
    }

    public final void d(Context context, com.yxcorp.kuaishou.addfp.a.b.b bVar) {
        try {
            this.f68324b = bVar;
            this.f68325c = context;
            Intent intent = new Intent();
            intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
            if (!context.bindService(intent, this.f68327e, 1)) {
                d.q.a.a.c.b.b.e("sumsang off");
                e(false);
                return;
            }
            this.f68326d.await(2000L, TimeUnit.MILLISECONDS);
            if (this.f68323a != null) {
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
                this.f68324b.a(this.f68323a);
            } else {
                this.f68324b.e();
            }
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
        }
    }

    public final boolean f() {
        return this.f68323a != null;
    }
}
