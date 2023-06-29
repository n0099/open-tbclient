package rx.schedulers;

import com.baidu.tieba.atb;
import com.baidu.tieba.avb;
import com.baidu.tieba.bvb;
import com.baidu.tieba.evb;
import com.baidu.tieba.gvb;
import com.baidu.tieba.kxb;
import com.baidu.tieba.nxb;
import com.baidu.tieba.oxb;
import com.baidu.tieba.zub;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class Schedulers {
    public static final AtomicReference<Schedulers> d = new AtomicReference<>();
    public final atb a;
    public final atb b;
    public final atb c;

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

    public static atb computation() {
        return kxb.f(a().a);
    }

    public static atb immediate() {
        return bvb.a;
    }

    public static atb io() {
        return kxb.k(a().b);
    }

    public static atb newThread() {
        return kxb.l(a().c);
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
            avb.d.shutdown();
        }
    }

    public static void start() {
        Schedulers a = a();
        a.c();
        synchronized (a) {
            avb.d.start();
        }
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static atb trampoline() {
        return gvb.a;
    }

    public synchronized void b() {
        if (this.a instanceof evb) {
            ((evb) this.a).shutdown();
        }
        if (this.b instanceof evb) {
            ((evb) this.b).shutdown();
        }
        if (this.c instanceof evb) {
            ((evb) this.c).shutdown();
        }
    }

    public synchronized void c() {
        if (this.a instanceof evb) {
            ((evb) this.a).start();
        }
        if (this.b instanceof evb) {
            ((evb) this.b).start();
        }
        if (this.c instanceof evb) {
            ((evb) this.c).start();
        }
    }

    public Schedulers() {
        oxb f = nxb.c().f();
        atb g = f.g();
        if (g != null) {
            this.a = g;
        } else {
            this.a = oxb.a();
        }
        atb i = f.i();
        if (i != null) {
            this.b = i;
        } else {
            this.b = oxb.c();
        }
        atb j = f.j();
        if (j != null) {
            this.c = j;
        } else {
            this.c = oxb.e();
        }
    }

    public static atb from(Executor executor) {
        return new zub(executor);
    }
}
