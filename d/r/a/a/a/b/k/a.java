package d.r.a.a.a.b.k;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: f  reason: collision with root package name */
    public static String f68493f = "com.mdid.msa";

    /* renamed from: b  reason: collision with root package name */
    public com.yxcorp.kuaishou.addfp.a.b.b f68495b;

    /* renamed from: c  reason: collision with root package name */
    public Context f68496c;

    /* renamed from: a  reason: collision with root package name */
    public com.yxcorp.kuaishou.addfp.a.b.j.a f68494a = null;

    /* renamed from: d  reason: collision with root package name */
    public CountDownLatch f68497d = new CountDownLatch(1);

    /* renamed from: e  reason: collision with root package name */
    public ServiceConnection f68498e = new b(this);

    public static a f() {
        a aVar;
        aVar = c.f68500a;
        return aVar;
    }

    public static boolean g(Context context) {
        try {
            context.getPackageManager().getPackageInfo(f68493f, 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public final String a() {
        try {
            if (this.f68494a != null) {
                return this.f68494a.a();
            }
            return null;
        } catch (RemoteException unused) {
            return null;
        }
    }

    public final void c(Context context) {
        try {
            if (this.f68498e != null && context != null) {
                context.unbindService(this.f68498e);
            }
            if (this.f68494a != null) {
                this.f68494a.c();
            }
        } catch (Throwable th) {
            d.r.a.a.c.b.b.c(th);
        }
    }

    public final void d(Context context, com.yxcorp.kuaishou.addfp.a.b.b bVar) {
        try {
            this.f68495b = bVar;
            this.f68496c = context;
            if (g(context)) {
                String packageName = context.getPackageName();
                Intent intent = new Intent();
                intent.setClassName(f68493f, "com.mdid.msa.service.MsaKlService");
                intent.setAction("com.bun.msa.action.start.service");
                intent.putExtra("com.bun.msa.param.pkgname", packageName);
                try {
                    intent.putExtra("com.bun.msa.param.runinset", true);
                    context.startService(intent);
                } catch (Exception e2) {
                    d.r.a.a.c.b.b.c(e2);
                }
            }
            Intent intent2 = new Intent();
            intent2.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
            intent2.setAction("com.bun.msa.action.bindto.service");
            intent2.putExtra("com.bun.msa.param.pkgname", context.getPackageName());
            if (!context.bindService(intent2, this.f68498e, 1)) {
                d.r.a.a.c.b.b.e("zte off");
                e(false);
                return;
            }
            this.f68497d.await(2000L, TimeUnit.MILLISECONDS);
            if (this.f68494a != null) {
                e(true);
            } else {
                e(false);
            }
        } catch (Throwable th) {
            d.r.a.a.c.b.b.c(th);
            e(false);
        }
    }

    public final void e(boolean z) {
        try {
            if (z) {
                this.f68495b.a(this.f68494a);
            } else {
                this.f68495b.e();
            }
        } catch (Throwable th) {
            d.r.a.a.c.b.b.c(th);
        }
    }

    public final boolean h() {
        try {
            if (this.f68494a == null) {
                return false;
            }
            return this.f68494a.b();
        } catch (Throwable th) {
            d.r.a.a.c.b.b.c(th);
            return false;
        }
    }
}
