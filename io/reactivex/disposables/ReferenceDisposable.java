package io.reactivex.disposables;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes25.dex */
abstract class ReferenceDisposable<T> extends AtomicReference<T> implements b {
    private static final long serialVersionUID = 6537757548749041217L;

    protected abstract void onDisposed(T t);

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReferenceDisposable(T t) {
        super(io.reactivex.internal.functions.a.k(t, "value is null"));
    }

    @Override // io.reactivex.disposables.b
    public final void dispose() {
        T andSet;
        if (get() != null && (andSet = getAndSet(null)) != null) {
            onDisposed(andSet);
        }
    }

    @Override // io.reactivex.disposables.b
    public final boolean isDisposed() {
        return get() == null;
    }
}
