package rx.schedulers;

import com.baidu.tieba.goc;
import com.baidu.tieba.iqc;
import com.baidu.tieba.jqc;
import com.baidu.tieba.kqc;
import com.baidu.tieba.nqc;
import com.baidu.tieba.pqc;
import com.baidu.tieba.tsc;
import com.baidu.tieba.wsc;
import com.baidu.tieba.xsc;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class Schedulers {
    public static final AtomicReference<Schedulers> d = new AtomicReference<>();
    public final goc a;
    public final goc b;
    public final goc c;

    public static Schedulers a() {
        while (true) {
            Schedulers schedulers = d.get();
            if (schedulers != null) {
                return schedulers;
            }
            Schedulers schedulers2 = new Schedulers();
            if (d.compareAndSet(null, schedulers2)) {
                return schedulers2;
            }
            schedulers2.b();
        }
    }

    public static goc computation() {
        return tsc.f(a().a);
    }

    public static goc immediate() {
        return kqc.a;
    }

    public static goc io() {
        return tsc.k(a().b);
    }

    public static goc newThread() {
        return tsc.l(a().c);
    }

    public static void reset() {
        Schedulers andSet = d.getAndSet(null);
        if (andSet != null) {
            andSet.b();
        }
    }

    public static void shutdown() {
        Schedulers a = a();
        a.b();
        synchronized (a) {
            jqc.d.shutdown();
        }
    }

    public static void start() {
        Schedulers a = a();
        a.c();
        synchronized (a) {
            jqc.d.start();
        }
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static goc trampoline() {
        return pqc.a;
    }

    public synchronized void b() {
        if (this.a instanceof nqc) {
            ((nqc) this.a).shutdown();
        }
        if (this.b instanceof nqc) {
            ((nqc) this.b).shutdown();
        }
        if (this.c instanceof nqc) {
            ((nqc) this.c).shutdown();
        }
    }

    public synchronized void c() {
        if (this.a instanceof nqc) {
            ((nqc) this.a).start();
        }
        if (this.b instanceof nqc) {
            ((nqc) this.b).start();
        }
        if (this.c instanceof nqc) {
            ((nqc) this.c).start();
        }
    }

    public Schedulers() {
        xsc f = wsc.c().f();
        goc g = f.g();
        if (g != null) {
            this.a = g;
        } else {
            this.a = xsc.a();
        }
        goc i = f.i();
        if (i != null) {
            this.b = i;
        } else {
            this.b = xsc.c();
        }
        goc j = f.j();
        if (j != null) {
            this.c = j;
        } else {
            this.c = xsc.e();
        }
    }

    public static goc from(Executor executor) {
        return new iqc(executor);
    }
}
