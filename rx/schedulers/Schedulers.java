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
    private static final AtomicReference<Schedulers> iFe = new AtomicReference<>();
    private final g iFb;
    private final g iFc;
    private final g iFd;

    private static Schedulers cdF() {
        Schedulers schedulers;
        while (true) {
            schedulers = iFe.get();
            if (schedulers == null) {
                schedulers = new Schedulers();
                if (iFe.compareAndSet(null, schedulers)) {
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
            this.iFb = cdA;
        } else {
            this.iFb = rx.c.g.cdx();
        }
        g cdB = cdw.cdB();
        if (cdB != null) {
            this.iFc = cdB;
        } else {
            this.iFc = rx.c.g.cdy();
        }
        g cdC = cdw.cdC();
        if (cdC != null) {
            this.iFd = cdC;
        } else {
            this.iFd = rx.c.g.cdz();
        }
    }

    public static g immediate() {
        return e.iCn;
    }

    public static g trampoline() {
        return j.iCN;
    }

    public static g newThread() {
        return c.f(cdF().iFd);
    }

    public static g computation() {
        return c.d(cdF().iFb);
    }

    public static g io() {
        return c.e(cdF().iFc);
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static g from(Executor executor) {
        return new rx.internal.schedulers.c(executor);
    }

    public static void reset() {
        Schedulers andSet = iFe.getAndSet(null);
        if (andSet != null) {
            andSet.cdH();
        }
    }

    public static void start() {
        Schedulers cdF = cdF();
        cdF.cdG();
        synchronized (cdF) {
            d.iCk.start();
        }
    }

    public static void shutdown() {
        Schedulers cdF = cdF();
        cdF.cdH();
        synchronized (cdF) {
            d.iCk.shutdown();
        }
    }

    synchronized void cdG() {
        if (this.iFb instanceof h) {
            ((h) this.iFb).start();
        }
        if (this.iFc instanceof h) {
            ((h) this.iFc).start();
        }
        if (this.iFd instanceof h) {
            ((h) this.iFd).start();
        }
    }

    synchronized void cdH() {
        if (this.iFb instanceof h) {
            ((h) this.iFb).shutdown();
        }
        if (this.iFc instanceof h) {
            ((h) this.iFc).shutdown();
        }
        if (this.iFd instanceof h) {
            ((h) this.iFd).shutdown();
        }
    }
}
