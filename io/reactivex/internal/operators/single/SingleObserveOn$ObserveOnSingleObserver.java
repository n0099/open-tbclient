package io.reactivex.internal.operators.single;

import f.b.p;
import f.b.r;
import f.b.t.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class SingleObserveOn$ObserveOnSingleObserver<T> extends AtomicReference<b> implements r<T>, b, Runnable {
    public static final long serialVersionUID = 3528003840217436037L;
    public final r<? super T> actual;
    public Throwable error;
    public final p scheduler;
    public T value;

    public SingleObserveOn$ObserveOnSingleObserver(r<? super T> rVar, p pVar) {
        this.actual = rVar;
        this.scheduler = pVar;
    }

    @Override // f.b.t.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // f.b.t.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // f.b.r
    public void onError(Throwable th) {
        this.error = th;
        DisposableHelper.replace(this, this.scheduler.c(this));
    }

    @Override // f.b.r
    public void onSubscribe(b bVar) {
        if (DisposableHelper.setOnce(this, bVar)) {
            this.actual.onSubscribe(this);
        }
    }

    @Override // f.b.r
    public void onSuccess(T t) {
        this.value = t;
        DisposableHelper.replace(this, this.scheduler.c(this));
    }

    /* JADX DEBUG: Type inference failed for r1v0. Raw type applied. Possible types: T, ? super T */
    @Override // java.lang.Runnable
    public void run() {
        Throwable th = this.error;
        if (th != null) {
            this.actual.onError(th);
        } else {
            this.actual.onSuccess((T) this.value);
        }
    }
}
