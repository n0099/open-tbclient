package d.c.c.a.a;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public class r {

    /* renamed from: d  reason: collision with root package name */
    public static final r f66009d = new a();

    /* renamed from: a  reason: collision with root package name */
    public boolean f66010a;

    /* renamed from: b  reason: collision with root package name */
    public long f66011b;

    /* renamed from: c  reason: collision with root package name */
    public long f66012c;

    /* loaded from: classes5.dex */
    public static class a extends r {
        @Override // d.c.c.a.a.r
        public r a(long j) {
            return this;
        }

        @Override // d.c.c.a.a.r
        public r b(long j, TimeUnit timeUnit) {
            return this;
        }

        @Override // d.c.c.a.a.r
        public void h() throws IOException {
        }
    }

    public r a(long j) {
        this.f66010a = true;
        this.f66011b = j;
        return this;
    }

    public r b(long j, TimeUnit timeUnit) {
        if (j >= 0) {
            if (timeUnit != null) {
                this.f66012c = timeUnit.toNanos(j);
                return this;
            }
            throw new IllegalArgumentException("unit == null");
        }
        throw new IllegalArgumentException("timeout < 0: " + j);
    }

    public long c() {
        return this.f66012c;
    }

    public boolean d() {
        return this.f66010a;
    }

    public long e() {
        if (this.f66010a) {
            return this.f66011b;
        }
        throw new IllegalStateException("No deadline");
    }

    public r f() {
        this.f66012c = 0L;
        return this;
    }

    public r g() {
        this.f66010a = false;
        return this;
    }

    public void h() throws IOException {
        if (!Thread.interrupted()) {
            if (this.f66010a && this.f66011b - System.nanoTime() <= 0) {
                throw new InterruptedIOException("deadline reached");
            }
            return;
        }
        Thread.currentThread().interrupt();
        throw new InterruptedIOException("interrupted");
    }
}
