package io.reactivex.internal.observers;

import io.reactivex.c.g;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.Functions;
import io.reactivex.y;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ConsumerSingleObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, y<T> {
    private static final long serialVersionUID = -7012088219455310787L;
    final g<? super Throwable> onError;
    final g<? super T> onSuccess;

    public ConsumerSingleObserver(g<? super T> gVar, g<? super Throwable> gVar2) {
        this.onSuccess = gVar;
        this.onError = gVar2;
    }

    @Override // io.reactivex.y
    public void onError(Throwable th) {
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.onError.accept(th);
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.L(th2);
            io.reactivex.e.a.onError(new CompositeException(th, th2));
        }
    }

    @Override // io.reactivex.y
    public void onSubscribe(io.reactivex.disposables.b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }

    @Override // io.reactivex.y
    public void onSuccess(T t) {
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.onSuccess.accept(t);
        } catch (Throwable th) {
            io.reactivex.exceptions.a.L(th);
            io.reactivex.e.a.onError(th);
        }
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }

    public boolean hasCustomOnError() {
        return this.onError != Functions.nmD;
    }
}
