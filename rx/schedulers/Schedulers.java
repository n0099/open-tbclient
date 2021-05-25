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
    public static final AtomicReference<Schedulers> f69194d = new AtomicReference<>();

    /* renamed from: a  reason: collision with root package name */
    public final g f69195a;

    /* renamed from: b  reason: collision with root package name */
    public final g f69196b;

    /* renamed from: c  reason: collision with root package name */
    public final g f69197c;

    public Schedulers() {
        h.r.g f2 = f.c().f();
        g g2 = f2.g();
        if (g2 != null) {
            this.f69195a = g2;
        } else {
            this.f69195a = h.r.g.a();
        }
        g i2 = f2.i();
        if (i2 != null) {
            this.f69196b = i2;
        } else {
            this.f69196b = h.r.g.c();
        }
        g j = f2.j();
        if (j != null) {
            this.f69197c = j;
        } else {
            this.f69197c = h.r.g.e();
        }
    }

    public static Schedulers a() {
        while (true) {
            Schedulers schedulers = f69194d.get();
            if (schedulers != null) {
                return schedulers;
            }
            Schedulers schedulers2 = new Schedulers();
            if (f69194d.compareAndSet(null, schedulers2)) {
                return schedulers2;
            }
            schedulers2.b();
        }
    }

    public static g computation() {
        return c.f(a().f69195a);
    }

    public static g from(Executor executor) {
        return new h.o.c.c(executor);
    }

    public static g immediate() {
        return e.f68638a;
    }

    public static g io() {
        return c.k(a().f69196b);
    }

    public static g newThread() {
        return c.l(a().f69197c);
    }

    public static void reset() {
        Schedulers andSet = f69194d.getAndSet(null);
        if (andSet != null) {
            andSet.b();
        }
    }

    public static void shutdown() {
        Schedulers a2 = a();
        a2.b();
        synchronized (a2) {
            d.f68635h.shutdown();
        }
    }

    public static void start() {
        Schedulers a2 = a();
        a2.c();
        synchronized (a2) {
            d.f68635h.start();
        }
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static g trampoline() {
        return j.f68650a;
    }

    public synchronized void b() {
        if (this.f69195a instanceof h) {
            ((h) this.f69195a).shutdown();
        }
        if (this.f69196b instanceof h) {
            ((h) this.f69196b).shutdown();
        }
        if (this.f69197c instanceof h) {
            ((h) this.f69197c).shutdown();
        }
    }

    public synchronized void c() {
        if (this.f69195a instanceof h) {
            ((h) this.f69195a).start();
        }
        if (this.f69196b instanceof h) {
            ((h) this.f69196b).start();
        }
        if (this.f69197c instanceof h) {
            ((h) this.f69197c).start();
        }
    }
}
