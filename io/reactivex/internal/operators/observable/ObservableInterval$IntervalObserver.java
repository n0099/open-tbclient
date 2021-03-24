package io.reactivex.internal.operators.observable;

import f.a.o;
import f.a.t.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ObservableInterval$IntervalObserver extends AtomicReference<b> implements b, Runnable {
    public static final long serialVersionUID = 346773832286157679L;
    public final o<? super Long> actual;
    public long count;

    public ObservableInterval$IntervalObserver(o<? super Long> oVar) {
        this.actual = oVar;
    }

    @Override // f.a.t.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // f.a.t.b
    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (get() != DisposableHelper.DISPOSED) {
            o<? super Long> oVar = this.actual;
            long j = this.count;
            this.count = 1 + j;
            oVar.onNext(Long.valueOf(j));
        }
    }

    public void setResource(b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }
}
