package d.b.c.a.b;

import d.b.c.a.b.a.c.f;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public final class n {

    /* renamed from: a  reason: collision with root package name */
    public final int f69304a;

    /* renamed from: b  reason: collision with root package name */
    public final long f69305b;

    /* renamed from: c  reason: collision with root package name */
    public final Runnable f69306c;

    /* renamed from: d  reason: collision with root package name */
    public final Deque<d.b.c.a.b.a.c.c> f69307d;

    /* renamed from: e  reason: collision with root package name */
    public final d.b.c.a.b.a.c.d f69308e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f69309f;

    /* renamed from: h  reason: collision with root package name */
    public static final /* synthetic */ boolean f69303h = !n.class.desiredAssertionStatus();

    /* renamed from: g  reason: collision with root package name */
    public static final Executor f69302g = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), d.b.c.a.b.a.e.o("OkHttp ConnectionPool", true));

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            while (true) {
                long b2 = n.this.b(System.nanoTime());
                if (b2 == -1) {
                    return;
                }
                if (b2 > 0) {
                    long j = b2 / 1000000;
                    long j2 = b2 - (1000000 * j);
                    synchronized (n.this) {
                        try {
                            n.this.wait(j, (int) j2);
                        } catch (InterruptedException unused) {
                        }
                    }
                }
            }
        }
    }

    public n() {
        this(5, 5L, TimeUnit.MINUTES);
    }

    public final int a(d.b.c.a.b.a.c.c cVar, long j) {
        List<Reference<d.b.c.a.b.a.c.f>> list = cVar.n;
        int i2 = 0;
        while (i2 < list.size()) {
            Reference<d.b.c.a.b.a.c.f> reference = list.get(i2);
            if (reference.get() != null) {
                i2++;
            } else {
                d.b.c.a.b.a.i.e.j().g("A connection to " + cVar.a().a().a() + " was leaked. Did you forget to close a response body?", ((f.a) reference).f68983a);
                list.remove(i2);
                cVar.k = true;
                if (list.isEmpty()) {
                    cVar.o = j - this.f69305b;
                    return 0;
                }
            }
        }
        return list.size();
    }

    public long b(long j) {
        synchronized (this) {
            d.b.c.a.b.a.c.c cVar = null;
            long j2 = Long.MIN_VALUE;
            int i2 = 0;
            int i3 = 0;
            for (d.b.c.a.b.a.c.c cVar2 : this.f69307d) {
                if (a(cVar2, j) > 0) {
                    i3++;
                } else {
                    i2++;
                    long j3 = j - cVar2.o;
                    if (j3 > j2) {
                        cVar = cVar2;
                        j2 = j3;
                    }
                }
            }
            if (j2 < this.f69305b && i2 <= this.f69304a) {
                if (i2 > 0) {
                    return this.f69305b - j2;
                } else if (i3 > 0) {
                    return this.f69305b;
                } else {
                    this.f69309f = false;
                    return -1L;
                }
            }
            this.f69307d.remove(cVar);
            d.b.c.a.b.a.e.r(cVar.m());
            return 0L;
        }
    }

    public d.b.c.a.b.a.c.c c(b bVar, d.b.c.a.b.a.c.f fVar, e eVar) {
        if (f69303h || Thread.holdsLock(this)) {
            for (d.b.c.a.b.a.c.c cVar : this.f69307d) {
                if (cVar.j(bVar, eVar)) {
                    fVar.g(cVar, true);
                    return cVar;
                }
            }
            return null;
        }
        throw new AssertionError();
    }

    public Socket d(b bVar, d.b.c.a.b.a.c.f fVar) {
        if (f69303h || Thread.holdsLock(this)) {
            for (d.b.c.a.b.a.c.c cVar : this.f69307d) {
                if (cVar.j(bVar, null) && cVar.o() && cVar != fVar.j()) {
                    return fVar.e(cVar);
                }
            }
            return null;
        }
        throw new AssertionError();
    }

    public void e(d.b.c.a.b.a.c.c cVar) {
        if (!f69303h && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (!this.f69309f) {
            this.f69309f = true;
            f69302g.execute(this.f69306c);
        }
        this.f69307d.add(cVar);
    }

    public boolean f(d.b.c.a.b.a.c.c cVar) {
        if (f69303h || Thread.holdsLock(this)) {
            if (!cVar.k && this.f69304a != 0) {
                notifyAll();
                return false;
            }
            this.f69307d.remove(cVar);
            return true;
        }
        throw new AssertionError();
    }

    public n(int i2, long j, TimeUnit timeUnit) {
        this.f69306c = new a();
        this.f69307d = new ArrayDeque();
        this.f69308e = new d.b.c.a.b.a.c.d();
        this.f69304a = i2;
        this.f69305b = timeUnit.toNanos(j);
        if (j > 0) {
            return;
        }
        throw new IllegalArgumentException("keepAliveDuration <= 0: " + j);
    }
}
