package io.reactivex.internal.observers;

import f.a.t.b;
import f.a.w.a;
import f.a.w.g;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class CallbackCompletableObserver extends AtomicReference<b> implements f.a.b, b, g<Throwable> {
    public static final long serialVersionUID = -4361286194466301354L;
    public final a onComplete;
    public final g<? super Throwable> onError;

    public CallbackCompletableObserver(a aVar) {
        this.onError = this;
        this.onComplete = aVar;
    }

    @Override // f.a.t.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean hasCustomOnError() {
        return this.onError != this;
    }

    @Override // f.a.t.b
    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }

    @Override // f.a.b
    public void onComplete() {
        try {
            this.onComplete.run();
        } catch (Throwable th) {
            f.a.u.a.a(th);
            f.a.a0.a.f(th);
        }
        lazySet(DisposableHelper.DISPOSED);
    }

    @Override // f.a.b
    public void onError(Throwable th) {
        try {
            this.onError.accept(th);
        } catch (Throwable th2) {
            f.a.u.a.a(th2);
            f.a.a0.a.f(th2);
        }
        lazySet(DisposableHelper.DISPOSED);
    }

    @Override // f.a.b
    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // f.a.w.g
    public void accept(Throwable th) {
        f.a.a0.a.f(new OnErrorNotImplementedException(th));
    }

    public CallbackCompletableObserver(g<? super Throwable> gVar, a aVar) {
        this.onError = gVar;
        this.onComplete = aVar;
    }
}
