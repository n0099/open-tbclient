package rx;

import java.util.concurrent.TimeUnit;
import rx.exceptions.OnErrorFailedException;
import rx.functions.Actions;
import rx.internal.operators.EmptyObservableHolder;
import rx.internal.operators.NeverObservableHolder;
import rx.internal.operators.OnSubscribeFromIterable;
import rx.internal.operators.OperatorMerge;
import rx.internal.operators.OperatorReplay;
import rx.internal.operators.l;
import rx.internal.operators.m;
import rx.internal.operators.n;
import rx.internal.operators.o;
import rx.internal.operators.p;
import rx.internal.util.InternalObservableUtils;
import rx.internal.util.ScalarSynchronousObservable;
import rx.internal.util.UtilityFunctions;
import rx.schedulers.Schedulers;
/* loaded from: classes6.dex */
public class d<T> {
    final a<T> niP;

    /* loaded from: classes6.dex */
    public interface a<T> extends rx.functions.b<j<? super T>> {
    }

    /* loaded from: classes6.dex */
    public interface b<R, T> extends rx.functions.f<j<? super R>, j<? super T>> {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public d(a<T> aVar) {
        this.niP = aVar;
    }

    public static <T> d<T> a(a<T> aVar) {
        return new d<>(rx.c.c.b(aVar));
    }

    public final <R> d<R> a(b<? extends R, ? super T> bVar) {
        return a((a) new rx.internal.operators.e(this.niP, bVar));
    }

    public static <T> d<T> dHt() {
        return EmptyObservableHolder.instance();
    }

    public static <T> d<T> l(Iterable<? extends T> iterable) {
        return a((a) new OnSubscribeFromIterable(iterable));
    }

    public static <T> d<T> bK(T t) {
        return ScalarSynchronousObservable.bS(t);
    }

    public static <T> d<T> m(Iterable<? extends d<? extends T>> iterable) {
        return a(l(iterable));
    }

    public static <T> d<T> a(d<? extends d<? extends T>> dVar) {
        return dVar.getClass() == ScalarSynchronousObservable.class ? ((ScalarSynchronousObservable) dVar).f(UtilityFunctions.dIk()) : (d<T>) dVar.a((b<? extends R, ? super Object>) OperatorMerge.wL(false));
    }

    public static <T> d<T> dHu() {
        return NeverObservableHolder.instance();
    }

    public static d<Long> b(long j, TimeUnit timeUnit) {
        return a(j, timeUnit, Schedulers.computation());
    }

    public static d<Long> a(long j, TimeUnit timeUnit, g gVar) {
        return a((a) new rx.internal.operators.h(j, timeUnit, gVar));
    }

    public final <R> d<R> O(Class<R> cls) {
        return a((b) new rx.internal.operators.j(cls));
    }

    public final <R> d<R> a(rx.functions.f<? super T, ? extends d<? extends R>> fVar) {
        return this instanceof ScalarSynchronousObservable ? ((ScalarSynchronousObservable) this).f(fVar) : a((a) new rx.internal.operators.b(this, fVar, 2, 0));
    }

    public final d<T> a(rx.functions.b<? super Throwable> bVar) {
        return a((a) new rx.internal.operators.c(this, new rx.internal.util.a(Actions.dHH(), bVar, Actions.dHH())));
    }

    public final d<T> b(rx.functions.b<? super T> bVar) {
        return a((a) new rx.internal.operators.c(this, new rx.internal.util.a(bVar, Actions.dHH(), Actions.dHH())));
    }

    public final d<T> a(rx.functions.a aVar) {
        return a((a) new rx.internal.operators.c(this, new rx.internal.util.a(Actions.dHH(), Actions.e(aVar), aVar)));
    }

    public final d<T> b(rx.functions.f<? super T, Boolean> fVar) {
        return a((a) new rx.internal.operators.d(this, fVar));
    }

    public final d<T> b(rx.functions.a aVar) {
        return (d<T>) a((b) new rx.internal.operators.k(aVar));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: rx.functions.f<? super T, ? extends rx.d<? extends R>> */
    /* JADX WARN: Multi-variable type inference failed */
    public final <R> d<R> c(rx.functions.f<? super T, ? extends d<? extends R>> fVar) {
        return getClass() == ScalarSynchronousObservable.class ? ((ScalarSynchronousObservable) this).f(fVar) : a(d(fVar));
    }

    public final <R> d<R> d(rx.functions.f<? super T, ? extends R> fVar) {
        return a((a) new rx.internal.operators.f(this, fVar));
    }

    public final d<T> c(g gVar) {
        return a(gVar, rx.internal.util.g.SIZE);
    }

    public final d<T> a(g gVar, int i) {
        return a(gVar, false, i);
    }

    public final d<T> a(g gVar, boolean z, int i) {
        return this instanceof ScalarSynchronousObservable ? ((ScalarSynchronousObservable) this).g(gVar) : (d<T>) a((b) new l(gVar, z, i));
    }

    public final <R> d<R> P(Class<R> cls) {
        return b(InternalObservableUtils.isInstanceOf(cls)).O(cls);
    }

    public final d<T> dHv() {
        return (d<T>) a((b) m.dHT());
    }

    public final rx.observables.a<T> dHw() {
        return OperatorReplay.e(this);
    }

    public final rx.observables.a<T> Jz(int i) {
        return OperatorReplay.a(this, i);
    }

    public final rx.observables.a<T> a(int i, long j, TimeUnit timeUnit, g gVar) {
        if (i < 0) {
            throw new IllegalArgumentException("bufferSize < 0");
        }
        return OperatorReplay.a(this, j, timeUnit, gVar, i);
    }

    public final rx.observables.a<T> b(long j, TimeUnit timeUnit, g gVar) {
        return OperatorReplay.a(this, j, timeUnit, gVar);
    }

    public final d<T> dHx() {
        return rx.internal.operators.g.b(this);
    }

    public final k dHm() {
        return b(new rx.internal.util.b(Actions.dHH(), InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.dHH()));
    }

    public final k c(rx.functions.b<? super T> bVar) {
        if (bVar == null) {
            throw new IllegalArgumentException("onNext can not be null");
        }
        return b(new rx.internal.util.b(bVar, InternalObservableUtils.ERROR_NOT_IMPLEMENTED, Actions.dHH()));
    }

    public final k a(rx.functions.b<? super T> bVar, rx.functions.b<Throwable> bVar2) {
        if (bVar == null) {
            throw new IllegalArgumentException("onNext can not be null");
        }
        if (bVar2 == null) {
            throw new IllegalArgumentException("onError can not be null");
        }
        return b(new rx.internal.util.b(bVar, bVar2, Actions.dHH()));
    }

    public final k a(e<? super T> eVar) {
        if (eVar instanceof j) {
            return b((j) eVar);
        }
        if (eVar == null) {
            throw new NullPointerException("observer is null");
        }
        return b(new rx.internal.util.d(eVar));
    }

    public final k a(j<? super T> jVar) {
        try {
            jVar.onStart();
            rx.c.c.a(this, this.niP).call(jVar);
            return rx.c.c.b(jVar);
        } catch (Throwable th) {
            rx.exceptions.a.L(th);
            try {
                jVar.onError(rx.c.c.ac(th));
                return rx.subscriptions.e.dJd();
            } catch (Throwable th2) {
                rx.exceptions.a.L(th2);
                OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                rx.c.c.ac(onErrorFailedException);
                throw onErrorFailedException;
            }
        }
    }

    public final k b(j<? super T> jVar) {
        return a(jVar, this);
    }

    static <T> k a(j<? super T> jVar, d<T> dVar) {
        if (jVar == null) {
            throw new IllegalArgumentException("subscriber can not be null");
        }
        if (dVar.niP == null) {
            throw new IllegalStateException("onSubscribe function can not be null.");
        }
        jVar.onStart();
        if (!(jVar instanceof rx.b.c)) {
            jVar = new rx.b.c(jVar);
        }
        try {
            rx.c.c.a(dVar, dVar.niP).call(jVar);
            return rx.c.c.b(jVar);
        } catch (Throwable th) {
            rx.exceptions.a.L(th);
            if (jVar.isUnsubscribed()) {
                rx.c.c.onError(rx.c.c.ac(th));
            } else {
                try {
                    jVar.onError(rx.c.c.ac(th));
                } catch (Throwable th2) {
                    rx.exceptions.a.L(th2);
                    OnErrorFailedException onErrorFailedException = new OnErrorFailedException("Error occurred attempting to subscribe [" + th.getMessage() + "] and then again while trying to pass to onError.", th2);
                    rx.c.c.ac(onErrorFailedException);
                    throw onErrorFailedException;
                }
            }
            return rx.subscriptions.e.dJd();
        }
    }

    public final d<T> d(g gVar) {
        return this instanceof ScalarSynchronousObservable ? ((ScalarSynchronousObservable) this).g(gVar) : a((a) new n(this, gVar));
    }

    public final d<T> e(rx.functions.f<? super T, Boolean> fVar) {
        return (d<T>) a((b) new o(fVar));
    }

    public final d<T> c(long j, TimeUnit timeUnit) {
        return a(j, timeUnit, (d) null, Schedulers.computation());
    }

    public final d<T> a(long j, TimeUnit timeUnit, d<? extends T> dVar, g gVar) {
        return (d<T>) a((b) new p(j, timeUnit, dVar, gVar));
    }
}
