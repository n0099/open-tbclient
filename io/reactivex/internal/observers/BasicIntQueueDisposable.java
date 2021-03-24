package io.reactivex.internal.observers;

import f.a.x.c.b;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public abstract class BasicIntQueueDisposable<T> extends AtomicInteger implements b<T> {
    public static final long serialVersionUID = -1001730202384742097L;

    @Override // f.a.x.c.f
    public abstract /* synthetic */ void clear();

    @Override // f.a.t.b
    public abstract /* synthetic */ void dispose();

    @Override // f.a.t.b
    public abstract /* synthetic */ boolean isDisposed();

    @Override // f.a.x.c.f
    public abstract /* synthetic */ boolean isEmpty();

    @Override // f.a.x.c.f
    public final boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called");
    }

    @Override // f.a.x.c.f
    public abstract /* synthetic */ T poll() throws Exception;

    @Override // f.a.x.c.c
    public abstract /* synthetic */ int requestFusion(int i);

    public final boolean offer(T t, T t2) {
        throw new UnsupportedOperationException("Should not be called");
    }
}
