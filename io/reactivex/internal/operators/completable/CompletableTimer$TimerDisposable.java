package io.reactivex.internal.operators.completable;

import f.a.t.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class CompletableTimer$TimerDisposable extends AtomicReference<b> implements b, Runnable {
    public static final long serialVersionUID = 3167244060586201109L;
    public final f.a.b actual;

    public CompletableTimer$TimerDisposable(f.a.b bVar) {
        this.actual = bVar;
    }

    @Override // f.a.t.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // f.a.t.b
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
