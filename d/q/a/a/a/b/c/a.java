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
    public com.yxcorp.kuaishou.addfp.a.b.b f67542a;

    /* renamed from: b  reason: collision with root package name */
    public Context f67543b;

    /* renamed from: c  reason: collision with root package name */
    public d f67544c = null;

    /* renamed from: d  reason: collision with root package name */
    public CountDownLatch f67545d = new CountDownLatch(1);

    /* renamed from: e  reason: collision with root package name */
    public long f67546e = 0;

    /* renamed from: f  reason: collision with root package name */
    public ServiceConnection f67547f = new b(this);

    public a(Context context) {
        this.f67543b = context;
    }

    public final void c() {
        Context context;
        ServiceConnection serviceConnection = this.f67547f;
        if (serviceConnection == null || (context = this.f67543b) == null) {
            return;
        }
        context.unbindService(serviceConnection);
    }

    public final void d(com.yxcorp.kuaishou.addfp.a.b.b bVar) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            this.f67542a = bVar;
            this.f67543b.getPackageManager().getPackageInfo("com.huawei.hwid", 0);
            Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            intent.setPackage("com.huawei.hwid");
            this.f67546e = System.currentTimeMillis();
            d.q.a.a.c.b.b.e("hua wei lala  : " + this.f67546e);
            if (!this.f67543b.bindService(intent, this.f67547f, 1)) {
                e(false);
                return;
            }
            this.f67545d.await(2000L, TimeUnit.MILLISECONDS);
            if (this.f67544c == null) {
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
                this.f67542a.a(this.f67544c);
            } else {
                this.f67542a.e();
            }
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
        }
    }
}
