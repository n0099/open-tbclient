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
/* loaded from: classes16.dex */
public final class Schedulers {
    private static final AtomicReference<Schedulers> qdL = new AtomicReference<>();
    private final g qjU;
    private final g qjV;
    private final g qjW;

    private static Schedulers eGI() {
        Schedulers schedulers;
        while (true) {
            schedulers = qdL.get();
            if (schedulers == null) {
                schedulers = new Schedulers();
                if (qdL.compareAndSet(null, schedulers)) {
                    break;
                }
                schedulers.eGK();
            } else {
                break;
            }
        }
        return schedulers;
    }

    private Schedulers() {
        rx.c.g eGz = f.eGu().eGz();
        g eGD = eGz.eGD();
        if (eGD != null) {
            this.qjU = eGD;
        } else {
            this.qjU = rx.c.g.eGA();
        }
        g eGE = eGz.eGE();
        if (eGE != null) {
            this.qjV = eGE;
        } else {
            this.qjV = rx.c.g.eGB();
        }
        g eGF = eGz.eGF();
        if (eGF != null) {
            this.qjW = eGF;
        } else {
            this.qjW = rx.c.g.eGC();
        }
    }

    public static g immediate() {
        return e.qia;
    }

    public static g trampoline() {
        return j.qiz;
    }

    public static g newThread() {
        return c.k(eGI().qjW);
    }

    public static g computation() {
        return c.i(eGI().qjU);
    }

    public static g io() {
        return c.j(eGI().qjV);
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static g from(Executor executor) {
        return new rx.internal.schedulers.c(executor);
    }

    public static void reset() {
        Schedulers andSet = qdL.getAndSet(null);
        if (andSet != null) {
            andSet.eGK();
        }
    }

    public static void start() {
        Schedulers eGI = eGI();
        eGI.eGJ();
        synchronized (eGI) {
            d.qhY.start();
        }
    }

    public static void shutdown() {
        Schedulers eGI = eGI();
        eGI.eGK();
        synchronized (eGI) {
            d.qhY.shutdown();
        }
    }

    synchronized void eGJ() {
        if (this.qjU instanceof h) {
            ((h) this.qjU).start();
        }
        if (this.qjV instanceof h) {
            ((h) this.qjV).start();
        }
        if (this.qjW instanceof h) {
            ((h) this.qjW).start();
        }
    }

    synchronized void eGK() {
        if (this.qjU instanceof h) {
            ((h) this.qjU).shutdown();
        }
        if (this.qjV instanceof h) {
            ((h) this.qjV).shutdown();
        }
        if (this.qjW instanceof h) {
            ((h) this.qjW).shutdown();
        }
    }
}
