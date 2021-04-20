package io.reactivex.internal.operators.observable;

import f.b.a0.a;
import f.b.m;
import f.b.o;
import f.b.t.b;
import f.b.w.f;
import io.reactivex.internal.disposables.CancellableDisposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ObservableCreate$CreateEmitter<T> extends AtomicReference<b> implements m<T>, b {
    public static final long serialVersionUID = -3434801548987643227L;
    public final o<? super T> observer;

    public ObservableCreate$CreateEmitter(o<? super T> oVar) {
        this.observer = oVar;
    }

    @Override // f.b.t.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // f.b.m, f.b.t.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // f.b.d
    public void onComplete() {
        if (isDisposed()) {
            return;
        }
        try {
            this.observer.onComplete();
        } finally {
            dispose();
        }
    }

    @Override // f.b.d
    public void onError(Throwable th) {
        if (tryOnError(th)) {
            return;
        }
        a.f(th);
    }

    @Override // f.b.d
    public void onNext(T t) {
        if (t == null) {
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
        } else if (isDisposed()) {
        } else {
            this.observer.onNext(t);
        }
    }

    public m<T> serialize() {
        return new ObservableCreate$SerializedEmitter(this);
    }

    @Override // f.b.m
    public void setCancellable(f fVar) {
        setDisposable(new CancellableDisposable(fVar));
    }

    @Override // f.b.m
    public void setDisposable(b bVar) {
        DisposableHelper.set(this, bVar);
    }

    public boolean tryOnError(Throwable th) {
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        if (isDisposed()) {
            return false;
        }
        try {
            this.observer.onError(th);
            dispose();
            return true;
        } catch (Throwable th2) {
            dispose();
            throw th2;
        }
    }
}
