package d.q.a.a.a.b.k;

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
    public static String f66873f = "com.mdid.msa";

    /* renamed from: b  reason: collision with root package name */
    public com.yxcorp.kuaishou.addfp.a.b.b f66875b;

    /* renamed from: c  reason: collision with root package name */
    public Context f66876c;

    /* renamed from: a  reason: collision with root package name */
    public com.yxcorp.kuaishou.addfp.a.b.j.a f66874a = null;

    /* renamed from: d  reason: collision with root package name */
    public CountDownLatch f66877d = new CountDownLatch(1);

    /* renamed from: e  reason: collision with root package name */
    public ServiceConnection f66878e = new b(this);

    public static a f() {
        a aVar;
        aVar = c.f66880a;
        return aVar;
    }

    public static boolean g(Context context) {
        try {
            context.getPackageManager().getPackageInfo(f66873f, 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public final String a() {
        try {
            if (this.f66874a != null) {
                return this.f66874a.a();
            }
            return null;
        } catch (RemoteException unused) {
            return null;
        }
    }

    public final void c(Context context) {
        try {
            if (this.f66878e != null && context != null) {
                context.unbindService(this.f66878e);
            }
            if (this.f66874a != null) {
                this.f66874a.c();
            }
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
        }
    }

    public final void d(Context context, com.yxcorp.kuaishou.addfp.a.b.b bVar) {
        try {
            this.f66875b = bVar;
            this.f66876c = context;
            if (g(context)) {
                String packageName = context.getPackageName();
                Intent intent = new Intent();
                intent.setClassName(f66873f, "com.mdid.msa.service.MsaKlService");
                intent.setAction("com.bun.msa.action.start.service");
                intent.putExtra("com.bun.msa.param.pkgname", packageName);
                try {
                    intent.putExtra("com.bun.msa.param.runinset", true);
                    context.startService(intent);
                } catch (Exception e2) {
                    d.q.a.a.c.b.b.c(e2);
                }
            }
            Intent intent2 = new Intent();
            intent2.setClassName("com.mdid.msa", "com.mdid.msa.service.MsaIdService");
            intent2.setAction("com.bun.msa.action.bindto.service");
            intent2.putExtra("com.bun.msa.param.pkgname", context.getPackageName());
            if (!context.bindService(intent2, this.f66878e, 1)) {
                d.q.a.a.c.b.b.e("zte off");
                e(false);
                return;
            }
            this.f66877d.await(2000L, TimeUnit.MILLISECONDS);
            if (this.f66874a != null) {
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
                this.f66875b.a(this.f66874a);
            } else {
                this.f66875b.e();
            }
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
        }
    }

    public final boolean h() {
        try {
            if (this.f66874a == null) {
                return false;
            }
            return this.f66874a.b();
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
            return false;
        }
    }
}
