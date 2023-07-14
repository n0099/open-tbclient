package rx.schedulers;

import com.baidu.tieba.b4c;
import com.baidu.tieba.d4c;
import com.baidu.tieba.h6c;
import com.baidu.tieba.k6c;
import com.baidu.tieba.l6c;
import com.baidu.tieba.w3c;
import com.baidu.tieba.x1c;
import com.baidu.tieba.x3c;
import com.baidu.tieba.y3c;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class Schedulers {
    public static final AtomicReference<Schedulers> d = new AtomicReference<>();
    public final x1c a;
    public final x1c b;
    public final x1c c;

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

    public static x1c computation() {
        return h6c.f(a().a);
    }

    public static x1c immediate() {
        return y3c.a;
    }

    public static x1c io() {
        return h6c.k(a().b);
    }

    public static x1c newThread() {
        return h6c.l(a().c);
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
            x3c.d.shutdown();
        }
    }

    public static void start() {
        Schedulers a = a();
        a.c();
        synchronized (a) {
            x3c.d.start();
        }
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static x1c trampoline() {
        return d4c.a;
    }

    public synchronized void b() {
        if (this.a instanceof b4c) {
            ((b4c) this.a).shutdown();
        }
        if (this.b instanceof b4c) {
            ((b4c) this.b).shutdown();
        }
        if (this.c instanceof b4c) {
            ((b4c) this.c).shutdown();
        }
    }

    public synchronized void c() {
        if (this.a instanceof b4c) {
            ((b4c) this.a).start();
        }
        if (this.b instanceof b4c) {
            ((b4c) this.b).start();
        }
        if (this.c instanceof b4c) {
            ((b4c) this.c).start();
        }
    }

    public Schedulers() {
        l6c f = k6c.c().f();
        x1c g = f.g();
        if (g != null) {
            this.a = g;
        } else {
            this.a = l6c.a();
        }
        x1c i = f.i();
        if (i != null) {
            this.b = i;
        } else {
            this.b = l6c.c();
        }
        x1c j = f.j();
        if (j != null) {
            this.c = j;
        } else {
            this.c = l6c.e();
        }
    }

    public static x1c from(Executor executor) {
        return new w3c(executor);
    }
}
