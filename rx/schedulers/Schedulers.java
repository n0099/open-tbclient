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
    private static final AtomicReference<Schedulers> kcm = new AtomicReference<>();
    private final g kcj;
    private final g kck;
    private final g kcl;

    private static Schedulers cFe() {
        Schedulers schedulers;
        while (true) {
            schedulers = kcm.get();
            if (schedulers == null) {
                schedulers = new Schedulers();
                if (kcm.compareAndSet(null, schedulers)) {
                    break;
                }
                schedulers.cFg();
            } else {
                break;
            }
        }
        return schedulers;
    }

    private Schedulers() {
        rx.c.g cEV = f.cEQ().cEV();
        g cEZ = cEV.cEZ();
        if (cEZ != null) {
            this.kcj = cEZ;
        } else {
            this.kcj = rx.c.g.cEW();
        }
        g cFa = cEV.cFa();
        if (cFa != null) {
            this.kck = cFa;
        } else {
            this.kck = rx.c.g.cEX();
        }
        g cFb = cEV.cFb();
        if (cFb != null) {
            this.kcl = cFb;
        } else {
            this.kcl = rx.c.g.cEY();
        }
    }

    public static g immediate() {
        return e.jZT;
    }

    public static g trampoline() {
        return j.kat;
    }

    public static g newThread() {
        return c.i(cFe().kcl);
    }

    public static g computation() {
        return c.g(cFe().kcj);
    }

    public static g io() {
        return c.h(cFe().kck);
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static g from(Executor executor) {
        return new rx.internal.schedulers.c(executor);
    }

    public static void reset() {
        Schedulers andSet = kcm.getAndSet(null);
        if (andSet != null) {
            andSet.cFg();
        }
    }

    public static void start() {
        Schedulers cFe = cFe();
        cFe.cFf();
        synchronized (cFe) {
            d.jZQ.start();
        }
    }

    public static void shutdown() {
        Schedulers cFe = cFe();
        cFe.cFg();
        synchronized (cFe) {
            d.jZQ.shutdown();
        }
    }

    synchronized void cFf() {
        if (this.kcj instanceof h) {
            ((h) this.kcj).start();
        }
        if (this.kck instanceof h) {
            ((h) this.kck).start();
        }
        if (this.kcl instanceof h) {
            ((h) this.kcl).start();
        }
    }

    synchronized void cFg() {
        if (this.kcj instanceof h) {
            ((h) this.kcj).shutdown();
        }
        if (this.kck instanceof h) {
            ((h) this.kck).shutdown();
        }
        if (this.kcl instanceof h) {
            ((h) this.kcl).shutdown();
        }
    }
}
