package io.reactivex.internal.operators.maybe;

import f.a.x.e.b.d;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class MaybeMergeArray$ClqSimpleQueue<T> extends ConcurrentLinkedQueue<T> implements d<T> {
    public static final long serialVersionUID = -4025173261791142821L;
    public int consumerIndex;
    public final AtomicInteger producerIndex = new AtomicInteger();

    @Override // f.a.x.e.b.d
    public int consumerIndex() {
        return this.consumerIndex;
    }

    @Override // f.a.x.e.b.d
    public void drop() {
        poll();
    }

    public boolean offer(T t, T t2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.Queue, f.a.x.e.b.d, f.a.x.c.f
    public T poll() {
        T t = (T) super.poll();
        if (t != null) {
            this.consumerIndex++;
        }
        return t;
    }

    @Override // f.a.x.e.b.d
    public int producerIndex() {
        return this.producerIndex.get();
    }

    @Override // java.util.concurrent.ConcurrentLinkedQueue, java.util.Queue, f.a.x.c.f
    public boolean offer(T t) {
        this.producerIndex.getAndIncrement();
        return super.offer(t);
    }
}
