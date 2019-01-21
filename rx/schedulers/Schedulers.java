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
    private static final AtomicReference<Schedulers> iSo = new AtomicReference<>();
    private final g iSl;
    private final g iSm;
    private final g iSn;

    private static Schedulers cgD() {
        Schedulers schedulers;
        while (true) {
            schedulers = iSo.get();
            if (schedulers == null) {
                schedulers = new Schedulers();
                if (iSo.compareAndSet(null, schedulers)) {
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
            this.iSl = cgy;
        } else {
            this.iSl = rx.c.g.cgv();
        }
        g cgz = cgu.cgz();
        if (cgz != null) {
            this.iSm = cgz;
        } else {
            this.iSm = rx.c.g.cgw();
        }
        g cgA = cgu.cgA();
        if (cgA != null) {
            this.iSn = cgA;
        } else {
            this.iSn = rx.c.g.cgx();
        }
    }

    public static g immediate() {
        return e.iPx;
    }

    public static g trampoline() {
        return j.iPX;
    }

    public static g newThread() {
        return c.f(cgD().iSn);
    }

    public static g computation() {
        return c.d(cgD().iSl);
    }

    public static g io() {
        return c.e(cgD().iSm);
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static g from(Executor executor) {
        return new rx.internal.schedulers.c(executor);
    }

    public static void reset() {
        Schedulers andSet = iSo.getAndSet(null);
        if (andSet != null) {
            andSet.cgF();
        }
    }

    public static void start() {
        Schedulers cgD = cgD();
        cgD.cgE();
        synchronized (cgD) {
            d.iPu.start();
        }
    }

    public static void shutdown() {
        Schedulers cgD = cgD();
        cgD.cgF();
        synchronized (cgD) {
            d.iPu.shutdown();
        }
    }

    synchronized void cgE() {
        if (this.iSl instanceof h) {
            ((h) this.iSl).start();
        }
        if (this.iSm instanceof h) {
            ((h) this.iSm).start();
        }
        if (this.iSn instanceof h) {
            ((h) this.iSn).start();
        }
    }

    synchronized void cgF() {
        if (this.iSl instanceof h) {
            ((h) this.iSl).shutdown();
        }
        if (this.iSm instanceof h) {
            ((h) this.iSm).shutdown();
        }
        if (this.iSn instanceof h) {
            ((h) this.iSn).shutdown();
        }
    }
}
