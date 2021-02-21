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
/* loaded from: classes5.dex */
public final class Schedulers {
    private static final AtomicReference<Schedulers> qyE = new AtomicReference<>();
    private final g qEK;
    private final g qEL;
    private final g qEM;

    private static Schedulers eOf() {
        Schedulers schedulers;
        while (true) {
            schedulers = qyE.get();
            if (schedulers == null) {
                schedulers = new Schedulers();
                if (qyE.compareAndSet(null, schedulers)) {
                    break;
                }
                schedulers.eOh();
            } else {
                break;
            }
        }
        return schedulers;
    }

    private Schedulers() {
        rx.c.g eNW = f.eNR().eNW();
        g eOa = eNW.eOa();
        if (eOa != null) {
            this.qEK = eOa;
        } else {
            this.qEK = rx.c.g.eNX();
        }
        g eOb = eNW.eOb();
        if (eOb != null) {
            this.qEL = eOb;
        } else {
            this.qEL = rx.c.g.eNY();
        }
        g eOc = eNW.eOc();
        if (eOc != null) {
            this.qEM = eOc;
        } else {
            this.qEM = rx.c.g.eNZ();
        }
    }

    public static g immediate() {
        return e.qCS;
    }

    public static g trampoline() {
        return j.qDp;
    }

    public static g newThread() {
        return c.k(eOf().qEM);
    }

    public static g computation() {
        return c.i(eOf().qEK);
    }

    public static g io() {
        return c.j(eOf().qEL);
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static g from(Executor executor) {
        return new rx.internal.schedulers.c(executor);
    }

    public static void reset() {
        Schedulers andSet = qyE.getAndSet(null);
        if (andSet != null) {
            andSet.eOh();
        }
    }

    public static void start() {
        Schedulers eOf = eOf();
        eOf.eOg();
        synchronized (eOf) {
            d.qCQ.start();
        }
    }

    public static void shutdown() {
        Schedulers eOf = eOf();
        eOf.eOh();
        synchronized (eOf) {
            d.qCQ.shutdown();
        }
    }

    synchronized void eOg() {
        if (this.qEK instanceof h) {
            ((h) this.qEK).start();
        }
        if (this.qEL instanceof h) {
            ((h) this.qEL).start();
        }
        if (this.qEM instanceof h) {
            ((h) this.qEM).start();
        }
    }

    synchronized void eOh() {
        if (this.qEK instanceof h) {
            ((h) this.qEK).shutdown();
        }
        if (this.qEL instanceof h) {
            ((h) this.qEL).shutdown();
        }
        if (this.qEM instanceof h) {
            ((h) this.qEM).shutdown();
        }
    }
}
