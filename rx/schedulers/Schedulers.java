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
/* loaded from: classes5.dex */
public final class Schedulers {
    private static final AtomicReference<Schedulers> oDL = new AtomicReference<>();
    private final g oJT;
    private final g oJU;
    private final g oJV;

    private static Schedulers eld() {
        Schedulers schedulers;
        while (true) {
            schedulers = oDL.get();
            if (schedulers == null) {
                schedulers = new Schedulers();
                if (oDL.compareAndSet(null, schedulers)) {
                    break;
                }
                schedulers.elf();
            } else {
                break;
            }
        }
        return schedulers;
    }

    private Schedulers() {
        rx.c.g ekU = f.ekP().ekU();
        g ekY = ekU.ekY();
        if (ekY != null) {
            this.oJT = ekY;
        } else {
            this.oJT = rx.c.g.ekV();
        }
        g ekZ = ekU.ekZ();
        if (ekZ != null) {
            this.oJU = ekZ;
        } else {
            this.oJU = rx.c.g.ekW();
        }
        g ela = ekU.ela();
        if (ela != null) {
            this.oJV = ela;
        } else {
            this.oJV = rx.c.g.ekX();
        }
    }

    public static g immediate() {
        return e.oIa;
    }

    public static g trampoline() {
        return j.oIy;
    }

    public static g newThread() {
        return c.k(eld().oJV);
    }

    public static g computation() {
        return c.i(eld().oJT);
    }

    public static g io() {
        return c.j(eld().oJU);
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static g from(Executor executor) {
        return new rx.internal.schedulers.c(executor);
    }

    public static void reset() {
        Schedulers andSet = oDL.getAndSet(null);
        if (andSet != null) {
            andSet.elf();
        }
    }

    public static void start() {
        Schedulers eld = eld();
        eld.ele();
        synchronized (eld) {
            d.oHY.start();
        }
    }

    public static void shutdown() {
        Schedulers eld = eld();
        eld.elf();
        synchronized (eld) {
            d.oHY.shutdown();
        }
    }

    synchronized void ele() {
        if (this.oJT instanceof h) {
            ((h) this.oJT).start();
        }
        if (this.oJU instanceof h) {
            ((h) this.oJU).start();
        }
        if (this.oJV instanceof h) {
            ((h) this.oJV).start();
        }
    }

    synchronized void elf() {
        if (this.oJT instanceof h) {
            ((h) this.oJT).shutdown();
        }
        if (this.oJU instanceof h) {
            ((h) this.oJU).shutdown();
        }
        if (this.oJV instanceof h) {
            ((h) this.oJV).shutdown();
        }
    }
}
