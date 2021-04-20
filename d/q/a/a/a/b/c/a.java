package d.q.a.a.a.b.c;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.yxcorp.kuaishou.addfp.a.b.b.d;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public com.yxcorp.kuaishou.addfp.a.b.b f68287a;

    /* renamed from: b  reason: collision with root package name */
    public Context f68288b;

    /* renamed from: c  reason: collision with root package name */
    public d f68289c = null;

    /* renamed from: d  reason: collision with root package name */
    public CountDownLatch f68290d = new CountDownLatch(1);

    /* renamed from: e  reason: collision with root package name */
    public long f68291e = 0;

    /* renamed from: f  reason: collision with root package name */
    public ServiceConnection f68292f = new b(this);

    public a(Context context) {
        this.f68288b = context;
    }

    public final void c() {
        Context context;
        ServiceConnection serviceConnection = this.f68292f;
        if (serviceConnection == null || (context = this.f68288b) == null) {
            return;
        }
        context.unbindService(serviceConnection);
    }

    public final void d(com.yxcorp.kuaishou.addfp.a.b.b bVar) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            this.f68287a = bVar;
            this.f68288b.getPackageManager().getPackageInfo("com.huawei.hwid", 0);
            Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            intent.setPackage("com.huawei.hwid");
            this.f68291e = System.currentTimeMillis();
            d.q.a.a.c.b.b.e("hua wei lala  : " + this.f68291e);
            if (!this.f68288b.bindService(intent, this.f68292f, 1)) {
                e(false);
                return;
            }
            this.f68290d.await(2000L, TimeUnit.MILLISECONDS);
            if (this.f68289c == null) {
                e(false);
                return;
            }
            d.q.a.a.c.b.b.e("lalala " + Long.toString(System.currentTimeMillis() - currentTimeMillis));
            e(true);
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
            e(false);
        }
    }

    public final void e(boolean z) {
        try {
            if (z) {
                this.f68287a.a(this.f68289c);
            } else {
                this.f68287a.e();
            }
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
        }
    }
}
