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
/* loaded from: classes5.dex */
public final class Schedulers {
    private static final AtomicReference<Schedulers> nMC = new AtomicReference<>();
    private final g nSJ;
    private final g nSK;
    private final g nSL;

    private static Schedulers dNV() {
        Schedulers schedulers;
        while (true) {
            schedulers = nMC.get();
            if (schedulers == null) {
                schedulers = new Schedulers();
                if (nMC.compareAndSet(null, schedulers)) {
                    break;
                }
                schedulers.dNX();
            } else {
                break;
            }
        }
        return schedulers;
    }

    private Schedulers() {
        rx.c.g dNM = f.dNH().dNM();
        g dNQ = dNM.dNQ();
        if (dNQ != null) {
            this.nSJ = dNQ;
        } else {
            this.nSJ = rx.c.g.dNN();
        }
        g dNR = dNM.dNR();
        if (dNR != null) {
            this.nSK = dNR;
        } else {
            this.nSK = rx.c.g.dNO();
        }
        g dNS = dNM.dNS();
        if (dNS != null) {
            this.nSL = dNS;
        } else {
            this.nSL = rx.c.g.dNP();
        }
    }

    public static g immediate() {
        return e.nQQ;
    }

    public static g trampoline() {
        return j.nRo;
    }

    public static g newThread() {
        return c.k(dNV().nSL);
    }

    public static g computation() {
        return c.i(dNV().nSJ);
    }

    public static g io() {
        return c.j(dNV().nSK);
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static g from(Executor executor) {
        return new rx.internal.schedulers.c(executor);
    }

    public static void reset() {
        Schedulers andSet = nMC.getAndSet(null);
        if (andSet != null) {
            andSet.dNX();
        }
    }

    public static void start() {
        Schedulers dNV = dNV();
        dNV.dNW();
        synchronized (dNV) {
            d.nQO.start();
        }
    }

    public static void shutdown() {
        Schedulers dNV = dNV();
        dNV.dNX();
        synchronized (dNV) {
            d.nQO.shutdown();
        }
    }

    synchronized void dNW() {
        if (this.nSJ instanceof h) {
            ((h) this.nSJ).start();
        }
        if (this.nSK instanceof h) {
            ((h) this.nSK).start();
        }
        if (this.nSL instanceof h) {
            ((h) this.nSL).start();
        }
    }

    synchronized void dNX() {
        if (this.nSJ instanceof h) {
            ((h) this.nSJ).shutdown();
        }
        if (this.nSK instanceof h) {
            ((h) this.nSK).shutdown();
        }
        if (this.nSL instanceof h) {
            ((h) this.nSL).shutdown();
        }
    }
}
