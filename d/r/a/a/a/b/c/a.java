package d.r.a.a.a.b.c;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.yxcorp.kuaishou.addfp.a.b.b.d;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public com.yxcorp.kuaishou.addfp.a.b.b f68434a;

    /* renamed from: b  reason: collision with root package name */
    public Context f68435b;

    /* renamed from: c  reason: collision with root package name */
    public d f68436c = null;

    /* renamed from: d  reason: collision with root package name */
    public CountDownLatch f68437d = new CountDownLatch(1);

    /* renamed from: e  reason: collision with root package name */
    public long f68438e = 0;

    /* renamed from: f  reason: collision with root package name */
    public ServiceConnection f68439f = new b(this);

    public a(Context context) {
        this.f68435b = context;
    }

    public final void c() {
        Context context;
        ServiceConnection serviceConnection = this.f68439f;
        if (serviceConnection == null || (context = this.f68435b) == null) {
            return;
        }
        context.unbindService(serviceConnection);
    }

    public final void d(com.yxcorp.kuaishou.addfp.a.b.b bVar) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            this.f68434a = bVar;
            this.f68435b.getPackageManager().getPackageInfo("com.huawei.hwid", 0);
            Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            intent.setPackage("com.huawei.hwid");
            this.f68438e = System.currentTimeMillis();
            d.r.a.a.c.b.b.e("hua wei lala  : " + this.f68438e);
            if (!this.f68435b.bindService(intent, this.f68439f, 1)) {
                e(false);
                return;
            }
            this.f68437d.await(2000L, TimeUnit.MILLISECONDS);
            if (this.f68436c == null) {
                e(false);
                return;
            }
            d.r.a.a.c.b.b.e("lalala " + Long.toString(System.currentTimeMillis() - currentTimeMillis));
            e(true);
        } catch (Throwable th) {
            d.r.a.a.c.b.b.c(th);
            e(false);
        }
    }

    public final void e(boolean z) {
        try {
            if (z) {
                this.f68434a.a(this.f68436c);
            } else {
                this.f68434a.e();
            }
        } catch (Throwable th) {
            d.r.a.a.c.b.b.c(th);
        }
    }
}
