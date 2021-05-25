package d.g.c.i.a;

import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes6.dex */
public final class d {

    /* renamed from: c  reason: collision with root package name */
    public static final Logger f66348c = Logger.getLogger(d.class.getName());

    /* renamed from: a  reason: collision with root package name */
    public a f66349a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f66350b;

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final Runnable f66351a;

        /* renamed from: b  reason: collision with root package name */
        public final Executor f66352b;

        /* renamed from: c  reason: collision with root package name */
        public a f66353c;

        public a(Runnable runnable, Executor executor, a aVar) {
            this.f66351a = runnable;
            this.f66352b = executor;
            this.f66353c = aVar;
        }
    }

    public static void c(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e2) {
            Logger logger = f66348c;
            Level level = Level.SEVERE;
            logger.log(level, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e2);
        }
    }

    public void a(Runnable runnable, Executor executor) {
        d.g.c.a.n.q(runnable, "Runnable was null.");
        d.g.c.a.n.q(executor, "Executor was null.");
        synchronized (this) {
            if (!this.f66350b) {
                this.f66349a = new a(runnable, executor, this.f66349a);
            } else {
                c(runnable, executor);
            }
        }
    }

    public void b() {
        synchronized (this) {
            if (this.f66350b) {
                return;
            }
            this.f66350b = true;
            a aVar = this.f66349a;
            a aVar2 = null;
            this.f66349a = null;
            while (aVar != null) {
                a aVar3 = aVar.f66353c;
                aVar.f66353c = aVar2;
                aVar2 = aVar;
                aVar = aVar3;
            }
            while (aVar2 != null) {
                c(aVar2.f66351a, aVar2.f66352b);
                aVar2 = aVar2.f66353c;
            }
        }
    }
}
