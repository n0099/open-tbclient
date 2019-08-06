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
    private static final AtomicReference<Schedulers> kCO = new AtomicReference<>();
    private final g kCL;
    private final g kCM;
    private final g kCN;

    private static Schedulers cQY() {
        Schedulers schedulers;
        while (true) {
            schedulers = kCO.get();
            if (schedulers == null) {
                schedulers = new Schedulers();
                if (kCO.compareAndSet(null, schedulers)) {
                    break;
                }
                schedulers.cRa();
            } else {
                break;
            }
        }
        return schedulers;
    }

    private Schedulers() {
        rx.c.g cQP = f.cQK().cQP();
        g cQT = cQP.cQT();
        if (cQT != null) {
            this.kCL = cQT;
        } else {
            this.kCL = rx.c.g.cQQ();
        }
        g cQU = cQP.cQU();
        if (cQU != null) {
            this.kCM = cQU;
        } else {
            this.kCM = rx.c.g.cQR();
        }
        g cQV = cQP.cQV();
        if (cQV != null) {
            this.kCN = cQV;
        } else {
            this.kCN = rx.c.g.cQS();
        }
    }

    public static g immediate() {
        return e.kAv;
    }

    public static g trampoline() {
        return j.kAV;
    }

    public static g newThread() {
        return c.i(cQY().kCN);
    }

    public static g computation() {
        return c.g(cQY().kCL);
    }

    public static g io() {
        return c.h(cQY().kCM);
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static g from(Executor executor) {
        return new rx.internal.schedulers.c(executor);
    }

    public static void reset() {
        Schedulers andSet = kCO.getAndSet(null);
        if (andSet != null) {
            andSet.cRa();
        }
    }

    public static void start() {
        Schedulers cQY = cQY();
        cQY.cQZ();
        synchronized (cQY) {
            d.kAs.start();
        }
    }

    public static void shutdown() {
        Schedulers cQY = cQY();
        cQY.cRa();
        synchronized (cQY) {
            d.kAs.shutdown();
        }
    }

    synchronized void cQZ() {
        if (this.kCL instanceof h) {
            ((h) this.kCL).start();
        }
        if (this.kCM instanceof h) {
            ((h) this.kCM).start();
        }
        if (this.kCN instanceof h) {
            ((h) this.kCN).start();
        }
    }

    synchronized void cRa() {
        if (this.kCL instanceof h) {
            ((h) this.kCL).shutdown();
        }
        if (this.kCM instanceof h) {
            ((h) this.kCM).shutdown();
        }
        if (this.kCN instanceof h) {
            ((h) this.kCN).shutdown();
        }
    }
}
