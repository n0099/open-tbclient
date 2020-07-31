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
    private static final AtomicReference<Schedulers> ojN = new AtomicReference<>();
    private final g opX;
    private final g opY;
    private final g opZ;

    private static Schedulers dYY() {
        Schedulers schedulers;
        while (true) {
            schedulers = ojN.get();
            if (schedulers == null) {
                schedulers = new Schedulers();
                if (ojN.compareAndSet(null, schedulers)) {
                    break;
                }
                schedulers.dZa();
            } else {
                break;
            }
        }
        return schedulers;
    }

    private Schedulers() {
        rx.c.g dYP = f.dYK().dYP();
        g dYT = dYP.dYT();
        if (dYT != null) {
            this.opX = dYT;
        } else {
            this.opX = rx.c.g.dYQ();
        }
        g dYU = dYP.dYU();
        if (dYU != null) {
            this.opY = dYU;
        } else {
            this.opY = rx.c.g.dYR();
        }
        g dYV = dYP.dYV();
        if (dYV != null) {
            this.opZ = dYV;
        } else {
            this.opZ = rx.c.g.dYS();
        }
    }

    public static g immediate() {
        return e.ood;
    }

    public static g trampoline() {
        return j.ooB;
    }

    public static g newThread() {
        return c.k(dYY().opZ);
    }

    public static g computation() {
        return c.i(dYY().opX);
    }

    public static g io() {
        return c.j(dYY().opY);
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static g from(Executor executor) {
        return new rx.internal.schedulers.c(executor);
    }

    public static void reset() {
        Schedulers andSet = ojN.getAndSet(null);
        if (andSet != null) {
            andSet.dZa();
        }
    }

    public static void start() {
        Schedulers dYY = dYY();
        dYY.dYZ();
        synchronized (dYY) {
            d.oob.start();
        }
    }

    public static void shutdown() {
        Schedulers dYY = dYY();
        dYY.dZa();
        synchronized (dYY) {
            d.oob.shutdown();
        }
    }

    synchronized void dYZ() {
        if (this.opX instanceof h) {
            ((h) this.opX).start();
        }
        if (this.opY instanceof h) {
            ((h) this.opY).start();
        }
        if (this.opZ instanceof h) {
            ((h) this.opZ).start();
        }
    }

    synchronized void dZa() {
        if (this.opX instanceof h) {
            ((h) this.opX).shutdown();
        }
        if (this.opY instanceof h) {
            ((h) this.opY).shutdown();
        }
        if (this.opZ instanceof h) {
            ((h) this.opZ).shutdown();
        }
    }
}
