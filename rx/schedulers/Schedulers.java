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
/* loaded from: classes6.dex */
public final class Schedulers {
    private static final AtomicReference<Schedulers> nEf = new AtomicReference<>();
    private final g nKn;
    private final g nKo;
    private final g nKp;

    private static Schedulers dQE() {
        Schedulers schedulers;
        while (true) {
            schedulers = nEf.get();
            if (schedulers == null) {
                schedulers = new Schedulers();
                if (nEf.compareAndSet(null, schedulers)) {
                    break;
                }
                schedulers.dQG();
            } else {
                break;
            }
        }
        return schedulers;
    }

    private Schedulers() {
        rx.c.g dQv = f.dQq().dQv();
        g dQz = dQv.dQz();
        if (dQz != null) {
            this.nKn = dQz;
        } else {
            this.nKn = rx.c.g.dQw();
        }
        g dQA = dQv.dQA();
        if (dQA != null) {
            this.nKo = dQA;
        } else {
            this.nKo = rx.c.g.dQx();
        }
        g dQB = dQv.dQB();
        if (dQB != null) {
            this.nKp = dQB;
        } else {
            this.nKp = rx.c.g.dQy();
        }
    }

    public static g immediate() {
        return e.nIu;
    }

    public static g trampoline() {
        return j.nIS;
    }

    public static g newThread() {
        return c.k(dQE().nKp);
    }

    public static g computation() {
        return c.i(dQE().nKn);
    }

    public static g io() {
        return c.j(dQE().nKo);
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static g from(Executor executor) {
        return new rx.internal.schedulers.c(executor);
    }

    public static void reset() {
        Schedulers andSet = nEf.getAndSet(null);
        if (andSet != null) {
            andSet.dQG();
        }
    }

    public static void start() {
        Schedulers dQE = dQE();
        dQE.dQF();
        synchronized (dQE) {
            d.nIs.start();
        }
    }

    public static void shutdown() {
        Schedulers dQE = dQE();
        dQE.dQG();
        synchronized (dQE) {
            d.nIs.shutdown();
        }
    }

    synchronized void dQF() {
        if (this.nKn instanceof h) {
            ((h) this.nKn).start();
        }
        if (this.nKo instanceof h) {
            ((h) this.nKo).start();
        }
        if (this.nKp instanceof h) {
            ((h) this.nKp).start();
        }
    }

    synchronized void dQG() {
        if (this.nKn instanceof h) {
            ((h) this.nKn).shutdown();
        }
        if (this.nKo instanceof h) {
            ((h) this.nKo).shutdown();
        }
        if (this.nKp instanceof h) {
            ((h) this.nKp).shutdown();
        }
    }
}
