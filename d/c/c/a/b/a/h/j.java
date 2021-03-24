package d.c.c.a.b.a.h;

import java.util.concurrent.CountDownLatch;
/* loaded from: classes5.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    public final CountDownLatch f65385a = new CountDownLatch(1);

    /* renamed from: b  reason: collision with root package name */
    public long f65386b = -1;

    /* renamed from: c  reason: collision with root package name */
    public long f65387c = -1;

    public void a() {
        if (this.f65386b == -1) {
            this.f65386b = System.nanoTime();
            return;
        }
        throw new IllegalStateException();
    }

    public void b() {
        if (this.f65387c == -1 && this.f65386b != -1) {
            this.f65387c = System.nanoTime();
            this.f65385a.countDown();
            return;
        }
        throw new IllegalStateException();
    }

    public void c() {
        if (this.f65387c == -1) {
            long j = this.f65386b;
            if (j != -1) {
                this.f65387c = j - 1;
                this.f65385a.countDown();
                return;
            }
        }
        throw new IllegalStateException();
    }
}
