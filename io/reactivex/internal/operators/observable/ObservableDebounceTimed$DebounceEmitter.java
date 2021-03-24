package io.reactivex.internal.operators.observable;

import f.a.t.b;
import f.a.x.e.c.d;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class ObservableDebounceTimed$DebounceEmitter<T> extends AtomicReference<b> implements Runnable, b {
    public static final long serialVersionUID = 6812032969491025141L;
    public final long idx;
    public final AtomicBoolean once = new AtomicBoolean();
    public final d<T> parent;
    public final T value;

    public ObservableDebounceTimed$DebounceEmitter(T t, long j, d<T> dVar) {
        this.value = t;
        this.idx = j;
        this.parent = dVar;
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
        if (this.once.compareAndSet(false, true)) {
            this.parent.a(this.idx, this.value, this);
            throw null;
        }
    }

    public void setResource(b bVar) {
        DisposableHelper.replace(this, bVar);
    }
}
