package rx.internal.util.atomic;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* loaded from: classes2.dex */
public final class c<E> extends a<E> {
    private static final Integer kDV = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    final AtomicLong consumerIndex;
    long kDW;
    final int kDX;
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
        this.kDX = Math.min(i / 4, kDV.intValue());
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray<E> atomicReferenceArray = this.kDS;
        int i = this.mask;
        long j = this.producerIndex.get();
        int w = w(j, i);
        if (j >= this.kDW) {
            int i2 = this.kDX;
            if (a(atomicReferenceArray, w(i2 + j, i)) == null) {
                this.kDW = i2 + j;
            } else if (a(atomicReferenceArray, w) != null) {
                return false;
            }
        }
        a(atomicReferenceArray, w, e);
        fa(1 + j);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long j = this.consumerIndex.get();
        int eZ = eZ(j);
        AtomicReferenceArray<E> atomicReferenceArray = this.kDS;
        E a = a(atomicReferenceArray, eZ);
        if (a == null) {
            return null;
        }
        a(atomicReferenceArray, eZ, null);
        fb(j + 1);
        return a;
    }

    @Override // java.util.Queue
    public E peek() {
        return EY(eZ(this.consumerIndex.get()));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long cRi = cRi();
        while (true) {
            long cRj = cRj();
            long cRi2 = cRi();
            if (cRi == cRi2) {
                return (int) (cRj - cRi2);
            }
            cRi = cRi2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return cRj() == cRi();
    }

    private void fa(long j) {
        this.producerIndex.lazySet(j);
    }

    private void fb(long j) {
        this.consumerIndex.lazySet(j);
    }

    private long cRi() {
        return this.consumerIndex.get();
    }

    private long cRj() {
        return this.producerIndex.get();
    }
}
