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
    private static final AtomicReference<Schedulers> ndD = new AtomicReference<>();
    private final g njM;
    private final g njN;
    private final g njO;

    private static Schedulers dHu() {
        Schedulers schedulers;
        while (true) {
            schedulers = ndD.get();
            if (schedulers == null) {
                schedulers = new Schedulers();
                if (ndD.compareAndSet(null, schedulers)) {
                    break;
                }
                schedulers.dHw();
            } else {
                break;
            }
        }
        return schedulers;
    }

    private Schedulers() {
        rx.c.g dHl = f.dHg().dHl();
        g dHp = dHl.dHp();
        if (dHp != null) {
            this.njM = dHp;
        } else {
            this.njM = rx.c.g.dHm();
        }
        g dHq = dHl.dHq();
        if (dHq != null) {
            this.njN = dHq;
        } else {
            this.njN = rx.c.g.dHn();
        }
        g dHr = dHl.dHr();
        if (dHr != null) {
            this.njO = dHr;
        } else {
            this.njO = rx.c.g.dHo();
        }
    }

    public static g immediate() {
        return e.nhS;
    }

    public static g trampoline() {
        return j.nir;
    }

    public static g newThread() {
        return c.k(dHu().njO);
    }

    public static g computation() {
        return c.i(dHu().njM);
    }

    public static g io() {
        return c.j(dHu().njN);
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static g from(Executor executor) {
        return new rx.internal.schedulers.c(executor);
    }

    public static void reset() {
        Schedulers andSet = ndD.getAndSet(null);
        if (andSet != null) {
            andSet.dHw();
        }
    }

    public static void start() {
        Schedulers dHu = dHu();
        dHu.dHv();
        synchronized (dHu) {
            d.nhQ.start();
        }
    }

    public static void shutdown() {
        Schedulers dHu = dHu();
        dHu.dHw();
        synchronized (dHu) {
            d.nhQ.shutdown();
        }
    }

    synchronized void dHv() {
        if (this.njM instanceof h) {
            ((h) this.njM).start();
        }
        if (this.njN instanceof h) {
            ((h) this.njN).start();
        }
        if (this.njO instanceof h) {
            ((h) this.njO).start();
        }
    }

    synchronized void dHw() {
        if (this.njM instanceof h) {
            ((h) this.njM).shutdown();
        }
        if (this.njN instanceof h) {
            ((h) this.njN).shutdown();
        }
        if (this.njO instanceof h) {
            ((h) this.njO).shutdown();
        }
    }
}
