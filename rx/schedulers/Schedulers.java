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
    private static final AtomicReference<Schedulers> kcF = new AtomicReference<>();
    private final g kcC;
    private final g kcD;
    private final g kcE;

    private static Schedulers cFo() {
        Schedulers schedulers;
        while (true) {
            schedulers = kcF.get();
            if (schedulers == null) {
                schedulers = new Schedulers();
                if (kcF.compareAndSet(null, schedulers)) {
                    break;
                }
                schedulers.cFq();
            } else {
                break;
            }
        }
        return schedulers;
    }

    private Schedulers() {
        rx.c.g cFf = f.cFa().cFf();
        g cFj = cFf.cFj();
        if (cFj != null) {
            this.kcC = cFj;
        } else {
            this.kcC = rx.c.g.cFg();
        }
        g cFk = cFf.cFk();
        if (cFk != null) {
            this.kcD = cFk;
        } else {
            this.kcD = rx.c.g.cFh();
        }
        g cFl = cFf.cFl();
        if (cFl != null) {
            this.kcE = cFl;
        } else {
            this.kcE = rx.c.g.cFi();
        }
    }

    public static g immediate() {
        return e.kam;
    }

    public static g trampoline() {
        return j.kaM;
    }

    public static g newThread() {
        return c.i(cFo().kcE);
    }

    public static g computation() {
        return c.g(cFo().kcC);
    }

    public static g io() {
        return c.h(cFo().kcD);
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static g from(Executor executor) {
        return new rx.internal.schedulers.c(executor);
    }

    public static void reset() {
        Schedulers andSet = kcF.getAndSet(null);
        if (andSet != null) {
            andSet.cFq();
        }
    }

    public static void start() {
        Schedulers cFo = cFo();
        cFo.cFp();
        synchronized (cFo) {
            d.kaj.start();
        }
    }

    public static void shutdown() {
        Schedulers cFo = cFo();
        cFo.cFq();
        synchronized (cFo) {
            d.kaj.shutdown();
        }
    }

    synchronized void cFp() {
        if (this.kcC instanceof h) {
            ((h) this.kcC).start();
        }
        if (this.kcD instanceof h) {
            ((h) this.kcD).start();
        }
        if (this.kcE instanceof h) {
            ((h) this.kcE).start();
        }
    }

    synchronized void cFq() {
        if (this.kcC instanceof h) {
            ((h) this.kcC).shutdown();
        }
        if (this.kcD instanceof h) {
            ((h) this.kcD).shutdown();
        }
        if (this.kcE instanceof h) {
            ((h) this.kcE).shutdown();
        }
    }
}
