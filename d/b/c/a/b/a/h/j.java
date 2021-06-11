package d.b.c.a.b.a.h;

import java.util.concurrent.CountDownLatch;
/* loaded from: classes6.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    public final CountDownLatch f69171a = new CountDownLatch(1);

    /* renamed from: b  reason: collision with root package name */
    public long f69172b = -1;

    /* renamed from: c  reason: collision with root package name */
    public long f69173c = -1;

    public void a() {
        if (this.f69172b == -1) {
            this.f69172b = System.nanoTime();
            return;
        }
        throw new IllegalStateException();
    }

    public void b() {
        if (this.f69173c == -1 && this.f69172b != -1) {
            this.f69173c = System.nanoTime();
            this.f69171a.countDown();
            return;
        }
        throw new IllegalStateException();
    }

    public void c() {
        if (this.f69173c == -1) {
            long j = this.f69172b;
            if (j != -1) {
                this.f69173c = j - 1;
                this.f69171a.countDown();
                return;
            }
        }
        throw new IllegalStateException();
    }
}
