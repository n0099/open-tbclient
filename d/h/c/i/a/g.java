package d.h.c.i.a;

import d.h.c.a.j;
import d.h.c.i.a.k;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
/* loaded from: classes6.dex */
public final class g extends j {

    /* loaded from: classes6.dex */
    public static final class a<V> implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final Future<V> f67209e;

        /* renamed from: f  reason: collision with root package name */
        public final f<? super V> f67210f;

        public a(Future<V> future, f<? super V> fVar) {
            this.f67209e = future;
            this.f67210f = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f67210f.onSuccess(g.b(this.f67209e));
            } catch (Error e2) {
                e = e2;
                this.f67210f.onFailure(e);
            } catch (RuntimeException e3) {
                e = e3;
                this.f67210f.onFailure(e);
            } catch (ExecutionException e4) {
                this.f67210f.onFailure(e4.getCause());
            }
        }

        public String toString() {
            j.b b2 = d.h.c.a.j.b(this);
            b2.h(this.f67210f);
            return b2.toString();
        }
    }

    public static <V> void a(l<V> lVar, f<? super V> fVar, Executor executor) {
        d.h.c.a.n.p(fVar);
        lVar.a(new a(lVar, fVar), executor);
    }

    public static <V> V b(Future<V> future) throws ExecutionException {
        d.h.c.a.n.A(future.isDone(), "Future was expected to be done: %s", future);
        return (V) t.a(future);
    }

    public static <V> l<V> c(Throwable th) {
        d.h.c.a.n.p(th);
        return new k.a(th);
    }

    public static <V> l<V> d(V v) {
        if (v == null) {
            return k.b.f67213g;
        }
        return new k.b(v);
    }

    public static <I, O> l<O> e(l<I> lVar, d.h.c.a.g<? super I, ? extends O> gVar, Executor executor) {
        return d.h.c.i.a.a.F(lVar, gVar, executor);
    }
}
