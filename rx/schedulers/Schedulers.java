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
    private static final AtomicReference<Schedulers> iSn = new AtomicReference<>();
    private final g iSk;
    private final g iSl;
    private final g iSm;

    private static Schedulers cgD() {
        Schedulers schedulers;
        while (true) {
            schedulers = iSn.get();
            if (schedulers == null) {
                schedulers = new Schedulers();
                if (iSn.compareAndSet(null, schedulers)) {
                    break;
                }
                schedulers.cgF();
            } else {
                break;
            }
        }
        return schedulers;
    }

    private Schedulers() {
        rx.c.g cgu = f.cgp().cgu();
        g cgy = cgu.cgy();
        if (cgy != null) {
            this.iSk = cgy;
        } else {
            this.iSk = rx.c.g.cgv();
        }
        g cgz = cgu.cgz();
        if (cgz != null) {
            this.iSl = cgz;
        } else {
            this.iSl = rx.c.g.cgw();
        }
        g cgA = cgu.cgA();
        if (cgA != null) {
            this.iSm = cgA;
        } else {
            this.iSm = rx.c.g.cgx();
        }
    }

    public static g immediate() {
        return e.iPw;
    }

    public static g trampoline() {
        return j.iPW;
    }

    public static g newThread() {
        return c.f(cgD().iSm);
    }

    public static g computation() {
        return c.d(cgD().iSk);
    }

    public static g io() {
        return c.e(cgD().iSl);
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static g from(Executor executor) {
        return new rx.internal.schedulers.c(executor);
    }

    public static void reset() {
        Schedulers andSet = iSn.getAndSet(null);
        if (andSet != null) {
            andSet.cgF();
        }
    }

    public static void start() {
        Schedulers cgD = cgD();
        cgD.cgE();
        synchronized (cgD) {
            d.iPt.start();
        }
    }

    public static void shutdown() {
        Schedulers cgD = cgD();
        cgD.cgF();
        synchronized (cgD) {
            d.iPt.shutdown();
        }
    }

    synchronized void cgE() {
        if (this.iSk instanceof h) {
            ((h) this.iSk).start();
        }
        if (this.iSl instanceof h) {
            ((h) this.iSl).start();
        }
        if (this.iSm instanceof h) {
            ((h) this.iSm).start();
        }
    }

    synchronized void cgF() {
        if (this.iSk instanceof h) {
            ((h) this.iSk).shutdown();
        }
        if (this.iSl instanceof h) {
            ((h) this.iSl).shutdown();
        }
        if (this.iSm instanceof h) {
            ((h) this.iSm).shutdown();
        }
    }
}
