package d.q.a.a.a.a;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public final class b implements a {

    /* renamed from: d  reason: collision with root package name */
    public static AtomicBoolean f67280d = new AtomicBoolean(false);

    /* renamed from: a  reason: collision with root package name */
    public a f67281a;

    /* renamed from: b  reason: collision with root package name */
    public CountDownLatch f67282b;

    /* renamed from: c  reason: collision with root package name */
    public d.q.a.a.a.b.b f67283c;

    public b() {
        this.f67282b = null;
        this.f67283c = null;
    }

    public /* synthetic */ b(byte b2) {
        this();
    }

    public static final b c() {
        b bVar;
        bVar = d.f67287a;
        return bVar;
    }

    public static /* synthetic */ String e(b bVar) {
        return !TextUtils.isEmpty(Build.MANUFACTURER) ? Build.MANUFACTURER.toLowerCase() : "";
    }

    @Override // d.q.a.a.a.a.a
    public final void a(boolean z, d.q.a.a.a.b.b bVar) {
        try {
            if (this.f67281a != null) {
                this.f67281a.a(z, bVar);
            }
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
        }
    }

    public final void f(Context context, a aVar) {
        try {
            if (!f67280d.compareAndSet(false, true)) {
                d.q.a.a.c.b.b.e("OaHelper has been initialized,return");
                return;
            }
            if (Build.VERSION.SDK_INT >= 29) {
                this.f67282b = new CountDownLatch(1);
            }
            new Thread(new c(this, aVar, context)).start();
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
            a(false, null);
        }
    }

    public final void h() {
        CountDownLatch countDownLatch = this.f67282b;
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
    }

    public final void i() {
        try {
            if (this.f67282b == null || this.f67282b.getCount() <= 0) {
                return;
            }
            d.q.a.a.c.b.b.e("awaitCdOaid");
            this.f67282b.await(2000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e2) {
            d.q.a.a.c.b.b.c(e2);
        }
    }
}
