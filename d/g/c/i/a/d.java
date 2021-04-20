package d.g.c.i.a;

import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes6.dex */
public final class d {

    /* renamed from: c  reason: collision with root package name */
    public static final Logger f67056c = Logger.getLogger(d.class.getName());

    /* renamed from: a  reason: collision with root package name */
    public a f67057a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f67058b;

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final Runnable f67059a;

        /* renamed from: b  reason: collision with root package name */
        public final Executor f67060b;

        /* renamed from: c  reason: collision with root package name */
        public a f67061c;

        public a(Runnable runnable, Executor executor, a aVar) {
            this.f67059a = runnable;
            this.f67060b = executor;
            this.f67061c = aVar;
        }
    }

    public static void c(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e2) {
            Logger logger = f67056c;
            Level level = Level.SEVERE;
            logger.log(level, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e2);
        }
    }

    public void a(Runnable runnable, Executor executor) {
        d.g.c.a.n.q(runnable, "Runnable was null.");
        d.g.c.a.n.q(executor, "Executor was null.");
        synchronized (this) {
            if (!this.f67058b) {
                this.f67057a = new a(runnable, executor, this.f67057a);
            } else {
                c(runnable, executor);
            }
        }
    }

    public void b() {
        synchronized (this) {
            if (this.f67058b) {
                return;
            }
            this.f67058b = true;
            a aVar = this.f67057a;
            a aVar2 = null;
            this.f67057a = null;
            while (aVar != null) {
                a aVar3 = aVar.f67061c;
                aVar.f67061c = aVar2;
                aVar2 = aVar;
                aVar = aVar3;
            }
            while (aVar2 != null) {
                c(aVar2.f67059a, aVar2.f67060b);
                aVar2 = aVar2.f67061c;
            }
        }
    }
}
