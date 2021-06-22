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
    public static final AtomicReference<Schedulers> f72607d = new AtomicReference<>();

    /* renamed from: a  reason: collision with root package name */
    public final g f72608a;

    /* renamed from: b  reason: collision with root package name */
    public final g f72609b;

    /* renamed from: c  reason: collision with root package name */
    public final g f72610c;

    public Schedulers() {
        h.r.g f2 = f.c().f();
        g g2 = f2.g();
        if (g2 != null) {
            this.f72608a = g2;
        } else {
            this.f72608a = h.r.g.a();
        }
        g i2 = f2.i();
        if (i2 != null) {
            this.f72609b = i2;
        } else {
            this.f72609b = h.r.g.c();
        }
        g j = f2.j();
        if (j != null) {
            this.f72610c = j;
        } else {
            this.f72610c = h.r.g.e();
        }
    }

    public static Schedulers a() {
        while (true) {
            Schedulers schedulers = f72607d.get();
            if (schedulers != null) {
                return schedulers;
            }
            Schedulers schedulers2 = new Schedulers();
            if (f72607d.compareAndSet(null, schedulers2)) {
                return schedulers2;
            }
            schedulers2.b();
        }
    }

    public static g computation() {
        return c.f(a().f72608a);
    }

    public static g from(Executor executor) {
        return new h.o.c.c(executor);
    }

    public static g immediate() {
        return e.f71998a;
    }

    public static g io() {
        return c.k(a().f72609b);
    }

    public static g newThread() {
        return c.l(a().f72610c);
    }

    public static void reset() {
        Schedulers andSet = f72607d.getAndSet(null);
        if (andSet != null) {
            andSet.b();
        }
    }

    public static void shutdown() {
        Schedulers a2 = a();
        a2.b();
        synchronized (a2) {
            d.f71995h.shutdown();
        }
    }

    public static void start() {
        Schedulers a2 = a();
        a2.c();
        synchronized (a2) {
            d.f71995h.start();
        }
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static g trampoline() {
        return j.f72010a;
    }

    public synchronized void b() {
        if (this.f72608a instanceof h) {
            ((h) this.f72608a).shutdown();
        }
        if (this.f72609b instanceof h) {
            ((h) this.f72609b).shutdown();
        }
        if (this.f72610c instanceof h) {
            ((h) this.f72610c).shutdown();
        }
    }

    public synchronized void c() {
        if (this.f72608a instanceof h) {
            ((h) this.f72608a).start();
        }
        if (this.f72609b instanceof h) {
            ((h) this.f72609b).start();
        }
        if (this.f72610c instanceof h) {
            ((h) this.f72610c).start();
        }
    }
}
