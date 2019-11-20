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
    private static final AtomicReference<Schedulers> kEW = new AtomicReference<>();
    private final g kET;
    private final g kEU;
    private final g kEV;

    private static Schedulers cPN() {
        Schedulers schedulers;
        while (true) {
            schedulers = kEW.get();
            if (schedulers == null) {
                schedulers = new Schedulers();
                if (kEW.compareAndSet(null, schedulers)) {
                    break;
                }
                schedulers.cPP();
            } else {
                break;
            }
        }
        return schedulers;
    }

    private Schedulers() {
        rx.c.g cPE = f.cPz().cPE();
        g cPI = cPE.cPI();
        if (cPI != null) {
            this.kET = cPI;
        } else {
            this.kET = rx.c.g.cPF();
        }
        g cPJ = cPE.cPJ();
        if (cPJ != null) {
            this.kEU = cPJ;
        } else {
            this.kEU = rx.c.g.cPG();
        }
        g cPK = cPE.cPK();
        if (cPK != null) {
            this.kEV = cPK;
        } else {
            this.kEV = rx.c.g.cPH();
        }
    }

    public static g immediate() {
        return e.kCE;
    }

    public static g trampoline() {
        return j.kDe;
    }

    public static g newThread() {
        return c.i(cPN().kEV);
    }

    public static g computation() {
        return c.g(cPN().kET);
    }

    public static g io() {
        return c.h(cPN().kEU);
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static g from(Executor executor) {
        return new rx.internal.schedulers.c(executor);
    }

    public static void reset() {
        Schedulers andSet = kEW.getAndSet(null);
        if (andSet != null) {
            andSet.cPP();
        }
    }

    public static void start() {
        Schedulers cPN = cPN();
        cPN.cPO();
        synchronized (cPN) {
            d.kCB.start();
        }
    }

    public static void shutdown() {
        Schedulers cPN = cPN();
        cPN.cPP();
        synchronized (cPN) {
            d.kCB.shutdown();
        }
    }

    synchronized void cPO() {
        if (this.kET instanceof h) {
            ((h) this.kET).start();
        }
        if (this.kEU instanceof h) {
            ((h) this.kEU).start();
        }
        if (this.kEV instanceof h) {
            ((h) this.kEV).start();
        }
    }

    synchronized void cPP() {
        if (this.kET instanceof h) {
            ((h) this.kET).shutdown();
        }
        if (this.kEU instanceof h) {
            ((h) this.kEU).shutdown();
        }
        if (this.kEV instanceof h) {
            ((h) this.kEV).shutdown();
        }
    }
}
