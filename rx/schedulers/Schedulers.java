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
    private static final AtomicReference<Schedulers> pcY = new AtomicReference<>();
    private final g pjj;
    private final g pjk;
    private final g pjl;

    private static Schedulers esV() {
        Schedulers schedulers;
        while (true) {
            schedulers = pcY.get();
            if (schedulers == null) {
                schedulers = new Schedulers();
                if (pcY.compareAndSet(null, schedulers)) {
                    break;
                }
                schedulers.esX();
            } else {
                break;
            }
        }
        return schedulers;
    }

    private Schedulers() {
        rx.c.g esM = f.esH().esM();
        g esQ = esM.esQ();
        if (esQ != null) {
            this.pjj = esQ;
        } else {
            this.pjj = rx.c.g.esN();
        }
        g esR = esM.esR();
        if (esR != null) {
            this.pjk = esR;
        } else {
            this.pjk = rx.c.g.esO();
        }
        g esS = esM.esS();
        if (esS != null) {
            this.pjl = esS;
        } else {
            this.pjl = rx.c.g.esP();
        }
    }

    public static g immediate() {
        return e.phn;
    }

    public static g trampoline() {
        return j.phL;
    }

    public static g newThread() {
        return c.k(esV().pjl);
    }

    public static g computation() {
        return c.i(esV().pjj);
    }

    public static g io() {
        return c.j(esV().pjk);
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static g from(Executor executor) {
        return new rx.internal.schedulers.c(executor);
    }

    public static void reset() {
        Schedulers andSet = pcY.getAndSet(null);
        if (andSet != null) {
            andSet.esX();
        }
    }

    public static void start() {
        Schedulers esV = esV();
        esV.esW();
        synchronized (esV) {
            d.phl.start();
        }
    }

    public static void shutdown() {
        Schedulers esV = esV();
        esV.esX();
        synchronized (esV) {
            d.phl.shutdown();
        }
    }

    synchronized void esW() {
        if (this.pjj instanceof h) {
            ((h) this.pjj).start();
        }
        if (this.pjk instanceof h) {
            ((h) this.pjk).start();
        }
        if (this.pjl instanceof h) {
            ((h) this.pjl).start();
        }
    }

    synchronized void esX() {
        if (this.pjj instanceof h) {
            ((h) this.pjj).shutdown();
        }
        if (this.pjk instanceof h) {
            ((h) this.pjk).shutdown();
        }
        if (this.pjl instanceof h) {
            ((h) this.pjl).shutdown();
        }
    }
}
