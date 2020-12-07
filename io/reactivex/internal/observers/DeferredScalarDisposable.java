package io.reactivex.internal.observers;

import io.reactivex.u;
/* loaded from: classes9.dex */
public class DeferredScalarDisposable<T> extends BasicIntQueueDisposable<T> {
    static final int DISPOSED = 4;
    static final int FUSED_CONSUMED = 32;
    static final int FUSED_EMPTY = 8;
    static final int FUSED_READY = 16;
    static final int TERMINATED = 2;
    private static final long serialVersionUID = -5502432239815349361L;
    protected final u<? super T> actual;
    protected T value;

    public DeferredScalarDisposable(u<? super T> uVar) {
        this.actual = uVar;
    }

    @Override // io.reactivex.internal.a.c
    public final int requestFusion(int i) {
        if ((i & 2) != 0) {
            lazySet(8);
            return 2;
        }
        return 0;
    }

    public final void complete(T t) {
        int i = get();
        if ((i & 54) == 0) {
            if (i == 8) {
                this.value = t;
                lazySet(16);
            } else {
                lazySet(2);
            }
            u<? super T> uVar = this.actual;
            uVar.onNext(t);
            if (get() != 4) {
                uVar.onComplete();
            }
        }
    }

    public final void error(Throwable th) {
        if ((get() & 54) != 0) {
            io.reactivex.d.a.onError(th);
            return;
        }
        lazySet(2);
        this.actual.onError(th);
    }

    public final void complete() {
        if ((get() & 54) == 0) {
            lazySet(2);
            this.actual.onComplete();
        }
    }

    @Override // io.reactivex.internal.a.f
    public final T poll() throws Exception {
        if (get() == 16) {
            T t = this.value;
            this.value = null;
            lazySet(32);
            return t;
        }
        return null;
    }

    @Override // io.reactivex.internal.a.f
    public final boolean isEmpty() {
        return get() != 16;
    }

    @Override // io.reactivex.internal.a.f
    public final void clear() {
        lazySet(32);
        this.value = null;
    }

    @Override // io.reactivex.disposables.b
    public void dispose() {
        set(4);
        this.value = null;
    }

    public final boolean tryDispose() {
        return getAndSet(4) != 4;
    }

    @Override // io.reactivex.disposables.b
    public final boolean isDisposed() {
        return get() == 4;
    }
}
