package d.g.c.i.a;

import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes6.dex */
public final class d {

    /* renamed from: c  reason: collision with root package name */
    public static final Logger f70079c = Logger.getLogger(d.class.getName());

    /* renamed from: a  reason: collision with root package name */
    public a f70080a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f70081b;

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final Runnable f70082a;

        /* renamed from: b  reason: collision with root package name */
        public final Executor f70083b;

        /* renamed from: c  reason: collision with root package name */
        public a f70084c;

        public a(Runnable runnable, Executor executor, a aVar) {
            this.f70082a = runnable;
            this.f70083b = executor;
            this.f70084c = aVar;
        }
    }

    public static void c(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e2) {
            Logger logger = f70079c;
            Level level = Level.SEVERE;
            logger.log(level, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e2);
        }
    }

    public void a(Runnable runnable, Executor executor) {
        d.g.c.a.n.q(runnable, "Runnable was null.");
        d.g.c.a.n.q(executor, "Executor was null.");
        synchronized (this) {
            if (!this.f70081b) {
                this.f70080a = new a(runnable, executor, this.f70080a);
            } else {
                c(runnable, executor);
            }
        }
    }

    public void b() {
        synchronized (this) {
            if (this.f70081b) {
                return;
            }
            this.f70081b = true;
            a aVar = this.f70080a;
            a aVar2 = null;
            this.f70080a = null;
            while (aVar != null) {
                a aVar3 = aVar.f70084c;
                aVar.f70084c = aVar2;
                aVar2 = aVar;
                aVar = aVar3;
            }
            while (aVar2 != null) {
                c(aVar2.f70082a, aVar2.f70083b);
                aVar2 = aVar2.f70084c;
            }
        }
    }
}
