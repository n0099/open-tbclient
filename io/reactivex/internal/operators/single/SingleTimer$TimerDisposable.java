package io.reactivex.internal.operators.single;

import f.b.r;
import f.b.t.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class SingleTimer$TimerDisposable extends AtomicReference<b> implements b, Runnable {
    public static final long serialVersionUID = 8465401857522493082L;
    public final r<? super Long> actual;

    public SingleTimer$TimerDisposable(r<? super Long> rVar) {
        this.actual = rVar;
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
