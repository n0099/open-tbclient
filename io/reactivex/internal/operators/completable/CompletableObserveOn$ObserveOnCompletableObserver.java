package io.reactivex.internal.operators.completable;

import f.a.p;
import f.a.t.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class CompletableObserveOn$ObserveOnCompletableObserver extends AtomicReference<b> implements f.a.b, b, Runnable {
    public static final long serialVersionUID = 8571289934935992137L;
    public final f.a.b actual;
    public Throwable error;
    public final p scheduler;

    public CompletableObserveOn$ObserveOnCompletableObserver(f.a.b bVar, p pVar) {
        this.actual = bVar;
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

    @Override // f.a.b
    public void onComplete() {
        DisposableHelper.replace(this, this.scheduler.c(this));
    }

    @Override // f.a.b
    public void onError(Throwable th) {
        this.error = th;
        DisposableHelper.replace(this, this.scheduler.c(this));
    }

    @Override // f.a.b
    public void onSubscribe(b bVar) {
        if (DisposableHelper.setOnce(this, bVar)) {
            this.actual.onSubscribe(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Throwable th = this.error;
        if (th != null) {
            this.error = null;
            this.actual.onError(th);
            return;
        }
        this.actual.onComplete();
    }
}
