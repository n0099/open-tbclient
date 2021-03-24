package io.reactivex.internal.operators.observable;

import f.a.o;
import f.a.t.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ObservableIntervalRange$IntervalRangeObserver extends AtomicReference<b> implements b, Runnable {
    public static final long serialVersionUID = 1891866368734007884L;
    public final o<? super Long> actual;
    public long count;
    public final long end;

    public ObservableIntervalRange$IntervalRangeObserver(o<? super Long> oVar, long j, long j2) {
        this.actual = oVar;
        this.count = j;
        this.end = j2;
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
        if (isDisposed()) {
            return;
        }
        long j = this.count;
        this.actual.onNext(Long.valueOf(j));
        if (j == this.end) {
            DisposableHelper.dispose(this);
            this.actual.onComplete();
            return;
        }
        this.count = j + 1;
    }

    public void setResource(b bVar) {
        DisposableHelper.setOnce(this, bVar);
    }
}
