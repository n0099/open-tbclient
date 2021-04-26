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
/* loaded from: classes7.dex */
public final class Schedulers {

    /* renamed from: d  reason: collision with root package name */
    public static final AtomicReference<Schedulers> f68471d = new AtomicReference<>();

    /* renamed from: a  reason: collision with root package name */
    public final g f68472a;

    /* renamed from: b  reason: collision with root package name */
    public final g f68473b;

    /* renamed from: c  reason: collision with root package name */
    public final g f68474c;

    public Schedulers() {
        h.r.g f2 = f.c().f();
        g g2 = f2.g();
        if (g2 != null) {
            this.f68472a = g2;
        } else {
            this.f68472a = h.r.g.a();
        }
        g i2 = f2.i();
        if (i2 != null) {
            this.f68473b = i2;
        } else {
            this.f68473b = h.r.g.c();
        }
        g j = f2.j();
        if (j != null) {
            this.f68474c = j;
        } else {
            this.f68474c = h.r.g.e();
        }
    }

    public static Schedulers a() {
        while (true) {
            Schedulers schedulers = f68471d.get();
            if (schedulers != null) {
                return schedulers;
            }
            Schedulers schedulers2 = new Schedulers();
            if (f68471d.compareAndSet(null, schedulers2)) {
                return schedulers2;
            }
            schedulers2.b();
        }
    }

    public static g computation() {
        return c.f(a().f68472a);
    }

    public static g from(Executor executor) {
        return new h.o.c.c(executor);
    }

    public static g immediate() {
        return e.f67915a;
    }

    public static g io() {
        return c.k(a().f68473b);
    }

    public static g newThread() {
        return c.l(a().f68474c);
    }

    public static void reset() {
        Schedulers andSet = f68471d.getAndSet(null);
        if (andSet != null) {
            andSet.b();
        }
    }

    public static void shutdown() {
        Schedulers a2 = a();
        a2.b();
        synchronized (a2) {
            d.f67912h.shutdown();
        }
    }

    public static void start() {
        Schedulers a2 = a();
        a2.c();
        synchronized (a2) {
            d.f67912h.start();
        }
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static g trampoline() {
        return j.f67927a;
    }

    public synchronized void b() {
        if (this.f68472a instanceof h) {
            ((h) this.f68472a).shutdown();
        }
        if (this.f68473b instanceof h) {
            ((h) this.f68473b).shutdown();
        }
        if (this.f68474c instanceof h) {
            ((h) this.f68474c).shutdown();
        }
    }

    public synchronized void c() {
        if (this.f68472a instanceof h) {
            ((h) this.f68472a).start();
        }
        if (this.f68473b instanceof h) {
            ((h) this.f68473b).start();
        }
        if (this.f68474c instanceof h) {
            ((h) this.f68474c).start();
        }
    }
}
