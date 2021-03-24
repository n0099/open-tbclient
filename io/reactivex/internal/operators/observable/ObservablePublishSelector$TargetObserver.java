package io.reactivex.internal.operators.observable;

import f.a.o;
import f.a.t.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ObservablePublishSelector$TargetObserver<T, R> extends AtomicReference<b> implements o<R>, b {
    public static final long serialVersionUID = 854110278590336484L;
    public final o<? super R> actual;

    /* renamed from: d  reason: collision with root package name */
    public b f68061d;

    public ObservablePublishSelector$TargetObserver(o<? super R> oVar) {
        this.actual = oVar;
    }

    @Override // f.a.t.b
    public void dispose() {
        this.f68061d.dispose();
        DisposableHelper.dispose(this);
    }

    @Override // f.a.t.b
    public boolean isDisposed() {
        return this.f68061d.isDisposed();
    }

    @Override // f.a.o
    public void onComplete() {
        DisposableHelper.dispose(this);
        this.actual.onComplete();
    }

    @Override // f.a.o
    public void onError(Throwable th) {
        DisposableHelper.dispose(this);
        this.actual.onError(th);
    }

    @Override // f.a.o
    public void onNext(R r) {
        this.actual.onNext(r);
    }

    @Override // f.a.o
    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.f68061d, bVar)) {
            this.f68061d = bVar;
            this.actual.onSubscribe(this);
        }
    }
}
