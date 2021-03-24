package d.c.c.a.a;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class r {

    /* renamed from: d  reason: collision with root package name */
    public static final r f65163d = new a();

    /* renamed from: a  reason: collision with root package name */
    public boolean f65164a;

    /* renamed from: b  reason: collision with root package name */
    public long f65165b;

    /* renamed from: c  reason: collision with root package name */
    public long f65166c;

    /* loaded from: classes4.dex */
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
        this.f65164a = true;
        this.f65165b = j;
        return this;
    }

    public r b(long j, TimeUnit timeUnit) {
        if (j >= 0) {
            if (timeUnit != null) {
                this.f65166c = timeUnit.toNanos(j);
                return this;
            }
            throw new IllegalArgumentException("unit == null");
        }
        throw new IllegalArgumentException("timeout < 0: " + j);
    }

    public long c() {
        return this.f65166c;
    }

    public boolean d() {
        return this.f65164a;
    }

    public long e() {
        if (this.f65164a) {
            return this.f65165b;
        }
        throw new IllegalStateException("No deadline");
    }

    public r f() {
        this.f65166c = 0L;
        return this;
    }

    public r g() {
        this.f65164a = false;
        return this;
    }

    public void h() throws IOException {
        if (!Thread.interrupted()) {
            if (this.f65164a && this.f65165b - System.nanoTime() <= 0) {
                throw new InterruptedIOException("deadline reached");
            }
            return;
        }
        Thread.currentThread().interrupt();
        throw new InterruptedIOException("interrupted");
    }
}
