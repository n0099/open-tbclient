package io.reactivex.internal.operators.single;

import f.a.a0.a;
import f.a.r;
import f.a.t.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class SingleTakeUntil$TakeUntilMainObserver<T> extends AtomicReference<b> implements r<T>, b {
    public static final long serialVersionUID = -622603812305745221L;
    public final r<? super T> actual;
    public final SingleTakeUntil$TakeUntilOtherSubscriber other = new SingleTakeUntil$TakeUntilOtherSubscriber(this);

    public SingleTakeUntil$TakeUntilMainObserver(r<? super T> rVar) {
        this.actual = rVar;
    }

    @Override // f.a.t.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // f.a.t.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // f.a.r
    public void onError(Throwable th) {
        this.other.dispose();
        b bVar = get();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (bVar != disposableHelper && getAndSet(disposableHelper) != DisposableHelper.DISPOSED) {
            this.actual.onError(th);
        } else {
            a.f(th);
        }
    }

    @Override // f.a.r
    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }

    @Override // f.a.r
    public void onSuccess(T t) {
        this.other.dispose();
        b bVar = get();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (bVar == disposableHelper || getAndSet(disposableHelper) == DisposableHelper.DISPOSED) {
            return;
        }
        this.actual.onSuccess(t);
    }

    public void otherError(Throwable th) {
        b andSet;
        b bVar = get();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (bVar != disposableHelper && (andSet = getAndSet(disposableHelper)) != DisposableHelper.DISPOSED) {
            if (andSet != null) {
                andSet.dispose();
            }
            this.actual.onError(th);
            return;
        }
        a.f(th);
    }
}
