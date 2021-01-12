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
/* loaded from: classes14.dex */
public final class Schedulers {
    private static final AtomicReference<Schedulers> qoa = new AtomicReference<>();
    private final g qug;
    private final g quh;
    private final g qui;

    private static Schedulers eLH() {
        Schedulers schedulers;
        while (true) {
            schedulers = qoa.get();
            if (schedulers == null) {
                schedulers = new Schedulers();
                if (qoa.compareAndSet(null, schedulers)) {
                    break;
                }
                schedulers.eLJ();
            } else {
                break;
            }
        }
        return schedulers;
    }

    private Schedulers() {
        rx.c.g eLy = f.eLt().eLy();
        g eLC = eLy.eLC();
        if (eLC != null) {
            this.qug = eLC;
        } else {
            this.qug = rx.c.g.eLz();
        }
        g eLD = eLy.eLD();
        if (eLD != null) {
            this.quh = eLD;
        } else {
            this.quh = rx.c.g.eLA();
        }
        g eLE = eLy.eLE();
        if (eLE != null) {
            this.qui = eLE;
        } else {
            this.qui = rx.c.g.eLB();
        }
    }

    public static g immediate() {
        return e.qso;
    }

    public static g trampoline() {
        return j.qsL;
    }

    public static g newThread() {
        return c.k(eLH().qui);
    }

    public static g computation() {
        return c.i(eLH().qug);
    }

    public static g io() {
        return c.j(eLH().quh);
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static g from(Executor executor) {
        return new rx.internal.schedulers.c(executor);
    }

    public static void reset() {
        Schedulers andSet = qoa.getAndSet(null);
        if (andSet != null) {
            andSet.eLJ();
        }
    }

    public static void start() {
        Schedulers eLH = eLH();
        eLH.eLI();
        synchronized (eLH) {
            d.qsm.start();
        }
    }

    public static void shutdown() {
        Schedulers eLH = eLH();
        eLH.eLJ();
        synchronized (eLH) {
            d.qsm.shutdown();
        }
    }

    synchronized void eLI() {
        if (this.qug instanceof h) {
            ((h) this.qug).start();
        }
        if (this.quh instanceof h) {
            ((h) this.quh).start();
        }
        if (this.qui instanceof h) {
            ((h) this.qui).start();
        }
    }

    synchronized void eLJ() {
        if (this.qug instanceof h) {
            ((h) this.qug).shutdown();
        }
        if (this.quh instanceof h) {
            ((h) this.quh).shutdown();
        }
        if (this.qui instanceof h) {
            ((h) this.qui).shutdown();
        }
    }
}
