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
/* loaded from: classes6.dex */
public final class Schedulers {
    private static final AtomicReference<Schedulers> nNw = new AtomicReference<>();
    private final g nTC;
    private final g nTD;
    private final g nTE;

    private static Schedulers dPk() {
        Schedulers schedulers;
        while (true) {
            schedulers = nNw.get();
            if (schedulers == null) {
                schedulers = new Schedulers();
                if (nNw.compareAndSet(null, schedulers)) {
                    break;
                }
                schedulers.dPm();
            } else {
                break;
            }
        }
        return schedulers;
    }

    private Schedulers() {
        rx.c.g dPb = f.dOW().dPb();
        g dPf = dPb.dPf();
        if (dPf != null) {
            this.nTC = dPf;
        } else {
            this.nTC = rx.c.g.dPc();
        }
        g dPg = dPb.dPg();
        if (dPg != null) {
            this.nTD = dPg;
        } else {
            this.nTD = rx.c.g.dPd();
        }
        g dPh = dPb.dPh();
        if (dPh != null) {
            this.nTE = dPh;
        } else {
            this.nTE = rx.c.g.dPe();
        }
    }

    public static g immediate() {
        return e.nRK;
    }

    public static g trampoline() {
        return j.nSi;
    }

    public static g newThread() {
        return c.k(dPk().nTE);
    }

    public static g computation() {
        return c.i(dPk().nTC);
    }

    public static g io() {
        return c.j(dPk().nTD);
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static g from(Executor executor) {
        return new rx.internal.schedulers.c(executor);
    }

    public static void reset() {
        Schedulers andSet = nNw.getAndSet(null);
        if (andSet != null) {
            andSet.dPm();
        }
    }

    public static void start() {
        Schedulers dPk = dPk();
        dPk.dPl();
        synchronized (dPk) {
            d.nRI.start();
        }
    }

    public static void shutdown() {
        Schedulers dPk = dPk();
        dPk.dPm();
        synchronized (dPk) {
            d.nRI.shutdown();
        }
    }

    synchronized void dPl() {
        if (this.nTC instanceof h) {
            ((h) this.nTC).start();
        }
        if (this.nTD instanceof h) {
            ((h) this.nTD).start();
        }
        if (this.nTE instanceof h) {
            ((h) this.nTE).start();
        }
    }

    synchronized void dPm() {
        if (this.nTC instanceof h) {
            ((h) this.nTC).shutdown();
        }
        if (this.nTD instanceof h) {
            ((h) this.nTD).shutdown();
        }
        if (this.nTE instanceof h) {
            ((h) this.nTE).shutdown();
        }
    }
}
