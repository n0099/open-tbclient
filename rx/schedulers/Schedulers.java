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
    private static final AtomicReference<Schedulers> oba = new AtomicReference<>();
    private final g ohl;
    private final g ohm;
    private final g ohn;

    private static Schedulers dVy() {
        Schedulers schedulers;
        while (true) {
            schedulers = oba.get();
            if (schedulers == null) {
                schedulers = new Schedulers();
                if (oba.compareAndSet(null, schedulers)) {
                    break;
                }
                schedulers.dVA();
            } else {
                break;
            }
        }
        return schedulers;
    }

    private Schedulers() {
        rx.c.g dVp = f.dVk().dVp();
        g dVt = dVp.dVt();
        if (dVt != null) {
            this.ohl = dVt;
        } else {
            this.ohl = rx.c.g.dVq();
        }
        g dVu = dVp.dVu();
        if (dVu != null) {
            this.ohm = dVu;
        } else {
            this.ohm = rx.c.g.dVr();
        }
        g dVv = dVp.dVv();
        if (dVv != null) {
            this.ohn = dVv;
        } else {
            this.ohn = rx.c.g.dVs();
        }
    }

    public static g immediate() {
        return e.ofs;
    }

    public static g trampoline() {
        return j.ofQ;
    }

    public static g newThread() {
        return c.k(dVy().ohn);
    }

    public static g computation() {
        return c.i(dVy().ohl);
    }

    public static g io() {
        return c.j(dVy().ohm);
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static g from(Executor executor) {
        return new rx.internal.schedulers.c(executor);
    }

    public static void reset() {
        Schedulers andSet = oba.getAndSet(null);
        if (andSet != null) {
            andSet.dVA();
        }
    }

    public static void start() {
        Schedulers dVy = dVy();
        dVy.dVz();
        synchronized (dVy) {
            d.ofq.start();
        }
    }

    public static void shutdown() {
        Schedulers dVy = dVy();
        dVy.dVA();
        synchronized (dVy) {
            d.ofq.shutdown();
        }
    }

    synchronized void dVz() {
        if (this.ohl instanceof h) {
            ((h) this.ohl).start();
        }
        if (this.ohm instanceof h) {
            ((h) this.ohm).start();
        }
        if (this.ohn instanceof h) {
            ((h) this.ohn).start();
        }
    }

    synchronized void dVA() {
        if (this.ohl instanceof h) {
            ((h) this.ohl).shutdown();
        }
        if (this.ohm instanceof h) {
            ((h) this.ohm).shutdown();
        }
        if (this.ohn instanceof h) {
            ((h) this.ohn).shutdown();
        }
    }
}
