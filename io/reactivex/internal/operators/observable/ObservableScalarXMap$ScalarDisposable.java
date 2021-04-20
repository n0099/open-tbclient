package io.reactivex.internal.operators.observable;

import f.b.o;
import f.b.x.c.b;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class ObservableScalarXMap$ScalarDisposable<T> extends AtomicInteger implements b<T>, Runnable {
    public static final int FUSED = 1;
    public static final int ON_COMPLETE = 3;
    public static final int ON_NEXT = 2;
    public static final int START = 0;
    public static final long serialVersionUID = 3880992722410194083L;
    public final o<? super T> observer;
    public final T value;

    public ObservableScalarXMap$ScalarDisposable(o<? super T> oVar, T t) {
        this.observer = oVar;
        this.value = t;
    }

    @Override // f.b.x.c.f
    public void clear() {
        lazySet(3);
    }

    @Override // f.b.t.b
    public void dispose() {
        set(3);
    }

    @Override // f.b.t.b
    public boolean isDisposed() {
        return get() == 3;
    }

    @Override // f.b.x.c.f
    public boolean isEmpty() {
        return get() != 1;
    }

    @Override // f.b.x.c.f
    public boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // f.b.x.c.f
    public T poll() throws Exception {
        if (get() == 1) {
            lazySet(3);
            return this.value;
        }
        return null;
    }

    @Override // f.b.x.c.c
    public int requestFusion(int i) {
        if ((i & 1) != 0) {
            lazySet(1);
            return 1;
        }
        return 0;
    }

    /* JADX DEBUG: Type inference failed for r2v0. Raw type applied. Possible types: T, ? super T */
    @Override // java.lang.Runnable
    public void run() {
        if (get() == 0 && compareAndSet(0, 2)) {
            this.observer.onNext((T) this.value);
            if (get() == 2) {
                lazySet(3);
                this.observer.onComplete();
            }
        }
    }

    public boolean offer(T t, T t2) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
