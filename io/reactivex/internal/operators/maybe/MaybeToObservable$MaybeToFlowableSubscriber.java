package io.reactivex.internal.operators.maybe;

import f.b.i;
import f.b.o;
import f.b.t.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;
/* loaded from: classes7.dex */
public final class MaybeToObservable$MaybeToFlowableSubscriber<T> extends DeferredScalarDisposable<T> implements i<T> {
    public static final long serialVersionUID = 7603343402964826922L;

    /* renamed from: d  reason: collision with root package name */
    public b f69210d;

    public MaybeToObservable$MaybeToFlowableSubscriber(o<? super T> oVar) {
        super(oVar);
    }

    @Override // io.reactivex.internal.observers.DeferredScalarDisposable, io.reactivex.internal.observers.BasicIntQueueDisposable, f.b.t.b
    public void dispose() {
        super.dispose();
        this.f69210d.dispose();
    }

    @Override // f.b.i
    public void onComplete() {
        complete();
    }

    @Override // f.b.i
    public void onError(Throwable th) {
        error(th);
    }

    @Override // f.b.i
    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.f69210d, bVar)) {
            this.f69210d = bVar;
            this.actual.onSubscribe(this);
        }
    }

    @Override // f.b.i
    public void onSuccess(T t) {
        complete(t);
    }
}
