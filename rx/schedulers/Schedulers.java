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
/* loaded from: classes12.dex */
public final class Schedulers {
    private static final AtomicReference<Schedulers> pPq = new AtomicReference<>();
    private final g pVA;
    private final g pVy;
    private final g pVz;

    private static Schedulers eGK() {
        Schedulers schedulers;
        while (true) {
            schedulers = pPq.get();
            if (schedulers == null) {
                schedulers = new Schedulers();
                if (pPq.compareAndSet(null, schedulers)) {
                    break;
                }
                schedulers.eGM();
            } else {
                break;
            }
        }
        return schedulers;
    }

    private Schedulers() {
        rx.c.g eGB = f.eGw().eGB();
        g eGF = eGB.eGF();
        if (eGF != null) {
            this.pVy = eGF;
        } else {
            this.pVy = rx.c.g.eGC();
        }
        g eGG = eGB.eGG();
        if (eGG != null) {
            this.pVz = eGG;
        } else {
            this.pVz = rx.c.g.eGD();
        }
        g eGH = eGB.eGH();
        if (eGH != null) {
            this.pVA = eGH;
        } else {
            this.pVA = rx.c.g.eGE();
        }
    }

    public static g immediate() {
        return e.pTF;
    }

    public static g trampoline() {
        return j.pUd;
    }

    public static g newThread() {
        return c.k(eGK().pVA);
    }

    public static g computation() {
        return c.i(eGK().pVy);
    }

    public static g io() {
        return c.j(eGK().pVz);
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static g from(Executor executor) {
        return new rx.internal.schedulers.c(executor);
    }

    public static void reset() {
        Schedulers andSet = pPq.getAndSet(null);
        if (andSet != null) {
            andSet.eGM();
        }
    }

    public static void start() {
        Schedulers eGK = eGK();
        eGK.eGL();
        synchronized (eGK) {
            d.pTD.start();
        }
    }

    public static void shutdown() {
        Schedulers eGK = eGK();
        eGK.eGM();
        synchronized (eGK) {
            d.pTD.shutdown();
        }
    }

    synchronized void eGL() {
        if (this.pVy instanceof h) {
            ((h) this.pVy).start();
        }
        if (this.pVz instanceof h) {
            ((h) this.pVz).start();
        }
        if (this.pVA instanceof h) {
            ((h) this.pVA).start();
        }
    }

    synchronized void eGM() {
        if (this.pVy instanceof h) {
            ((h) this.pVy).shutdown();
        }
        if (this.pVz instanceof h) {
            ((h) this.pVz).shutdown();
        }
        if (this.pVA instanceof h) {
            ((h) this.pVA).shutdown();
        }
    }
}
