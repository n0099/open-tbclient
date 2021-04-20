package io.reactivex.internal.operators.maybe;

import f.b.i;
import f.b.t.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class MaybeTimer$TimerDisposable extends AtomicReference<b> implements b, Runnable {
    public static final long serialVersionUID = 2875964065294031672L;
    public final i<? super Long> actual;

    public MaybeTimer$TimerDisposable(i<? super Long> iVar) {
        this.actual = iVar;
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
        this.actual.onSuccess(0L);
    }

    public void setFuture(b bVar) {
        DisposableHelper.replace(this, bVar);
    }
}
