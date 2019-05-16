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
    private static final AtomicReference<Schedulers> kuf = new AtomicReference<>();
    private final g kuc;
    private final g kud;
    private final g kue;

    private static Schedulers cMM() {
        Schedulers schedulers;
        while (true) {
            schedulers = kuf.get();
            if (schedulers == null) {
                schedulers = new Schedulers();
                if (kuf.compareAndSet(null, schedulers)) {
                    break;
                }
                schedulers.cMO();
            } else {
                break;
            }
        }
        return schedulers;
    }

    private Schedulers() {
        rx.c.g cMD = f.cMy().cMD();
        g cMH = cMD.cMH();
        if (cMH != null) {
            this.kuc = cMH;
        } else {
            this.kuc = rx.c.g.cME();
        }
        g cMI = cMD.cMI();
        if (cMI != null) {
            this.kud = cMI;
        } else {
            this.kud = rx.c.g.cMF();
        }
        g cMJ = cMD.cMJ();
        if (cMJ != null) {
            this.kue = cMJ;
        } else {
            this.kue = rx.c.g.cMG();
        }
    }

    public static g immediate() {
        return e.krM;
    }

    public static g trampoline() {
        return j.ksm;
    }

    public static g newThread() {
        return c.i(cMM().kue);
    }

    public static g computation() {
        return c.g(cMM().kuc);
    }

    public static g io() {
        return c.h(cMM().kud);
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static g from(Executor executor) {
        return new rx.internal.schedulers.c(executor);
    }

    public static void reset() {
        Schedulers andSet = kuf.getAndSet(null);
        if (andSet != null) {
            andSet.cMO();
        }
    }

    public static void start() {
        Schedulers cMM = cMM();
        cMM.cMN();
        synchronized (cMM) {
            d.krJ.start();
        }
    }

    public static void shutdown() {
        Schedulers cMM = cMM();
        cMM.cMO();
        synchronized (cMM) {
            d.krJ.shutdown();
        }
    }

    synchronized void cMN() {
        if (this.kuc instanceof h) {
            ((h) this.kuc).start();
        }
        if (this.kud instanceof h) {
            ((h) this.kud).start();
        }
        if (this.kue instanceof h) {
            ((h) this.kue).start();
        }
    }

    synchronized void cMO() {
        if (this.kuc instanceof h) {
            ((h) this.kuc).shutdown();
        }
        if (this.kud instanceof h) {
            ((h) this.kud).shutdown();
        }
        if (this.kue instanceof h) {
            ((h) this.kue).shutdown();
        }
    }
}
