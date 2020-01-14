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
    private static final AtomicReference<Schedulers> nMH = new AtomicReference<>();
    private final g nSO;
    private final g nSP;
    private final g nSQ;

    private static Schedulers dNX() {
        Schedulers schedulers;
        while (true) {
            schedulers = nMH.get();
            if (schedulers == null) {
                schedulers = new Schedulers();
                if (nMH.compareAndSet(null, schedulers)) {
                    break;
                }
                schedulers.dNZ();
            } else {
                break;
            }
        }
        return schedulers;
    }

    private Schedulers() {
        rx.c.g dNO = f.dNJ().dNO();
        g dNS = dNO.dNS();
        if (dNS != null) {
            this.nSO = dNS;
        } else {
            this.nSO = rx.c.g.dNP();
        }
        g dNT = dNO.dNT();
        if (dNT != null) {
            this.nSP = dNT;
        } else {
            this.nSP = rx.c.g.dNQ();
        }
        g dNU = dNO.dNU();
        if (dNU != null) {
            this.nSQ = dNU;
        } else {
            this.nSQ = rx.c.g.dNR();
        }
    }

    public static g immediate() {
        return e.nQV;
    }

    public static g trampoline() {
        return j.nRt;
    }

    public static g newThread() {
        return c.k(dNX().nSQ);
    }

    public static g computation() {
        return c.i(dNX().nSO);
    }

    public static g io() {
        return c.j(dNX().nSP);
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static g from(Executor executor) {
        return new rx.internal.schedulers.c(executor);
    }

    public static void reset() {
        Schedulers andSet = nMH.getAndSet(null);
        if (andSet != null) {
            andSet.dNZ();
        }
    }

    public static void start() {
        Schedulers dNX = dNX();
        dNX.dNY();
        synchronized (dNX) {
            d.nQT.start();
        }
    }

    public static void shutdown() {
        Schedulers dNX = dNX();
        dNX.dNZ();
        synchronized (dNX) {
            d.nQT.shutdown();
        }
    }

    synchronized void dNY() {
        if (this.nSO instanceof h) {
            ((h) this.nSO).start();
        }
        if (this.nSP instanceof h) {
            ((h) this.nSP).start();
        }
        if (this.nSQ instanceof h) {
            ((h) this.nSQ).start();
        }
    }

    synchronized void dNZ() {
        if (this.nSO instanceof h) {
            ((h) this.nSO).shutdown();
        }
        if (this.nSP instanceof h) {
            ((h) this.nSP).shutdown();
        }
        if (this.nSQ instanceof h) {
            ((h) this.nSQ).shutdown();
        }
    }
}
