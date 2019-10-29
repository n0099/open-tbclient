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
    private static final AtomicReference<Schedulers> kFN = new AtomicReference<>();
    private final g kFK;
    private final g kFL;
    private final g kFM;

    private static Schedulers cPP() {
        Schedulers schedulers;
        while (true) {
            schedulers = kFN.get();
            if (schedulers == null) {
                schedulers = new Schedulers();
                if (kFN.compareAndSet(null, schedulers)) {
                    break;
                }
                schedulers.cPR();
            } else {
                break;
            }
        }
        return schedulers;
    }

    private Schedulers() {
        rx.c.g cPG = f.cPB().cPG();
        g cPK = cPG.cPK();
        if (cPK != null) {
            this.kFK = cPK;
        } else {
            this.kFK = rx.c.g.cPH();
        }
        g cPL = cPG.cPL();
        if (cPL != null) {
            this.kFL = cPL;
        } else {
            this.kFL = rx.c.g.cPI();
        }
        g cPM = cPG.cPM();
        if (cPM != null) {
            this.kFM = cPM;
        } else {
            this.kFM = rx.c.g.cPJ();
        }
    }

    public static g immediate() {
        return e.kDv;
    }

    public static g trampoline() {
        return j.kDV;
    }

    public static g newThread() {
        return c.i(cPP().kFM);
    }

    public static g computation() {
        return c.g(cPP().kFK);
    }

    public static g io() {
        return c.h(cPP().kFL);
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static g from(Executor executor) {
        return new rx.internal.schedulers.c(executor);
    }

    public static void reset() {
        Schedulers andSet = kFN.getAndSet(null);
        if (andSet != null) {
            andSet.cPR();
        }
    }

    public static void start() {
        Schedulers cPP = cPP();
        cPP.cPQ();
        synchronized (cPP) {
            d.kDs.start();
        }
    }

    public static void shutdown() {
        Schedulers cPP = cPP();
        cPP.cPR();
        synchronized (cPP) {
            d.kDs.shutdown();
        }
    }

    synchronized void cPQ() {
        if (this.kFK instanceof h) {
            ((h) this.kFK).start();
        }
        if (this.kFL instanceof h) {
            ((h) this.kFL).start();
        }
        if (this.kFM instanceof h) {
            ((h) this.kFM).start();
        }
    }

    synchronized void cPR() {
        if (this.kFK instanceof h) {
            ((h) this.kFK).shutdown();
        }
        if (this.kFL instanceof h) {
            ((h) this.kFL).shutdown();
        }
        if (this.kFM instanceof h) {
            ((h) this.kFM).shutdown();
        }
    }
}
