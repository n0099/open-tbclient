package rx.schedulers;

import com.baidu.tieba.dcc;
import com.baidu.tieba.gcc;
import com.baidu.tieba.hcc;
import com.baidu.tieba.s7c;
import com.baidu.tieba.s9c;
import com.baidu.tieba.t9c;
import com.baidu.tieba.u9c;
import com.baidu.tieba.x9c;
import com.baidu.tieba.z9c;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class Schedulers {
    public static final AtomicReference<Schedulers> d = new AtomicReference<>();
    public final s7c a;
    public final s7c b;
    public final s7c c;

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

    public static s7c computation() {
        return dcc.f(a().a);
    }

    public static s7c immediate() {
        return u9c.a;
    }

    public static s7c io() {
        return dcc.k(a().b);
    }

    public static s7c newThread() {
        return dcc.l(a().c);
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
            t9c.d.shutdown();
        }
    }

    public static void start() {
        Schedulers a = a();
        a.c();
        synchronized (a) {
            t9c.d.start();
        }
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static s7c trampoline() {
        return z9c.a;
    }

    public synchronized void b() {
        if (this.a instanceof x9c) {
            ((x9c) this.a).shutdown();
        }
        if (this.b instanceof x9c) {
            ((x9c) this.b).shutdown();
        }
        if (this.c instanceof x9c) {
            ((x9c) this.c).shutdown();
        }
    }

    public synchronized void c() {
        if (this.a instanceof x9c) {
            ((x9c) this.a).start();
        }
        if (this.b instanceof x9c) {
            ((x9c) this.b).start();
        }
        if (this.c instanceof x9c) {
            ((x9c) this.c).start();
        }
    }

    public Schedulers() {
        hcc f = gcc.c().f();
        s7c g = f.g();
        if (g != null) {
            this.a = g;
        } else {
            this.a = hcc.a();
        }
        s7c i = f.i();
        if (i != null) {
            this.b = i;
        } else {
            this.b = hcc.c();
        }
        s7c j = f.j();
        if (j != null) {
            this.c = j;
        } else {
            this.c = hcc.e();
        }
    }

    public static s7c from(Executor executor) {
        return new s9c(executor);
    }
}
