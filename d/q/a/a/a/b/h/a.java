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
    public com.yxcorp.kuaishou.addfp.a.b.b f66850b;

    /* renamed from: c  reason: collision with root package name */
    public Context f66851c;

    /* renamed from: a  reason: collision with root package name */
    public com.yxcorp.kuaishou.addfp.a.b.g.a f66849a = null;

    /* renamed from: d  reason: collision with root package name */
    public CountDownLatch f66852d = new CountDownLatch(1);

    /* renamed from: e  reason: collision with root package name */
    public ServiceConnection f66853e = new b(this);

    public final String a() {
        try {
            if (this.f66849a != null) {
                return this.f66849a.a();
            }
            return null;
        } catch (RemoteException unused) {
            return null;
        }
    }

    public final void c(Context context) {
        ServiceConnection serviceConnection = this.f66853e;
        if (serviceConnection == null || context == null) {
            return;
        }
        context.unbindService(serviceConnection);
    }

    public final void d(Context context, com.yxcorp.kuaishou.addfp.a.b.b bVar) {
        try {
            this.f66850b = bVar;
            this.f66851c = context;
            Intent intent = new Intent();
            intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
            if (!context.bindService(intent, this.f66853e, 1)) {
                d.q.a.a.c.b.b.e("sumsang off");
                e(false);
                return;
            }
            this.f66852d.await(2000L, TimeUnit.MILLISECONDS);
            if (this.f66849a != null) {
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
                this.f66850b.a(this.f66849a);
            } else {
                this.f66850b.e();
            }
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
        }
    }

    public final boolean f() {
        return this.f66849a != null;
    }
}
