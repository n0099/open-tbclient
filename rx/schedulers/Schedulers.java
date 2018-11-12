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
    private static final AtomicReference<Schedulers> iGP = new AtomicReference<>();
    private final g iGM;
    private final g iGN;
    private final g iGO;

    private static Schedulers cdc() {
        Schedulers schedulers;
        while (true) {
            schedulers = iGP.get();
            if (schedulers == null) {
                schedulers = new Schedulers();
                if (iGP.compareAndSet(null, schedulers)) {
                    break;
                }
                schedulers.cde();
            } else {
                break;
            }
        }
        return schedulers;
    }

    private Schedulers() {
        rx.c.g ccT = f.ccO().ccT();
        g ccX = ccT.ccX();
        if (ccX != null) {
            this.iGM = ccX;
        } else {
            this.iGM = rx.c.g.ccU();
        }
        g ccY = ccT.ccY();
        if (ccY != null) {
            this.iGN = ccY;
        } else {
            this.iGN = rx.c.g.ccV();
        }
        g ccZ = ccT.ccZ();
        if (ccZ != null) {
            this.iGO = ccZ;
        } else {
            this.iGO = rx.c.g.ccW();
        }
    }

    public static g immediate() {
        return e.iDY;
    }

    public static g trampoline() {
        return j.iEy;
    }

    public static g newThread() {
        return c.f(cdc().iGO);
    }

    public static g computation() {
        return c.d(cdc().iGM);
    }

    public static g io() {
        return c.e(cdc().iGN);
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static g from(Executor executor) {
        return new rx.internal.schedulers.c(executor);
    }

    public static void reset() {
        Schedulers andSet = iGP.getAndSet(null);
        if (andSet != null) {
            andSet.cde();
        }
    }

    public static void start() {
        Schedulers cdc = cdc();
        cdc.cdd();
        synchronized (cdc) {
            d.iDV.start();
        }
    }

    public static void shutdown() {
        Schedulers cdc = cdc();
        cdc.cde();
        synchronized (cdc) {
            d.iDV.shutdown();
        }
    }

    synchronized void cdd() {
        if (this.iGM instanceof h) {
            ((h) this.iGM).start();
        }
        if (this.iGN instanceof h) {
            ((h) this.iGN).start();
        }
        if (this.iGO instanceof h) {
            ((h) this.iGO).start();
        }
    }

    synchronized void cde() {
        if (this.iGM instanceof h) {
            ((h) this.iGM).shutdown();
        }
        if (this.iGN instanceof h) {
            ((h) this.iGN).shutdown();
        }
        if (this.iGO instanceof h) {
            ((h) this.iGO).shutdown();
        }
    }
}
