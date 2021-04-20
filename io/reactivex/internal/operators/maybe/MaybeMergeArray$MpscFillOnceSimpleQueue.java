package io.reactivex.internal.operators.maybe;

import f.b.x.b.a;
import f.b.x.e.b.d;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* loaded from: classes7.dex */
public final class MaybeMergeArray$MpscFillOnceSimpleQueue<T> extends AtomicReferenceArray<T> implements d<T> {
    public static final long serialVersionUID = -7969063454040569579L;
    public int consumerIndex;
    public final AtomicInteger producerIndex;

    public MaybeMergeArray$MpscFillOnceSimpleQueue(int i) {
        super(i);
        this.producerIndex = new AtomicInteger();
    }

    @Override // f.b.x.c.f
    public void clear() {
        while (poll() != null && !isEmpty()) {
        }
    }

    @Override // f.b.x.e.b.d
    public int consumerIndex() {
        return this.consumerIndex;
    }

    @Override // f.b.x.e.b.d
    public void drop() {
        int i = this.consumerIndex;
        lazySet(i, null);
        this.consumerIndex = i + 1;
    }

    @Override // f.b.x.c.f
    public boolean isEmpty() {
        return this.consumerIndex == producerIndex();
    }

    @Override // f.b.x.c.f
    public boolean offer(T t) {
        a.b(t, "value is null");
        int andIncrement = this.producerIndex.getAndIncrement();
        if (andIncrement < length()) {
            lazySet(andIncrement, t);
            return true;
        }
        return false;
    }

    @Override // f.b.x.e.b.d
    public T peek() {
        int i = this.consumerIndex;
        if (i == length()) {
            return null;
        }
        return get(i);
    }

    @Override // f.b.x.e.b.d, f.b.x.c.f
    public T poll() {
        int i = this.consumerIndex;
        if (i == length()) {
            return null;
        }
        AtomicInteger atomicInteger = this.producerIndex;
        do {
            T t = get(i);
            if (t != null) {
                this.consumerIndex = i + 1;
                lazySet(i, null);
                return t;
            }
        } while (atomicInteger.get() != i);
        return null;
    }

    @Override // f.b.x.e.b.d
    public int producerIndex() {
        return this.producerIndex.get();
    }

    public boolean offer(T t, T t2) {
        throw new UnsupportedOperationException();
    }
}
