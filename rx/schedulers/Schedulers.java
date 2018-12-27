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
    private static final AtomicReference<Schedulers> iRg = new AtomicReference<>();
    private final g iRd;
    private final g iRe;
    private final g iRf;

    private static Schedulers cfV() {
        Schedulers schedulers;
        while (true) {
            schedulers = iRg.get();
            if (schedulers == null) {
                schedulers = new Schedulers();
                if (iRg.compareAndSet(null, schedulers)) {
                    break;
                }
                schedulers.cfX();
            } else {
                break;
            }
        }
        return schedulers;
    }

    private Schedulers() {
        rx.c.g cfM = f.cfH().cfM();
        g cfQ = cfM.cfQ();
        if (cfQ != null) {
            this.iRd = cfQ;
        } else {
            this.iRd = rx.c.g.cfN();
        }
        g cfR = cfM.cfR();
        if (cfR != null) {
            this.iRe = cfR;
        } else {
            this.iRe = rx.c.g.cfO();
        }
        g cfS = cfM.cfS();
        if (cfS != null) {
            this.iRf = cfS;
        } else {
            this.iRf = rx.c.g.cfP();
        }
    }

    public static g immediate() {
        return e.iOp;
    }

    public static g trampoline() {
        return j.iOP;
    }

    public static g newThread() {
        return c.f(cfV().iRf);
    }

    public static g computation() {
        return c.d(cfV().iRd);
    }

    public static g io() {
        return c.e(cfV().iRe);
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static g from(Executor executor) {
        return new rx.internal.schedulers.c(executor);
    }

    public static void reset() {
        Schedulers andSet = iRg.getAndSet(null);
        if (andSet != null) {
            andSet.cfX();
        }
    }

    public static void start() {
        Schedulers cfV = cfV();
        cfV.cfW();
        synchronized (cfV) {
            d.iOm.start();
        }
    }

    public static void shutdown() {
        Schedulers cfV = cfV();
        cfV.cfX();
        synchronized (cfV) {
            d.iOm.shutdown();
        }
    }

    synchronized void cfW() {
        if (this.iRd instanceof h) {
            ((h) this.iRd).start();
        }
        if (this.iRe instanceof h) {
            ((h) this.iRe).start();
        }
        if (this.iRf instanceof h) {
            ((h) this.iRf).start();
        }
    }

    synchronized void cfX() {
        if (this.iRd instanceof h) {
            ((h) this.iRd).shutdown();
        }
        if (this.iRe instanceof h) {
            ((h) this.iRe).shutdown();
        }
        if (this.iRf instanceof h) {
            ((h) this.iRf).shutdown();
        }
    }
}
