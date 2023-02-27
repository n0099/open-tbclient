package rx.schedulers;

import com.baidu.tieba.cra;
import com.baidu.tieba.dra;
import com.baidu.tieba.ooa;
import com.baidu.tieba.poa;
import com.baidu.tieba.qoa;
import com.baidu.tieba.toa;
import com.baidu.tieba.vma;
import com.baidu.tieba.voa;
import com.baidu.tieba.zqa;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes9.dex */
public final class Schedulers {
    public static final AtomicReference<Schedulers> d = new AtomicReference<>();
    public final vma a;
    public final vma b;
    public final vma c;

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

    public static vma computation() {
        return zqa.f(a().a);
    }

    public static vma immediate() {
        return qoa.a;
    }

    public static vma io() {
        return zqa.k(a().b);
    }

    public static vma newThread() {
        return zqa.l(a().c);
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
            poa.d.shutdown();
        }
    }

    public static void start() {
        Schedulers a = a();
        a.c();
        synchronized (a) {
            poa.d.start();
        }
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static vma trampoline() {
        return voa.a;
    }

    public synchronized void b() {
        if (this.a instanceof toa) {
            ((toa) this.a).shutdown();
        }
        if (this.b instanceof toa) {
            ((toa) this.b).shutdown();
        }
        if (this.c instanceof toa) {
            ((toa) this.c).shutdown();
        }
    }

    public synchronized void c() {
        if (this.a instanceof toa) {
            ((toa) this.a).start();
        }
        if (this.b instanceof toa) {
            ((toa) this.b).start();
        }
        if (this.c instanceof toa) {
            ((toa) this.c).start();
        }
    }

    public Schedulers() {
        dra f = cra.c().f();
        vma g = f.g();
        if (g != null) {
            this.a = g;
        } else {
            this.a = dra.a();
        }
        vma i = f.i();
        if (i != null) {
            this.b = i;
        } else {
            this.b = dra.c();
        }
        vma j = f.j();
        if (j != null) {
            this.c = j;
        } else {
            this.c = dra.e();
        }
    }

    public static vma from(Executor executor) {
        return new ooa(executor);
    }
}
