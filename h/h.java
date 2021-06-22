package h;

import h.o.a.a0;
import h.o.a.v;
import h.o.a.w;
import h.o.a.z;
import java.util.concurrent.TimeUnit;
import rx.functions.Actions;
import rx.schedulers.Schedulers;
/* loaded from: classes8.dex */
public class h<T> {

    /* renamed from: a  reason: collision with root package name */
    public final c<T> f71786a;

    /* loaded from: classes8.dex */
    public class a extends i<T> {

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ h.n.b f71787f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ h.n.b f71788g;

        public a(h hVar, h.n.b bVar, h.n.b bVar2) {
            this.f71787f = bVar;
            this.f71788g = bVar2;
        }

        @Override // h.i
        public final void b(Throwable th) {
            try {
                this.f71787f.call(th);
            } finally {
                unsubscribe();
            }
        }

        @Override // h.i
        public final void c(T t) {
            try {
                this.f71788g.call(t);
            } finally {
                unsubscribe();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements h.n.b<Throwable> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h.n.b f71789e;

        public b(h hVar, h.n.b bVar) {
            this.f71789e = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(Throwable th) {
            this.f71789e.call(th);
        }
    }

    /* loaded from: classes8.dex */
    public interface c<T> extends h.n.b<i<? super T>> {
    }

    public h(c<T> cVar) {
        this.f71786a = h.r.c.i(cVar);
    }

    public static <T> d<T> a(h<T> hVar) {
        return d.b(new a0(hVar.f71786a));
    }

    public static <T> h<T> b(c<T> cVar) {
        return new h<>(cVar);
    }

    public static <T> h<T> g(T t) {
        return h.o.d.g.m(t);
    }

    public final h<T> c(long j, TimeUnit timeUnit) {
        return d(j, timeUnit, Schedulers.computation());
    }

    public final h<T> d(long j, TimeUnit timeUnit, g gVar) {
        return b(new v(this.f71786a, j, timeUnit, gVar));
    }

    public final h<T> e(h.n.b<Throwable> bVar) {
        if (bVar != null) {
            return b(new w(this, Actions.a(), new b(this, bVar)));
        }
        throw new IllegalArgumentException("onError is null");
    }

    public final h<T> f(h.n.b<? super T> bVar) {
        if (bVar != null) {
            return b(new w(this, bVar, Actions.a()));
        }
        throw new IllegalArgumentException("onSuccess is null");
    }

    public final h<T> h(g gVar) {
        if (this instanceof h.o.d.g) {
            return ((h.o.d.g) this).n(gVar);
        }
        if (gVar != null) {
            return b(new z(this.f71786a, gVar));
        }
        throw new NullPointerException("scheduler is null");
    }

    public final k i() {
        return k(Actions.a(), Actions.b());
    }

    public final k j(i<? super T> iVar) {
        if (iVar != null) {
            try {
                h.r.c.t(this, this.f71786a).call(iVar);
                return h.r.c.s(iVar);
            } catch (Throwable th) {
                h.m.a.e(th);
                try {
                    iVar.b(h.r.c.r(th));
                    return h.u.e.b();
                } catch (Throwable th2) {
                    h.m.a.e(th2);
                    RuntimeException runtimeException = new RuntimeException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                    h.r.c.r(runtimeException);
                    throw runtimeException;
                }
            }
        }
        throw new IllegalArgumentException("te is null");
    }

    public final k k(h.n.b<? super T> bVar, h.n.b<Throwable> bVar2) {
        if (bVar != null) {
            if (bVar2 != null) {
                return j(new a(this, bVar2, bVar));
            }
            throw new IllegalArgumentException("onError can not be null");
        }
        throw new IllegalArgumentException("onSuccess can not be null");
    }

    public final d<T> l() {
        return a(this);
    }
}
