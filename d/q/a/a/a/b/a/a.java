package d.q.a.a.a.b.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f66807a;

    /* renamed from: b  reason: collision with root package name */
    public com.yxcorp.kuaishou.addfp.a.b.a.b f66808b;

    /* renamed from: c  reason: collision with root package name */
    public com.yxcorp.kuaishou.addfp.a.b.b f66809c;

    /* renamed from: d  reason: collision with root package name */
    public CountDownLatch f66810d = new CountDownLatch(1);

    /* renamed from: e  reason: collision with root package name */
    public ServiceConnection f66811e = new b(this);

    public a(Context context) {
        this.f66807a = context;
    }

    public final void b() {
        Context context;
        ServiceConnection serviceConnection = this.f66811e;
        if (serviceConnection == null || (context = this.f66807a) == null) {
            return;
        }
        context.unbindService(serviceConnection);
    }

    public final void c(com.yxcorp.kuaishou.addfp.a.b.b bVar) {
        try {
            this.f66809c = bVar;
            Intent intent = new Intent("com.asus.msa.action.ACCESS_DID");
            ComponentName componentName = new ComponentName("com.asus.msa.SupplementaryDID", "com.asus.msa.SupplementaryDID.SupplementaryDIDService");
            Intent intent2 = new Intent(intent);
            intent2.setComponent(componentName);
            if (!this.f66807a.bindService(intent2, this.f66811e, 1)) {
                d(false);
                return;
            }
            this.f66810d.await(2000L, TimeUnit.MILLISECONDS);
            if (this.f66808b != null) {
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
                this.f66809c.a(this.f66808b);
            } else {
                this.f66809c.e();
            }
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
        }
    }
}
