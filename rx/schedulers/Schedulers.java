package rx.schedulers;

import com.baidu.tieba.j3b;
import com.baidu.tieba.k3b;
import com.baidu.tieba.l3b;
import com.baidu.tieba.o3b;
import com.baidu.tieba.q1b;
import com.baidu.tieba.q3b;
import com.baidu.tieba.u5b;
import com.baidu.tieba.x5b;
import com.baidu.tieba.y5b;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes9.dex */
public final class Schedulers {
    public static final AtomicReference<Schedulers> d = new AtomicReference<>();
    public final q1b a;
    public final q1b b;
    public final q1b c;

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

    public static q1b computation() {
        return u5b.f(a().a);
    }

    public static q1b immediate() {
        return l3b.a;
    }

    public static q1b io() {
        return u5b.k(a().b);
    }

    public static q1b newThread() {
        return u5b.l(a().c);
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
            k3b.d.shutdown();
        }
    }

    public static void start() {
        Schedulers a = a();
        a.c();
        synchronized (a) {
            k3b.d.start();
        }
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static q1b trampoline() {
        return q3b.a;
    }

    public synchronized void b() {
        if (this.a instanceof o3b) {
            ((o3b) this.a).shutdown();
        }
        if (this.b instanceof o3b) {
            ((o3b) this.b).shutdown();
        }
        if (this.c instanceof o3b) {
            ((o3b) this.c).shutdown();
        }
    }

    public synchronized void c() {
        if (this.a instanceof o3b) {
            ((o3b) this.a).start();
        }
        if (this.b instanceof o3b) {
            ((o3b) this.b).start();
        }
        if (this.c instanceof o3b) {
            ((o3b) this.c).start();
        }
    }

    public Schedulers() {
        y5b f = x5b.c().f();
        q1b g = f.g();
        if (g != null) {
            this.a = g;
        } else {
            this.a = y5b.a();
        }
        q1b i = f.i();
        if (i != null) {
            this.b = i;
        } else {
            this.b = y5b.c();
        }
        q1b j = f.j();
        if (j != null) {
            this.c = j;
        } else {
            this.c = y5b.e();
        }
    }

    public static q1b from(Executor executor) {
        return new j3b(executor);
    }
}
