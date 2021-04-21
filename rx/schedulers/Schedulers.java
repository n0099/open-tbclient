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
    public static final AtomicReference<Schedulers> f69425d = new AtomicReference<>();

    /* renamed from: a  reason: collision with root package name */
    public final g f69426a;

    /* renamed from: b  reason: collision with root package name */
    public final g f69427b;

    /* renamed from: c  reason: collision with root package name */
    public final g f69428c;

    public Schedulers() {
        h.r.g f2 = f.c().f();
        g g2 = f2.g();
        if (g2 != null) {
            this.f69426a = g2;
        } else {
            this.f69426a = h.r.g.a();
        }
        g i = f2.i();
        if (i != null) {
            this.f69427b = i;
        } else {
            this.f69427b = h.r.g.c();
        }
        g j = f2.j();
        if (j != null) {
            this.f69428c = j;
        } else {
            this.f69428c = h.r.g.e();
        }
    }

    public static Schedulers a() {
        while (true) {
            Schedulers schedulers = f69425d.get();
            if (schedulers != null) {
                return schedulers;
            }
            Schedulers schedulers2 = new Schedulers();
            if (f69425d.compareAndSet(null, schedulers2)) {
                return schedulers2;
            }
            schedulers2.b();
        }
    }

    public static g computation() {
        return c.f(a().f69426a);
    }

    public static g from(Executor executor) {
        return new h.o.c.c(executor);
    }

    public static g immediate() {
        return e.f69057a;
    }

    public static g io() {
        return c.k(a().f69427b);
    }

    public static g newThread() {
        return c.l(a().f69428c);
    }

    public static void reset() {
        Schedulers andSet = f69425d.getAndSet(null);
        if (andSet != null) {
            andSet.b();
        }
    }

    public static void shutdown() {
        Schedulers a2 = a();
        a2.b();
        synchronized (a2) {
            d.f69055h.shutdown();
        }
    }

    public static void start() {
        Schedulers a2 = a();
        a2.c();
        synchronized (a2) {
            d.f69055h.start();
        }
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static g trampoline() {
        return j.f69068a;
    }

    public synchronized void b() {
        if (this.f69426a instanceof h) {
            ((h) this.f69426a).shutdown();
        }
        if (this.f69427b instanceof h) {
            ((h) this.f69427b).shutdown();
        }
        if (this.f69428c instanceof h) {
            ((h) this.f69428c).shutdown();
        }
    }

    public synchronized void c() {
        if (this.f69426a instanceof h) {
            ((h) this.f69426a).start();
        }
        if (this.f69427b instanceof h) {
            ((h) this.f69427b).start();
        }
        if (this.f69428c instanceof h) {
            ((h) this.f69428c).start();
        }
    }
}
