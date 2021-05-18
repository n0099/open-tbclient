package d.g.c.i.a;

import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes6.dex */
public final class d {

    /* renamed from: c  reason: collision with root package name */
    public static final Logger f66305c = Logger.getLogger(d.class.getName());

    /* renamed from: a  reason: collision with root package name */
    public a f66306a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f66307b;

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final Runnable f66308a;

        /* renamed from: b  reason: collision with root package name */
        public final Executor f66309b;

        /* renamed from: c  reason: collision with root package name */
        public a f66310c;

        public a(Runnable runnable, Executor executor, a aVar) {
            this.f66308a = runnable;
            this.f66309b = executor;
            this.f66310c = aVar;
        }
    }

    public static void c(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e2) {
            Logger logger = f66305c;
            Level level = Level.SEVERE;
            logger.log(level, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e2);
        }
    }

    public void a(Runnable runnable, Executor executor) {
        d.g.c.a.n.q(runnable, "Runnable was null.");
        d.g.c.a.n.q(executor, "Executor was null.");
        synchronized (this) {
            if (!this.f66307b) {
                this.f66306a = new a(runnable, executor, this.f66306a);
            } else {
                c(runnable, executor);
            }
        }
    }

    public void b() {
        synchronized (this) {
            if (this.f66307b) {
                return;
            }
            this.f66307b = true;
            a aVar = this.f66306a;
            a aVar2 = null;
            this.f66306a = null;
            while (aVar != null) {
                a aVar3 = aVar.f66310c;
                aVar.f66310c = aVar2;
                aVar2 = aVar;
                aVar = aVar3;
            }
            while (aVar2 != null) {
                c(aVar2.f66308a, aVar2.f66309b);
                aVar2 = aVar2.f66310c;
            }
        }
    }
}
