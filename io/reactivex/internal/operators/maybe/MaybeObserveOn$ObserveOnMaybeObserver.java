package io.reactivex.internal.operators.maybe;

import f.a.i;
import f.a.p;
import f.a.t.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class MaybeObserveOn$ObserveOnMaybeObserver<T> extends AtomicReference<b> implements i<T>, b, Runnable {
    public static final long serialVersionUID = 8571289934935992137L;
    public final i<? super T> actual;
    public Throwable error;
    public final p scheduler;
    public T value;

    public MaybeObserveOn$ObserveOnMaybeObserver(i<? super T> iVar, p pVar) {
        this.actual = iVar;
        this.scheduler = pVar;
    }

    @Override // f.a.t.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // f.a.t.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // f.a.i
    public void onComplete() {
        DisposableHelper.replace(this, this.scheduler.c(this));
    }

    @Override // f.a.i
    public void onError(Throwable th) {
        this.error = th;
        DisposableHelper.replace(this, this.scheduler.c(this));
    }

    @Override // f.a.i
    public void onSubscribe(b bVar) {
        if (DisposableHelper.setOnce(this, bVar)) {
            this.actual.onSubscribe(this);
        }
    }

    @Override // f.a.i
    public void onSuccess(T t) {
        this.value = t;
        DisposableHelper.replace(this, this.scheduler.c(this));
    }

    @Override // java.lang.Runnable
    public void run() {
        Throwable th = this.error;
        if (th != null) {
            this.error = null;
            this.actual.onError(th);
            return;
        }
        T t = this.value;
        if (t != null) {
            this.value = null;
            this.actual.onSuccess(t);
            return;
        }
        this.actual.onComplete();
    }
}
