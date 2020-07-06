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
    private static final AtomicReference<Schedulers> obd = new AtomicReference<>();
    private final g oho;
    private final g ohp;
    private final g ohq;

    private static Schedulers dVC() {
        Schedulers schedulers;
        while (true) {
            schedulers = obd.get();
            if (schedulers == null) {
                schedulers = new Schedulers();
                if (obd.compareAndSet(null, schedulers)) {
                    break;
                }
                schedulers.dVE();
            } else {
                break;
            }
        }
        return schedulers;
    }

    private Schedulers() {
        rx.c.g dVt = f.dVo().dVt();
        g dVx = dVt.dVx();
        if (dVx != null) {
            this.oho = dVx;
        } else {
            this.oho = rx.c.g.dVu();
        }
        g dVy = dVt.dVy();
        if (dVy != null) {
            this.ohp = dVy;
        } else {
            this.ohp = rx.c.g.dVv();
        }
        g dVz = dVt.dVz();
        if (dVz != null) {
            this.ohq = dVz;
        } else {
            this.ohq = rx.c.g.dVw();
        }
    }

    public static g immediate() {
        return e.ofv;
    }

    public static g trampoline() {
        return j.ofT;
    }

    public static g newThread() {
        return c.k(dVC().ohq);
    }

    public static g computation() {
        return c.i(dVC().oho);
    }

    public static g io() {
        return c.j(dVC().ohp);
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static g from(Executor executor) {
        return new rx.internal.schedulers.c(executor);
    }

    public static void reset() {
        Schedulers andSet = obd.getAndSet(null);
        if (andSet != null) {
            andSet.dVE();
        }
    }

    public static void start() {
        Schedulers dVC = dVC();
        dVC.dVD();
        synchronized (dVC) {
            d.oft.start();
        }
    }

    public static void shutdown() {
        Schedulers dVC = dVC();
        dVC.dVE();
        synchronized (dVC) {
            d.oft.shutdown();
        }
    }

    synchronized void dVD() {
        if (this.oho instanceof h) {
            ((h) this.oho).start();
        }
        if (this.ohp instanceof h) {
            ((h) this.ohp).start();
        }
        if (this.ohq instanceof h) {
            ((h) this.ohq).start();
        }
    }

    synchronized void dVE() {
        if (this.oho instanceof h) {
            ((h) this.oho).shutdown();
        }
        if (this.ohp instanceof h) {
            ((h) this.ohp).shutdown();
        }
        if (this.ohq instanceof h) {
            ((h) this.ohq).shutdown();
        }
    }
}
