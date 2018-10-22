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
    private static final AtomicReference<Schedulers> iFf = new AtomicReference<>();
    private final g iFc;
    private final g iFd;
    private final g iFe;

    private static Schedulers cdF() {
        Schedulers schedulers;
        while (true) {
            schedulers = iFf.get();
            if (schedulers == null) {
                schedulers = new Schedulers();
                if (iFf.compareAndSet(null, schedulers)) {
                    break;
                }
                schedulers.cdH();
            } else {
                break;
            }
        }
        return schedulers;
    }

    private Schedulers() {
        rx.c.g cdw = f.cdr().cdw();
        g cdA = cdw.cdA();
        if (cdA != null) {
            this.iFc = cdA;
        } else {
            this.iFc = rx.c.g.cdx();
        }
        g cdB = cdw.cdB();
        if (cdB != null) {
            this.iFd = cdB;
        } else {
            this.iFd = rx.c.g.cdy();
        }
        g cdC = cdw.cdC();
        if (cdC != null) {
            this.iFe = cdC;
        } else {
            this.iFe = rx.c.g.cdz();
        }
    }

    public static g immediate() {
        return e.iCo;
    }

    public static g trampoline() {
        return j.iCO;
    }

    public static g newThread() {
        return c.f(cdF().iFe);
    }

    public static g computation() {
        return c.d(cdF().iFc);
    }

    public static g io() {
        return c.e(cdF().iFd);
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static g from(Executor executor) {
        return new rx.internal.schedulers.c(executor);
    }

    public static void reset() {
        Schedulers andSet = iFf.getAndSet(null);
        if (andSet != null) {
            andSet.cdH();
        }
    }

    public static void start() {
        Schedulers cdF = cdF();
        cdF.cdG();
        synchronized (cdF) {
            d.iCl.start();
        }
    }

    public static void shutdown() {
        Schedulers cdF = cdF();
        cdF.cdH();
        synchronized (cdF) {
            d.iCl.shutdown();
        }
    }

    synchronized void cdG() {
        if (this.iFc instanceof h) {
            ((h) this.iFc).start();
        }
        if (this.iFd instanceof h) {
            ((h) this.iFd).start();
        }
        if (this.iFe instanceof h) {
            ((h) this.iFe).start();
        }
    }

    synchronized void cdH() {
        if (this.iFc instanceof h) {
            ((h) this.iFc).shutdown();
        }
        if (this.iFd instanceof h) {
            ((h) this.iFd).shutdown();
        }
        if (this.iFe instanceof h) {
            ((h) this.iFe).shutdown();
        }
    }
}
