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
    private static final AtomicReference<Schedulers> kuj = new AtomicReference<>();
    private final g kug;
    private final g kuh;
    private final g kui;

    private static Schedulers cMN() {
        Schedulers schedulers;
        while (true) {
            schedulers = kuj.get();
            if (schedulers == null) {
                schedulers = new Schedulers();
                if (kuj.compareAndSet(null, schedulers)) {
                    break;
                }
                schedulers.cMP();
            } else {
                break;
            }
        }
        return schedulers;
    }

    private Schedulers() {
        rx.c.g cME = f.cMz().cME();
        g cMI = cME.cMI();
        if (cMI != null) {
            this.kug = cMI;
        } else {
            this.kug = rx.c.g.cMF();
        }
        g cMJ = cME.cMJ();
        if (cMJ != null) {
            this.kuh = cMJ;
        } else {
            this.kuh = rx.c.g.cMG();
        }
        g cMK = cME.cMK();
        if (cMK != null) {
            this.kui = cMK;
        } else {
            this.kui = rx.c.g.cMH();
        }
    }

    public static g immediate() {
        return e.krQ;
    }

    public static g trampoline() {
        return j.ksq;
    }

    public static g newThread() {
        return c.i(cMN().kui);
    }

    public static g computation() {
        return c.g(cMN().kug);
    }

    public static g io() {
        return c.h(cMN().kuh);
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static g from(Executor executor) {
        return new rx.internal.schedulers.c(executor);
    }

    public static void reset() {
        Schedulers andSet = kuj.getAndSet(null);
        if (andSet != null) {
            andSet.cMP();
        }
    }

    public static void start() {
        Schedulers cMN = cMN();
        cMN.cMO();
        synchronized (cMN) {
            d.krN.start();
        }
    }

    public static void shutdown() {
        Schedulers cMN = cMN();
        cMN.cMP();
        synchronized (cMN) {
            d.krN.shutdown();
        }
    }

    synchronized void cMO() {
        if (this.kug instanceof h) {
            ((h) this.kug).start();
        }
        if (this.kuh instanceof h) {
            ((h) this.kuh).start();
        }
        if (this.kui instanceof h) {
            ((h) this.kui).start();
        }
    }

    synchronized void cMP() {
        if (this.kug instanceof h) {
            ((h) this.kug).shutdown();
        }
        if (this.kuh instanceof h) {
            ((h) this.kuh).shutdown();
        }
        if (this.kui instanceof h) {
            ((h) this.kui).shutdown();
        }
    }
}
