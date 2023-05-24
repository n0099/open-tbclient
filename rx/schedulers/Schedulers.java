package rx.schedulers;

import com.baidu.tieba.h9b;
import com.baidu.tieba.i9b;
import com.baidu.tieba.j9b;
import com.baidu.tieba.l7b;
import com.baidu.tieba.m9b;
import com.baidu.tieba.o9b;
import com.baidu.tieba.sbb;
import com.baidu.tieba.vbb;
import com.baidu.tieba.wbb;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes10.dex */
public final class Schedulers {
    public static final AtomicReference<Schedulers> d = new AtomicReference<>();
    public final l7b a;
    public final l7b b;
    public final l7b c;

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

    public static l7b computation() {
        return sbb.f(a().a);
    }

    public static l7b immediate() {
        return j9b.a;
    }

    public static l7b io() {
        return sbb.k(a().b);
    }

    public static l7b newThread() {
        return sbb.l(a().c);
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
            i9b.d.shutdown();
        }
    }

    public static void start() {
        Schedulers a = a();
        a.c();
        synchronized (a) {
            i9b.d.start();
        }
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static l7b trampoline() {
        return o9b.a;
    }

    public synchronized void b() {
        if (this.a instanceof m9b) {
            ((m9b) this.a).shutdown();
        }
        if (this.b instanceof m9b) {
            ((m9b) this.b).shutdown();
        }
        if (this.c instanceof m9b) {
            ((m9b) this.c).shutdown();
        }
    }

    public synchronized void c() {
        if (this.a instanceof m9b) {
            ((m9b) this.a).start();
        }
        if (this.b instanceof m9b) {
            ((m9b) this.b).start();
        }
        if (this.c instanceof m9b) {
            ((m9b) this.c).start();
        }
    }

    public Schedulers() {
        wbb f = vbb.c().f();
        l7b g = f.g();
        if (g != null) {
            this.a = g;
        } else {
            this.a = wbb.a();
        }
        l7b i = f.i();
        if (i != null) {
            this.b = i;
        } else {
            this.b = wbb.c();
        }
        l7b j = f.j();
        if (j != null) {
            this.c = j;
        } else {
            this.c = wbb.e();
        }
    }

    public static l7b from(Executor executor) {
        return new h9b(executor);
    }
}
