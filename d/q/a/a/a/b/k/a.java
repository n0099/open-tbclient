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
    public static String f67559f = "com.mdid.msa";

    /* renamed from: b  reason: collision with root package name */
    public com.yxcorp.kuaishou.addfp.a.b.b f67561b;

    /* renamed from: c  reason: collision with root package name */
    public Context f67562c;

    /* renamed from: a  reason: collision with root package name */
    public com.yxcorp.kuaishou.addfp.a.b.j.a f67560a = null;

    /* renamed from: d  reason: collision with root package name */
    public CountDownLatch f67563d = new CountDownLatch(1);

    /* renamed from: e  reason: collision with root package name */
    public ServiceConnection f67564e = new b(this);

    public static a f() {
        a aVar;
        aVar = c.f67566a;
        return aVar;
    }

    public static boolean g(Context context) {
        try {
            context.getPackageManager().getPackageInfo(f67559f, 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public final String a() {
        try {
            if (this.f67560a != null) {
                return this.f67560a.a();
            }
            return null;
        } catch (RemoteException unused) {
            return null;
        }
    }

    public final void c(Context context) {
        try {
            if (this.f67564e != null && context != null) {
                context.unbindService(this.f67564e);
            }
            if (this.f67560a != null) {
                this.f67560a.c();
            }
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
        }
    }

    public final void d(Context context, com.yxcorp.kuaishou.addfp.a.b.b bVar) {
        try {
            this.f67561b = bVar;
            this.f67562c = context;
            if (g(context)) {
                String packageName = context.getPackageName();
                Intent intent = new Intent();
                intent.setClassName(f67559f, "com.mdid.msa.service.MsaKlService");
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
            if (!context.bindService(intent2, this.f67564e, 1)) {
                d.q.a.a.c.b.b.e("zte off");
                e(false);
                return;
            }
            this.f67563d.await(2000L, TimeUnit.MILLISECONDS);
            if (this.f67560a != null) {
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
                this.f67561b.a(this.f67560a);
            } else {
                this.f67561b.e();
            }
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
        }
    }

    public final boolean h() {
        try {
            if (this.f67560a == null) {
                return false;
            }
            return this.f67560a.b();
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
            return false;
        }
    }
}
