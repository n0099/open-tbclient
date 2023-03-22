package rx.schedulers;

import com.baidu.tieba.kta;
import com.baidu.tieba.lta;
import com.baidu.tieba.mta;
import com.baidu.tieba.pta;
import com.baidu.tieba.rra;
import com.baidu.tieba.rta;
import com.baidu.tieba.vva;
import com.baidu.tieba.yva;
import com.baidu.tieba.zva;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes9.dex */
public final class Schedulers {
    public static final AtomicReference<Schedulers> d = new AtomicReference<>();
    public final rra a;
    public final rra b;
    public final rra c;

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

    public static rra computation() {
        return vva.f(a().a);
    }

    public static rra immediate() {
        return mta.a;
    }

    public static rra io() {
        return vva.k(a().b);
    }

    public static rra newThread() {
        return vva.l(a().c);
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
            lta.d.shutdown();
        }
    }

    public static void start() {
        Schedulers a = a();
        a.c();
        synchronized (a) {
            lta.d.start();
        }
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static rra trampoline() {
        return rta.a;
    }

    public synchronized void b() {
        if (this.a instanceof pta) {
            ((pta) this.a).shutdown();
        }
        if (this.b instanceof pta) {
            ((pta) this.b).shutdown();
        }
        if (this.c instanceof pta) {
            ((pta) this.c).shutdown();
        }
    }

    public synchronized void c() {
        if (this.a instanceof pta) {
            ((pta) this.a).start();
        }
        if (this.b instanceof pta) {
            ((pta) this.b).start();
        }
        if (this.c instanceof pta) {
            ((pta) this.c).start();
        }
    }

    public Schedulers() {
        zva f = yva.c().f();
        rra g = f.g();
        if (g != null) {
            this.a = g;
        } else {
            this.a = zva.a();
        }
        rra i = f.i();
        if (i != null) {
            this.b = i;
        } else {
            this.b = zva.c();
        }
        rra j = f.j();
        if (j != null) {
            this.c = j;
        } else {
            this.c = zva.e();
        }
    }

    public static rra from(Executor executor) {
        return new kta(executor);
    }
}
