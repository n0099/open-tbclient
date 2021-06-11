package d.b.c.a.a;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public class r {

    /* renamed from: d  reason: collision with root package name */
    public static final r f68928d = new a();

    /* renamed from: a  reason: collision with root package name */
    public boolean f68929a;

    /* renamed from: b  reason: collision with root package name */
    public long f68930b;

    /* renamed from: c  reason: collision with root package name */
    public long f68931c;

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
        this.f68929a = true;
        this.f68930b = j;
        return this;
    }

    public r b(long j, TimeUnit timeUnit) {
        if (j >= 0) {
            if (timeUnit != null) {
                this.f68931c = timeUnit.toNanos(j);
                return this;
            }
            throw new IllegalArgumentException("unit == null");
        }
        throw new IllegalArgumentException("timeout < 0: " + j);
    }

    public long c() {
        return this.f68931c;
    }

    public boolean d() {
        return this.f68929a;
    }

    public long e() {
        if (this.f68929a) {
            return this.f68930b;
        }
        throw new IllegalStateException("No deadline");
    }

    public r f() {
        this.f68931c = 0L;
        return this;
    }

    public r g() {
        this.f68929a = false;
        return this;
    }

    public void h() throws IOException {
        if (!Thread.interrupted()) {
            if (this.f68929a && this.f68930b - System.nanoTime() <= 0) {
                throw new InterruptedIOException("deadline reached");
            }
            return;
        }
        Thread.currentThread().interrupt();
        throw new InterruptedIOException("interrupted");
    }
}
