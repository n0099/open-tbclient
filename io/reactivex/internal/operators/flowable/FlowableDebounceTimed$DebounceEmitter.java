package io.reactivex.internal.operators.flowable;

import f.a.t.b;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class FlowableDebounceTimed$DebounceEmitter<T> extends AtomicReference<b> implements Runnable, b {
    public static final long serialVersionUID = 6812032969491025141L;
    public final long idx;
    public final AtomicBoolean once = new AtomicBoolean();
    public final FlowableDebounceTimed$DebounceTimedSubscriber<T> parent;
    public final T value;

    public FlowableDebounceTimed$DebounceEmitter(T t, long j, FlowableDebounceTimed$DebounceTimedSubscriber<T> flowableDebounceTimed$DebounceTimedSubscriber) {
        this.value = t;
        this.idx = j;
        this.parent = flowableDebounceTimed$DebounceTimedSubscriber;
    }

    @Override // f.a.t.b
    public void dispose() {
        DisposableHelper.dispose(this);
    }

    public void emit() {
        if (this.once.compareAndSet(false, true)) {
            this.parent.emit(this.idx, this.value, this);
        }
    }

    @Override // f.a.t.b
    public boolean isDisposed() {
        return get() == DisposableHelper.DISPOSED;
    }

    @Override // java.lang.Runnable
    public void run() {
        emit();
    }

    public void setResource(b bVar) {
        DisposableHelper.replace(this, bVar);
    }
}
