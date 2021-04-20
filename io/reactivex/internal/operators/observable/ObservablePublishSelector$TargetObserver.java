package io.reactivex.internal.operators.observable;

import f.b.o;
import f.b.t.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ObservablePublishSelector$TargetObserver<T, R> extends AtomicReference<b> implements o<R>, b {
    public static final long serialVersionUID = 854110278590336484L;
    public final o<? super R> actual;

    /* renamed from: d  reason: collision with root package name */
    public b f69072d;

    public ObservablePublishSelector$TargetObserver(o<? super R> oVar) {
        this.actual = oVar;
    }

    @Override // f.b.t.b
    public void dispose() {
        this.f69072d.dispose();
        DisposableHelper.dispose(this);
    }

    @Override // f.b.t.b
    public boolean isDisposed() {
        return this.f69072d.isDisposed();
    }

    @Override // f.b.o
    public void onComplete() {
        DisposableHelper.dispose(this);
        this.actual.onComplete();
    }

    @Override // f.b.o
    public void onError(Throwable th) {
        DisposableHelper.dispose(this);
        this.actual.onError(th);
    }

    @Override // f.b.o
    public void onNext(R r) {
        this.actual.onNext(r);
    }

    @Override // f.b.o
    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.f69072d, bVar)) {
            this.f69072d = bVar;
            this.actual.onSubscribe(this);
        }
    }
}
