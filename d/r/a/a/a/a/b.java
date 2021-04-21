package d.r.a.a.a.a;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public final class b implements a {

    /* renamed from: d  reason: collision with root package name */
    public static AtomicBoolean f68420d = new AtomicBoolean(false);

    /* renamed from: a  reason: collision with root package name */
    public a f68421a;

    /* renamed from: b  reason: collision with root package name */
    public CountDownLatch f68422b;

    /* renamed from: c  reason: collision with root package name */
    public d.r.a.a.a.b.b f68423c;

    public b() {
        this.f68422b = null;
        this.f68423c = null;
    }

    public /* synthetic */ b(byte b2) {
        this();
    }

    public static final b c() {
        b bVar;
        bVar = d.f68427a;
        return bVar;
    }

    public static /* synthetic */ String e(b bVar) {
        return !TextUtils.isEmpty(Build.MANUFACTURER) ? Build.MANUFACTURER.toLowerCase() : "";
    }

    @Override // d.r.a.a.a.a.a
    public final void a(boolean z, d.r.a.a.a.b.b bVar) {
        try {
            if (this.f68421a != null) {
                this.f68421a.a(z, bVar);
            }
        } catch (Throwable th) {
            d.r.a.a.c.b.b.c(th);
        }
    }

    public final void f(Context context, a aVar) {
        try {
            if (!f68420d.compareAndSet(false, true)) {
                d.r.a.a.c.b.b.e("OaHelper has been initialized,return");
                return;
            }
            if (Build.VERSION.SDK_INT >= 29) {
                this.f68422b = new CountDownLatch(1);
            }
            new Thread(new c(this, aVar, context)).start();
        } catch (Throwable th) {
            d.r.a.a.c.b.b.c(th);
            a(false, null);
        }
    }

    public final void h() {
        CountDownLatch countDownLatch = this.f68422b;
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
    }

    public final void i() {
        try {
            if (this.f68422b == null || this.f68422b.getCount() <= 0) {
                return;
            }
            d.r.a.a.c.b.b.e("awaitCdOaid");
            this.f68422b.await(2000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e2) {
            d.r.a.a.c.b.b.c(e2);
        }
    }
}
