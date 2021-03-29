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
    public com.yxcorp.kuaishou.addfp.a.b.b f67294a;

    /* renamed from: b  reason: collision with root package name */
    public Context f67295b;

    /* renamed from: c  reason: collision with root package name */
    public d f67296c = null;

    /* renamed from: d  reason: collision with root package name */
    public CountDownLatch f67297d = new CountDownLatch(1);

    /* renamed from: e  reason: collision with root package name */
    public long f67298e = 0;

    /* renamed from: f  reason: collision with root package name */
    public ServiceConnection f67299f = new b(this);

    public a(Context context) {
        this.f67295b = context;
    }

    public final void c() {
        Context context;
        ServiceConnection serviceConnection = this.f67299f;
        if (serviceConnection == null || (context = this.f67295b) == null) {
            return;
        }
        context.unbindService(serviceConnection);
    }

    public final void d(com.yxcorp.kuaishou.addfp.a.b.b bVar) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            this.f67294a = bVar;
            this.f67295b.getPackageManager().getPackageInfo("com.huawei.hwid", 0);
            Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            intent.setPackage("com.huawei.hwid");
            this.f67298e = System.currentTimeMillis();
            d.q.a.a.c.b.b.e("hua wei lala  : " + this.f67298e);
            if (!this.f67295b.bindService(intent, this.f67299f, 1)) {
                e(false);
                return;
            }
            this.f67297d.await(2000L, TimeUnit.MILLISECONDS);
            if (this.f67296c == null) {
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
                this.f67294a.a(this.f67296c);
            } else {
                this.f67294a.e();
            }
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
        }
    }
}
