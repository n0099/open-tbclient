package io.reactivex.disposables;

import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class FutureDisposable extends AtomicReference<Future<?>> implements Disposable {
    public static final long serialVersionUID = 6545242830671168775L;
    public final boolean allowInterrupt;

    public FutureDisposable(Future<?> future, boolean z) {
        super(future);
        this.allowInterrupt = z;
    }

    @Override // io.reactivex.disposables.Disposable
    public void dispose() {
        Future<?> andSet = getAndSet(null);
        if (andSet != null) {
            andSet.cancel(this.allowInterrupt);
        }
    }

    @Override // io.reactivex.disposables.Disposable
    public boolean isDisposed() {
        Future<?> future = get();
        return future == null || future.isDone();
    }
}
