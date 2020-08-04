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
    private static final AtomicReference<Schedulers> ojP = new AtomicReference<>();
    private final g opZ;
    private final g oqa;
    private final g oqb;

    private static Schedulers dYZ() {
        Schedulers schedulers;
        while (true) {
            schedulers = ojP.get();
            if (schedulers == null) {
                schedulers = new Schedulers();
                if (ojP.compareAndSet(null, schedulers)) {
                    break;
                }
                schedulers.dZb();
            } else {
                break;
            }
        }
        return schedulers;
    }

    private Schedulers() {
        rx.c.g dYQ = f.dYL().dYQ();
        g dYU = dYQ.dYU();
        if (dYU != null) {
            this.opZ = dYU;
        } else {
            this.opZ = rx.c.g.dYR();
        }
        g dYV = dYQ.dYV();
        if (dYV != null) {
            this.oqa = dYV;
        } else {
            this.oqa = rx.c.g.dYS();
        }
        g dYW = dYQ.dYW();
        if (dYW != null) {
            this.oqb = dYW;
        } else {
            this.oqb = rx.c.g.dYT();
        }
    }

    public static g immediate() {
        return e.oof;
    }

    public static g trampoline() {
        return j.ooD;
    }

    public static g newThread() {
        return c.k(dYZ().oqb);
    }

    public static g computation() {
        return c.i(dYZ().opZ);
    }

    public static g io() {
        return c.j(dYZ().oqa);
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static g from(Executor executor) {
        return new rx.internal.schedulers.c(executor);
    }

    public static void reset() {
        Schedulers andSet = ojP.getAndSet(null);
        if (andSet != null) {
            andSet.dZb();
        }
    }

    public static void start() {
        Schedulers dYZ = dYZ();
        dYZ.dZa();
        synchronized (dYZ) {
            d.ood.start();
        }
    }

    public static void shutdown() {
        Schedulers dYZ = dYZ();
        dYZ.dZb();
        synchronized (dYZ) {
            d.ood.shutdown();
        }
    }

    synchronized void dZa() {
        if (this.opZ instanceof h) {
            ((h) this.opZ).start();
        }
        if (this.oqa instanceof h) {
            ((h) this.oqa).start();
        }
        if (this.oqb instanceof h) {
            ((h) this.oqb).start();
        }
    }

    synchronized void dZb() {
        if (this.opZ instanceof h) {
            ((h) this.opZ).shutdown();
        }
        if (this.oqa instanceof h) {
            ((h) this.oqa).shutdown();
        }
        if (this.oqb instanceof h) {
            ((h) this.oqb).shutdown();
        }
    }
}
