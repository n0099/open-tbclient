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
    public static AtomicBoolean f68273d = new AtomicBoolean(false);

    /* renamed from: a  reason: collision with root package name */
    public a f68274a;

    /* renamed from: b  reason: collision with root package name */
    public CountDownLatch f68275b;

    /* renamed from: c  reason: collision with root package name */
    public d.q.a.a.a.b.b f68276c;

    public b() {
        this.f68275b = null;
        this.f68276c = null;
    }

    public /* synthetic */ b(byte b2) {
        this();
    }

    public static final b c() {
        b bVar;
        bVar = d.f68280a;
        return bVar;
    }

    public static /* synthetic */ String e(b bVar) {
        return !TextUtils.isEmpty(Build.MANUFACTURER) ? Build.MANUFACTURER.toLowerCase() : "";
    }

    @Override // d.q.a.a.a.a.a
    public final void a(boolean z, d.q.a.a.a.b.b bVar) {
        try {
            if (this.f68274a != null) {
                this.f68274a.a(z, bVar);
            }
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
        }
    }

    public final void f(Context context, a aVar) {
        try {
            if (!f68273d.compareAndSet(false, true)) {
                d.q.a.a.c.b.b.e("OaHelper has been initialized,return");
                return;
            }
            if (Build.VERSION.SDK_INT >= 29) {
                this.f68275b = new CountDownLatch(1);
            }
            new Thread(new c(this, aVar, context)).start();
        } catch (Throwable th) {
            d.q.a.a.c.b.b.c(th);
            a(false, null);
        }
    }

    public final void h() {
        CountDownLatch countDownLatch = this.f68275b;
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
    }

    public final void i() {
        try {
            if (this.f68275b == null || this.f68275b.getCount() <= 0) {
                return;
            }
            d.q.a.a.c.b.b.e("awaitCdOaid");
            this.f68275b.await(2000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e2) {
            d.q.a.a.c.b.b.c(e2);
        }
    }
}
