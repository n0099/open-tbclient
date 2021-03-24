package io.reactivex.disposables;

import f.a.t.b;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class FutureDisposable extends AtomicReference<Future<?>> implements b {
    public static final long serialVersionUID = 6545242830671168775L;
    public final boolean allowInterrupt;

    public FutureDisposable(Future<?> future, boolean z) {
        super(future);
        this.allowInterrupt = z;
    }

    @Override // f.a.t.b
    public void dispose() {
        Future<?> andSet = getAndSet(null);
        if (andSet != null) {
            andSet.cancel(this.allowInterrupt);
        }
    }

    @Override // f.a.t.b
    public boolean isDisposed() {
        Future<?> future = get();
        return future == null || future.isDone();
    }
}
