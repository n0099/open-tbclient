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
    public com.yxcorp.kuaishou.addfp.a.b.b f66813a;

    /* renamed from: b  reason: collision with root package name */
    public Context f66814b;

    /* renamed from: c  reason: collision with root package name */
    public d f66815c = null;

    /* renamed from: d  reason: collision with root package name */
    public CountDownLatch f66816d = new CountDownLatch(1);

    /* renamed from: e  reason: collision with root package name */
    public long f66817e = 0;

    /* renamed from: f  reason: collision with root package name */
    public ServiceConnection f66818f = new b(this);

    public a(Context context) {
        this.f66814b = context;
    }

    public final void c() {
        Context context;
        ServiceConnection serviceConnection = this.f66818f;
        if (serviceConnection == null || (context = this.f66814b) == null) {
            return;
        }
        context.unbindService(serviceConnection);
    }

    public final void d(com.yxcorp.kuaishou.addfp.a.b.b bVar) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            this.f66813a = bVar;
            this.f66814b.getPackageManager().getPackageInfo("com.huawei.hwid", 0);
            Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            intent.setPackage("com.huawei.hwid");
            this.f66817e = System.currentTimeMillis();
            d.q.a.a.c.b.b.e("hua wei lala  : " + this.f66817e);
            if (!this.f66814b.bindService(intent, this.f66818f, 1)) {
                e(false);
                return;
            }
            this.f66816d.await(2000L, TimeUnit.MILLISECONDS);
            if (this.f66815c == null) {
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
                this.f66813a.a(this.f66815c);
            } else {
                this.f66813a.e();
            }
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
        }
    }
}
