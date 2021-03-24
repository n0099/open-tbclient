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
    public static final AtomicReference<Schedulers> f68267d = new AtomicReference<>();

    /* renamed from: a  reason: collision with root package name */
    public final g f68268a;

    /* renamed from: b  reason: collision with root package name */
    public final g f68269b;

    /* renamed from: c  reason: collision with root package name */
    public final g f68270c;

    public Schedulers() {
        h.r.g f2 = f.c().f();
        g g2 = f2.g();
        if (g2 != null) {
            this.f68268a = g2;
        } else {
            this.f68268a = h.r.g.a();
        }
        g i = f2.i();
        if (i != null) {
            this.f68269b = i;
        } else {
            this.f68269b = h.r.g.c();
        }
        g j = f2.j();
        if (j != null) {
            this.f68270c = j;
        } else {
            this.f68270c = h.r.g.e();
        }
    }

    public static Schedulers a() {
        while (true) {
            Schedulers schedulers = f68267d.get();
            if (schedulers != null) {
                return schedulers;
            }
            Schedulers schedulers2 = new Schedulers();
            if (f68267d.compareAndSet(null, schedulers2)) {
                return schedulers2;
            }
            schedulers2.b();
        }
    }

    public static g computation() {
        return c.f(a().f68268a);
    }

    public static g from(Executor executor) {
        return new h.o.c.c(executor);
    }

    public static g immediate() {
        return e.f67895a;
    }

    public static g io() {
        return c.k(a().f68269b);
    }

    public static g newThread() {
        return c.l(a().f68270c);
    }

    public static void reset() {
        Schedulers andSet = f68267d.getAndSet(null);
        if (andSet != null) {
            andSet.b();
        }
    }

    public static void shutdown() {
        Schedulers a2 = a();
        a2.b();
        synchronized (a2) {
            d.f67893h.shutdown();
        }
    }

    public static void start() {
        Schedulers a2 = a();
        a2.c();
        synchronized (a2) {
            d.f67893h.start();
        }
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static g trampoline() {
        return j.f67906a;
    }

    public synchronized void b() {
        if (this.f68268a instanceof h) {
            ((h) this.f68268a).shutdown();
        }
        if (this.f68269b instanceof h) {
            ((h) this.f68269b).shutdown();
        }
        if (this.f68270c instanceof h) {
            ((h) this.f68270c).shutdown();
        }
    }

    public synchronized void c() {
        if (this.f68268a instanceof h) {
            ((h) this.f68268a).start();
        }
        if (this.f68269b instanceof h) {
            ((h) this.f68269b).start();
        }
        if (this.f68270c instanceof h) {
            ((h) this.f68270c).start();
        }
    }
}
