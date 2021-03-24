package io.reactivex.internal.operators.maybe;

import f.a.i;
import f.a.t.b;
import f.a.w.a;
import f.a.w.g;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.Functions;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class MaybeCallbackObserver<T> extends AtomicReference<b> implements i<T>, b {
    public static final long serialVersionUID = -6076952298809384986L;
    public final a onComplete;
    public final g<? super Throwable> onError;
    public final g<? super T> onSuccess;

    public MaybeCallbackObserver(g<? super T> gVar, g<? super Throwable> gVar2, a aVar) {
        this.onSuccess = gVar;
        this.onError = gVar2;
        this.onComplete = aVar;
    }

    @Override // f.a.t.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean hasCustomOnError() {
        return this.onError != Functions.f68022b;
    }

    @Override // f.a.t.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // f.a.i
    public void onComplete() {
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.onComplete.run();
        } catch (Throwable th) {
            f.a.u.a.a(th);
            f.a.a0.a.f(th);
        }
    }

    @Override // f.a.i
    public void onError(Throwable th) {
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.onError.accept(th);
        } catch (Throwable th2) {
            f.a.u.a.a(th2);
            f.a.a0.a.f(new CompositeException(th, th2));
        }
    }

    @Override // f.a.i
    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }

    @Override // f.a.i
    public void onSuccess(T t) {
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.onSuccess.accept(t);
        } catch (Throwable th) {
            f.a.u.a.a(th);
            f.a.a0.a.f(th);
        }
    }
}
