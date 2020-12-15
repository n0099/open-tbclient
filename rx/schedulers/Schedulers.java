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
    private static final AtomicReference<Schedulers> pPs = new AtomicReference<>();
    private final g pVA;
    private final g pVB;
    private final g pVC;

    private static Schedulers eGL() {
        Schedulers schedulers;
        while (true) {
            schedulers = pPs.get();
            if (schedulers == null) {
                schedulers = new Schedulers();
                if (pPs.compareAndSet(null, schedulers)) {
                    break;
                }
                schedulers.eGN();
            } else {
                break;
            }
        }
        return schedulers;
    }

    private Schedulers() {
        rx.c.g eGC = f.eGx().eGC();
        g eGG = eGC.eGG();
        if (eGG != null) {
            this.pVA = eGG;
        } else {
            this.pVA = rx.c.g.eGD();
        }
        g eGH = eGC.eGH();
        if (eGH != null) {
            this.pVB = eGH;
        } else {
            this.pVB = rx.c.g.eGE();
        }
        g eGI = eGC.eGI();
        if (eGI != null) {
            this.pVC = eGI;
        } else {
            this.pVC = rx.c.g.eGF();
        }
    }

    public static g immediate() {
        return e.pTH;
    }

    public static g trampoline() {
        return j.pUf;
    }

    public static g newThread() {
        return c.k(eGL().pVC);
    }

    public static g computation() {
        return c.i(eGL().pVA);
    }

    public static g io() {
        return c.j(eGL().pVB);
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static g from(Executor executor) {
        return new rx.internal.schedulers.c(executor);
    }

    public static void reset() {
        Schedulers andSet = pPs.getAndSet(null);
        if (andSet != null) {
            andSet.eGN();
        }
    }

    public static void start() {
        Schedulers eGL = eGL();
        eGL.eGM();
        synchronized (eGL) {
            d.pTF.start();
        }
    }

    public static void shutdown() {
        Schedulers eGL = eGL();
        eGL.eGN();
        synchronized (eGL) {
            d.pTF.shutdown();
        }
    }

    synchronized void eGM() {
        if (this.pVA instanceof h) {
            ((h) this.pVA).start();
        }
        if (this.pVB instanceof h) {
            ((h) this.pVB).start();
        }
        if (this.pVC instanceof h) {
            ((h) this.pVC).start();
        }
    }

    synchronized void eGN() {
        if (this.pVA instanceof h) {
            ((h) this.pVA).shutdown();
        }
        if (this.pVB instanceof h) {
            ((h) this.pVB).shutdown();
        }
        if (this.pVC instanceof h) {
            ((h) this.pVC).shutdown();
        }
    }
}
