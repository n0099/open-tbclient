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
    private static final AtomicReference<Schedulers> nNJ = new AtomicReference<>();
    private final g nTP;
    private final g nTQ;
    private final g nTR;

    private static Schedulers dPn() {
        Schedulers schedulers;
        while (true) {
            schedulers = nNJ.get();
            if (schedulers == null) {
                schedulers = new Schedulers();
                if (nNJ.compareAndSet(null, schedulers)) {
                    break;
                }
                schedulers.dPp();
            } else {
                break;
            }
        }
        return schedulers;
    }

    private Schedulers() {
        rx.c.g dPe = f.dOZ().dPe();
        g dPi = dPe.dPi();
        if (dPi != null) {
            this.nTP = dPi;
        } else {
            this.nTP = rx.c.g.dPf();
        }
        g dPj = dPe.dPj();
        if (dPj != null) {
            this.nTQ = dPj;
        } else {
            this.nTQ = rx.c.g.dPg();
        }
        g dPk = dPe.dPk();
        if (dPk != null) {
            this.nTR = dPk;
        } else {
            this.nTR = rx.c.g.dPh();
        }
    }

    public static g immediate() {
        return e.nRX;
    }

    public static g trampoline() {
        return j.nSv;
    }

    public static g newThread() {
        return c.k(dPn().nTR);
    }

    public static g computation() {
        return c.i(dPn().nTP);
    }

    public static g io() {
        return c.j(dPn().nTQ);
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static g from(Executor executor) {
        return new rx.internal.schedulers.c(executor);
    }

    public static void reset() {
        Schedulers andSet = nNJ.getAndSet(null);
        if (andSet != null) {
            andSet.dPp();
        }
    }

    public static void start() {
        Schedulers dPn = dPn();
        dPn.dPo();
        synchronized (dPn) {
            d.nRV.start();
        }
    }

    public static void shutdown() {
        Schedulers dPn = dPn();
        dPn.dPp();
        synchronized (dPn) {
            d.nRV.shutdown();
        }
    }

    synchronized void dPo() {
        if (this.nTP instanceof h) {
            ((h) this.nTP).start();
        }
        if (this.nTQ instanceof h) {
            ((h) this.nTQ).start();
        }
        if (this.nTR instanceof h) {
            ((h) this.nTR).start();
        }
    }

    synchronized void dPp() {
        if (this.nTP instanceof h) {
            ((h) this.nTP).shutdown();
        }
        if (this.nTQ instanceof h) {
            ((h) this.nTQ).shutdown();
        }
        if (this.nTR instanceof h) {
            ((h) this.nTR).shutdown();
        }
    }
}
