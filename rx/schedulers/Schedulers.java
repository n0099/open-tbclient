package rx.schedulers;

import com.baidu.tieba.h7b;
import com.baidu.tieba.i7b;
import com.baidu.tieba.j7b;
import com.baidu.tieba.m5b;
import com.baidu.tieba.m7b;
import com.baidu.tieba.o7b;
import com.baidu.tieba.s9b;
import com.baidu.tieba.v9b;
import com.baidu.tieba.w9b;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes9.dex */
public final class Schedulers {
    public static final AtomicReference<Schedulers> d = new AtomicReference<>();
    public final m5b a;
    public final m5b b;
    public final m5b c;

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

    public static m5b computation() {
        return s9b.f(a().a);
    }

    public static m5b immediate() {
        return j7b.a;
    }

    public static m5b io() {
        return s9b.k(a().b);
    }

    public static m5b newThread() {
        return s9b.l(a().c);
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
            i7b.d.shutdown();
        }
    }

    public static void start() {
        Schedulers a = a();
        a.c();
        synchronized (a) {
            i7b.d.start();
        }
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static m5b trampoline() {
        return o7b.a;
    }

    public synchronized void b() {
        if (this.a instanceof m7b) {
            ((m7b) this.a).shutdown();
        }
        if (this.b instanceof m7b) {
            ((m7b) this.b).shutdown();
        }
        if (this.c instanceof m7b) {
            ((m7b) this.c).shutdown();
        }
    }

    public synchronized void c() {
        if (this.a instanceof m7b) {
            ((m7b) this.a).start();
        }
        if (this.b instanceof m7b) {
            ((m7b) this.b).start();
        }
        if (this.c instanceof m7b) {
            ((m7b) this.c).start();
        }
    }

    public Schedulers() {
        w9b f = v9b.c().f();
        m5b g = f.g();
        if (g != null) {
            this.a = g;
        } else {
            this.a = w9b.a();
        }
        m5b i = f.i();
        if (i != null) {
            this.b = i;
        } else {
            this.b = w9b.c();
        }
        m5b j = f.j();
        if (j != null) {
            this.c = j;
        } else {
            this.c = w9b.e();
        }
    }

    public static m5b from(Executor executor) {
        return new h7b(executor);
    }
}
