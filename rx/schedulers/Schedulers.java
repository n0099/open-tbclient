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
    private static final AtomicReference<Schedulers> njf = new AtomicReference<>();
    private final g npp;
    private final g npq;
    private final g npr;

    private static Schedulers dIJ() {
        Schedulers schedulers;
        while (true) {
            schedulers = njf.get();
            if (schedulers == null) {
                schedulers = new Schedulers();
                if (njf.compareAndSet(null, schedulers)) {
                    break;
                }
                schedulers.dIL();
            } else {
                break;
            }
        }
        return schedulers;
    }

    private Schedulers() {
        rx.c.g dIA = f.dIv().dIA();
        g dIE = dIA.dIE();
        if (dIE != null) {
            this.npp = dIE;
        } else {
            this.npp = rx.c.g.dIB();
        }
        g dIF = dIA.dIF();
        if (dIF != null) {
            this.npq = dIF;
        } else {
            this.npq = rx.c.g.dIC();
        }
        g dIG = dIA.dIG();
        if (dIG != null) {
            this.npr = dIG;
        } else {
            this.npr = rx.c.g.dID();
        }
    }

    public static g immediate() {
        return e.nnu;
    }

    public static g trampoline() {
        return j.nnS;
    }

    public static g newThread() {
        return c.k(dIJ().npr);
    }

    public static g computation() {
        return c.i(dIJ().npp);
    }

    public static g io() {
        return c.j(dIJ().npq);
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static g from(Executor executor) {
        return new rx.internal.schedulers.c(executor);
    }

    public static void reset() {
        Schedulers andSet = njf.getAndSet(null);
        if (andSet != null) {
            andSet.dIL();
        }
    }

    public static void start() {
        Schedulers dIJ = dIJ();
        dIJ.dIK();
        synchronized (dIJ) {
            d.nns.start();
        }
    }

    public static void shutdown() {
        Schedulers dIJ = dIJ();
        dIJ.dIL();
        synchronized (dIJ) {
            d.nns.shutdown();
        }
    }

    synchronized void dIK() {
        if (this.npp instanceof h) {
            ((h) this.npp).start();
        }
        if (this.npq instanceof h) {
            ((h) this.npq).start();
        }
        if (this.npr instanceof h) {
            ((h) this.npr).start();
        }
    }

    synchronized void dIL() {
        if (this.npp instanceof h) {
            ((h) this.npp).shutdown();
        }
        if (this.npq instanceof h) {
            ((h) this.npq).shutdown();
        }
        if (this.npr instanceof h) {
            ((h) this.npr).shutdown();
        }
    }
}
