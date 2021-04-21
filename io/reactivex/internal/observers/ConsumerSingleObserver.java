package io.reactivex.internal.observers;

import f.b.r;
import f.b.t.b;
import f.b.u.a;
import f.b.w.g;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.Functions;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ConsumerSingleObserver<T> extends AtomicReference<b> implements r<T>, b {
    public static final long serialVersionUID = -7012088219455310787L;
    public final g<? super Throwable> onError;
    public final g<? super T> onSuccess;

    public ConsumerSingleObserver(g<? super T> gVar, g<? super Throwable> gVar2) {
        this.onSuccess = gVar;
        this.onError = gVar2;
    }

    @Override // f.b.t.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean hasCustomOnError() {
        return this.onError != Functions.f69180b;
    }

    @Override // f.b.t.b
    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }

    @Override // f.b.r
    public void onError(Throwable th) {
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.onError.accept(th);
        } catch (Throwable th2) {
            a.a(th2);
            f.b.a0.a.f(new CompositeException(th, th2));
        }
    }

    @Override // f.b.r
    public void onSubscribe(b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }

    @Override // f.b.r
    public void onSuccess(T t) {
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.onSuccess.accept(t);
        } catch (Throwable th) {
            a.a(th);
            f.b.a0.a.f(th);
        }
    }
}
