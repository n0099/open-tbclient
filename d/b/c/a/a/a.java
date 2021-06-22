package d.b.c.a.a;

import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public class a extends r {

    /* renamed from: h  reason: collision with root package name */
    public static final long f68985h = TimeUnit.SECONDS.toMillis(60);

    /* renamed from: i  reason: collision with root package name */
    public static final long f68986i = TimeUnit.MILLISECONDS.toNanos(f68985h);
    public static a j;

    /* renamed from: e  reason: collision with root package name */
    public boolean f68987e;

    /* renamed from: f  reason: collision with root package name */
    public a f68988f;

    /* renamed from: g  reason: collision with root package name */
    public long f68989g;

    /* renamed from: d.b.c.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C1886a implements p {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ p f68990e;

        public C1886a(p pVar) {
            this.f68990e = pVar;
        }

        @Override // d.b.c.a.a.p
        public r a() {
            return a.this;
        }

        @Override // d.b.c.a.a.p
        public void b(d.b.c.a.a.c cVar, long j) throws IOException {
            s.c(cVar.f68997f, 0L, j);
            while (true) {
                long j2 = 0;
                if (j <= 0) {
                    return;
                }
                n nVar = cVar.f68996e;
                while (true) {
                    if (j2 >= 65536) {
                        break;
                    }
                    j2 += nVar.f69025c - nVar.f69024b;
                    if (j2 >= j) {
                        j2 = j;
                        break;
                    }
                    nVar = nVar.f69028f;
                }
                a.this.l();
                try {
                    try {
                        this.f68990e.b(cVar, j2);
                        j -= j2;
                        a.this.n(true);
                    } catch (IOException e2) {
                        throw a.this.k(e2);
                    }
                } catch (Throwable th) {
                    a.this.n(false);
                    throw th;
                }
            }
        }

        @Override // d.b.c.a.a.p, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            a.this.l();
            try {
                try {
                    this.f68990e.close();
                    a.this.n(true);
                } catch (IOException e2) {
                    throw a.this.k(e2);
                }
            } catch (Throwable th) {
                a.this.n(false);
                throw th;
            }
        }

        @Override // d.b.c.a.a.p, java.io.Flushable
        public void flush() throws IOException {
            a.this.l();
            try {
                try {
                    this.f68990e.flush();
                    a.this.n(true);
                } catch (IOException e2) {
                    throw a.this.k(e2);
                }
            } catch (Throwable th) {
                a.this.n(false);
                throw th;
            }
        }

        public String toString() {
            return "AsyncTimeout.sink(" + this.f68990e + SmallTailInfo.EMOTION_SUFFIX;
        }
    }

    /* loaded from: classes6.dex */
    public static final class c extends Thread {
        public c() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0015, code lost:
            r1.p();
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            while (true) {
                synchronized (a.class) {
                    a t = a.t();
                    if (t != null) {
                        if (t == a.j) {
                            a.j = null;
                            return;
                        }
                    }
                }
            }
        }
    }

    public static synchronized void m(a aVar, long j2, boolean z) {
        synchronized (a.class) {
            if (j == null) {
                j = new a();
                c cVar = new c();
                cVar.setName("tt_pangle_thread_watch_dog");
                cVar.start();
            }
            long nanoTime = System.nanoTime();
            int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
            if (i2 != 0 && z) {
                aVar.f68989g = Math.min(j2, aVar.e() - nanoTime) + nanoTime;
            } else if (i2 != 0) {
                aVar.f68989g = j2 + nanoTime;
            } else if (z) {
                aVar.f68989g = aVar.e();
            } else {
                throw new AssertionError();
            }
            long q = aVar.q(nanoTime);
            a aVar2 = j;
            while (aVar2.f68988f != null && q >= aVar2.f68988f.q(nanoTime)) {
                aVar2 = aVar2.f68988f;
            }
            aVar.f68988f = aVar2.f68988f;
            aVar2.f68988f = aVar;
            if (aVar2 == j) {
                a.class.notify();
            }
        }
    }

    public static synchronized boolean o(a aVar) {
        synchronized (a.class) {
            for (a aVar2 = j; aVar2 != null; aVar2 = aVar2.f68988f) {
                if (aVar2.f68988f == aVar) {
                    aVar2.f68988f = aVar.f68988f;
                    aVar.f68988f = null;
                    return false;
                }
            }
            return true;
        }
    }

    public static a t() throws InterruptedException {
        a aVar = j.f68988f;
        if (aVar == null) {
            long nanoTime = System.nanoTime();
            a.class.wait(f68985h);
            if (j.f68988f != null || System.nanoTime() - nanoTime < f68986i) {
                return null;
            }
            return j;
        }
        long q = aVar.q(System.nanoTime());
        if (q > 0) {
            long j2 = q / 1000000;
            a.class.wait(j2, (int) (q - (1000000 * j2)));
            return null;
        }
        j.f68988f = aVar.f68988f;
        aVar.f68988f = null;
        return aVar;
    }

    public final p i(p pVar) {
        return new C1886a(pVar);
    }

    public final q j(q qVar) {
        return new b(qVar);
    }

    public final IOException k(IOException iOException) throws IOException {
        return !s() ? iOException : r(iOException);
    }

    public final void l() {
        if (!this.f68987e) {
            long c2 = c();
            boolean d2 = d();
            if (c2 != 0 || d2) {
                this.f68987e = true;
                m(this, c2, d2);
                return;
            }
            return;
        }
        throw new IllegalStateException("Unbalanced enter/exit");
    }

    public final void n(boolean z) throws IOException {
        if (s() && z) {
            throw r(null);
        }
    }

    public void p() {
    }

    public final long q(long j2) {
        return this.f68989g - j2;
    }

    public IOException r(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final boolean s() {
        if (this.f68987e) {
            this.f68987e = false;
            return o(this);
        }
        return false;
    }

    /* loaded from: classes6.dex */
    public class b implements q {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ q f68992e;

        public b(q qVar) {
            this.f68992e = qVar;
        }

        @Override // d.b.c.a.a.q
        public long a(d.b.c.a.a.c cVar, long j) throws IOException {
            a.this.l();
            try {
                try {
                    long a2 = this.f68992e.a(cVar, j);
                    a.this.n(true);
                    return a2;
                } catch (IOException e2) {
                    throw a.this.k(e2);
                }
            } catch (Throwable th) {
                a.this.n(false);
                throw th;
            }
        }

        @Override // d.b.c.a.a.q, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            a.this.l();
            try {
                try {
                    this.f68992e.close();
                    a.this.n(true);
                } catch (IOException e2) {
                    throw a.this.k(e2);
                }
            } catch (Throwable th) {
                a.this.n(false);
                throw th;
            }
        }

        public String toString() {
            return "AsyncTimeout.source(" + this.f68992e + SmallTailInfo.EMOTION_SUFFIX;
        }

        @Override // d.b.c.a.a.q
        public r a() {
            return a.this;
        }
    }
}
