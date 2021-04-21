package d.c.c.a.a;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public class r {

    /* renamed from: d  reason: collision with root package name */
    public static final r f66104d = new a();

    /* renamed from: a  reason: collision with root package name */
    public boolean f66105a;

    /* renamed from: b  reason: collision with root package name */
    public long f66106b;

    /* renamed from: c  reason: collision with root package name */
    public long f66107c;

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
        this.f66105a = true;
        this.f66106b = j;
        return this;
    }

    public r b(long j, TimeUnit timeUnit) {
        if (j >= 0) {
            if (timeUnit != null) {
                this.f66107c = timeUnit.toNanos(j);
                return this;
            }
            throw new IllegalArgumentException("unit == null");
        }
        throw new IllegalArgumentException("timeout < 0: " + j);
    }

    public long c() {
        return this.f66107c;
    }

    public boolean d() {
        return this.f66105a;
    }

    public long e() {
        if (this.f66105a) {
            return this.f66106b;
        }
        throw new IllegalStateException("No deadline");
    }

    public r f() {
        this.f66107c = 0L;
        return this;
    }

    public r g() {
        this.f66105a = false;
        return this;
    }

    public void h() throws IOException {
        if (!Thread.interrupted()) {
            if (this.f66105a && this.f66106b - System.nanoTime() <= 0) {
                throw new InterruptedIOException("deadline reached");
            }
            return;
        }
        Thread.currentThread().interrupt();
        throw new InterruptedIOException("interrupted");
    }
}
