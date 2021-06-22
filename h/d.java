package h;

import h.o.a.l;
import h.o.a.o;
import h.o.a.p;
import h.o.a.s;
import h.o.a.t;
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
/* loaded from: classes8.dex */
public class d<T> {

    /* renamed from: e  reason: collision with root package name */
    public final a<T> f71785e;

    /* loaded from: classes8.dex */
    public interface a<T> extends h.n.b<j<? super T>> {
    }

    /* loaded from: classes8.dex */
    public interface b<R, T> extends h.n.f<j<? super R>, j<? super T>> {
    }

    public d(a<T> aVar) {
        this.f71785e = aVar;
    }

    public static <T> k A(j<? super T> jVar, d<T> dVar) {
        if (jVar != null) {
            if (dVar.f71785e != null) {
                jVar.onStart();
                if (!(jVar instanceof h.q.c)) {
                    jVar = new h.q.c(jVar);
                }
                try {
                    h.r.c.p(dVar, dVar.f71785e).call(jVar);
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

    public static d<Long> G(long j, TimeUnit timeUnit) {
        return H(j, timeUnit, Schedulers.computation());
    }

    public static d<Long> H(long j, TimeUnit timeUnit, g gVar) {
        return b(new h.o.a.j(j, timeUnit, gVar));
    }

    public static <T> d<T> b(a<T> aVar) {
        return new d<>(h.r.c.h(aVar));
    }

    public static <T> d<T> e() {
        return EmptyObservableHolder.instance();
    }

    public static <T> d<T> h(Iterable<? extends T> iterable) {
        return b(new OnSubscribeFromIterable(iterable));
    }

    public static <T> d<T> i(T t) {
        return ScalarSynchronousObservable.J(t);
    }

    public static <T> d<T> l(Iterable<? extends d<? extends T>> iterable) {
        return m(h(iterable));
    }

    public static <T> d<T> m(d<? extends d<? extends T>> dVar) {
        if (dVar.getClass() == ScalarSynchronousObservable.class) {
            return ((ScalarSynchronousObservable) dVar).M(UtilityFunctions.b());
        }
        return (d<T>) dVar.j(OperatorMerge.b(false));
    }

    public static <T> d<T> n() {
        return NeverObservableHolder.instance();
    }

    public final k B(h.n.b<? super T> bVar) {
        if (bVar != null) {
            return z(new h.o.d.b(bVar, InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
        }
        throw new IllegalArgumentException("onNext can not be null");
    }

    public final k C(h.n.b<? super T> bVar, h.n.b<Throwable> bVar2) {
        if (bVar != null) {
            if (bVar2 != null) {
                return z(new h.o.d.b(bVar, bVar2, Actions.a()));
            }
            throw new IllegalArgumentException("onError can not be null");
        }
        throw new IllegalArgumentException("onNext can not be null");
    }

    public final d<T> D(g gVar) {
        if (this instanceof ScalarSynchronousObservable) {
            return ((ScalarSynchronousObservable) this).N(gVar);
        }
        return b(new s(this, gVar));
    }

    public final d<T> E(long j, TimeUnit timeUnit) {
        return F(j, timeUnit, null, Schedulers.computation());
    }

    public final d<T> F(long j, TimeUnit timeUnit, d<? extends T> dVar, g gVar) {
        return (d<T>) j(new t(j, timeUnit, dVar, gVar));
    }

    public final k I(j<? super T> jVar) {
        try {
            jVar.onStart();
            h.r.c.p(this, this.f71785e).call(jVar);
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
        return j(new l(cls));
    }

    public final d<T> c(h.n.b<? super Throwable> bVar) {
        return b(new h.o.a.e(this, new h.o.d.a(Actions.a(), bVar, Actions.a())));
    }

    public final d<T> d(h.n.b<? super T> bVar) {
        return b(new h.o.a.e(this, new h.o.d.a(bVar, Actions.a(), Actions.a())));
    }

    public final d<T> f(h.n.f<? super T, Boolean> fVar) {
        return b(new h.o.a.f(this, fVar));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: h.n.f<? super T, ? extends h.d<? extends R>> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <R> d<R> g(h.n.f<? super T, ? extends d<? extends R>> fVar) {
        if (getClass() == ScalarSynchronousObservable.class) {
            return ((ScalarSynchronousObservable) this).M(fVar);
        }
        return m(k(fVar));
    }

    public final <R> d<R> j(b<? extends R, ? super T> bVar) {
        return b(new h.o.a.g(this.f71785e, bVar));
    }

    public final <R> d<R> k(h.n.f<? super T, ? extends R> fVar) {
        return b(new h.o.a.h(this, fVar));
    }

    public final d<T> o(g gVar) {
        return p(gVar, h.o.d.f.f72033g);
    }

    public final d<T> p(g gVar, int i2) {
        return q(gVar, false, i2);
    }

    public final d<T> q(g gVar, boolean z, int i2) {
        if (this instanceof ScalarSynchronousObservable) {
            return ((ScalarSynchronousObservable) this).N(gVar);
        }
        return (d<T>) j(new o(gVar, z, i2));
    }

    public final <R> d<R> r(Class<R> cls) {
        return f(InternalObservableUtils.isInstanceOf(cls)).a(cls);
    }

    public final d<T> s() {
        return (d<T>) j(p.b());
    }

    public final h.p.a<T> t() {
        return OperatorReplay.K(this);
    }

    public final h.p.a<T> u(int i2) {
        return OperatorReplay.L(this, i2);
    }

    public final h.p.a<T> v(int i2, long j, TimeUnit timeUnit, g gVar) {
        if (i2 >= 0) {
            return OperatorReplay.N(this, j, timeUnit, gVar, i2);
        }
        throw new IllegalArgumentException("bufferSize < 0");
    }

    public final h.p.a<T> w(long j, TimeUnit timeUnit, g gVar) {
        return OperatorReplay.M(this, j, timeUnit, gVar);
    }

    public final d<T> x() {
        return h.o.a.i.b(this);
    }

    public final k y() {
        return z(new h.o.d.b(Actions.a(), InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.a()));
    }

    public final k z(j<? super T> jVar) {
        return A(jVar, this);
    }
}
