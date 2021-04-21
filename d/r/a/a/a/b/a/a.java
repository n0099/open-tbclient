package d.r.a.a.a.b.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f68428a;

    /* renamed from: b  reason: collision with root package name */
    public com.yxcorp.kuaishou.addfp.a.b.a.b f68429b;

    /* renamed from: c  reason: collision with root package name */
    public com.yxcorp.kuaishou.addfp.a.b.b f68430c;

    /* renamed from: d  reason: collision with root package name */
    public CountDownLatch f68431d = new CountDownLatch(1);

    /* renamed from: e  reason: collision with root package name */
    public ServiceConnection f68432e = new b(this);

    public a(Context context) {
        this.f68428a = context;
    }

    public final void b() {
        Context context;
        ServiceConnection serviceConnection = this.f68432e;
        if (serviceConnection == null || (context = this.f68428a) == null) {
            return;
        }
        context.unbindService(serviceConnection);
    }

    public final void c(com.yxcorp.kuaishou.addfp.a.b.b bVar) {
        try {
            this.f68430c = bVar;
            Intent intent = new Intent("com.asus.msa.action.ACCESS_DID");
            ComponentName componentName = new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService");
            Intent intent2 = new Intent(intent);
            intent2.setComponent(componentName);
            if (!this.f68428a.bindService(intent2, this.f68432e, 1)) {
                d(false);
                return;
            }
            this.f68431d.await(2000L, TimeUnit.MILLISECONDS);
            if (this.f68429b != null) {
                d(true);
            } else {
                d(false);
            }
        } catch (Throwable unused) {
            d(false);
        }
    }

    public final void d(boolean z) {
        try {
            if (z) {
                this.f68430c.a(this.f68429b);
            } else {
                this.f68430c.e();
            }
        } catch (Throwable th) {
            d.r.a.a.c.b.b.c(th);
        }
    }
}
