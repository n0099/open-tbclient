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
    public static final AtomicReference<Schedulers> f69278d = new AtomicReference<>();

    /* renamed from: a  reason: collision with root package name */
    public final g f69279a;

    /* renamed from: b  reason: collision with root package name */
    public final g f69280b;

    /* renamed from: c  reason: collision with root package name */
    public final g f69281c;

    public Schedulers() {
        h.r.g f2 = f.c().f();
        g g2 = f2.g();
        if (g2 != null) {
            this.f69279a = g2;
        } else {
            this.f69279a = h.r.g.a();
        }
        g i = f2.i();
        if (i != null) {
            this.f69280b = i;
        } else {
            this.f69280b = h.r.g.c();
        }
        g j = f2.j();
        if (j != null) {
            this.f69281c = j;
        } else {
            this.f69281c = h.r.g.e();
        }
    }

    public static Schedulers a() {
        while (true) {
            Schedulers schedulers = f69278d.get();
            if (schedulers != null) {
                return schedulers;
            }
            Schedulers schedulers2 = new Schedulers();
            if (f69278d.compareAndSet(null, schedulers2)) {
                return schedulers2;
            }
            schedulers2.b();
        }
    }

    public static g computation() {
        return c.f(a().f69279a);
    }

    public static g from(Executor executor) {
        return new h.o.c.c(executor);
    }

    public static g immediate() {
        return e.f68910a;
    }

    public static g io() {
        return c.k(a().f69280b);
    }

    public static g newThread() {
        return c.l(a().f69281c);
    }

    public static void reset() {
        Schedulers andSet = f69278d.getAndSet(null);
        if (andSet != null) {
            andSet.b();
        }
    }

    public static void shutdown() {
        Schedulers a2 = a();
        a2.b();
        synchronized (a2) {
            d.f68908h.shutdown();
        }
    }

    public static void start() {
        Schedulers a2 = a();
        a2.c();
        synchronized (a2) {
            d.f68908h.start();
        }
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static g trampoline() {
        return j.f68921a;
    }

    public synchronized void b() {
        if (this.f69279a instanceof h) {
            ((h) this.f69279a).shutdown();
        }
        if (this.f69280b instanceof h) {
            ((h) this.f69280b).shutdown();
        }
        if (this.f69281c instanceof h) {
            ((h) this.f69281c).shutdown();
        }
    }

    public synchronized void c() {
        if (this.f69279a instanceof h) {
            ((h) this.f69279a).start();
        }
        if (this.f69280b instanceof h) {
            ((h) this.f69280b).start();
        }
        if (this.f69281c instanceof h) {
            ((h) this.f69281c).start();
        }
    }
}
