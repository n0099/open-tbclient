package rx.internal.util.atomic;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* loaded from: classes2.dex */
public final class c<E> extends a<E> {
    private static final Integer kaE = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    final AtomicLong consumerIndex;
    long kaF;
    final int kaG;
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
        this.kaG = Math.min(i / 4, kaE.intValue());
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray<E> atomicReferenceArray = this.kaB;
        int i = this.mask;
        long j = this.producerIndex.get();
        int y = y(j, i);
        if (j >= this.kaF) {
            int i2 = this.kaG;
            if (a(atomicReferenceArray, y(i2 + j, i)) == null) {
                this.kaF = i2 + j;
            } else if (a(atomicReferenceArray, y) != null) {
                return false;
            }
        }
        a(atomicReferenceArray, y, e);
        ep(1 + j);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long j = this.consumerIndex.get();
        int eo = eo(j);
        AtomicReferenceArray<E> atomicReferenceArray = this.kaB;
        E a = a(atomicReferenceArray, eo);
        if (a == null) {
            return null;
        }
        a(atomicReferenceArray, eo, null);
        eq(j + 1);
        return a;
    }

    @Override // java.util.Queue
    public E peek() {
        return Dh(eo(this.consumerIndex.get()));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long cEE = cEE();
        while (true) {
            long cEF = cEF();
            long cEE2 = cEE();
            if (cEE == cEE2) {
                return (int) (cEF - cEE2);
            }
            cEE = cEE2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return cEF() == cEE();
    }

    private void ep(long j) {
        this.producerIndex.lazySet(j);
    }

    private void eq(long j) {
        this.consumerIndex.lazySet(j);
    }

    private long cEE() {
        return this.consumerIndex.get();
    }

    private long cEF() {
        return this.producerIndex.get();
    }
}
