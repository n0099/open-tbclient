package d.b.c.a.b.a.h;

import java.util.concurrent.CountDownLatch;
/* loaded from: classes5.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    public final CountDownLatch f64711a = new CountDownLatch(1);

    /* renamed from: b  reason: collision with root package name */
    public long f64712b = -1;

    /* renamed from: c  reason: collision with root package name */
    public long f64713c = -1;

    public void a() {
        if (this.f64712b == -1) {
            this.f64712b = System.nanoTime();
            return;
        }
        throw new IllegalStateException();
    }

    public void b() {
        if (this.f64713c == -1 && this.f64712b != -1) {
            this.f64713c = System.nanoTime();
            this.f64711a.countDown();
            return;
        }
        throw new IllegalStateException();
    }

    public void c() {
        if (this.f64713c == -1) {
            long j = this.f64712b;
            if (j != -1) {
                this.f64713c = j - 1;
                this.f64711a.countDown();
                return;
            }
        }
        throw new IllegalStateException();
    }
}
