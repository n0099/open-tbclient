package io.reactivex.internal.subscriptions;

import io.reactivex.internal.a.d;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes7.dex */
public abstract class BasicQueueSubscription<T> extends AtomicLong implements d<T> {
    private static final long serialVersionUID = -6671519529404341862L;

    @Override // io.reactivex.internal.a.g
    public final boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public final boolean offer(T t, T t2) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
