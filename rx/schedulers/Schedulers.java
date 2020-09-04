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
    private static final AtomicReference<Schedulers> oEd = new AtomicReference<>();
    private final g oKl;
    private final g oKm;
    private final g oKn;

    private static Schedulers elm() {
        Schedulers schedulers;
        while (true) {
            schedulers = oEd.get();
            if (schedulers == null) {
                schedulers = new Schedulers();
                if (oEd.compareAndSet(null, schedulers)) {
                    break;
                }
                schedulers.elo();
            } else {
                break;
            }
        }
        return schedulers;
    }

    private Schedulers() {
        rx.c.g eld = f.ekY().eld();
        g elh = eld.elh();
        if (elh != null) {
            this.oKl = elh;
        } else {
            this.oKl = rx.c.g.ele();
        }
        g eli = eld.eli();
        if (eli != null) {
            this.oKm = eli;
        } else {
            this.oKm = rx.c.g.elf();
        }
        g elj = eld.elj();
        if (elj != null) {
            this.oKn = elj;
        } else {
            this.oKn = rx.c.g.elg();
        }
    }

    public static g immediate() {
        return e.oIs;
    }

    public static g trampoline() {
        return j.oIQ;
    }

    public static g newThread() {
        return c.k(elm().oKn);
    }

    public static g computation() {
        return c.i(elm().oKl);
    }

    public static g io() {
        return c.j(elm().oKm);
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static g from(Executor executor) {
        return new rx.internal.schedulers.c(executor);
    }

    public static void reset() {
        Schedulers andSet = oEd.getAndSet(null);
        if (andSet != null) {
            andSet.elo();
        }
    }

    public static void start() {
        Schedulers elm = elm();
        elm.eln();
        synchronized (elm) {
            d.oIq.start();
        }
    }

    public static void shutdown() {
        Schedulers elm = elm();
        elm.elo();
        synchronized (elm) {
            d.oIq.shutdown();
        }
    }

    synchronized void eln() {
        if (this.oKl instanceof h) {
            ((h) this.oKl).start();
        }
        if (this.oKm instanceof h) {
            ((h) this.oKm).start();
        }
        if (this.oKn instanceof h) {
            ((h) this.oKn).start();
        }
    }

    synchronized void elo() {
        if (this.oKl instanceof h) {
            ((h) this.oKl).shutdown();
        }
        if (this.oKm instanceof h) {
            ((h) this.oKm).shutdown();
        }
        if (this.oKn instanceof h) {
            ((h) this.oKn).shutdown();
        }
    }
}
