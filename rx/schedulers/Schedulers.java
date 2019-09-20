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
    private static final AtomicReference<Schedulers> kFg = new AtomicReference<>();
    private final g kFd;
    private final g kFe;
    private final g kFf;

    private static Schedulers cRK() {
        Schedulers schedulers;
        while (true) {
            schedulers = kFg.get();
            if (schedulers == null) {
                schedulers = new Schedulers();
                if (kFg.compareAndSet(null, schedulers)) {
                    break;
                }
                schedulers.cRM();
            } else {
                break;
            }
        }
        return schedulers;
    }

    private Schedulers() {
        rx.c.g cRB = f.cRw().cRB();
        g cRF = cRB.cRF();
        if (cRF != null) {
            this.kFd = cRF;
        } else {
            this.kFd = rx.c.g.cRC();
        }
        g cRG = cRB.cRG();
        if (cRG != null) {
            this.kFe = cRG;
        } else {
            this.kFe = rx.c.g.cRD();
        }
        g cRH = cRB.cRH();
        if (cRH != null) {
            this.kFf = cRH;
        } else {
            this.kFf = rx.c.g.cRE();
        }
    }

    public static g immediate() {
        return e.kCN;
    }

    public static g trampoline() {
        return j.kDn;
    }

    public static g newThread() {
        return c.i(cRK().kFf);
    }

    public static g computation() {
        return c.g(cRK().kFd);
    }

    public static g io() {
        return c.h(cRK().kFe);
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static g from(Executor executor) {
        return new rx.internal.schedulers.c(executor);
    }

    public static void reset() {
        Schedulers andSet = kFg.getAndSet(null);
        if (andSet != null) {
            andSet.cRM();
        }
    }

    public static void start() {
        Schedulers cRK = cRK();
        cRK.cRL();
        synchronized (cRK) {
            d.kCK.start();
        }
    }

    public static void shutdown() {
        Schedulers cRK = cRK();
        cRK.cRM();
        synchronized (cRK) {
            d.kCK.shutdown();
        }
    }

    synchronized void cRL() {
        if (this.kFd instanceof h) {
            ((h) this.kFd).start();
        }
        if (this.kFe instanceof h) {
            ((h) this.kFe).start();
        }
        if (this.kFf instanceof h) {
            ((h) this.kFf).start();
        }
    }

    synchronized void cRM() {
        if (this.kFd instanceof h) {
            ((h) this.kFd).shutdown();
        }
        if (this.kFe instanceof h) {
            ((h) this.kFe).shutdown();
        }
        if (this.kFf instanceof h) {
            ((h) this.kFf).shutdown();
        }
    }
}
