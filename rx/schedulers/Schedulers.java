package rx.schedulers;

import com.baidu.tieba.bhc;
import com.baidu.tieba.chc;
import com.baidu.tieba.ncc;
import com.baidu.tieba.nec;
import com.baidu.tieba.oec;
import com.baidu.tieba.pec;
import com.baidu.tieba.sec;
import com.baidu.tieba.uec;
import com.baidu.tieba.ygc;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class Schedulers {
    public static final AtomicReference<Schedulers> d = new AtomicReference<>();
    public final ncc a;
    public final ncc b;
    public final ncc c;

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

    public static ncc computation() {
        return ygc.f(a().a);
    }

    public static ncc immediate() {
        return pec.a;
    }

    public static ncc io() {
        return ygc.k(a().b);
    }

    public static ncc newThread() {
        return ygc.l(a().c);
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
            oec.d.shutdown();
        }
    }

    public static void start() {
        Schedulers a = a();
        a.c();
        synchronized (a) {
            oec.d.start();
        }
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static ncc trampoline() {
        return uec.a;
    }

    public synchronized void b() {
        if (this.a instanceof sec) {
            ((sec) this.a).shutdown();
        }
        if (this.b instanceof sec) {
            ((sec) this.b).shutdown();
        }
        if (this.c instanceof sec) {
            ((sec) this.c).shutdown();
        }
    }

    public synchronized void c() {
        if (this.a instanceof sec) {
            ((sec) this.a).start();
        }
        if (this.b instanceof sec) {
            ((sec) this.b).start();
        }
        if (this.c instanceof sec) {
            ((sec) this.c).start();
        }
    }

    public Schedulers() {
        chc f = bhc.c().f();
        ncc g = f.g();
        if (g != null) {
            this.a = g;
        } else {
            this.a = chc.a();
        }
        ncc i = f.i();
        if (i != null) {
            this.b = i;
        } else {
            this.b = chc.c();
        }
        ncc j = f.j();
        if (j != null) {
            this.c = j;
        } else {
            this.c = chc.e();
        }
    }

    public static ncc from(Executor executor) {
        return new nec(executor);
    }
}
