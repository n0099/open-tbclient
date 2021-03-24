package io.reactivex.internal.operators.maybe;

import f.a.a0.a;
import f.a.i;
import f.a.t.b;
import f.a.w.f;
import io.reactivex.internal.disposables.CancellableDisposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class MaybeCreate$Emitter<T> extends AtomicReference<b> implements Object<T> {
    public static final long serialVersionUID = -2467358622224974244L;
    public final i<? super T> actual;

    public MaybeCreate$Emitter(i<? super T> iVar) {
        this.actual = iVar;
    }

    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    public void onComplete() {
        b andSet;
        b bVar = get();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (bVar == disposableHelper || (andSet = getAndSet(disposableHelper)) == DisposableHelper.DISPOSED) {
            return;
        }
        try {
            this.actual.onComplete();
        } finally {
            if (andSet != null) {
                andSet.dispose();
            }
        }
    }

    public void onError(Throwable th) {
        if (tryOnError(th)) {
            return;
        }
        a.f(th);
    }

    public void onSuccess(T t) {
        b andSet;
        b bVar = get();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (bVar == disposableHelper || (andSet = getAndSet(disposableHelper)) == DisposableHelper.DISPOSED) {
            return;
        }
        try {
            if (t == null) {
                this.actual.onError(new NullPointerException("onSuccess called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else {
                this.actual.onSuccess(t);
            }
            if (andSet != null) {
                andSet.dispose();
            }
        } catch (Throwable th) {
            if (andSet != null) {
                andSet.dispose();
            }
            throw th;
        }
    }

    public void setCancellable(f fVar) {
        setDisposable(new CancellableDisposable(fVar));
    }

    public void setDisposable(b bVar) {
        DisposableHelper.set(this, bVar);
    }

    public boolean tryOnError(Throwable th) {
        b andSet;
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        b bVar = get();
        DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
        if (bVar == disposableHelper || (andSet = getAndSet(disposableHelper)) == DisposableHelper.DISPOSED) {
            return false;
        }
        try {
            this.actual.onError(th);
        } finally {
            if (andSet != null) {
                andSet.dispose();
            }
        }
    }
}
