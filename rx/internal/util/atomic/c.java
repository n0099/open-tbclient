package rx.internal.util.atomic;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* loaded from: classes2.dex */
public final class c<E> extends a<E> {
    private static final Integer kbb = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    final AtomicLong consumerIndex;
    long kbc;
    final int kbd;
    final AtomicLong producerIndex;

    @Override // rx.internal.util.atomic.a, java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // rx.internal.util.atomic.a, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return super.iterator();
    }

    public c(int i) {
        super(i);
        this.producerIndex = new AtomicLong();
        this.consumerIndex = new AtomicLong();
        this.kbd = Math.min(i / 4, kbb.intValue());
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray<E> atomicReferenceArray = this.kaY;
        int i = this.mask;
        long j = this.producerIndex.get();
        int y = y(j, i);
        if (j >= this.kbc) {
            int i2 = this.kbd;
            if (a(atomicReferenceArray, y(i2 + j, i)) == null) {
                this.kbc = i2 + j;
            } else if (a(atomicReferenceArray, y) != null) {
                return false;
            }
        }
        a(atomicReferenceArray, y, e);
        eq(1 + j);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long j = this.consumerIndex.get();
        int ep = ep(j);
        AtomicReferenceArray<E> atomicReferenceArray = this.kaY;
        E a = a(atomicReferenceArray, ep);
        if (a == null) {
            return null;
        }
        a(atomicReferenceArray, ep, null);
        er(j + 1);
        return a;
    }

    @Override // java.util.Queue
    public E peek() {
        return Dq(ep(this.consumerIndex.get()));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long cEC = cEC();
        while (true) {
            long cED = cED();
            long cEC2 = cEC();
            if (cEC == cEC2) {
                return (int) (cED - cEC2);
            }
            cEC = cEC2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return cED() == cEC();
    }

    private void eq(long j) {
        this.producerIndex.lazySet(j);
    }

    private void er(long j) {
        this.consumerIndex.lazySet(j);
    }

    private long cEC() {
        return this.consumerIndex.get();
    }

    private long cED() {
        return this.producerIndex.get();
    }
}
