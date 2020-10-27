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
/* loaded from: classes16.dex */
public final class Schedulers {
    private static final AtomicReference<Schedulers> pUr = new AtomicReference<>();
    private final g qaA;
    private final g qaB;
    private final g qaz;

    private static Schedulers eCT() {
        Schedulers schedulers;
        while (true) {
            schedulers = pUr.get();
            if (schedulers == null) {
                schedulers = new Schedulers();
                if (pUr.compareAndSet(null, schedulers)) {
                    break;
                }
                schedulers.eCV();
            } else {
                break;
            }
        }
        return schedulers;
    }

    private Schedulers() {
        rx.c.g eCK = f.eCF().eCK();
        g eCO = eCK.eCO();
        if (eCO != null) {
            this.qaz = eCO;
        } else {
            this.qaz = rx.c.g.eCL();
        }
        g eCP = eCK.eCP();
        if (eCP != null) {
            this.qaA = eCP;
        } else {
            this.qaA = rx.c.g.eCM();
        }
        g eCQ = eCK.eCQ();
        if (eCQ != null) {
            this.qaB = eCQ;
        } else {
            this.qaB = rx.c.g.eCN();
        }
    }

    public static g immediate() {
        return e.pYG;
    }

    public static g trampoline() {
        return j.pZe;
    }

    public static g newThread() {
        return c.k(eCT().qaB);
    }

    public static g computation() {
        return c.i(eCT().qaz);
    }

    public static g io() {
        return c.j(eCT().qaA);
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static g from(Executor executor) {
        return new rx.internal.schedulers.c(executor);
    }

    public static void reset() {
        Schedulers andSet = pUr.getAndSet(null);
        if (andSet != null) {
            andSet.eCV();
        }
    }

    public static void start() {
        Schedulers eCT = eCT();
        eCT.eCU();
        synchronized (eCT) {
            d.pYE.start();
        }
    }

    public static void shutdown() {
        Schedulers eCT = eCT();
        eCT.eCV();
        synchronized (eCT) {
            d.pYE.shutdown();
        }
    }

    synchronized void eCU() {
        if (this.qaz instanceof h) {
            ((h) this.qaz).start();
        }
        if (this.qaA instanceof h) {
            ((h) this.qaA).start();
        }
        if (this.qaB instanceof h) {
            ((h) this.qaB).start();
        }
    }

    synchronized void eCV() {
        if (this.qaz instanceof h) {
            ((h) this.qaz).shutdown();
        }
        if (this.qaA instanceof h) {
            ((h) this.qaA).shutdown();
        }
        if (this.qaB instanceof h) {
            ((h) this.qaB).shutdown();
        }
    }
}
