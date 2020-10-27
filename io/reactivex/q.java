package io.reactivex;

import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.observers.LambdaObserver;
import io.reactivex.internal.operators.observable.ObservableObserveOn;
/* loaded from: classes17.dex */
public abstract class q<T> implements t<T> {
    protected abstract void a(u<? super T> uVar);

    public static int ewG() {
        return g.ewG();
    }

    public final q<T> d(v vVar) {
        return b(vVar, false, ewG());
    }

    public final q<T> b(v vVar, boolean z, int i) {
        io.reactivex.internal.functions.a.l(vVar, "scheduler is null");
        io.reactivex.internal.functions.a.bX(i, "bufferSize");
        return io.reactivex.e.a.a(new ObservableObserveOn(this, vVar, z, i));
    }

    public final io.reactivex.disposables.b b(io.reactivex.c.g<? super T> gVar) {
        return a(gVar, Functions.pCZ, Functions.pCW, Functions.ewQ());
    }

    public final io.reactivex.disposables.b a(io.reactivex.c.g<? super T> gVar, io.reactivex.c.g<? super Throwable> gVar2, io.reactivex.c.a aVar, io.reactivex.c.g<? super io.reactivex.disposables.b> gVar3) {
        io.reactivex.internal.functions.a.l(gVar, "onNext is null");
        io.reactivex.internal.functions.a.l(gVar2, "onError is null");
        io.reactivex.internal.functions.a.l(aVar, "onComplete is null");
        io.reactivex.internal.functions.a.l(gVar3, "onSubscribe is null");
        LambdaObserver lambdaObserver = new LambdaObserver(gVar, gVar2, aVar, gVar3);
        subscribe(lambdaObserver);
        return lambdaObserver;
    }

    @Override // io.reactivex.t
    public final void subscribe(u<? super T> uVar) {
        io.reactivex.internal.functions.a.l(uVar, "observer is null");
        try {
            u<? super T> a2 = io.reactivex.e.a.a(this, uVar);
            io.reactivex.internal.functions.a.l(a2, "Plugin returned null Observer");
            a(a2);
        } catch (NullPointerException e) {
            throw e;
        } catch (Throwable th) {
            io.reactivex.exceptions.a.J(th);
            io.reactivex.e.a.onError(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }
}
