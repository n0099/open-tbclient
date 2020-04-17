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
    private static final AtomicReference<Schedulers> njc = new AtomicReference<>();
    private final g npm;
    private final g npn;
    private final g npo;

    private static Schedulers dIN() {
        Schedulers schedulers;
        while (true) {
            schedulers = njc.get();
            if (schedulers == null) {
                schedulers = new Schedulers();
                if (njc.compareAndSet(null, schedulers)) {
                    break;
                }
                schedulers.dIP();
            } else {
                break;
            }
        }
        return schedulers;
    }

    private Schedulers() {
        rx.c.g dIE = f.dIz().dIE();
        g dII = dIE.dII();
        if (dII != null) {
            this.npm = dII;
        } else {
            this.npm = rx.c.g.dIF();
        }
        g dIJ = dIE.dIJ();
        if (dIJ != null) {
            this.npn = dIJ;
        } else {
            this.npn = rx.c.g.dIG();
        }
        g dIK = dIE.dIK();
        if (dIK != null) {
            this.npo = dIK;
        } else {
            this.npo = rx.c.g.dIH();
        }
    }

    public static g immediate() {
        return e.nnr;
    }

    public static g trampoline() {
        return j.nnP;
    }

    public static g newThread() {
        return c.k(dIN().npo);
    }

    public static g computation() {
        return c.i(dIN().npm);
    }

    public static g io() {
        return c.j(dIN().npn);
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static g from(Executor executor) {
        return new rx.internal.schedulers.c(executor);
    }

    public static void reset() {
        Schedulers andSet = njc.getAndSet(null);
        if (andSet != null) {
            andSet.dIP();
        }
    }

    public static void start() {
        Schedulers dIN = dIN();
        dIN.dIO();
        synchronized (dIN) {
            d.nnp.start();
        }
    }

    public static void shutdown() {
        Schedulers dIN = dIN();
        dIN.dIP();
        synchronized (dIN) {
            d.nnp.shutdown();
        }
    }

    synchronized void dIO() {
        if (this.npm instanceof h) {
            ((h) this.npm).start();
        }
        if (this.npn instanceof h) {
            ((h) this.npn).start();
        }
        if (this.npo instanceof h) {
            ((h) this.npo).start();
        }
    }

    synchronized void dIP() {
        if (this.npm instanceof h) {
            ((h) this.npm).shutdown();
        }
        if (this.npn instanceof h) {
            ((h) this.npn).shutdown();
        }
        if (this.npo instanceof h) {
            ((h) this.npo).shutdown();
        }
    }
}
