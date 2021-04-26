package d.g.c.i.a;

import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes6.dex */
public final class d {

    /* renamed from: c  reason: collision with root package name */
    public static final Logger f65619c = Logger.getLogger(d.class.getName());

    /* renamed from: a  reason: collision with root package name */
    public a f65620a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f65621b;

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final Runnable f65622a;

        /* renamed from: b  reason: collision with root package name */
        public final Executor f65623b;

        /* renamed from: c  reason: collision with root package name */
        public a f65624c;

        public a(Runnable runnable, Executor executor, a aVar) {
            this.f65622a = runnable;
            this.f65623b = executor;
            this.f65624c = aVar;
        }
    }

    public static void c(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e2) {
            Logger logger = f65619c;
            Level level = Level.SEVERE;
            logger.log(level, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e2);
        }
    }

    public void a(Runnable runnable, Executor executor) {
        d.g.c.a.n.q(runnable, "Runnable was null.");
        d.g.c.a.n.q(executor, "Executor was null.");
        synchronized (this) {
            if (!this.f65621b) {
                this.f65620a = new a(runnable, executor, this.f65620a);
            } else {
                c(runnable, executor);
            }
        }
    }

    public void b() {
        synchronized (this) {
            if (this.f65621b) {
                return;
            }
            this.f65621b = true;
            a aVar = this.f65620a;
            a aVar2 = null;
            this.f65620a = null;
            while (aVar != null) {
                a aVar3 = aVar.f65624c;
                aVar.f65624c = aVar2;
                aVar2 = aVar;
                aVar = aVar3;
            }
            while (aVar2 != null) {
                c(aVar2.f65622a, aVar2.f65623b);
                aVar2 = aVar2.f65624c;
            }
        }
    }
}
