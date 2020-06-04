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
    private static final AtomicReference<Schedulers> nFp = new AtomicReference<>();
    private final g nLx;
    private final g nLy;
    private final g nLz;

    private static Schedulers dQS() {
        Schedulers schedulers;
        while (true) {
            schedulers = nFp.get();
            if (schedulers == null) {
                schedulers = new Schedulers();
                if (nFp.compareAndSet(null, schedulers)) {
                    break;
                }
                schedulers.dQU();
            } else {
                break;
            }
        }
        return schedulers;
    }

    private Schedulers() {
        rx.c.g dQJ = f.dQE().dQJ();
        g dQN = dQJ.dQN();
        if (dQN != null) {
            this.nLx = dQN;
        } else {
            this.nLx = rx.c.g.dQK();
        }
        g dQO = dQJ.dQO();
        if (dQO != null) {
            this.nLy = dQO;
        } else {
            this.nLy = rx.c.g.dQL();
        }
        g dQP = dQJ.dQP();
        if (dQP != null) {
            this.nLz = dQP;
        } else {
            this.nLz = rx.c.g.dQM();
        }
    }

    public static g immediate() {
        return e.nJE;
    }

    public static g trampoline() {
        return j.nKc;
    }

    public static g newThread() {
        return c.k(dQS().nLz);
    }

    public static g computation() {
        return c.i(dQS().nLx);
    }

    public static g io() {
        return c.j(dQS().nLy);
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static g from(Executor executor) {
        return new rx.internal.schedulers.c(executor);
    }

    public static void reset() {
        Schedulers andSet = nFp.getAndSet(null);
        if (andSet != null) {
            andSet.dQU();
        }
    }

    public static void start() {
        Schedulers dQS = dQS();
        dQS.dQT();
        synchronized (dQS) {
            d.nJC.start();
        }
    }

    public static void shutdown() {
        Schedulers dQS = dQS();
        dQS.dQU();
        synchronized (dQS) {
            d.nJC.shutdown();
        }
    }

    synchronized void dQT() {
        if (this.nLx instanceof h) {
            ((h) this.nLx).start();
        }
        if (this.nLy instanceof h) {
            ((h) this.nLy).start();
        }
        if (this.nLz instanceof h) {
            ((h) this.nLz).start();
        }
    }

    synchronized void dQU() {
        if (this.nLx instanceof h) {
            ((h) this.nLx).shutdown();
        }
        if (this.nLy instanceof h) {
            ((h) this.nLy).shutdown();
        }
        if (this.nLz instanceof h) {
            ((h) this.nLz).shutdown();
        }
    }
}
