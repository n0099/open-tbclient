package io.reactivex.internal.subscriptions;

import f.b.x.c.d;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public abstract class BasicIntQueueSubscription<T> extends AtomicInteger implements d<T> {
    public static final long serialVersionUID = -6671519529404341862L;

    public abstract /* synthetic */ void cancel();

    public abstract /* synthetic */ void clear();

    public abstract /* synthetic */ boolean isEmpty();

    @Override // f.b.x.c.f
    public final boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public abstract /* synthetic */ T poll() throws Exception;

    public abstract /* synthetic */ void request(long j);

    public abstract /* synthetic */ int requestFusion(int i);

    public final boolean offer(T t, T t2) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
