package d.b.c.a.a;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public class r {

    /* renamed from: d  reason: collision with root package name */
    public static final r f69032d = new a();

    /* renamed from: a  reason: collision with root package name */
    public boolean f69033a;

    /* renamed from: b  reason: collision with root package name */
    public long f69034b;

    /* renamed from: c  reason: collision with root package name */
    public long f69035c;

    /* loaded from: classes6.dex */
    public static class a extends r {
        @Override // d.b.c.a.a.r
        public r a(long j) {
            return this;
        }

        @Override // d.b.c.a.a.r
        public r b(long j, TimeUnit timeUnit) {
            return this;
        }

        @Override // d.b.c.a.a.r
        public void h() throws IOException {
        }
    }

    public r a(long j) {
        this.f69033a = true;
        this.f69034b = j;
        return this;
    }

    public r b(long j, TimeUnit timeUnit) {
        if (j >= 0) {
            if (timeUnit != null) {
                this.f69035c = timeUnit.toNanos(j);
                return this;
            }
            throw new IllegalArgumentException("unit == null");
        }
        throw new IllegalArgumentException("timeout < 0: " + j);
    }

    public long c() {
        return this.f69035c;
    }

    public boolean d() {
        return this.f69033a;
    }

    public long e() {
        if (this.f69033a) {
            return this.f69034b;
        }
        throw new IllegalStateException("No deadline");
    }

    public r f() {
        this.f69035c = 0L;
        return this;
    }

    public r g() {
        this.f69033a = false;
        return this;
    }

    public void h() throws IOException {
        if (!Thread.interrupted()) {
            if (this.f69033a && this.f69034b - System.nanoTime() <= 0) {
                throw new InterruptedIOException("deadline reached");
            }
            return;
        }
        Thread.currentThread().interrupt();
        throw new InterruptedIOException("interrupted");
    }
}
