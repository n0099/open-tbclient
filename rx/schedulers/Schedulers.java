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
    private static final AtomicReference<Schedulers> kcx = new AtomicReference<>();
    private final g kcu;
    private final g kcv;
    private final g kcw;

    private static Schedulers cFr() {
        Schedulers schedulers;
        while (true) {
            schedulers = kcx.get();
            if (schedulers == null) {
                schedulers = new Schedulers();
                if (kcx.compareAndSet(null, schedulers)) {
                    break;
                }
                schedulers.cFt();
            } else {
                break;
            }
        }
        return schedulers;
    }

    private Schedulers() {
        rx.c.g cFi = f.cFd().cFi();
        g cFm = cFi.cFm();
        if (cFm != null) {
            this.kcu = cFm;
        } else {
            this.kcu = rx.c.g.cFj();
        }
        g cFn = cFi.cFn();
        if (cFn != null) {
            this.kcv = cFn;
        } else {
            this.kcv = rx.c.g.cFk();
        }
        g cFo = cFi.cFo();
        if (cFo != null) {
            this.kcw = cFo;
        } else {
            this.kcw = rx.c.g.cFl();
        }
    }

    public static g immediate() {
        return e.kae;
    }

    public static g trampoline() {
        return j.kaE;
    }

    public static g newThread() {
        return c.i(cFr().kcw);
    }

    public static g computation() {
        return c.g(cFr().kcu);
    }

    public static g io() {
        return c.h(cFr().kcv);
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static g from(Executor executor) {
        return new rx.internal.schedulers.c(executor);
    }

    public static void reset() {
        Schedulers andSet = kcx.getAndSet(null);
        if (andSet != null) {
            andSet.cFt();
        }
    }

    public static void start() {
        Schedulers cFr = cFr();
        cFr.cFs();
        synchronized (cFr) {
            d.kab.start();
        }
    }

    public static void shutdown() {
        Schedulers cFr = cFr();
        cFr.cFt();
        synchronized (cFr) {
            d.kab.shutdown();
        }
    }

    synchronized void cFs() {
        if (this.kcu instanceof h) {
            ((h) this.kcu).start();
        }
        if (this.kcv instanceof h) {
            ((h) this.kcv).start();
        }
        if (this.kcw instanceof h) {
            ((h) this.kcw).start();
        }
    }

    synchronized void cFt() {
        if (this.kcu instanceof h) {
            ((h) this.kcu).shutdown();
        }
        if (this.kcv instanceof h) {
            ((h) this.kcv).shutdown();
        }
        if (this.kcw instanceof h) {
            ((h) this.kcw).shutdown();
        }
    }
}
