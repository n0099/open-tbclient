package rx.schedulers;

import com.baidu.tieba.a3c;
import com.baidu.tieba.b1c;
import com.baidu.tieba.b3c;
import com.baidu.tieba.c3c;
import com.baidu.tieba.f3c;
import com.baidu.tieba.h3c;
import com.baidu.tieba.l5c;
import com.baidu.tieba.o5c;
import com.baidu.tieba.p5c;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class Schedulers {
    public static final AtomicReference<Schedulers> d = new AtomicReference<>();
    public final b1c a;
    public final b1c b;
    public final b1c c;

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

    public static b1c computation() {
        return l5c.f(a().a);
    }

    public static b1c immediate() {
        return c3c.a;
    }

    public static b1c io() {
        return l5c.k(a().b);
    }

    public static b1c newThread() {
        return l5c.l(a().c);
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
            b3c.d.shutdown();
        }
    }

    public static void start() {
        Schedulers a = a();
        a.c();
        synchronized (a) {
            b3c.d.start();
        }
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static b1c trampoline() {
        return h3c.a;
    }

    public synchronized void b() {
        if (this.a instanceof f3c) {
            ((f3c) this.a).shutdown();
        }
        if (this.b instanceof f3c) {
            ((f3c) this.b).shutdown();
        }
        if (this.c instanceof f3c) {
            ((f3c) this.c).shutdown();
        }
    }

    public synchronized void c() {
        if (this.a instanceof f3c) {
            ((f3c) this.a).start();
        }
        if (this.b instanceof f3c) {
            ((f3c) this.b).start();
        }
        if (this.c instanceof f3c) {
            ((f3c) this.c).start();
        }
    }

    public Schedulers() {
        p5c f = o5c.c().f();
        b1c g = f.g();
        if (g != null) {
            this.a = g;
        } else {
            this.a = p5c.a();
        }
        b1c i = f.i();
        if (i != null) {
            this.b = i;
        } else {
            this.b = p5c.c();
        }
        b1c j = f.j();
        if (j != null) {
            this.c = j;
        } else {
            this.c = p5c.e();
        }
    }

    public static b1c from(Executor executor) {
        return new a3c(executor);
    }
}
