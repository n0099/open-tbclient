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
/* loaded from: classes6.dex */
public final class Schedulers {
    private static final AtomicReference<Schedulers> nPw = new AtomicReference<>();
    private final g nVC;
    private final g nVD;
    private final g nVE;

    private static Schedulers dPN() {
        Schedulers schedulers;
        while (true) {
            schedulers = nPw.get();
            if (schedulers == null) {
                schedulers = new Schedulers();
                if (nPw.compareAndSet(null, schedulers)) {
                    break;
                }
                schedulers.dPP();
            } else {
                break;
            }
        }
        return schedulers;
    }

    private Schedulers() {
        rx.c.g dPE = f.dPz().dPE();
        g dPI = dPE.dPI();
        if (dPI != null) {
            this.nVC = dPI;
        } else {
            this.nVC = rx.c.g.dPF();
        }
        g dPJ = dPE.dPJ();
        if (dPJ != null) {
            this.nVD = dPJ;
        } else {
            this.nVD = rx.c.g.dPG();
        }
        g dPK = dPE.dPK();
        if (dPK != null) {
            this.nVE = dPK;
        } else {
            this.nVE = rx.c.g.dPH();
        }
    }

    public static g immediate() {
        return e.nTK;
    }

    public static g trampoline() {
        return j.nUi;
    }

    public static g newThread() {
        return c.k(dPN().nVE);
    }

    public static g computation() {
        return c.i(dPN().nVC);
    }

    public static g io() {
        return c.j(dPN().nVD);
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static g from(Executor executor) {
        return new rx.internal.schedulers.c(executor);
    }

    public static void reset() {
        Schedulers andSet = nPw.getAndSet(null);
        if (andSet != null) {
            andSet.dPP();
        }
    }

    public static void start() {
        Schedulers dPN = dPN();
        dPN.dPO();
        synchronized (dPN) {
            d.nTI.start();
        }
    }

    public static void shutdown() {
        Schedulers dPN = dPN();
        dPN.dPP();
        synchronized (dPN) {
            d.nTI.shutdown();
        }
    }

    synchronized void dPO() {
        if (this.nVC instanceof h) {
            ((h) this.nVC).start();
        }
        if (this.nVD instanceof h) {
            ((h) this.nVD).start();
        }
        if (this.nVE instanceof h) {
            ((h) this.nVE).start();
        }
    }

    synchronized void dPP() {
        if (this.nVC instanceof h) {
            ((h) this.nVC).shutdown();
        }
        if (this.nVD instanceof h) {
            ((h) this.nVD).shutdown();
        }
        if (this.nVE instanceof h) {
            ((h) this.nVE).shutdown();
        }
    }
}
