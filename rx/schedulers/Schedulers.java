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
/* loaded from: classes14.dex */
public final class Schedulers {
    private static final AtomicReference<Schedulers> qfo = new AtomicReference<>();
    private final g qlx;
    private final g qly;
    private final g qlz;

    private static Schedulers eGJ() {
        Schedulers schedulers;
        while (true) {
            schedulers = qfo.get();
            if (schedulers == null) {
                schedulers = new Schedulers();
                if (qfo.compareAndSet(null, schedulers)) {
                    break;
                }
                schedulers.eGL();
            } else {
                break;
            }
        }
        return schedulers;
    }

    private Schedulers() {
        rx.c.g eGA = f.eGv().eGA();
        g eGE = eGA.eGE();
        if (eGE != null) {
            this.qlx = eGE;
        } else {
            this.qlx = rx.c.g.eGB();
        }
        g eGF = eGA.eGF();
        if (eGF != null) {
            this.qly = eGF;
        } else {
            this.qly = rx.c.g.eGC();
        }
        g eGG = eGA.eGG();
        if (eGG != null) {
            this.qlz = eGG;
        } else {
            this.qlz = rx.c.g.eGD();
        }
    }

    public static g immediate() {
        return e.qjE;
    }

    public static g trampoline() {
        return j.qkc;
    }

    public static g newThread() {
        return c.k(eGJ().qlz);
    }

    public static g computation() {
        return c.i(eGJ().qlx);
    }

    public static g io() {
        return c.j(eGJ().qly);
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static g from(Executor executor) {
        return new rx.internal.schedulers.c(executor);
    }

    public static void reset() {
        Schedulers andSet = qfo.getAndSet(null);
        if (andSet != null) {
            andSet.eGL();
        }
    }

    public static void start() {
        Schedulers eGJ = eGJ();
        eGJ.eGK();
        synchronized (eGJ) {
            d.qjC.start();
        }
    }

    public static void shutdown() {
        Schedulers eGJ = eGJ();
        eGJ.eGL();
        synchronized (eGJ) {
            d.qjC.shutdown();
        }
    }

    synchronized void eGK() {
        if (this.qlx instanceof h) {
            ((h) this.qlx).start();
        }
        if (this.qly instanceof h) {
            ((h) this.qly).start();
        }
        if (this.qlz instanceof h) {
            ((h) this.qlz).start();
        }
    }

    synchronized void eGL() {
        if (this.qlx instanceof h) {
            ((h) this.qlx).shutdown();
        }
        if (this.qly instanceof h) {
            ((h) this.qly).shutdown();
        }
        if (this.qlz instanceof h) {
            ((h) this.qlz).shutdown();
        }
    }
}
