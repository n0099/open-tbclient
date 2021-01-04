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
/* loaded from: classes15.dex */
public final class Schedulers {
    private static final AtomicReference<Schedulers> qqU = new AtomicReference<>();
    private final g qxa;
    private final g qxb;
    private final g qxc;

    private static Schedulers eOT() {
        Schedulers schedulers;
        while (true) {
            schedulers = qqU.get();
            if (schedulers == null) {
                schedulers = new Schedulers();
                if (qqU.compareAndSet(null, schedulers)) {
                    break;
                }
                schedulers.eOV();
            } else {
                break;
            }
        }
        return schedulers;
    }

    private Schedulers() {
        rx.c.g eOK = f.eOF().eOK();
        g eOO = eOK.eOO();
        if (eOO != null) {
            this.qxa = eOO;
        } else {
            this.qxa = rx.c.g.eOL();
        }
        g eOP = eOK.eOP();
        if (eOP != null) {
            this.qxb = eOP;
        } else {
            this.qxb = rx.c.g.eOM();
        }
        g eOQ = eOK.eOQ();
        if (eOQ != null) {
            this.qxc = eOQ;
        } else {
            this.qxc = rx.c.g.eON();
        }
    }

    public static g immediate() {
        return e.qvi;
    }

    public static g trampoline() {
        return j.qvF;
    }

    public static g newThread() {
        return c.k(eOT().qxc);
    }

    public static g computation() {
        return c.i(eOT().qxa);
    }

    public static g io() {
        return c.j(eOT().qxb);
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static g from(Executor executor) {
        return new rx.internal.schedulers.c(executor);
    }

    public static void reset() {
        Schedulers andSet = qqU.getAndSet(null);
        if (andSet != null) {
            andSet.eOV();
        }
    }

    public static void start() {
        Schedulers eOT = eOT();
        eOT.eOU();
        synchronized (eOT) {
            d.qvg.start();
        }
    }

    public static void shutdown() {
        Schedulers eOT = eOT();
        eOT.eOV();
        synchronized (eOT) {
            d.qvg.shutdown();
        }
    }

    synchronized void eOU() {
        if (this.qxa instanceof h) {
            ((h) this.qxa).start();
        }
        if (this.qxb instanceof h) {
            ((h) this.qxb).start();
        }
        if (this.qxc instanceof h) {
            ((h) this.qxc).start();
        }
    }

    synchronized void eOV() {
        if (this.qxa instanceof h) {
            ((h) this.qxa).shutdown();
        }
        if (this.qxb instanceof h) {
            ((h) this.qxb).shutdown();
        }
        if (this.qxc instanceof h) {
            ((h) this.qxc).shutdown();
        }
    }
}
