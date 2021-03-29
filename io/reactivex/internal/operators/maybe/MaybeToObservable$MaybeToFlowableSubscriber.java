package io.reactivex.internal.operators.maybe;

import f.a.i;
import f.a.o;
import f.a.t.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;
/* loaded from: classes7.dex */
public final class MaybeToObservable$MaybeToFlowableSubscriber<T> extends DeferredScalarDisposable<T> implements i<T> {
    public static final long serialVersionUID = 7603343402964826922L;

    /* renamed from: d  reason: collision with root package name */
    public b f68057d;

    public MaybeToObservable$MaybeToFlowableSubscriber(o<? super T> oVar) {
        super(oVar);
    }

    @Override // io.reactivex.internal.observers.DeferredScalarDisposable, io.reactivex.internal.observers.BasicIntQueueDisposable, f.a.t.b
    public void dispose() {
        super.dispose();
        this.f68057d.dispose();
    }

    @Override // f.a.i
    public void onComplete() {
        complete();
    }

    @Override // f.a.i
    public void onError(Throwable th) {
        error(th);
    }

    @Override // f.a.i
    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.f68057d, bVar)) {
            this.f68057d = bVar;
            this.actual.onSubscribe(this);
        }
    }

    @Override // f.a.i
    public void onSuccess(T t) {
        complete(t);
    }
}
