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
/* loaded from: classes7.dex */
public final class Schedulers {
    private static final AtomicReference<Schedulers> oNI = new AtomicReference<>();
    private final g oTQ;
    private final g oTR;
    private final g oTS;

    private static Schedulers epk() {
        Schedulers schedulers;
        while (true) {
            schedulers = oNI.get();
            if (schedulers == null) {
                schedulers = new Schedulers();
                if (oNI.compareAndSet(null, schedulers)) {
                    break;
                }
                schedulers.epm();
            } else {
                break;
            }
        }
        return schedulers;
    }

    private Schedulers() {
        rx.c.g epb = f.eoW().epb();
        g epf = epb.epf();
        if (epf != null) {
            this.oTQ = epf;
        } else {
            this.oTQ = rx.c.g.epc();
        }
        g epg = epb.epg();
        if (epg != null) {
            this.oTR = epg;
        } else {
            this.oTR = rx.c.g.epd();
        }
        g eph = epb.eph();
        if (eph != null) {
            this.oTS = eph;
        } else {
            this.oTS = rx.c.g.epe();
        }
    }

    public static g immediate() {
        return e.oRX;
    }

    public static g trampoline() {
        return j.oSv;
    }

    public static g newThread() {
        return c.k(epk().oTS);
    }

    public static g computation() {
        return c.i(epk().oTQ);
    }

    public static g io() {
        return c.j(epk().oTR);
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static g from(Executor executor) {
        return new rx.internal.schedulers.c(executor);
    }

    public static void reset() {
        Schedulers andSet = oNI.getAndSet(null);
        if (andSet != null) {
            andSet.epm();
        }
    }

    public static void start() {
        Schedulers epk = epk();
        epk.epl();
        synchronized (epk) {
            d.oRV.start();
        }
    }

    public static void shutdown() {
        Schedulers epk = epk();
        epk.epm();
        synchronized (epk) {
            d.oRV.shutdown();
        }
    }

    synchronized void epl() {
        if (this.oTQ instanceof h) {
            ((h) this.oTQ).start();
        }
        if (this.oTR instanceof h) {
            ((h) this.oTR).start();
        }
        if (this.oTS instanceof h) {
            ((h) this.oTS).start();
        }
    }

    synchronized void epm() {
        if (this.oTQ instanceof h) {
            ((h) this.oTQ).shutdown();
        }
        if (this.oTR instanceof h) {
            ((h) this.oTR).shutdown();
        }
        if (this.oTS instanceof h) {
            ((h) this.oTS).shutdown();
        }
    }
}
