package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public final class ObservableFromFuture<T> extends Observable<T> {
    public final Future<? extends T> future;
    public final long timeout;
    public final TimeUnit unit;

    public ObservableFromFuture(Future<? extends T> future, long j, TimeUnit timeUnit) {
        this.future = future;
        this.timeout = j;
        this.unit = timeUnit;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: io.reactivex.internal.observers.DeferredScalarDisposable */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        DeferredScalarDisposable deferredScalarDisposable = new DeferredScalarDisposable(observer);
        observer.onSubscribe(deferredScalarDisposable);
        if (deferredScalarDisposable.isDisposed()) {
            return;
        }
        try {
            deferredScalarDisposable.complete(ObjectHelper.requireNonNull(this.unit != null ? this.future.get(this.timeout, this.unit) : this.future.get(), "Future returned null"));
        } catch (Throwable th) {
            Exceptions.throwIfFatal(th);
            if (deferredScalarDisposable.isDisposed()) {
                return;
            }
            observer.onError(th);
        }
    }
}
