package io.reactivex.internal.observers;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.u;
/* loaded from: classes17.dex */
public abstract class DeferredScalarObserver<T, R> extends DeferredScalarDisposable<R> implements u<T> {
    private static final long serialVersionUID = -266195175408988651L;
    protected io.reactivex.disposables.b s;

    public DeferredScalarObserver(u<? super R> uVar) {
        super(uVar);
    }

    @Override // io.reactivex.u
    public void onSubscribe(io.reactivex.disposables.b bVar) {
        if (DisposableHelper.validate(this.s, bVar)) {
            this.s = bVar;
            this.actual.onSubscribe(this);
        }
    }

    @Override // io.reactivex.u
    public void onError(Throwable th) {
        this.value = null;
        error(th);
    }

    @Override // io.reactivex.u
    public void onComplete() {
        T t = this.value;
        if (t != null) {
            this.value = null;
            complete(t);
            return;
        }
        complete();
    }

    @Override // io.reactivex.internal.observers.DeferredScalarDisposable, io.reactivex.disposables.b
    public void dispose() {
        super.dispose();
        this.s.dispose();
    }
}
