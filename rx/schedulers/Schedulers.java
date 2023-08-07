package rx.schedulers;

import com.baidu.tieba.a1c;
import com.baidu.tieba.a3c;
import com.baidu.tieba.b3c;
import com.baidu.tieba.e3c;
import com.baidu.tieba.g3c;
import com.baidu.tieba.k5c;
import com.baidu.tieba.n5c;
import com.baidu.tieba.o5c;
import com.baidu.tieba.z2c;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class Schedulers {
    public static final AtomicReference<Schedulers> d = new AtomicReference<>();
    public final a1c a;
    public final a1c b;
    public final a1c c;

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

    public static a1c computation() {
        return k5c.f(a().a);
    }

    public static a1c immediate() {
        return b3c.a;
    }

    public static a1c io() {
        return k5c.k(a().b);
    }

    public static a1c newThread() {
        return k5c.l(a().c);
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
            a3c.d.shutdown();
        }
    }

    public static void start() {
        Schedulers a = a();
        a.c();
        synchronized (a) {
            a3c.d.start();
        }
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static a1c trampoline() {
        return g3c.a;
    }

    public synchronized void b() {
        if (this.a instanceof e3c) {
            ((e3c) this.a).shutdown();
        }
        if (this.b instanceof e3c) {
            ((e3c) this.b).shutdown();
        }
        if (this.c instanceof e3c) {
            ((e3c) this.c).shutdown();
        }
    }

    public synchronized void c() {
        if (this.a instanceof e3c) {
            ((e3c) this.a).start();
        }
        if (this.b instanceof e3c) {
            ((e3c) this.b).start();
        }
        if (this.c instanceof e3c) {
            ((e3c) this.c).start();
        }
    }

    public Schedulers() {
        o5c f = n5c.c().f();
        a1c g = f.g();
        if (g != null) {
            this.a = g;
        } else {
            this.a = o5c.a();
        }
        a1c i = f.i();
        if (i != null) {
            this.b = i;
        } else {
            this.b = o5c.c();
        }
        a1c j = f.j();
        if (j != null) {
            this.c = j;
        } else {
            this.c = o5c.e();
        }
    }

    public static a1c from(Executor executor) {
        return new z2c(executor);
    }
}
