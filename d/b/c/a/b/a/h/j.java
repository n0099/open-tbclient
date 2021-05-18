package d.b.c.a.b.a.h;

import java.util.concurrent.CountDownLatch;
/* loaded from: classes6.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    public final CountDownLatch f65397a = new CountDownLatch(1);

    /* renamed from: b  reason: collision with root package name */
    public long f65398b = -1;

    /* renamed from: c  reason: collision with root package name */
    public long f65399c = -1;

    public void a() {
        if (this.f65398b == -1) {
            this.f65398b = System.nanoTime();
            return;
        }
        throw new IllegalStateException();
    }

    public void b() {
        if (this.f65399c == -1 && this.f65398b != -1) {
            this.f65399c = System.nanoTime();
            this.f65397a.countDown();
            return;
        }
        throw new IllegalStateException();
    }

    public void c() {
        if (this.f65399c == -1) {
            long j = this.f65398b;
            if (j != -1) {
                this.f65399c = j - 1;
                this.f65397a.countDown();
                return;
            }
        }
        throw new IllegalStateException();
    }
}
