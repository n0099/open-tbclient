package d.c.c.a.b;

import d.c.c.a.b.a.c.f;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public final class n {

    /* renamed from: a  reason: collision with root package name */
    public final int f66359a;

    /* renamed from: b  reason: collision with root package name */
    public final long f66360b;

    /* renamed from: c  reason: collision with root package name */
    public final Runnable f66361c;

    /* renamed from: d  reason: collision with root package name */
    public final Deque<d.c.c.a.b.a.c.c> f66362d;

    /* renamed from: e  reason: collision with root package name */
    public final d.c.c.a.b.a.c.d f66363e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f66364f;

    /* renamed from: h  reason: collision with root package name */
    public static final /* synthetic */ boolean f66358h = !n.class.desiredAssertionStatus();

    /* renamed from: g  reason: collision with root package name */
    public static final Executor f66357g = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), d.c.c.a.b.a.e.o("OkHttp ConnectionPool", true));

    /* loaded from: classes5.dex */
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

    public final int a(d.c.c.a.b.a.c.c cVar, long j) {
        List<Reference<d.c.c.a.b.a.c.f>> list = cVar.n;
        int i = 0;
        while (i < list.size()) {
            Reference<d.c.c.a.b.a.c.f> reference = list.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                d.c.c.a.b.a.i.e.j().g("A connection to " + cVar.a().a().a() + " was leaked. Did you forget to close a response body?", ((f.a) reference).f66061a);
                list.remove(i);
                cVar.k = true;
                if (list.isEmpty()) {
                    cVar.o = j - this.f66360b;
                    return 0;
                }
            }
        }
        return list.size();
    }

    public long b(long j) {
        synchronized (this) {
            d.c.c.a.b.a.c.c cVar = null;
            long j2 = Long.MIN_VALUE;
            int i = 0;
            int i2 = 0;
            for (d.c.c.a.b.a.c.c cVar2 : this.f66362d) {
                if (a(cVar2, j) > 0) {
                    i2++;
                } else {
                    i++;
                    long j3 = j - cVar2.o;
                    if (j3 > j2) {
                        cVar = cVar2;
                        j2 = j3;
                    }
                }
            }
            if (j2 < this.f66360b && i <= this.f66359a) {
                if (i > 0) {
                    return this.f66360b - j2;
                } else if (i2 > 0) {
                    return this.f66360b;
                } else {
                    this.f66364f = false;
                    return -1L;
                }
            }
            this.f66362d.remove(cVar);
            d.c.c.a.b.a.e.r(cVar.m());
            return 0L;
        }
    }

    public d.c.c.a.b.a.c.c c(b bVar, d.c.c.a.b.a.c.f fVar, e eVar) {
        if (f66358h || Thread.holdsLock(this)) {
            for (d.c.c.a.b.a.c.c cVar : this.f66362d) {
                if (cVar.j(bVar, eVar)) {
                    fVar.g(cVar, true);
                    return cVar;
                }
            }
            return null;
        }
        throw new AssertionError();
    }

    public Socket d(b bVar, d.c.c.a.b.a.c.f fVar) {
        if (f66358h || Thread.holdsLock(this)) {
            for (d.c.c.a.b.a.c.c cVar : this.f66362d) {
                if (cVar.j(bVar, null) && cVar.o() && cVar != fVar.j()) {
                    return fVar.e(cVar);
                }
            }
            return null;
        }
        throw new AssertionError();
    }

    public void e(d.c.c.a.b.a.c.c cVar) {
        if (!f66358h && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        if (!this.f66364f) {
            this.f66364f = true;
            f66357g.execute(this.f66361c);
        }
        this.f66362d.add(cVar);
    }

    public boolean f(d.c.c.a.b.a.c.c cVar) {
        if (f66358h || Thread.holdsLock(this)) {
            if (!cVar.k && this.f66359a != 0) {
                notifyAll();
                return false;
            }
            this.f66362d.remove(cVar);
            return true;
        }
        throw new AssertionError();
    }

    public n(int i, long j, TimeUnit timeUnit) {
        this.f66361c = new a();
        this.f66362d = new ArrayDeque();
        this.f66363e = new d.c.c.a.b.a.c.d();
        this.f66359a = i;
        this.f66360b = timeUnit.toNanos(j);
        if (j > 0) {
            return;
        }
        throw new IllegalArgumentException("keepAliveDuration <= 0: " + j);
    }
}
