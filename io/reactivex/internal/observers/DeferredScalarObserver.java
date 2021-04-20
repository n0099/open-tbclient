package io.reactivex.internal.observers;

import f.b.o;
import f.b.t.b;
import io.reactivex.internal.disposables.DisposableHelper;
/* loaded from: classes7.dex */
public abstract class DeferredScalarObserver<T, R> extends DeferredScalarDisposable<R> implements o<T> {
    public static final long serialVersionUID = -266195175408988651L;
    public b s;

    public DeferredScalarObserver(o<? super R> oVar) {
        super(oVar);
    }

    @Override // io.reactivex.internal.observers.DeferredScalarDisposable, io.reactivex.internal.observers.BasicIntQueueDisposable, f.b.t.b
    public void dispose() {
        super.dispose();
        this.s.dispose();
    }

    @Override // f.b.o
    public void onComplete() {
        T t = this.value;
        if (t != null) {
            this.value = null;
            complete(t);
            return;
        }
        complete();
    }

    @Override // f.b.o
    public void onError(Throwable th) {
        this.value = null;
        error(th);
    }

    @Override // f.b.o
    public abstract /* synthetic */ void onNext(T t);

    @Override // f.b.o
    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.s, bVar)) {
            this.s = bVar;
            this.actual.onSubscribe(this);
        }
    }
}
