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
/* loaded from: classes4.dex */
public final class Schedulers {
    private static final AtomicReference<Schedulers> qzg = new AtomicReference<>();
    private final g qFm;
    private final g qFn;
    private final g qFo;

    private static Schedulers eNN() {
        Schedulers schedulers;
        while (true) {
            schedulers = qzg.get();
            if (schedulers == null) {
                schedulers = new Schedulers();
                if (qzg.compareAndSet(null, schedulers)) {
                    break;
                }
                schedulers.eNP();
            } else {
                break;
            }
        }
        return schedulers;
    }

    private Schedulers() {
        rx.c.g eNE = f.eNz().eNE();
        g eNI = eNE.eNI();
        if (eNI != null) {
            this.qFm = eNI;
        } else {
            this.qFm = rx.c.g.eNF();
        }
        g eNJ = eNE.eNJ();
        if (eNJ != null) {
            this.qFn = eNJ;
        } else {
            this.qFn = rx.c.g.eNG();
        }
        g eNK = eNE.eNK();
        if (eNK != null) {
            this.qFo = eNK;
        } else {
            this.qFo = rx.c.g.eNH();
        }
    }

    public static g immediate() {
        return e.qDu;
    }

    public static g trampoline() {
        return j.qDR;
    }

    public static g newThread() {
        return c.k(eNN().qFo);
    }

    public static g computation() {
        return c.i(eNN().qFm);
    }

    public static g io() {
        return c.j(eNN().qFn);
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static g from(Executor executor) {
        return new rx.internal.schedulers.c(executor);
    }

    public static void reset() {
        Schedulers andSet = qzg.getAndSet(null);
        if (andSet != null) {
            andSet.eNP();
        }
    }

    public static void start() {
        Schedulers eNN = eNN();
        eNN.eNO();
        synchronized (eNN) {
            d.qDs.start();
        }
    }

    public static void shutdown() {
        Schedulers eNN = eNN();
        eNN.eNP();
        synchronized (eNN) {
            d.qDs.shutdown();
        }
    }

    synchronized void eNO() {
        if (this.qFm instanceof h) {
            ((h) this.qFm).start();
        }
        if (this.qFn instanceof h) {
            ((h) this.qFn).start();
        }
        if (this.qFo instanceof h) {
            ((h) this.qFo).start();
        }
    }

    synchronized void eNP() {
        if (this.qFm instanceof h) {
            ((h) this.qFm).shutdown();
        }
        if (this.qFn instanceof h) {
            ((h) this.qFn).shutdown();
        }
        if (this.qFo instanceof h) {
            ((h) this.qFo).shutdown();
        }
    }
}
