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
    private static final AtomicReference<Schedulers> nNy = new AtomicReference<>();
    private final g nTE;
    private final g nTF;
    private final g nTG;

    private static Schedulers dPm() {
        Schedulers schedulers;
        while (true) {
            schedulers = nNy.get();
            if (schedulers == null) {
                schedulers = new Schedulers();
                if (nNy.compareAndSet(null, schedulers)) {
                    break;
                }
                schedulers.dPo();
            } else {
                break;
            }
        }
        return schedulers;
    }

    private Schedulers() {
        rx.c.g dPd = f.dOY().dPd();
        g dPh = dPd.dPh();
        if (dPh != null) {
            this.nTE = dPh;
        } else {
            this.nTE = rx.c.g.dPe();
        }
        g dPi = dPd.dPi();
        if (dPi != null) {
            this.nTF = dPi;
        } else {
            this.nTF = rx.c.g.dPf();
        }
        g dPj = dPd.dPj();
        if (dPj != null) {
            this.nTG = dPj;
        } else {
            this.nTG = rx.c.g.dPg();
        }
    }

    public static g immediate() {
        return e.nRM;
    }

    public static g trampoline() {
        return j.nSk;
    }

    public static g newThread() {
        return c.k(dPm().nTG);
    }

    public static g computation() {
        return c.i(dPm().nTE);
    }

    public static g io() {
        return c.j(dPm().nTF);
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static g from(Executor executor) {
        return new rx.internal.schedulers.c(executor);
    }

    public static void reset() {
        Schedulers andSet = nNy.getAndSet(null);
        if (andSet != null) {
            andSet.dPo();
        }
    }

    public static void start() {
        Schedulers dPm = dPm();
        dPm.dPn();
        synchronized (dPm) {
            d.nRK.start();
        }
    }

    public static void shutdown() {
        Schedulers dPm = dPm();
        dPm.dPo();
        synchronized (dPm) {
            d.nRK.shutdown();
        }
    }

    synchronized void dPn() {
        if (this.nTE instanceof h) {
            ((h) this.nTE).start();
        }
        if (this.nTF instanceof h) {
            ((h) this.nTF).start();
        }
        if (this.nTG instanceof h) {
            ((h) this.nTG).start();
        }
    }

    synchronized void dPo() {
        if (this.nTE instanceof h) {
            ((h) this.nTE).shutdown();
        }
        if (this.nTF instanceof h) {
            ((h) this.nTF).shutdown();
        }
        if (this.nTG instanceof h) {
            ((h) this.nTG).shutdown();
        }
    }
}
