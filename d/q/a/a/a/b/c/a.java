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
    public com.yxcorp.kuaishou.addfp.a.b.b f71328a;

    /* renamed from: b  reason: collision with root package name */
    public Context f71329b;

    /* renamed from: c  reason: collision with root package name */
    public d f71330c = null;

    /* renamed from: d  reason: collision with root package name */
    public CountDownLatch f71331d = new CountDownLatch(1);

    /* renamed from: e  reason: collision with root package name */
    public long f71332e = 0;

    /* renamed from: f  reason: collision with root package name */
    public ServiceConnection f71333f = new b(this);

    public a(Context context) {
        this.f71329b = context;
    }

    public final void c() {
        Context context;
        ServiceConnection serviceConnection = this.f71333f;
        if (serviceConnection == null || (context = this.f71329b) == null) {
            return;
        }
        context.unbindService(serviceConnection);
    }

    public final void d(com.yxcorp.kuaishou.addfp.a.b.b bVar) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            this.f71328a = bVar;
            this.f71329b.getPackageManager().getPackageInfo("com.huawei.hwid", 0);
            Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
            intent.setPackage("com.huawei.hwid");
            this.f71332e = System.currentTimeMillis();
            d.q.a.a.c.b.b.e("hua wei lala  : " + this.f71332e);
            if (!this.f71329b.bindService(intent, this.f71333f, 1)) {
                e(false);
                return;
            }
            this.f71331d.await(2000L, TimeUnit.MILLISECONDS);
            if (this.f71330c == null) {
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
                this.f71328a.a(this.f71330c);
            } else {
                this.f71328a.e();
            }
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
        }
    }
}
