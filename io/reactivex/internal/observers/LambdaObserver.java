package io.reactivex.internal.observers;

import f.a.o;
import f.a.t.b;
import f.a.w.a;
import f.a.w.g;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.functions.Functions;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class LambdaObserver<T> extends AtomicReference<b> implements o<T>, b {
    public static final long serialVersionUID = -7251123623727029452L;
    public final a onComplete;
    public final g<? super Throwable> onError;
    public final g<? super T> onNext;
    public final g<? super b> onSubscribe;

    public LambdaObserver(g<? super T> gVar, g<? super Throwable> gVar2, a aVar, g<? super b> gVar3) {
        this.onNext = gVar;
        this.onError = gVar2;
        this.onComplete = aVar;
        this.onSubscribe = gVar3;
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
        return get() == DisposableHelper.DISPOSED;
    }

    @Override // f.a.o
    public void onComplete() {
        if (isDisposed()) {
            return;
        }
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.onComplete.run();
        } catch (Throwable th) {
            f.a.u.a.a(th);
            f.a.a0.a.f(th);
        }
    }

    @Override // f.a.o
    public void onError(Throwable th) {
        if (isDisposed()) {
            return;
        }
        lazySet(DisposableHelper.DISPOSED);
        try {
            this.onError.accept(th);
        } catch (Throwable th2) {
            f.a.u.a.a(th2);
            f.a.a0.a.f(new CompositeException(th, th2));
        }
    }

    @Override // f.a.o
    public void onNext(T t) {
        if (isDisposed()) {
            return;
        }
        try {
            this.onNext.accept(t);
        } catch (Throwable th) {
            f.a.u.a.a(th);
            get().dispose();
            onError(th);
        }
    }

    @Override // f.a.o
    public void onSubscribe(b bVar) {
        if (DisposableHelper.setOnce(this, bVar)) {
            try {
                this.onSubscribe.accept(this);
            } catch (Throwable th) {
                f.a.u.a.a(th);
                bVar.dispose();
                onError(th);
            }
        }
    }
}
