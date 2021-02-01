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
    private static final AtomicReference<Schedulers> qye = new AtomicReference<>();
    private final g qEk;
    private final g qEl;
    private final g qEm;

    private static Schedulers eNX() {
        Schedulers schedulers;
        while (true) {
            schedulers = qye.get();
            if (schedulers == null) {
                schedulers = new Schedulers();
                if (qye.compareAndSet(null, schedulers)) {
                    break;
                }
                schedulers.eNZ();
            } else {
                break;
            }
        }
        return schedulers;
    }

    private Schedulers() {
        rx.c.g eNO = f.eNJ().eNO();
        g eNS = eNO.eNS();
        if (eNS != null) {
            this.qEk = eNS;
        } else {
            this.qEk = rx.c.g.eNP();
        }
        g eNT = eNO.eNT();
        if (eNT != null) {
            this.qEl = eNT;
        } else {
            this.qEl = rx.c.g.eNQ();
        }
        g eNU = eNO.eNU();
        if (eNU != null) {
            this.qEm = eNU;
        } else {
            this.qEm = rx.c.g.eNR();
        }
    }

    public static g immediate() {
        return e.qCs;
    }

    public static g trampoline() {
        return j.qCP;
    }

    public static g newThread() {
        return c.k(eNX().qEm);
    }

    public static g computation() {
        return c.i(eNX().qEk);
    }

    public static g io() {
        return c.j(eNX().qEl);
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static g from(Executor executor) {
        return new rx.internal.schedulers.c(executor);
    }

    public static void reset() {
        Schedulers andSet = qye.getAndSet(null);
        if (andSet != null) {
            andSet.eNZ();
        }
    }

    public static void start() {
        Schedulers eNX = eNX();
        eNX.eNY();
        synchronized (eNX) {
            d.qCq.start();
        }
    }

    public static void shutdown() {
        Schedulers eNX = eNX();
        eNX.eNZ();
        synchronized (eNX) {
            d.qCq.shutdown();
        }
    }

    synchronized void eNY() {
        if (this.qEk instanceof h) {
            ((h) this.qEk).start();
        }
        if (this.qEl instanceof h) {
            ((h) this.qEl).start();
        }
        if (this.qEm instanceof h) {
            ((h) this.qEm).start();
        }
    }

    synchronized void eNZ() {
        if (this.qEk instanceof h) {
            ((h) this.qEk).shutdown();
        }
        if (this.qEl instanceof h) {
            ((h) this.qEl).shutdown();
        }
        if (this.qEm instanceof h) {
            ((h) this.qEm).shutdown();
        }
    }
}
