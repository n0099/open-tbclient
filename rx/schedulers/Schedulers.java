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
    private static final AtomicReference<Schedulers> kBI = new AtomicReference<>();
    private final g kBF;
    private final g kBG;
    private final g kBH;

    private static Schedulers cQD() {
        Schedulers schedulers;
        while (true) {
            schedulers = kBI.get();
            if (schedulers == null) {
                schedulers = new Schedulers();
                if (kBI.compareAndSet(null, schedulers)) {
                    break;
                }
                schedulers.cQF();
            } else {
                break;
            }
        }
        return schedulers;
    }

    private Schedulers() {
        rx.c.g cQu = f.cQp().cQu();
        g cQy = cQu.cQy();
        if (cQy != null) {
            this.kBF = cQy;
        } else {
            this.kBF = rx.c.g.cQv();
        }
        g cQz = cQu.cQz();
        if (cQz != null) {
            this.kBG = cQz;
        } else {
            this.kBG = rx.c.g.cQw();
        }
        g cQA = cQu.cQA();
        if (cQA != null) {
            this.kBH = cQA;
        } else {
            this.kBH = rx.c.g.cQx();
        }
    }

    public static g immediate() {
        return e.kzp;
    }

    public static g trampoline() {
        return j.kzP;
    }

    public static g newThread() {
        return c.i(cQD().kBH);
    }

    public static g computation() {
        return c.g(cQD().kBF);
    }

    public static g io() {
        return c.h(cQD().kBG);
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static g from(Executor executor) {
        return new rx.internal.schedulers.c(executor);
    }

    public static void reset() {
        Schedulers andSet = kBI.getAndSet(null);
        if (andSet != null) {
            andSet.cQF();
        }
    }

    public static void start() {
        Schedulers cQD = cQD();
        cQD.cQE();
        synchronized (cQD) {
            d.kzm.start();
        }
    }

    public static void shutdown() {
        Schedulers cQD = cQD();
        cQD.cQF();
        synchronized (cQD) {
            d.kzm.shutdown();
        }
    }

    synchronized void cQE() {
        if (this.kBF instanceof h) {
            ((h) this.kBF).start();
        }
        if (this.kBG instanceof h) {
            ((h) this.kBG).start();
        }
        if (this.kBH instanceof h) {
            ((h) this.kBH).start();
        }
    }

    synchronized void cQF() {
        if (this.kBF instanceof h) {
            ((h) this.kBF).shutdown();
        }
        if (this.kBG instanceof h) {
            ((h) this.kBG).shutdown();
        }
        if (this.kBH instanceof h) {
            ((h) this.kBH).shutdown();
        }
    }
}
