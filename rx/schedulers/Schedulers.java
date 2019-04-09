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
    private static final AtomicReference<Schedulers> kbQ = new AtomicReference<>();
    private final g kbN;
    private final g kbO;
    private final g kbP;

    private static Schedulers cFg() {
        Schedulers schedulers;
        while (true) {
            schedulers = kbQ.get();
            if (schedulers == null) {
                schedulers = new Schedulers();
                if (kbQ.compareAndSet(null, schedulers)) {
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
            this.kbN = cFb;
        } else {
            this.kbN = rx.c.g.cEY();
        }
        g cFc = cEX.cFc();
        if (cFc != null) {
            this.kbO = cFc;
        } else {
            this.kbO = rx.c.g.cEZ();
        }
        g cFd = cEX.cFd();
        if (cFd != null) {
            this.kbP = cFd;
        } else {
            this.kbP = rx.c.g.cFa();
        }
    }

    public static g immediate() {
        return e.jZx;
    }

    public static g trampoline() {
        return j.jZX;
    }

    public static g newThread() {
        return c.i(cFg().kbP);
    }

    public static g computation() {
        return c.g(cFg().kbN);
    }

    public static g io() {
        return c.h(cFg().kbO);
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static g from(Executor executor) {
        return new rx.internal.schedulers.c(executor);
    }

    public static void reset() {
        Schedulers andSet = kbQ.getAndSet(null);
        if (andSet != null) {
            andSet.cFi();
        }
    }

    public static void start() {
        Schedulers cFg = cFg();
        cFg.cFh();
        synchronized (cFg) {
            d.jZu.start();
        }
    }

    public static void shutdown() {
        Schedulers cFg = cFg();
        cFg.cFi();
        synchronized (cFg) {
            d.jZu.shutdown();
        }
    }

    synchronized void cFh() {
        if (this.kbN instanceof h) {
            ((h) this.kbN).start();
        }
        if (this.kbO instanceof h) {
            ((h) this.kbO).start();
        }
        if (this.kbP instanceof h) {
            ((h) this.kbP).start();
        }
    }

    synchronized void cFi() {
        if (this.kbN instanceof h) {
            ((h) this.kbN).shutdown();
        }
        if (this.kbO instanceof h) {
            ((h) this.kbO).shutdown();
        }
        if (this.kbP instanceof h) {
            ((h) this.kbP).shutdown();
        }
    }
}
