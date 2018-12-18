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

    private static Schedulers cfe() {
        Schedulers schedulers;
        while (true) {
            schedulers = iNW.get();
            if (schedulers == null) {
                schedulers = new Schedulers();
                if (iNW.compareAndSet(null, schedulers)) {
                    break;
                }
                schedulers.cfg();
            } else {
                break;
            }
        }
        return schedulers;
    }

    private Schedulers() {
        rx.c.g ceV = f.ceQ().ceV();
        g ceZ = ceV.ceZ();
        if (ceZ != null) {
            this.iNT = ceZ;
        } else {
            this.iNT = rx.c.g.ceW();
        }
        g cfa = ceV.cfa();
        if (cfa != null) {
            this.iNU = cfa;
        } else {
            this.iNU = rx.c.g.ceX();
        }
        g cfb = ceV.cfb();
        if (cfb != null) {
            this.iNV = cfb;
        } else {
            this.iNV = rx.c.g.ceY();
        }
    }

    public static g immediate() {
        return e.iLf;
    }

    public static g trampoline() {
        return j.iLF;
    }

    public static g newThread() {
        return c.f(cfe().iNV);
    }

    public static g computation() {
        return c.d(cfe().iNT);
    }

    public static g io() {
        return c.e(cfe().iNU);
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
            andSet.cfg();
        }
    }

    public static void start() {
        Schedulers cfe = cfe();
        cfe.cff();
        synchronized (cfe) {
            d.iLc.start();
        }
    }

    public static void shutdown() {
        Schedulers cfe = cfe();
        cfe.cfg();
        synchronized (cfe) {
            d.iLc.shutdown();
        }
    }

    synchronized void cff() {
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

    synchronized void cfg() {
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
