package d.g.c.i.a;

import d.g.c.a.j;
import d.g.c.i.a.k;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
/* loaded from: classes6.dex */
public final class g extends j {

    /* loaded from: classes6.dex */
    public static final class a<V> implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final Future<V> f65625e;

        /* renamed from: f  reason: collision with root package name */
        public final f<? super V> f65626f;

        public a(Future<V> future, f<? super V> fVar) {
            this.f65625e = future;
            this.f65626f = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f65626f.onSuccess(g.b(this.f65625e));
            } catch (Error e2) {
                e = e2;
                this.f65626f.onFailure(e);
            } catch (RuntimeException e3) {
                e = e3;
                this.f65626f.onFailure(e);
            } catch (ExecutionException e4) {
                this.f65626f.onFailure(e4.getCause());
            }
        }

        public String toString() {
            j.b b2 = d.g.c.a.j.b(this);
            b2.h(this.f65626f);
            return b2.toString();
        }
    }

    public static <V> void a(l<V> lVar, f<? super V> fVar, Executor executor) {
        d.g.c.a.n.p(fVar);
        lVar.a(new a(lVar, fVar), executor);
    }

    public static <V> V b(Future<V> future) throws ExecutionException {
        d.g.c.a.n.A(future.isDone(), "Future was expected to be done: %s", future);
        return (V) t.a(future);
    }

    public static <V> l<V> c(Throwable th) {
        d.g.c.a.n.p(th);
        return new k.a(th);
    }

    public static <V> l<V> d(V v) {
        if (v == null) {
            return k.b.f65629g;
        }
        return new k.b(v);
    }

    public static <I, O> l<O> e(l<I> lVar, d.g.c.a.g<? super I, ? extends O> gVar, Executor executor) {
        return d.g.c.i.a.a.F(lVar, gVar, executor);
    }
}
