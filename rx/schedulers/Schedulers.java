package rx.schedulers;

import com.baidu.tieba.boc;
import com.baidu.tieba.coc;
import com.baidu.tieba.ljc;
import com.baidu.tieba.nlc;
import com.baidu.tieba.olc;
import com.baidu.tieba.plc;
import com.baidu.tieba.slc;
import com.baidu.tieba.ulc;
import com.baidu.tieba.ync;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class Schedulers {
    public static final AtomicReference<Schedulers> d = new AtomicReference<>();
    public final ljc a;
    public final ljc b;
    public final ljc c;

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

    public static ljc computation() {
        return ync.f(a().a);
    }

    public static ljc immediate() {
        return plc.a;
    }

    public static ljc io() {
        return ync.k(a().b);
    }

    public static ljc newThread() {
        return ync.l(a().c);
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
            olc.d.shutdown();
        }
    }

    public static void start() {
        Schedulers a = a();
        a.c();
        synchronized (a) {
            olc.d.start();
        }
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static ljc trampoline() {
        return ulc.a;
    }

    public synchronized void b() {
        if (this.a instanceof slc) {
            ((slc) this.a).shutdown();
        }
        if (this.b instanceof slc) {
            ((slc) this.b).shutdown();
        }
        if (this.c instanceof slc) {
            ((slc) this.c).shutdown();
        }
    }

    public synchronized void c() {
        if (this.a instanceof slc) {
            ((slc) this.a).start();
        }
        if (this.b instanceof slc) {
            ((slc) this.b).start();
        }
        if (this.c instanceof slc) {
            ((slc) this.c).start();
        }
    }

    public Schedulers() {
        coc f = boc.c().f();
        ljc g = f.g();
        if (g != null) {
            this.a = g;
        } else {
            this.a = coc.a();
        }
        ljc i = f.i();
        if (i != null) {
            this.b = i;
        } else {
            this.b = coc.c();
        }
        ljc j = f.j();
        if (j != null) {
            this.c = j;
        } else {
            this.c = coc.e();
        }
    }

    public static ljc from(Executor executor) {
        return new nlc(executor);
    }
}
