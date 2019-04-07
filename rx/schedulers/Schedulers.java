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
    private static final AtomicReference<Schedulers> kbP = new AtomicReference<>();
    private final g kbM;
    private final g kbN;
    private final g kbO;

    private static Schedulers cFg() {
        Schedulers schedulers;
        while (true) {
            schedulers = kbP.get();
            if (schedulers == null) {
                schedulers = new Schedulers();
                if (kbP.compareAndSet(null, schedulers)) {
                    break;
                }
                schedulers.cFi();
            } else {
                break;
            }
        }
        return schedulers;
    }

    private Schedulers() {
        rx.c.g cEX = f.cES().cEX();
        g cFb = cEX.cFb();
        if (cFb != null) {
            this.kbM = cFb;
        } else {
            this.kbM = rx.c.g.cEY();
        }
        g cFc = cEX.cFc();
        if (cFc != null) {
            this.kbN = cFc;
        } else {
            this.kbN = rx.c.g.cEZ();
        }
        g cFd = cEX.cFd();
        if (cFd != null) {
            this.kbO = cFd;
        } else {
            this.kbO = rx.c.g.cFa();
        }
    }

    public static g immediate() {
        return e.jZw;
    }

    public static g trampoline() {
        return j.jZW;
    }

    public static g newThread() {
        return c.i(cFg().kbO);
    }

    public static g computation() {
        return c.g(cFg().kbM);
    }

    public static g io() {
        return c.h(cFg().kbN);
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static g from(Executor executor) {
        return new rx.internal.schedulers.c(executor);
    }

    public static void reset() {
        Schedulers andSet = kbP.getAndSet(null);
        if (andSet != null) {
            andSet.cFi();
        }
    }

    public static void start() {
        Schedulers cFg = cFg();
        cFg.cFh();
        synchronized (cFg) {
            d.jZt.start();
        }
    }

    public static void shutdown() {
        Schedulers cFg = cFg();
        cFg.cFi();
        synchronized (cFg) {
            d.jZt.shutdown();
        }
    }

    synchronized void cFh() {
        if (this.kbM instanceof h) {
            ((h) this.kbM).start();
        }
        if (this.kbN instanceof h) {
            ((h) this.kbN).start();
        }
        if (this.kbO instanceof h) {
            ((h) this.kbO).start();
        }
    }

    synchronized void cFi() {
        if (this.kbM instanceof h) {
            ((h) this.kbM).shutdown();
        }
        if (this.kbN instanceof h) {
            ((h) this.kbN).shutdown();
        }
        if (this.kbO instanceof h) {
            ((h) this.kbO).shutdown();
        }
    }
}
