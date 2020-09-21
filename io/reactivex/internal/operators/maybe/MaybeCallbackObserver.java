package io.reactivex.internal.operators.maybe;

import io.reactivex.c.g;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.Functions;
import io.reactivex.m;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes25.dex */
public final class MaybeCallbackObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, m<T> {
    private static final long serialVersionUID = -6076952298809384986L;
    final io.reactivex.c.a onComplete;
    final g<? super Throwable> onError;
    final g<? super T> onSuccess;

    public MaybeCallbackObserver(g<? super T> gVar, g<? super Throwable> gVar2, io.reactivex.c.a aVar) {
        this.onSuccess = gVar;
        this.onError = gVar2;
        this.onComplete = aVar;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // io.reactivex.disposables.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // io.reactivex.m
    public void onSubscribe(io.reactivex.disposables.b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }

    @Override // io.reactivex.m
    public void onSuccess(T t) {
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.onSuccess.accept(t);
        } catch (Throwable th) {
            io.reactivex.exceptions.a.J(th);
            io.reactivex.e.a.onError(th);
        }
    }

    @Override // io.reactivex.m
    public void onError(Throwable th) {
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.onError.accept(th);
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.J(th2);
            io.reactivex.e.a.onError(new CompositeException(th, th2));
        }
    }

    @Override // io.reactivex.m
    public void onComplete() {
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.onComplete.run();
        } catch (Throwable th) {
            io.reactivex.exceptions.a.J(th);
            io.reactivex.e.a.onError(th);
        }
    }

    public boolean hasCustomOnError() {
        return this.onError != Functions.own;
    }
}
