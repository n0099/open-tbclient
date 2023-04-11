package rx.schedulers;

import com.baidu.tieba.b3b;
import com.baidu.tieba.c3b;
import com.baidu.tieba.d3b;
import com.baidu.tieba.g3b;
import com.baidu.tieba.i1b;
import com.baidu.tieba.i3b;
import com.baidu.tieba.m5b;
import com.baidu.tieba.p5b;
import com.baidu.tieba.q5b;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes9.dex */
public final class Schedulers {
    public static final AtomicReference<Schedulers> d = new AtomicReference<>();
    public final i1b a;
    public final i1b b;
    public final i1b c;

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

    public static i1b computation() {
        return m5b.f(a().a);
    }

    public static i1b immediate() {
        return d3b.a;
    }

    public static i1b io() {
        return m5b.k(a().b);
    }

    public static i1b newThread() {
        return m5b.l(a().c);
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
            c3b.d.shutdown();
        }
    }

    public static void start() {
        Schedulers a = a();
        a.c();
        synchronized (a) {
            c3b.d.start();
        }
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static i1b trampoline() {
        return i3b.a;
    }

    public synchronized void b() {
        if (this.a instanceof g3b) {
            ((g3b) this.a).shutdown();
        }
        if (this.b instanceof g3b) {
            ((g3b) this.b).shutdown();
        }
        if (this.c instanceof g3b) {
            ((g3b) this.c).shutdown();
        }
    }

    public synchronized void c() {
        if (this.a instanceof g3b) {
            ((g3b) this.a).start();
        }
        if (this.b instanceof g3b) {
            ((g3b) this.b).start();
        }
        if (this.c instanceof g3b) {
            ((g3b) this.c).start();
        }
    }

    public Schedulers() {
        q5b f = p5b.c().f();
        i1b g = f.g();
        if (g != null) {
            this.a = g;
        } else {
            this.a = q5b.a();
        }
        i1b i = f.i();
        if (i != null) {
            this.b = i;
        } else {
            this.b = q5b.c();
        }
        i1b j = f.j();
        if (j != null) {
            this.c = j;
        } else {
            this.c = q5b.e();
        }
    }

    public static i1b from(Executor executor) {
        return new b3b(executor);
    }
}
