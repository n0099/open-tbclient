package d.b.c.a.b.a.h;

import java.util.concurrent.CountDownLatch;
/* loaded from: classes6.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    public final CountDownLatch f65440a = new CountDownLatch(1);

    /* renamed from: b  reason: collision with root package name */
    public long f65441b = -1;

    /* renamed from: c  reason: collision with root package name */
    public long f65442c = -1;

    public void a() {
        if (this.f65441b == -1) {
            this.f65441b = System.nanoTime();
            return;
        }
        throw new IllegalStateException();
    }

    public void b() {
        if (this.f65442c == -1 && this.f65441b != -1) {
            this.f65442c = System.nanoTime();
            this.f65440a.countDown();
            return;
        }
        throw new IllegalStateException();
    }

    public void c() {
        if (this.f65442c == -1) {
            long j = this.f65441b;
            if (j != -1) {
                this.f65442c = j - 1;
                this.f65440a.countDown();
                return;
            }
        }
        throw new IllegalStateException();
    }
}
