package rx.schedulers;

import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import rx.c.c;
import rx.c.f;
import rx.g;
import rx.internal.schedulers.d;
import rx.internal.schedulers.e;
import rx.internal.schedulers.h;
import rx.internal.schedulers.j;
/* loaded from: classes2.dex */
public final class Schedulers {
    private static final AtomicReference<Schedulers> iNW = new AtomicReference<>();
    private final g iNT;
    private final g iNU;
    private final g iNV;

    private static Schedulers cff() {
        Schedulers schedulers;
        while (true) {
            schedulers = iNW.get();
            if (schedulers == null) {
                schedulers = new Schedulers();
                if (iNW.compareAndSet(null, schedulers)) {
                    break;
                }
                schedulers.cfh();
            } else {
                break;
            }
        }
        return schedulers;
    }

    private Schedulers() {
        rx.c.g ceW = f.ceR().ceW();
        g cfa = ceW.cfa();
        if (cfa != null) {
            this.iNT = cfa;
        } else {
            this.iNT = rx.c.g.ceX();
        }
        g cfb = ceW.cfb();
        if (cfb != null) {
            this.iNU = cfb;
        } else {
            this.iNU = rx.c.g.ceY();
        }
        g cfc = ceW.cfc();
        if (cfc != null) {
            this.iNV = cfc;
        } else {
            this.iNV = rx.c.g.ceZ();
        }
    }

    public static g immediate() {
        return e.iLf;
    }

    public static g trampoline() {
        return j.iLF;
    }

    public static g newThread() {
        return c.f(cff().iNV);
    }

    public static g computation() {
        return c.d(cff().iNT);
    }

    public static g io() {
        return c.e(cff().iNU);
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static g from(Executor executor) {
        return new rx.internal.schedulers.c(executor);
    }

    public static void reset() {
        Schedulers andSet = iNW.getAndSet(null);
        if (andSet != null) {
            andSet.cfh();
        }
    }

    public static void start() {
        Schedulers cff = cff();
        cff.cfg();
        synchronized (cff) {
            d.iLc.start();
        }
    }

    public static void shutdown() {
        Schedulers cff = cff();
        cff.cfh();
        synchronized (cff) {
            d.iLc.shutdown();
        }
    }

    synchronized void cfg() {
        if (this.iNT instanceof h) {
            ((h) this.iNT).start();
        }
        if (this.iNU instanceof h) {
            ((h) this.iNU).start();
        }
        if (this.iNV instanceof h) {
            ((h) this.iNV).start();
        }
    }

    synchronized void cfh() {
        if (this.iNT instanceof h) {
            ((h) this.iNT).shutdown();
        }
        if (this.iNU instanceof h) {
            ((h) this.iNU).shutdown();
        }
        if (this.iNV instanceof h) {
            ((h) this.iNV).shutdown();
        }
    }
}
