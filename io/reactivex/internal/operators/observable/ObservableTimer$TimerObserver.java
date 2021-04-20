package io.reactivex.internal.operators.observable;

import f.b.o;
import f.b.t.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ObservableTimer$TimerObserver extends AtomicReference<b> implements b, Runnable {
    public static final long serialVersionUID = -2809475196591179431L;
    public final o<? super Long> actual;

    public ObservableTimer$TimerObserver(o<? super Long> oVar) {
        this.actual = oVar;
    }

    @Override // f.b.t.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    @Override // f.b.t.b
    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (isDisposed()) {
            return;
        }
        this.actual.onNext(0L);
        lazySet(EmptyDisposable.INSTANCE);
        this.actual.onComplete();
    }

    public void setResource(b bVar) {
        DisposableHelper.trySet(this, bVar);
    }
}
