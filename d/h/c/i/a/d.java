package d.h.c.i.a;

import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes6.dex */
public final class d {

    /* renamed from: c  reason: collision with root package name */
    public static final Logger f67203c = Logger.getLogger(d.class.getName());

    /* renamed from: a  reason: collision with root package name */
    public a f67204a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f67205b;

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final Runnable f67206a;

        /* renamed from: b  reason: collision with root package name */
        public final Executor f67207b;

        /* renamed from: c  reason: collision with root package name */
        public a f67208c;

        public a(Runnable runnable, Executor executor, a aVar) {
            this.f67206a = runnable;
            this.f67207b = executor;
            this.f67208c = aVar;
        }
    }

    public static void c(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e2) {
            Logger logger = f67203c;
            Level level = Level.SEVERE;
            logger.log(level, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e2);
        }
    }

    public void a(Runnable runnable, Executor executor) {
        d.h.c.a.n.q(runnable, "Runnable was null.");
        d.h.c.a.n.q(executor, "Executor was null.");
        synchronized (this) {
            if (!this.f67205b) {
                this.f67204a = new a(runnable, executor, this.f67204a);
            } else {
                c(runnable, executor);
            }
        }
    }

    public void b() {
        synchronized (this) {
            if (this.f67205b) {
                return;
            }
            this.f67205b = true;
            a aVar = this.f67204a;
            a aVar2 = null;
            this.f67204a = null;
            while (aVar != null) {
                a aVar3 = aVar.f67208c;
                aVar.f67208c = aVar2;
                aVar2 = aVar;
                aVar = aVar3;
            }
            while (aVar2 != null) {
                c(aVar2.f67206a, aVar2.f67207b);
                aVar2 = aVar2.f67208c;
            }
        }
    }
}
