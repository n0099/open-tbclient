package io.reactivex.internal.observers;

import io.reactivex.c.g;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class CallbackCompletableObserver extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.c, g<Throwable>, io.reactivex.disposables.b {
    private static final long serialVersionUID = -4361286194466301354L;
    final io.reactivex.c.a onComplete;
    final g<? super Throwable> onError;

    public CallbackCompletableObserver(io.reactivex.c.a aVar) {
        this.onError = this;
        this.onComplete = aVar;
    }

    public CallbackCompletableObserver(g<? super Throwable> gVar, io.reactivex.c.a aVar) {
        this.onError = gVar;
        this.onComplete = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // io.reactivex.c.g
    public void accept(Throwable th) {
        io.reactivex.e.a.onError(new OnErrorNotImplementedException(th));
    }

    @Override // io.reactivex.c
    public void onComplete() {
        try {
            this.onComplete.run();
        } catch (Throwable th) {
            io.reactivex.exceptions.a.J(th);
            io.reactivex.e.a.onError(th);
        }
        lazySet(DisposableHelper.DISPOSED);
    }

    @Override // io.reactivex.c
    public void onError(Throwable th) {
        try {
            this.onError.accept(th);
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.J(th2);
            io.reactivex.e.a.onError(th2);
        }
        lazySet(DisposableHelper.DISPOSED);
    }

    @Override // io.reactivex.c
    public void onSubscribe(io.reactivex.disposables.b bVar) {
        DisposableHelper.setOnce(this, bVar);
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
        return this.onError != this;
    }
}
