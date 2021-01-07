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
/* loaded from: classes15.dex */
public final class Schedulers {
    private static final AtomicReference<Schedulers> qsC = new AtomicReference<>();
    private final g qyI;
    private final g qyJ;
    private final g qyK;

    private static Schedulers ePx() {
        Schedulers schedulers;
        while (true) {
            schedulers = qsC.get();
            if (schedulers == null) {
                schedulers = new Schedulers();
                if (qsC.compareAndSet(null, schedulers)) {
                    break;
                }
                schedulers.ePz();
            } else {
                break;
            }
        }
        return schedulers;
    }

    private Schedulers() {
        rx.c.g ePo = f.ePj().ePo();
        g ePs = ePo.ePs();
        if (ePs != null) {
            this.qyI = ePs;
        } else {
            this.qyI = rx.c.g.ePp();
        }
        g ePt = ePo.ePt();
        if (ePt != null) {
            this.qyJ = ePt;
        } else {
            this.qyJ = rx.c.g.ePq();
        }
        g ePu = ePo.ePu();
        if (ePu != null) {
            this.qyK = ePu;
        } else {
            this.qyK = rx.c.g.ePr();
        }
    }

    public static g immediate() {
        return e.qwQ;
    }

    public static g trampoline() {
        return j.qxn;
    }

    public static g newThread() {
        return c.k(ePx().qyK);
    }

    public static g computation() {
        return c.i(ePx().qyI);
    }

    public static g io() {
        return c.j(ePx().qyJ);
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static g from(Executor executor) {
        return new rx.internal.schedulers.c(executor);
    }

    public static void reset() {
        Schedulers andSet = qsC.getAndSet(null);
        if (andSet != null) {
            andSet.ePz();
        }
    }

    public static void start() {
        Schedulers ePx = ePx();
        ePx.ePy();
        synchronized (ePx) {
            d.qwO.start();
        }
    }

    public static void shutdown() {
        Schedulers ePx = ePx();
        ePx.ePz();
        synchronized (ePx) {
            d.qwO.shutdown();
        }
    }

    synchronized void ePy() {
        if (this.qyI instanceof h) {
            ((h) this.qyI).start();
        }
        if (this.qyJ instanceof h) {
            ((h) this.qyJ).start();
        }
        if (this.qyK instanceof h) {
            ((h) this.qyK).start();
        }
    }

    synchronized void ePz() {
        if (this.qyI instanceof h) {
            ((h) this.qyI).shutdown();
        }
        if (this.qyJ instanceof h) {
            ((h) this.qyJ).shutdown();
        }
        if (this.qyK instanceof h) {
            ((h) this.qyK).shutdown();
        }
    }
}
