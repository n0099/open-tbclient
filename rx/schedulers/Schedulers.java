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
    private static final AtomicReference<Schedulers> qob = new AtomicReference<>();
    private final g quh;
    private final g qui;
    private final g quj;

    private static Schedulers eLH() {
        Schedulers schedulers;
        while (true) {
            schedulers = qob.get();
            if (schedulers == null) {
                schedulers = new Schedulers();
                if (qob.compareAndSet(null, schedulers)) {
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
            this.quh = eLC;
        } else {
            this.quh = rx.c.g.eLz();
        }
        g eLD = eLy.eLD();
        if (eLD != null) {
            this.qui = eLD;
        } else {
            this.qui = rx.c.g.eLA();
        }
        g eLE = eLy.eLE();
        if (eLE != null) {
            this.quj = eLE;
        } else {
            this.quj = rx.c.g.eLB();
        }
    }

    public static g immediate() {
        return e.qsp;
    }

    public static g trampoline() {
        return j.qsM;
    }

    public static g newThread() {
        return c.k(eLH().quj);
    }

    public static g computation() {
        return c.i(eLH().quh);
    }

    public static g io() {
        return c.j(eLH().qui);
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static g from(Executor executor) {
        return new rx.internal.schedulers.c(executor);
    }

    public static void reset() {
        Schedulers andSet = qob.getAndSet(null);
        if (andSet != null) {
            andSet.eLJ();
        }
    }

    public static void start() {
        Schedulers eLH = eLH();
        eLH.eLI();
        synchronized (eLH) {
            d.qsn.start();
        }
    }

    public static void shutdown() {
        Schedulers eLH = eLH();
        eLH.eLJ();
        synchronized (eLH) {
            d.qsn.shutdown();
        }
    }

    synchronized void eLI() {
        if (this.quh instanceof h) {
            ((h) this.quh).start();
        }
        if (this.qui instanceof h) {
            ((h) this.qui).start();
        }
        if (this.quj instanceof h) {
            ((h) this.quj).start();
        }
    }

    synchronized void eLJ() {
        if (this.quh instanceof h) {
            ((h) this.quh).shutdown();
        }
        if (this.qui instanceof h) {
            ((h) this.qui).shutdown();
        }
        if (this.quj instanceof h) {
            ((h) this.quj).shutdown();
        }
    }
}
