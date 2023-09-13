package rx.schedulers;

import com.baidu.tieba.adc;
import com.baidu.tieba.cdc;
import com.baidu.tieba.gfc;
import com.baidu.tieba.jfc;
import com.baidu.tieba.kfc;
import com.baidu.tieba.vac;
import com.baidu.tieba.vcc;
import com.baidu.tieba.wcc;
import com.baidu.tieba.xcc;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class Schedulers {
    public static final AtomicReference<Schedulers> d = new AtomicReference<>();
    public final vac a;
    public final vac b;
    public final vac c;

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

    public static vac computation() {
        return gfc.f(a().a);
    }

    public static vac immediate() {
        return xcc.a;
    }

    public static vac io() {
        return gfc.k(a().b);
    }

    public static vac newThread() {
        return gfc.l(a().c);
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
            wcc.d.shutdown();
        }
    }

    public static void start() {
        Schedulers a = a();
        a.c();
        synchronized (a) {
            wcc.d.start();
        }
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static vac trampoline() {
        return cdc.a;
    }

    public synchronized void b() {
        if (this.a instanceof adc) {
            ((adc) this.a).shutdown();
        }
        if (this.b instanceof adc) {
            ((adc) this.b).shutdown();
        }
        if (this.c instanceof adc) {
            ((adc) this.c).shutdown();
        }
    }

    public synchronized void c() {
        if (this.a instanceof adc) {
            ((adc) this.a).start();
        }
        if (this.b instanceof adc) {
            ((adc) this.b).start();
        }
        if (this.c instanceof adc) {
            ((adc) this.c).start();
        }
    }

    public Schedulers() {
        kfc f = jfc.c().f();
        vac g = f.g();
        if (g != null) {
            this.a = g;
        } else {
            this.a = kfc.a();
        }
        vac i = f.i();
        if (i != null) {
            this.b = i;
        } else {
            this.b = kfc.c();
        }
        vac j = f.j();
        if (j != null) {
            this.c = j;
        } else {
            this.c = kfc.e();
        }
    }

    public static vac from(Executor executor) {
        return new vcc(executor);
    }
}
