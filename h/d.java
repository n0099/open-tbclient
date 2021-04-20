package h;

import h.o.a.m;
import h.o.a.p;
import h.o.a.q;
import h.o.a.t;
import h.o.a.u;
import h.o.a.v;
import java.util.concurrent.TimeUnit;
import rx.exceptions.OnErrorFailedException;
import rx.functions.Actions;
import rx.internal.operators.EmptyObservableHolder;
import rx.internal.operators.NeverObservableHolder;
import rx.internal.operators.OnSubscribeFromIterable;
import rx.internal.operators.OperatorMerge;
import rx.internal.operators.OperatorReplay;
import rx.internal.util.InternalObservableUtils;
import rx.internal.util.ScalarSynchronousObservable;
import rx.internal.util.UtilityFunctions;
import rx.schedulers.Schedulers;
/* loaded from: classes7.dex */
public class d<T> {

    /* renamed from: e  reason: collision with root package name */
    public final a<T> f68686e;

    /* loaded from: classes7.dex */
    public interface a<T> extends h.n.b<j<? super T>> {
    }

    /* loaded from: classes7.dex */
    public interface b<R, T> extends h.n.f<j<? super R>, j<? super T>> {
    }

    public d(a<T> aVar) {
        this.f68686e = aVar;
    }

    public static <T> k C(j<? super T> jVar, d<T> dVar) {
        if (jVar != null) {
            if (dVar.f68686e != null) {
                jVar.onStart();
                if (!(jVar instanceof h.q.c)) {
                    jVar = new h.q.c(jVar);
                }
                try {
                    h.r.c.p(dVar, dVar.f68686e).call(jVar);
                    return h.r.c.o(jVar);
                } catch (Throwable th) {
                    h.m.a.e(th);
                    if (jVar.isUnsubscribed()) {
                        h.r.c.j(h.r.c.m(th));
                    } else {
                        try {
                            jVar.onError(h.r.c.m(th));
                        } catch (Throwable th2) {
                            h.m.a.e(th2);
                            OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                            h.r.c.m(onErrorFailedException);
                            throw onErrorFailedException;
                        }
                    }
                    return h.u.e.c();
                }
            }
            throw new IllegalStateException("onSubscribe function can not be null.");
        }
        throw new IllegalArgumentException("subscriber can not be null");
    }

    public static d<Long> J(long j, TimeUnit timeUnit) {
        return K(j, timeUnit, Schedulers.computation());
    }

    public static d<Long> K(long j, TimeUnit timeUnit, g gVar) {
        return c(new h.o.a.k(j, timeUnit, gVar));
    }

    public static <T> d<T> c(a<T> aVar) {
        return new d<>(h.r.c.h(aVar));
    }

    public static <T> d<T> f() {
        return EmptyObservableHolder.instance();
    }

    public static <T> d<T> i(Iterable<? extends T> iterable) {
        return c(new OnSubscribeFromIterable(iterable));
    }

    public static <T> d<T> j(T t) {
        return ScalarSynchronousObservable.M(t);
    }

    public static <T> d<T> m(Iterable<? extends d<? extends T>> iterable) {
        return n(i(iterable));
    }

    public static <T> d<T> n(d<? extends d<? extends T>> dVar) {
        if (dVar.getClass() == ScalarSynchronousObservable.class) {
            return ((ScalarSynchronousObservable) dVar).P(UtilityFunctions.b());
        }
        return (d<T>) dVar.k(OperatorMerge.b(false));
    }

    public static <T> d<T> o() {
        return NeverObservableHolder.instance();
    }

    public final k A(e<? super T> eVar) {
        if (eVar instanceof j) {
            return B((j) eVar);
        }
        if (eVar != null) {
            return B(new h.o.d.d(eVar));
        }
        throw new NullPointerException("observer is null");
    }

    public final k B(j<? super T> jVar) {
        return C(jVar, this);
    }

    public final k D(h.n.b<? super T> bVar) {
        if (bVar != null) {
            return B(new h.o.d.b(bVar, InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
        }
        throw new IllegalArgumentException("onNext can not be null");
    }

    public final k E(h.n.b<? super T> bVar, h.n.b<Throwable> bVar2) {
        if (bVar != null) {
            if (bVar2 != null) {
                return B(new h.o.d.b(bVar, bVar2, Actions.a()));
            }
            throw new IllegalArgumentException("onError can not be null");
        }
        throw new IllegalArgumentException("onNext can not be null");
    }

    public final d<T> F(g gVar) {
        if (this instanceof ScalarSynchronousObservable) {
            return ((ScalarSynchronousObservable) this).Q(gVar);
        }
        return c(new t(this, gVar));
    }

    public final d<T> G(h.n.f<? super T, Boolean> fVar) {
        return (d<T>) k(new u(fVar));
    }

    public final d<T> H(long j, TimeUnit timeUnit) {
        return I(j, timeUnit, null, Schedulers.computation());
    }

    public final d<T> I(long j, TimeUnit timeUnit, d<? extends T> dVar, g gVar) {
        return (d<T>) k(new v(j, timeUnit, dVar, gVar));
    }

    public final k L(j<? super T> jVar) {
        try {
            jVar.onStart();
            h.r.c.p(this, this.f68686e).call(jVar);
            return h.r.c.o(jVar);
        } catch (Throwable th) {
            h.m.a.e(th);
            try {
                jVar.onError(h.r.c.m(th));
                return h.u.e.c();
            } catch (Throwable th2) {
                h.m.a.e(th2);
                OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                h.r.c.m(onErrorFailedException);
                throw onErrorFailedException;
            }
        }
    }

    public final <R> d<R> a(Class<R> cls) {
        return k(new m(cls));
    }

    public final <R> d<R> b(h.n.f<? super T, ? extends d<? extends R>> fVar) {
        if (this instanceof ScalarSynchronousObservable) {
            return ((ScalarSynchronousObservable) this).P(fVar);
        }
        return c(new h.o.a.e(this, fVar, 2, 0));
    }

    public final d<T> d(h.n.b<? super Throwable> bVar) {
        return c(new h.o.a.f(this, new h.o.d.a(Actions.a(), bVar, Actions.a())));
    }

    public final d<T> e(h.n.b<? super T> bVar) {
        return c(new h.o.a.f(this, new h.o.d.a(bVar, Actions.a(), Actions.a())));
    }

    public final d<T> g(h.n.f<? super T, Boolean> fVar) {
        return c(new h.o.a.g(this, fVar));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: h.n.f<? super T, ? extends h.d<? extends R>> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <R> d<R> h(h.n.f<? super T, ? extends d<? extends R>> fVar) {
        if (getClass() == ScalarSynchronousObservable.class) {
            return ((ScalarSynchronousObservable) this).P(fVar);
        }
        return n(l(fVar));
    }

    public final <R> d<R> k(b<? extends R, ? super T> bVar) {
        return c(new h.o.a.h(this.f68686e, bVar));
    }

    public final <R> d<R> l(h.n.f<? super T, ? extends R> fVar) {
        return c(new h.o.a.i(this, fVar));
    }

    public final d<T> p(g gVar) {
        return q(gVar, h.o.d.g.f68945g);
    }

    public final d<T> q(g gVar, int i) {
        return r(gVar, false, i);
    }

    public final d<T> r(g gVar, boolean z, int i) {
        if (this instanceof ScalarSynchronousObservable) {
            return ((ScalarSynchronousObservable) this).Q(gVar);
        }
        return (d<T>) k(new p(gVar, z, i));
    }

    public final <R> d<R> s(Class<R> cls) {
        return g(InternalObservableUtils.isInstanceOf(cls)).a(cls);
    }

    public final d<T> t() {
        return (d<T>) k(q.b());
    }

    public final h.p.a<T> u() {
        return OperatorReplay.N(this);
    }

    public final h.p.a<T> v(int i) {
        return OperatorReplay.O(this, i);
    }

    public final h.p.a<T> w(int i, long j, TimeUnit timeUnit, g gVar) {
        if (i >= 0) {
            return OperatorReplay.Q(this, j, timeUnit, gVar, i);
        }
        throw new IllegalArgumentException("bufferSize < 0");
    }

    public final h.p.a<T> x(long j, TimeUnit timeUnit, g gVar) {
        return OperatorReplay.P(this, j, timeUnit, gVar);
    }

    public final d<T> y() {
        return h.o.a.j.b(this);
    }

    public final k z() {
        return B(new h.o.d.b(Actions.a(), InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
    }
}
