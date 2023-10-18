package rx.schedulers;

import com.baidu.tieba.abc;
import com.baidu.tieba.bbc;
import com.baidu.tieba.k6c;
import com.baidu.tieba.m8c;
import com.baidu.tieba.n8c;
import com.baidu.tieba.o8c;
import com.baidu.tieba.r8c;
import com.baidu.tieba.t8c;
import com.baidu.tieba.xac;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class Schedulers {
    public static final AtomicReference<Schedulers> d = new AtomicReference<>();
    public final k6c a;
    public final k6c b;
    public final k6c c;

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

    public static k6c computation() {
        return xac.f(a().a);
    }

    public static k6c immediate() {
        return o8c.a;
    }

    public static k6c io() {
        return xac.k(a().b);
    }

    public static k6c newThread() {
        return xac.l(a().c);
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
            n8c.d.shutdown();
        }
    }

    public static void start() {
        Schedulers a = a();
        a.c();
        synchronized (a) {
            n8c.d.start();
        }
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static k6c trampoline() {
        return t8c.a;
    }

    public synchronized void b() {
        if (this.a instanceof r8c) {
            ((r8c) this.a).shutdown();
        }
        if (this.b instanceof r8c) {
            ((r8c) this.b).shutdown();
        }
        if (this.c instanceof r8c) {
            ((r8c) this.c).shutdown();
        }
    }

    public synchronized void c() {
        if (this.a instanceof r8c) {
            ((r8c) this.a).start();
        }
        if (this.b instanceof r8c) {
            ((r8c) this.b).start();
        }
        if (this.c instanceof r8c) {
            ((r8c) this.c).start();
        }
    }

    public Schedulers() {
        bbc f = abc.c().f();
        k6c g = f.g();
        if (g != null) {
            this.a = g;
        } else {
            this.a = bbc.a();
        }
        k6c i = f.i();
        if (i != null) {
            this.b = i;
        } else {
            this.b = bbc.c();
        }
        k6c j = f.j();
        if (j != null) {
            this.c = j;
        } else {
            this.c = bbc.e();
        }
    }

    public static k6c from(Executor executor) {
        return new m8c(executor);
    }
}
