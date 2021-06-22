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
    public com.yxcorp.kuaishou.addfp.a.b.b f71432a;

    /* renamed from: b  reason: collision with root package name */
    public Context f71433b;

    /* renamed from: c  reason: collision with root package name */
    public d f71434c = null;

    /* renamed from: d  reason: collision with root package name */
    public CountDownLatch f71435d = new CountDownLatch(1);

    /* renamed from: e  reason: collision with root package name */
    public long f71436e = 0;

    /* renamed from: f  reason: collision with root package name */
    public ServiceConnection f71437f = new b(this);

    public a(Context context) {
        this.f71433b = context;
    }

    public final void c() {
        Context context;
        ServiceConnection serviceConnection = this.f71437f;
        if (serviceConnection == null || (context = this.f71433b) == null) {
            return;
        }
        context.unbindService(serviceConnection);
    }

    public final void d(com.yxcorp.kuaishou.addfp.a.b.b bVar) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            this.f71432a = bVar;
            this.f71433b.getPackageManager().getPackageInfo("com.huawei.hwid", 0);
            Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            intent.setPackage("com.huawei.hwid");
            this.f71436e = System.currentTimeMillis();
            d.q.a.a.c.b.b.e("hua wei lala  : " + this.f71436e);
            if (!this.f71433b.bindService(intent, this.f71437f, 1)) {
                e(false);
                return;
            }
            this.f71435d.await(2000L, TimeUnit.MILLISECONDS);
            if (this.f71434c == null) {
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
                this.f71432a.a(this.f71434c);
            } else {
                this.f71432a.e();
            }
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
        }
    }
}
