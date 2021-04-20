package d.g.c.i.a;

import com.google.common.util.concurrent.AbstractFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes6.dex */
public abstract class k<V> implements l<V> {

    /* renamed from: e  reason: collision with root package name */
    public static final Logger f67065e = Logger.getLogger(k.class.getName());

    /* loaded from: classes6.dex */
    public static final class a<V> extends AbstractFuture.i<V> {
        public a(Throwable th) {
            B(th);
        }
    }

    /* loaded from: classes6.dex */
    public static class b<V> extends k<V> {

        /* renamed from: g  reason: collision with root package name */
        public static final b<Object> f67066g = new b<>(null);

        /* renamed from: f  reason: collision with root package name */
        public final V f67067f;

        public b(V v) {
            this.f67067f = v;
        }

        @Override // d.g.c.i.a.k, java.util.concurrent.Future
        public V get() {
            return this.f67067f;
        }

        public String toString() {
            return super.toString() + "[status=SUCCESS, result=[" + this.f67067f + "]]";
        }
    }

    @Override // d.g.c.i.a.l
    public void a(Runnable runnable, Executor executor) {
        d.g.c.a.n.q(runnable, "Runnable was null.");
        d.g.c.a.n.q(executor, "Executor was null.");
        try {
            executor.execute(runnable);
        } catch (RuntimeException e2) {
            Logger logger = f67065e;
            Level level = Level.SEVERE;
            logger.log(level, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e2);
        }
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        return false;
    }

    @Override // java.util.concurrent.Future
    public abstract V get() throws ExecutionException;

    @Override // java.util.concurrent.Future
    public V get(long j, TimeUnit timeUnit) throws ExecutionException {
        d.g.c.a.n.p(timeUnit);
        return get();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return true;
    }
}
