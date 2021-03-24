package io.reactivex.internal.operators.observable;

import f.a.o;
import f.a.t.b;
import f.a.x.b.a;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes7.dex */
public final class ObservableBuffer$BufferSkipObserver<T, U extends Collection<? super T>> extends AtomicBoolean implements o<T>, b {
    public static final long serialVersionUID = -8223395059921494546L;
    public final o<? super U> actual;
    public final Callable<U> bufferSupplier;
    public final ArrayDeque<U> buffers = new ArrayDeque<>();
    public final int count;
    public long index;
    public b s;
    public final int skip;

    public ObservableBuffer$BufferSkipObserver(o<? super U> oVar, int i, int i2, Callable<U> callable) {
        this.actual = oVar;
        this.count = i;
        this.skip = i2;
        this.bufferSupplier = callable;
    }

    @Override // f.a.t.b
    public void dispose() {
        this.s.dispose();
    }

    @Override // f.a.t.b
    public boolean isDisposed() {
        return this.s.isDisposed();
    }

    @Override // f.a.o
    public void onComplete() {
        while (!this.buffers.isEmpty()) {
            this.actual.onNext(this.buffers.poll());
        }
        this.actual.onComplete();
    }

    @Override // f.a.o
    public void onError(Throwable th) {
        this.buffers.clear();
        this.actual.onError(th);
    }

    @Override // f.a.o
    public void onNext(T t) {
        long j = this.index;
        this.index = 1 + j;
        if (j % this.skip == 0) {
            try {
                U call = this.bufferSupplier.call();
                a.b(call, "The bufferSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.");
                this.buffers.offer(call);
            } catch (Throwable th) {
                this.buffers.clear();
                this.s.dispose();
                this.actual.onError(th);
                return;
            }
        }
        Iterator<U> it = this.buffers.iterator();
        while (it.hasNext()) {
            U next = it.next();
            next.add(t);
            if (this.count <= next.size()) {
                it.remove();
                this.actual.onNext(next);
            }
        }
    }

    @Override // f.a.o
    public void onSubscribe(b bVar) {
        if (DisposableHelper.validate(this.s, bVar)) {
            this.s = bVar;
            this.actual.onSubscribe(this);
        }
    }
}
