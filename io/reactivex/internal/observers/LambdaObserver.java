package io.reactivex.internal.observers;

import io.reactivex.c.g;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.Functions;
import io.reactivex.u;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes25.dex */
public final class LambdaObserver<T> extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, u<T> {
    private static final long serialVersionUID = -7251123623727029452L;
    final io.reactivex.c.a onComplete;
    final g<? super Throwable> onError;
    final g<? super T> onNext;
    final g<? super io.reactivex.disposables.b> onSubscribe;

    public LambdaObserver(g<? super T> gVar, g<? super Throwable> gVar2, io.reactivex.c.a aVar, g<? super io.reactivex.disposables.b> gVar3) {
        this.onNext = gVar;
        this.onError = gVar2;
        this.onComplete = aVar;
        this.onSubscribe = gVar3;
    }

    @Override // io.reactivex.u
    public void onSubscribe(io.reactivex.disposables.b bVar) {
        if (DisposableHelper.setOnce(this, bVar)) {
            try {
                this.onSubscribe.accept(this);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.J(th);
                bVar.dispose();
                onError(th);
            }
        }
    }

    @Override // io.reactivex.u
    public void onNext(T t) {
        if (!isDisposed()) {
            try {
                this.onNext.accept(t);
            } catch (Throwable th) {
                io.reactivex.exceptions.a.J(th);
                get().dispose();
                onError(th);
            }
        }
    }

    @Override // io.reactivex.u
    public void onError(Throwable th) {
        if (!isDisposed()) {
            lazySet(DisposableHelper.DISPOSED);
            try {
                this.onError.accept(th);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.J(th2);
                io.reactivex.e.a.onError(new CompositeException(th, th2));
            }
        }
    }

    @Override // io.reactivex.u
    public void onComplete() {
        if (!isDisposed()) {
            lazySet(DisposableHelper.DISPOSED);
            try {
                this.onComplete.run();
            } catch (Throwable th) {
                io.reactivex.exceptions.a.J(th);
                io.reactivex.e.a.onError(th);
            }
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
        return this.onError != Functions.own;
    }
}
