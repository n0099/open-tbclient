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
    public static final AtomicReference<Schedulers> f68272d = new AtomicReference<>();

    /* renamed from: a  reason: collision with root package name */
    public final g f68273a;

    /* renamed from: b  reason: collision with root package name */
    public final g f68274b;

    /* renamed from: c  reason: collision with root package name */
    public final g f68275c;

    public Schedulers() {
        h.r.g f2 = f.c().f();
        g g2 = f2.g();
        if (g2 != null) {
            this.f68273a = g2;
        } else {
            this.f68273a = h.r.g.a();
        }
        g i = f2.i();
        if (i != null) {
            this.f68274b = i;
        } else {
            this.f68274b = h.r.g.c();
        }
        g j = f2.j();
        if (j != null) {
            this.f68275c = j;
        } else {
            this.f68275c = h.r.g.e();
        }
    }

    public static Schedulers a() {
        while (true) {
            Schedulers schedulers = f68272d.get();
            if (schedulers != null) {
                return schedulers;
            }
            Schedulers schedulers2 = new Schedulers();
            if (f68272d.compareAndSet(null, schedulers2)) {
                return schedulers2;
            }
            schedulers2.b();
        }
    }

    public static g computation() {
        return c.f(a().f68273a);
    }

    public static g from(Executor executor) {
        return new h.o.c.c(executor);
    }

    public static g immediate() {
        return e.f67900a;
    }

    public static g io() {
        return c.k(a().f68274b);
    }

    public static g newThread() {
        return c.l(a().f68275c);
    }

    public static void reset() {
        Schedulers andSet = f68272d.getAndSet(null);
        if (andSet != null) {
            andSet.b();
        }
    }

    public static void shutdown() {
        Schedulers a2 = a();
        a2.b();
        synchronized (a2) {
            d.f67898h.shutdown();
        }
    }

    public static void start() {
        Schedulers a2 = a();
        a2.c();
        synchronized (a2) {
            d.f67898h.start();
        }
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static g trampoline() {
        return j.f67911a;
    }

    public synchronized void b() {
        if (this.f68273a instanceof h) {
            ((h) this.f68273a).shutdown();
        }
        if (this.f68274b instanceof h) {
            ((h) this.f68274b).shutdown();
        }
        if (this.f68275c instanceof h) {
            ((h) this.f68275c).shutdown();
        }
    }

    public synchronized void c() {
        if (this.f68273a instanceof h) {
            ((h) this.f68273a).start();
        }
        if (this.f68274b instanceof h) {
            ((h) this.f68274b).start();
        }
        if (this.f68275c instanceof h) {
            ((h) this.f68275c).start();
        }
    }
}
