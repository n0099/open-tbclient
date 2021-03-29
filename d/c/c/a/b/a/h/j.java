package d.c.c.a.b.a.h;

import java.util.concurrent.CountDownLatch;
/* loaded from: classes5.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    public final CountDownLatch f65386a = new CountDownLatch(1);

    /* renamed from: b  reason: collision with root package name */
    public long f65387b = -1;

    /* renamed from: c  reason: collision with root package name */
    public long f65388c = -1;

    public void a() {
        if (this.f65387b == -1) {
            this.f65387b = System.nanoTime();
            return;
        }
        throw new IllegalStateException();
    }

    public void b() {
        if (this.f65388c == -1 && this.f65387b != -1) {
            this.f65388c = System.nanoTime();
            this.f65386a.countDown();
            return;
        }
        throw new IllegalStateException();
    }

    public void c() {
        if (this.f65388c == -1) {
            long j = this.f65387b;
            if (j != -1) {
                this.f65388c = j - 1;
                this.f65386a.countDown();
                return;
            }
        }
        throw new IllegalStateException();
    }
}
