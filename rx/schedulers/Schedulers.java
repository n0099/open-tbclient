package rx.schedulers;

import com.baidu.tieba.g9b;
import com.baidu.tieba.h9b;
import com.baidu.tieba.i9b;
import com.baidu.tieba.k7b;
import com.baidu.tieba.l9b;
import com.baidu.tieba.n9b;
import com.baidu.tieba.rbb;
import com.baidu.tieba.ubb;
import com.baidu.tieba.vbb;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes10.dex */
public final class Schedulers {
    public static final AtomicReference<Schedulers> d = new AtomicReference<>();
    public final k7b a;
    public final k7b b;
    public final k7b c;

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

    public static k7b computation() {
        return rbb.f(a().a);
    }

    public static k7b immediate() {
        return i9b.a;
    }

    public static k7b io() {
        return rbb.k(a().b);
    }

    public static k7b newThread() {
        return rbb.l(a().c);
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
            h9b.d.shutdown();
        }
    }

    public static void start() {
        Schedulers a = a();
        a.c();
        synchronized (a) {
            h9b.d.start();
        }
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static k7b trampoline() {
        return n9b.a;
    }

    public synchronized void b() {
        if (this.a instanceof l9b) {
            ((l9b) this.a).shutdown();
        }
        if (this.b instanceof l9b) {
            ((l9b) this.b).shutdown();
        }
        if (this.c instanceof l9b) {
            ((l9b) this.c).shutdown();
        }
    }

    public synchronized void c() {
        if (this.a instanceof l9b) {
            ((l9b) this.a).start();
        }
        if (this.b instanceof l9b) {
            ((l9b) this.b).start();
        }
        if (this.c instanceof l9b) {
            ((l9b) this.c).start();
        }
    }

    public Schedulers() {
        vbb f = ubb.c().f();
        k7b g = f.g();
        if (g != null) {
            this.a = g;
        } else {
            this.a = vbb.a();
        }
        k7b i = f.i();
        if (i != null) {
            this.b = i;
        } else {
            this.b = vbb.c();
        }
        k7b j = f.j();
        if (j != null) {
            this.c = j;
        } else {
            this.c = vbb.e();
        }
    }

    public static k7b from(Executor executor) {
        return new g9b(executor);
    }
}
