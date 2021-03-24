package io.reactivex.internal.observers;

import f.a.a0.a;
import f.a.o;
/* loaded from: classes7.dex */
public class DeferredScalarDisposable<T> extends BasicIntQueueDisposable<T> {
    public static final int DISPOSED = 4;
    public static final int FUSED_CONSUMED = 32;
    public static final int FUSED_EMPTY = 8;
    public static final int FUSED_READY = 16;
    public static final int TERMINATED = 2;
    public static final long serialVersionUID = -5502432239815349361L;
    public final o<? super T> actual;
    public T value;

    public DeferredScalarDisposable(o<? super T> oVar) {
        this.actual = oVar;
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, f.a.x.c.f
    public final void clear() {
        lazySet(32);
        this.value = null;
    }

    public final void complete(T t) {
        int i = get();
        if ((i & 54) != 0) {
            return;
        }
        if (i == 8) {
            this.value = t;
            lazySet(16);
        } else {
            lazySet(2);
        }
        o<? super T> oVar = this.actual;
        oVar.onNext(t);
        if (get() != 4) {
            oVar.onComplete();
        }
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, f.a.t.b
    public void dispose() {
        set(4);
        this.value = null;
    }

    public final void error(Throwable th) {
        if ((get() & 54) != 0) {
            a.f(th);
            return;
        }
        lazySet(2);
        this.actual.onError(th);
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, f.a.t.b
    public final boolean isDisposed() {
        return get() == 4;
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, f.a.x.c.f
    public final boolean isEmpty() {
        return get() != 16;
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, f.a.x.c.f
    public final T poll() throws Exception {
        if (get() == 16) {
            T t = this.value;
            this.value = null;
            lazySet(32);
            return t;
        }
        return null;
    }

    @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, f.a.x.c.c
    public final int requestFusion(int i) {
        if ((i & 2) != 0) {
            lazySet(8);
            return 2;
        }
        return 0;
    }

    public final boolean tryDispose() {
        return getAndSet(4) != 4;
    }

    public final void complete() {
        if ((get() & 54) != 0) {
            return;
        }
        lazySet(2);
        this.actual.onComplete();
    }
}
