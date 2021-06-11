package d.g.c.i.a;

import d.g.c.i.a.e;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
/* loaded from: classes6.dex */
public abstract class a<I, O, F, T> extends e.a<O> implements Runnable {
    public l<? extends I> l;
    public F m;

    /* renamed from: d.g.c.i.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C1912a<I, O> extends a<I, O, d.g.c.a.g<? super I, ? extends O>, O> {
        public C1912a(l<? extends I> lVar, d.g.c.a.g<? super I, ? extends O> gVar) {
            super(lVar, gVar);
        }

        @Override // d.g.c.i.a.a
        public void H(O o) {
            A(o);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: I */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // d.g.c.i.a.a
        /* renamed from: I */
        public O G(d.g.c.a.g<? super I, ? extends O> gVar, I i2) {
            return gVar.apply(i2);
        }
    }

    public a(l<? extends I> lVar, F f2) {
        d.g.c.a.n.p(lVar);
        this.l = lVar;
        d.g.c.a.n.p(f2);
        this.m = f2;
    }

    public static <I, O> l<O> F(l<I> lVar, d.g.c.a.g<? super I, ? extends O> gVar, Executor executor) {
        d.g.c.a.n.p(gVar);
        C1912a c1912a = new C1912a(lVar, gVar);
        lVar.a(c1912a, n.b(executor, c1912a));
        return c1912a;
    }

    public abstract T G(F f2, I i2) throws Exception;

    public abstract void H(T t);

    @Override // com.google.common.util.concurrent.AbstractFuture
    public final void n() {
        w(this.l);
        this.l = null;
        this.m = null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: d.g.c.i.a.a<I, O, F, T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        l<? extends I> lVar = this.l;
        F f2 = this.m;
        if ((isCancelled() | (lVar == null)) || (f2 == null)) {
            return;
        }
        this.l = null;
        if (lVar.isCancelled()) {
            C(lVar);
            return;
        }
        try {
            try {
                Object G = G(f2, g.b(lVar));
                this.m = null;
                H(G);
            } catch (Throwable th) {
                try {
                    B(th);
                } finally {
                    this.m = null;
                }
            }
        } catch (Error e2) {
            B(e2);
        } catch (CancellationException unused) {
            cancel(false);
        } catch (RuntimeException e3) {
            B(e3);
        } catch (ExecutionException e4) {
            B(e4.getCause());
        }
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public String x() {
        String str;
        l<? extends I> lVar = this.l;
        F f2 = this.m;
        String x = super.x();
        if (lVar != null) {
            str = "inputFuture=[" + lVar + "], ";
        } else {
            str = "";
        }
        if (f2 != null) {
            return str + "function=[" + f2 + "]";
        } else if (x != null) {
            return str + x;
        } else {
            return null;
        }
    }
}
