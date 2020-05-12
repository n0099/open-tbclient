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

    private static Schedulers dIK() {
        Schedulers schedulers;
        while (true) {
            schedulers = njf.get();
            if (schedulers == null) {
                schedulers = new Schedulers();
                if (njf.compareAndSet(null, schedulers)) {
                    break;
                }
                schedulers.dIM();
            } else {
                break;
            }
        }
        return schedulers;
    }

    private Schedulers() {
        rx.c.g dIB = f.dIw().dIB();
        g dIF = dIB.dIF();
        if (dIF != null) {
            this.npp = dIF;
        } else {
            this.npp = rx.c.g.dIC();
        }
        g dIG = dIB.dIG();
        if (dIG != null) {
            this.npq = dIG;
        } else {
            this.npq = rx.c.g.dID();
        }
        g dIH = dIB.dIH();
        if (dIH != null) {
            this.npr = dIH;
        } else {
            this.npr = rx.c.g.dIE();
        }
    }

    public static g immediate() {
        return e.nnu;
    }

    public static g trampoline() {
        return j.nnS;
    }

    public static g newThread() {
        return c.k(dIK().npr);
    }

    public static g computation() {
        return c.i(dIK().npp);
    }

    public static g io() {
        return c.j(dIK().npq);
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
            andSet.dIM();
        }
    }

    public static void start() {
        Schedulers dIK = dIK();
        dIK.dIL();
        synchronized (dIK) {
            d.nns.start();
        }
    }

    public static void shutdown() {
        Schedulers dIK = dIK();
        dIK.dIM();
        synchronized (dIK) {
            d.nns.shutdown();
        }
    }

    synchronized void dIL() {
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

    synchronized void dIM() {
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
