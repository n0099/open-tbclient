package d.c.c.a.b.a.h;

import java.util.concurrent.CountDownLatch;
/* loaded from: classes5.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    public final CountDownLatch f66231a = new CountDownLatch(1);

    /* renamed from: b  reason: collision with root package name */
    public long f66232b = -1;

    /* renamed from: c  reason: collision with root package name */
    public long f66233c = -1;

    public void a() {
        if (this.f66232b == -1) {
            this.f66232b = System.nanoTime();
            return;
        }
        throw new IllegalStateException();
    }

    public void b() {
        if (this.f66233c == -1 && this.f66232b != -1) {
            this.f66233c = System.nanoTime();
            this.f66231a.countDown();
            return;
        }
        throw new IllegalStateException();
    }

    public void c() {
        if (this.f66233c == -1) {
            long j = this.f66232b;
            if (j != -1) {
                this.f66233c = j - 1;
                this.f66231a.countDown();
                return;
            }
        }
        throw new IllegalStateException();
    }
}
