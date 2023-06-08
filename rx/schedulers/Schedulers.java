package rx.schedulers;

import com.baidu.tieba.arb;
import com.baidu.tieba.brb;
import com.baidu.tieba.mob;
import com.baidu.tieba.nob;
import com.baidu.tieba.oob;
import com.baidu.tieba.qmb;
import com.baidu.tieba.rob;
import com.baidu.tieba.tob;
import com.baidu.tieba.xqb;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class Schedulers {
    public static final AtomicReference<Schedulers> d = new AtomicReference<>();
    public final qmb a;
    public final qmb b;
    public final qmb c;

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

    public static qmb computation() {
        return xqb.f(a().a);
    }

    public static qmb immediate() {
        return oob.a;
    }

    public static qmb io() {
        return xqb.k(a().b);
    }

    public static qmb newThread() {
        return xqb.l(a().c);
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
            nob.d.shutdown();
        }
    }

    public static void start() {
        Schedulers a = a();
        a.c();
        synchronized (a) {
            nob.d.start();
        }
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static qmb trampoline() {
        return tob.a;
    }

    public synchronized void b() {
        if (this.a instanceof rob) {
            ((rob) this.a).shutdown();
        }
        if (this.b instanceof rob) {
            ((rob) this.b).shutdown();
        }
        if (this.c instanceof rob) {
            ((rob) this.c).shutdown();
        }
    }

    public synchronized void c() {
        if (this.a instanceof rob) {
            ((rob) this.a).start();
        }
        if (this.b instanceof rob) {
            ((rob) this.b).start();
        }
        if (this.c instanceof rob) {
            ((rob) this.c).start();
        }
    }

    public Schedulers() {
        brb f = arb.c().f();
        qmb g = f.g();
        if (g != null) {
            this.a = g;
        } else {
            this.a = brb.a();
        }
        qmb i = f.i();
        if (i != null) {
            this.b = i;
        } else {
            this.b = brb.c();
        }
        qmb j = f.j();
        if (j != null) {
            this.c = j;
        } else {
            this.c = brb.e();
        }
    }

    public static qmb from(Executor executor) {
        return new mob(executor);
    }
}
