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
    private static final AtomicReference<Schedulers> kug = new AtomicReference<>();
    private final g kud;
    private final g kue;
    private final g kuf;

    private static Schedulers cMO() {
        Schedulers schedulers;
        while (true) {
            schedulers = kug.get();
            if (schedulers == null) {
                schedulers = new Schedulers();
                if (kug.compareAndSet(null, schedulers)) {
                    break;
                }
                schedulers.cMQ();
            } else {
                break;
            }
        }
        return schedulers;
    }

    private Schedulers() {
        rx.c.g cMF = f.cMA().cMF();
        g cMJ = cMF.cMJ();
        if (cMJ != null) {
            this.kud = cMJ;
        } else {
            this.kud = rx.c.g.cMG();
        }
        g cMK = cMF.cMK();
        if (cMK != null) {
            this.kue = cMK;
        } else {
            this.kue = rx.c.g.cMH();
        }
        g cML = cMF.cML();
        if (cML != null) {
            this.kuf = cML;
        } else {
            this.kuf = rx.c.g.cMI();
        }
    }

    public static g immediate() {
        return e.krN;
    }

    public static g trampoline() {
        return j.ksn;
    }

    public static g newThread() {
        return c.i(cMO().kuf);
    }

    public static g computation() {
        return c.g(cMO().kud);
    }

    public static g io() {
        return c.h(cMO().kue);
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static g from(Executor executor) {
        return new rx.internal.schedulers.c(executor);
    }

    public static void reset() {
        Schedulers andSet = kug.getAndSet(null);
        if (andSet != null) {
            andSet.cMQ();
        }
    }

    public static void start() {
        Schedulers cMO = cMO();
        cMO.cMP();
        synchronized (cMO) {
            d.krK.start();
        }
    }

    public static void shutdown() {
        Schedulers cMO = cMO();
        cMO.cMQ();
        synchronized (cMO) {
            d.krK.shutdown();
        }
    }

    synchronized void cMP() {
        if (this.kud instanceof h) {
            ((h) this.kud).start();
        }
        if (this.kue instanceof h) {
            ((h) this.kue).start();
        }
        if (this.kuf instanceof h) {
            ((h) this.kuf).start();
        }
    }

    synchronized void cMQ() {
        if (this.kud instanceof h) {
            ((h) this.kud).shutdown();
        }
        if (this.kue instanceof h) {
            ((h) this.kue).shutdown();
        }
        if (this.kuf instanceof h) {
            ((h) this.kuf).shutdown();
        }
    }
}
