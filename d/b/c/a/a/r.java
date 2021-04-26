package d.b.c.a.a;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public class r {

    /* renamed from: d  reason: collision with root package name */
    public static final r f64468d = new a();

    /* renamed from: a  reason: collision with root package name */
    public boolean f64469a;

    /* renamed from: b  reason: collision with root package name */
    public long f64470b;

    /* renamed from: c  reason: collision with root package name */
    public long f64471c;

    /* loaded from: classes5.dex */
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
        this.f64469a = true;
        this.f64470b = j;
        return this;
    }

    public r b(long j, TimeUnit timeUnit) {
        if (j >= 0) {
            if (timeUnit != null) {
                this.f64471c = timeUnit.toNanos(j);
                return this;
            }
            throw new IllegalArgumentException("unit == null");
        }
        throw new IllegalArgumentException("timeout < 0: " + j);
    }

    public long c() {
        return this.f64471c;
    }

    public boolean d() {
        return this.f64469a;
    }

    public long e() {
        if (this.f64469a) {
            return this.f64470b;
        }
        throw new IllegalStateException("No deadline");
    }

    public r f() {
        this.f64471c = 0L;
        return this;
    }

    public r g() {
        this.f64469a = false;
        return this;
    }

    public void h() throws IOException {
        if (!Thread.interrupted()) {
            if (this.f64469a && this.f64470b - System.nanoTime() <= 0) {
                throw new InterruptedIOException("deadline reached");
            }
            return;
        }
        Thread.currentThread().interrupt();
        throw new InterruptedIOException("interrupted");
    }
}
