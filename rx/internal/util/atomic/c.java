package rx.internal.util.atomic;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* loaded from: classes2.dex */
public final class c<E> extends a<E> {
    private static final Integer kbu = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    final AtomicLong consumerIndex;
    long kbv;
    final int kbw;
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
        this.kbw = Math.min(i / 4, kbu.intValue());
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray<E> atomicReferenceArray = this.kbr;
        int i = this.mask;
        long j = this.producerIndex.get();
        int y = y(j, i);
        if (j >= this.kbv) {
            int i2 = this.kbw;
            if (a(atomicReferenceArray, y(i2 + j, i)) == null) {
                this.kbv = i2 + j;
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
        AtomicReferenceArray<E> atomicReferenceArray = this.kbr;
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
        return Dr(ep(this.consumerIndex.get()));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long cEM = cEM();
        while (true) {
            long cEN = cEN();
            long cEM2 = cEM();
            if (cEM == cEM2) {
                return (int) (cEN - cEM2);
            }
            cEM = cEM2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return cEN() == cEM();
    }

    private void eq(long j) {
        this.producerIndex.lazySet(j);
    }

    private void er(long j) {
        this.consumerIndex.lazySet(j);
    }

    private long cEM() {
        return this.consumerIndex.get();
    }

    private long cEN() {
        return this.producerIndex.get();
    }
}
