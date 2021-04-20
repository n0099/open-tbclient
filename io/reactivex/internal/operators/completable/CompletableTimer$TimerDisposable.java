package io.reactivex.internal.operators.completable;

import f.b.t.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class CompletableTimer$TimerDisposable extends AtomicReference<b> implements b, Runnable {
    public static final long serialVersionUID = 3167244060586201109L;
    public final f.b.b actual;

    public CompletableTimer$TimerDisposable(f.b.b bVar) {
        this.actual = bVar;
    }

    @Override // f.b.t.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // f.b.t.b
    public boolean isDisposed() {
        return DisposableHelper.isDisposed(get());
    }

    @Override // java.lang.Runnable
    public void run() {
        this.actual.onComplete();
    }

    public void setFuture(b bVar) {
        DisposableHelper.replace(this, bVar);
    }
}
