package rx.schedulers;

import com.baidu.tieba.coc;
import com.baidu.tieba.doc;
import com.baidu.tieba.mjc;
import com.baidu.tieba.olc;
import com.baidu.tieba.plc;
import com.baidu.tieba.qlc;
import com.baidu.tieba.tlc;
import com.baidu.tieba.vlc;
import com.baidu.tieba.znc;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
public final class Schedulers {
    public static final AtomicReference<Schedulers> d = new AtomicReference<>();
    public final mjc a;
    public final mjc b;
    public final mjc c;

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

    public static mjc computation() {
        return znc.f(a().a);
    }

    public static mjc immediate() {
        return qlc.a;
    }

    public static mjc io() {
        return znc.k(a().b);
    }

    public static mjc newThread() {
        return znc.l(a().c);
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
            plc.d.shutdown();
        }
    }

    public static void start() {
        Schedulers a = a();
        a.c();
        synchronized (a) {
            plc.d.start();
        }
    }

    public static TestScheduler test() {
        return new TestScheduler();
    }

    public static mjc trampoline() {
        return vlc.a;
    }

    public synchronized void b() {
        if (this.a instanceof tlc) {
            ((tlc) this.a).shutdown();
        }
        if (this.b instanceof tlc) {
            ((tlc) this.b).shutdown();
        }
        if (this.c instanceof tlc) {
            ((tlc) this.c).shutdown();
        }
    }

    public synchronized void c() {
        if (this.a instanceof tlc) {
            ((tlc) this.a).start();
        }
        if (this.b instanceof tlc) {
            ((tlc) this.b).start();
        }
        if (this.c instanceof tlc) {
            ((tlc) this.c).start();
        }
    }

    public Schedulers() {
        doc f = coc.c().f();
        mjc g = f.g();
        if (g != null) {
            this.a = g;
        } else {
            this.a = doc.a();
        }
        mjc i = f.i();
        if (i != null) {
            this.b = i;
        } else {
            this.b = doc.c();
        }
        mjc j = f.j();
        if (j != null) {
            this.c = j;
        } else {
            this.c = doc.e();
        }
    }

    public static mjc from(Executor executor) {
        return new olc(executor);
    }
}
