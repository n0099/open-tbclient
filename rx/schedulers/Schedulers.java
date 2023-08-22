package rx.schedulers;

import com.baidu.tieba.bcc;
import com.baidu.tieba.ecc;
import com.baidu.tieba.fcc;
import com.baidu.tieba.q7c;
import com.baidu.tieba.q9c;
import com.baidu.tieba.r9c;
import com.baidu.tieba.s9c;
import com.baidu.tieba.v9c;
import com.baidu.tieba.x9c;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class Schedulers {
    public static final AtomicReference<Schedulers> d = new AtomicReference<>();
    public final q7c a;
    public final q7c b;
    public final q7c c;

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

    public static q7c computation() {
        return bcc.f(a().a);
    }

    public static q7c immediate() {
        return s9c.a;
    }

    public static q7c io() {
        return bcc.k(a().b);
    }

    public static q7c newThread() {
        return bcc.l(a().c);
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
            r9c.d.shutdown();
        }
    }

    public static void start() {
        Schedulers a = a();
        a.c();
        synchronized (a) {
            r9c.d.start();
        }
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static q7c trampoline() {
        return x9c.a;
    }

    public synchronized void b() {
        if (this.a instanceof v9c) {
            ((v9c) this.a).shutdown();
        }
        if (this.b instanceof v9c) {
            ((v9c) this.b).shutdown();
        }
        if (this.c instanceof v9c) {
            ((v9c) this.c).shutdown();
        }
    }

    public synchronized void c() {
        if (this.a instanceof v9c) {
            ((v9c) this.a).start();
        }
        if (this.b instanceof v9c) {
            ((v9c) this.b).start();
        }
        if (this.c instanceof v9c) {
            ((v9c) this.c).start();
        }
    }

    public Schedulers() {
        fcc f = ecc.c().f();
        q7c g = f.g();
        if (g != null) {
            this.a = g;
        } else {
            this.a = fcc.a();
        }
        q7c i = f.i();
        if (i != null) {
            this.b = i;
        } else {
            this.b = fcc.c();
        }
        q7c j = f.j();
        if (j != null) {
            this.c = j;
        } else {
            this.c = fcc.e();
        }
    }

    public static q7c from(Executor executor) {
        return new q9c(executor);
    }
}
