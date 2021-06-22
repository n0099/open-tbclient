package d.g.c.i.a;

import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes6.dex */
public final class d {

    /* renamed from: c  reason: collision with root package name */
    public static final Logger f70183c = Logger.getLogger(d.class.getName());

    /* renamed from: a  reason: collision with root package name */
    public a f70184a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f70185b;

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final Runnable f70186a;

        /* renamed from: b  reason: collision with root package name */
        public final Executor f70187b;

        /* renamed from: c  reason: collision with root package name */
        public a f70188c;

        public a(Runnable runnable, Executor executor, a aVar) {
            this.f70186a = runnable;
            this.f70187b = executor;
            this.f70188c = aVar;
        }
    }

    public static void c(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e2) {
            Logger logger = f70183c;
            Level level = Level.SEVERE;
            logger.log(level, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e2);
        }
    }

    public void a(Runnable runnable, Executor executor) {
        d.g.c.a.n.q(runnable, "Runnable was null.");
        d.g.c.a.n.q(executor, "Executor was null.");
        synchronized (this) {
            if (!this.f70185b) {
                this.f70184a = new a(runnable, executor, this.f70184a);
            } else {
                c(runnable, executor);
            }
        }
    }

    public void b() {
        synchronized (this) {
            if (this.f70185b) {
                return;
            }
            this.f70185b = true;
            a aVar = this.f70184a;
            a aVar2 = null;
            this.f70184a = null;
            while (aVar != null) {
                a aVar3 = aVar.f70188c;
                aVar.f70188c = aVar2;
                aVar2 = aVar;
                aVar = aVar3;
            }
            while (aVar2 != null) {
                c(aVar2.f70186a, aVar2.f70187b);
                aVar2 = aVar2.f70188c;
            }
        }
    }
}
