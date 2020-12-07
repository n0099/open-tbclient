package io.reactivex.internal.observers;

import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes9.dex */
public abstract class BasicIntQueueDisposable<T> extends AtomicInteger implements io.reactivex.internal.a.b<T> {
    private static final long serialVersionUID = -1001730202384742097L;

    @Override // io.reactivex.internal.a.f
    public final boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called");
    }

    public final boolean offer(T t, T t2) {
        throw new UnsupportedOperationException("Should not be called");
    }
}
