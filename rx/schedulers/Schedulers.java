package rx.schedulers;

import h.g;
import h.o.c.d;
import h.o.c.e;
import h.o.c.h;
import h.o.c.j;
import h.r.c;
import h.r.f;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes8.dex */
public final class Schedulers {

    /* renamed from: d  reason: collision with root package name */
    public static final AtomicReference<Schedulers> f72503d = new AtomicReference<>();

    /* renamed from: a  reason: collision with root package name */
    public final g f72504a;

    /* renamed from: b  reason: collision with root package name */
    public final g f72505b;

    /* renamed from: c  reason: collision with root package name */
    public final g f72506c;

    public Schedulers() {
        h.r.g f2 = f.c().f();
        g g2 = f2.g();
        if (g2 != null) {
            this.f72504a = g2;
        } else {
            this.f72504a = h.r.g.a();
        }
        g i2 = f2.i();
        if (i2 != null) {
            this.f72505b = i2;
        } else {
            this.f72505b = h.r.g.c();
        }
        g j = f2.j();
        if (j != null) {
            this.f72506c = j;
        } else {
            this.f72506c = h.r.g.e();
        }
    }

    public static Schedulers a() {
        while (true) {
            Schedulers schedulers = f72503d.get();
            if (schedulers != null) {
                return schedulers;
            }
            Schedulers schedulers2 = new Schedulers();
            if (f72503d.compareAndSet(null, schedulers2)) {
                return schedulers2;
            }
            schedulers2.b();
        }
    }

    public static g computation() {
        return c.f(a().f72504a);
    }

    public static g from(Executor executor) {
        return new h.o.c.c(executor);
    }

    public static g immediate() {
        return e.f71894a;
    }

    public static g io() {
        return c.k(a().f72505b);
    }

    public static g newThread() {
        return c.l(a().f72506c);
    }

    public static void reset() {
        Schedulers andSet = f72503d.getAndSet(null);
        if (andSet != null) {
            andSet.b();
        }
    }

    public static void shutdown() {
        Schedulers a2 = a();
        a2.b();
        synchronized (a2) {
            d.f71891h.shutdown();
        }
    }

    public static void start() {
        Schedulers a2 = a();
        a2.c();
        synchronized (a2) {
            d.f71891h.start();
        }
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static g trampoline() {
        return j.f71906a;
    }

    public synchronized void b() {
        if (this.f72504a instanceof h) {
            ((h) this.f72504a).shutdown();
        }
        if (this.f72505b instanceof h) {
            ((h) this.f72505b).shutdown();
        }
        if (this.f72506c instanceof h) {
            ((h) this.f72506c).shutdown();
        }
    }

    public synchronized void c() {
        if (this.f72504a instanceof h) {
            ((h) this.f72504a).start();
        }
        if (this.f72505b instanceof h) {
            ((h) this.f72505b).start();
        }
        if (this.f72506c instanceof h) {
            ((h) this.f72506c).start();
        }
    }
}
