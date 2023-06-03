package rx.schedulers;

import com.baidu.tieba.hob;
import com.baidu.tieba.iob;
import com.baidu.tieba.job;
import com.baidu.tieba.lmb;
import com.baidu.tieba.mob;
import com.baidu.tieba.oob;
import com.baidu.tieba.sqb;
import com.baidu.tieba.vqb;
import com.baidu.tieba.wqb;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class Schedulers {
    public static final AtomicReference<Schedulers> d = new AtomicReference<>();
    public final lmb a;
    public final lmb b;
    public final lmb c;

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

    public static lmb computation() {
        return sqb.f(a().a);
    }

    public static lmb immediate() {
        return job.a;
    }

    public static lmb io() {
        return sqb.k(a().b);
    }

    public static lmb newThread() {
        return sqb.l(a().c);
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
            iob.d.shutdown();
        }
    }

    public static void start() {
        Schedulers a = a();
        a.c();
        synchronized (a) {
            iob.d.start();
        }
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static lmb trampoline() {
        return oob.a;
    }

    public synchronized void b() {
        if (this.a instanceof mob) {
            ((mob) this.a).shutdown();
        }
        if (this.b instanceof mob) {
            ((mob) this.b).shutdown();
        }
        if (this.c instanceof mob) {
            ((mob) this.c).shutdown();
        }
    }

    public synchronized void c() {
        if (this.a instanceof mob) {
            ((mob) this.a).start();
        }
        if (this.b instanceof mob) {
            ((mob) this.b).start();
        }
        if (this.c instanceof mob) {
            ((mob) this.c).start();
        }
    }

    public Schedulers() {
        wqb f = vqb.c().f();
        lmb g = f.g();
        if (g != null) {
            this.a = g;
        } else {
            this.a = wqb.a();
        }
        lmb i = f.i();
        if (i != null) {
            this.b = i;
        } else {
            this.b = wqb.c();
        }
        lmb j = f.j();
        if (j != null) {
            this.c = j;
        } else {
            this.c = wqb.e();
        }
    }

    public static lmb from(Executor executor) {
        return new hob(executor);
    }
}
