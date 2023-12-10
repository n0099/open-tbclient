package rx.schedulers;

import com.baidu.tieba.hoc;
import com.baidu.tieba.jqc;
import com.baidu.tieba.kqc;
import com.baidu.tieba.lqc;
import com.baidu.tieba.oqc;
import com.baidu.tieba.qqc;
import com.baidu.tieba.usc;
import com.baidu.tieba.xsc;
import com.baidu.tieba.ysc;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class Schedulers {
    public static final AtomicReference<Schedulers> d = new AtomicReference<>();
    public final hoc a;
    public final hoc b;
    public final hoc c;

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

    public static hoc computation() {
        return usc.f(a().a);
    }

    public static hoc immediate() {
        return lqc.a;
    }

    public static hoc io() {
        return usc.k(a().b);
    }

    public static hoc newThread() {
        return usc.l(a().c);
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
            kqc.d.shutdown();
        }
    }

    public static void start() {
        Schedulers a = a();
        a.c();
        synchronized (a) {
            kqc.d.start();
        }
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static hoc trampoline() {
        return qqc.a;
    }

    public synchronized void b() {
        if (this.a instanceof oqc) {
            ((oqc) this.a).shutdown();
        }
        if (this.b instanceof oqc) {
            ((oqc) this.b).shutdown();
        }
        if (this.c instanceof oqc) {
            ((oqc) this.c).shutdown();
        }
    }

    public synchronized void c() {
        if (this.a instanceof oqc) {
            ((oqc) this.a).start();
        }
        if (this.b instanceof oqc) {
            ((oqc) this.b).start();
        }
        if (this.c instanceof oqc) {
            ((oqc) this.c).start();
        }
    }

    public Schedulers() {
        ysc f = xsc.c().f();
        hoc g = f.g();
        if (g != null) {
            this.a = g;
        } else {
            this.a = ysc.a();
        }
        hoc i = f.i();
        if (i != null) {
            this.b = i;
        } else {
            this.b = ysc.c();
        }
        hoc j = f.j();
        if (j != null) {
            this.c = j;
        } else {
            this.c = ysc.e();
        }
    }

    public static hoc from(Executor executor) {
        return new jqc(executor);
    }
}
