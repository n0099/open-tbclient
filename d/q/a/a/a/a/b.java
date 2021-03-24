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
    public static AtomicBoolean f67275d = new AtomicBoolean(false);

    /* renamed from: a  reason: collision with root package name */
    public a f67276a;

    /* renamed from: b  reason: collision with root package name */
    public CountDownLatch f67277b;

    /* renamed from: c  reason: collision with root package name */
    public d.q.a.a.a.b.b f67278c;

    public b() {
        this.f67277b = null;
        this.f67278c = null;
    }

    public /* synthetic */ b(byte b2) {
        this();
    }

    public static final b c() {
        b bVar;
        bVar = d.f67282a;
        return bVar;
    }

    public static /* synthetic */ String e(b bVar) {
        return !TextUtils.isEmpty(Build.MANUFACTURER) ? Build.MANUFACTURER.toLowerCase() : "";
    }

    @Override // d.q.a.a.a.a.a
    public final void a(boolean z, d.q.a.a.a.b.b bVar) {
        try {
            if (this.f67276a != null) {
                this.f67276a.a(z, bVar);
            }
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
        }
    }

    public final void f(Context context, a aVar) {
        try {
            if (!f67275d.compareAndSet(false, true)) {
                d.q.a.a.c.b.b.e("OaHelper has been initialized,return");
                return;
            }
            if (Build.VERSION.SDK_INT >= 29) {
                this.f67277b = new CountDownLatch(1);
            }
            new Thread(new c(this, aVar, context)).start();
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
            a(false, null);
        }
    }

    public final void h() {
        CountDownLatch countDownLatch = this.f67277b;
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
    }

    public final void i() {
        try {
            if (this.f67277b == null || this.f67277b.getCount() <= 0) {
                return;
            }
            d.q.a.a.c.b.b.e("awaitCdOaid");
            this.f67277b.await(2000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e2) {
            d.q.a.a.c.b.b.c(e2);
        }
    }
}
