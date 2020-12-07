package io.reactivex.internal.observers;

import io.reactivex.b.g;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes9.dex */
public final class CallbackCompletableObserver extends AtomicReference<io.reactivex.disposables.b> implements g<Throwable>, io.reactivex.c, io.reactivex.disposables.b {
    private static final long serialVersionUID = -4361286194466301354L;
    final io.reactivex.b.a onComplete;
    final g<? super Throwable> onError;

    public CallbackCompletableObserver(io.reactivex.b.a aVar) {
        this.onError = this;
        this.onComplete = aVar;
    }

    public CallbackCompletableObserver(g<? super Throwable> gVar, io.reactivex.b.a aVar) {
        this.onError = gVar;
        this.onComplete = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // io.reactivex.b.g
    public void accept(Throwable th) {
        io.reactivex.d.a.onError(new OnErrorNotImplementedException(th));
    }

    @Override // io.reactivex.c
    public void onComplete() {
        try {
            this.onComplete.run();
        } catch (Throwable th) {
            io.reactivex.exceptions.a.J(th);
            io.reactivex.d.a.onError(th);
        }
        lazySet(DisposableHelper.DISPOSED);
    }

    @Override // io.reactivex.c
    public void onError(Throwable th) {
        try {
            this.onError.accept(th);
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.J(th2);
            io.reactivex.d.a.onError(th2);
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
