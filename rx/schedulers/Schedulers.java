package rx.schedulers;

import com.baidu.tieba.fqb;
import com.baidu.tieba.gqb;
import com.baidu.tieba.hqb;
import com.baidu.tieba.job;
import com.baidu.tieba.kqb;
import com.baidu.tieba.mqb;
import com.baidu.tieba.qsb;
import com.baidu.tieba.tsb;
import com.baidu.tieba.usb;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class Schedulers {
    public static final AtomicReference<Schedulers> d = new AtomicReference<>();
    public final job a;
    public final job b;
    public final job c;

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

    public static job computation() {
        return qsb.f(a().a);
    }

    public static job immediate() {
        return hqb.a;
    }

    public static job io() {
        return qsb.k(a().b);
    }

    public static job newThread() {
        return qsb.l(a().c);
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
            gqb.d.shutdown();
        }
    }

    public static void start() {
        Schedulers a = a();
        a.c();
        synchronized (a) {
            gqb.d.start();
        }
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static job trampoline() {
        return mqb.a;
    }

    public synchronized void b() {
        if (this.a instanceof kqb) {
            ((kqb) this.a).shutdown();
        }
        if (this.b instanceof kqb) {
            ((kqb) this.b).shutdown();
        }
        if (this.c instanceof kqb) {
            ((kqb) this.c).shutdown();
        }
    }

    public synchronized void c() {
        if (this.a instanceof kqb) {
            ((kqb) this.a).start();
        }
        if (this.b instanceof kqb) {
            ((kqb) this.b).start();
        }
        if (this.c instanceof kqb) {
            ((kqb) this.c).start();
        }
    }

    public Schedulers() {
        usb f = tsb.c().f();
        job g = f.g();
        if (g != null) {
            this.a = g;
        } else {
            this.a = usb.a();
        }
        job i = f.i();
        if (i != null) {
            this.b = i;
        } else {
            this.b = usb.c();
        }
        job j = f.j();
        if (j != null) {
            this.c = j;
        } else {
            this.c = usb.e();
        }
    }

    public static job from(Executor executor) {
        return new fqb(executor);
    }
}
