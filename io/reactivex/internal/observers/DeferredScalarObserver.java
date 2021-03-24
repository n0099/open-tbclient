package io.reactivex.internal.observers;

import f.a.o;
import f.a.t.b;
import io.reactivex.internal.disposables.DisposableHelper;
/* loaded from: classes7.dex */
public abstract class DeferredScalarObserver<T, R> extends DeferredScalarDisposable<R> implements o<T> {
    public static final long serialVersionUID = -266195175408988651L;
    public b s;

    public DeferredScalarObserver(o<? super R> oVar) {
        super(oVar);
    }

    @Override // io.reactivex.internal.observers.DeferredScalarDisposable, io.reactivex.internal.observers.BasicIntQueueDisposable, f.a.t.b
    public void dispose() {
        super.dispose();
        this.s.dispose();
    }

    @Override // f.a.o
    public void onComplete() {
        T t = this.value;
        if (t != null) {
            this.value = null;
            complete(t);
            return;
        }
        complete();
    }

    @Override // f.a.o
    public void onError(Throwable th) {
        this.value = null;
        error(th);
    }

    @Override // f.a.o
    public abstract /* synthetic */ void onNext(T t);

    @Override // f.a.o
    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.s, bVar)) {
            this.s = bVar;
            this.actual.onSubscribe(this);
        }
    }
}
