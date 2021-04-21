package d.c.c.a.b.a.h;

import java.util.concurrent.CountDownLatch;
/* loaded from: classes5.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    public final CountDownLatch f66326a = new CountDownLatch(1);

    /* renamed from: b  reason: collision with root package name */
    public long f66327b = -1;

    /* renamed from: c  reason: collision with root package name */
    public long f66328c = -1;

    public void a() {
        if (this.f66327b == -1) {
            this.f66327b = System.nanoTime();
            return;
        }
        throw new IllegalStateException();
    }

    public void b() {
        if (this.f66328c == -1 && this.f66327b != -1) {
            this.f66328c = System.nanoTime();
            this.f66326a.countDown();
            return;
        }
        throw new IllegalStateException();
    }

    public void c() {
        if (this.f66328c == -1) {
            long j = this.f66327b;
            if (j != -1) {
                this.f66328c = j - 1;
                this.f66326a.countDown();
                return;
            }
        }
        throw new IllegalStateException();
    }
}
