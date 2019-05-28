package rx.internal.util.atomic;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* loaded from: classes2.dex */
public final class c<E> extends a<E> {
    private static final Integer ksV = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    final AtomicLong consumerIndex;
    long ksW;
    final int ksX;
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
        this.ksX = Math.min(i / 4, ksV.intValue());
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray<E> atomicReferenceArray = this.ksS;
        int i = this.mask;
        long j = this.producerIndex.get();
        int w = w(j, i);
        if (j >= this.ksW) {
            int i2 = this.ksX;
            if (a(atomicReferenceArray, w(i2 + j, i)) == null) {
                this.ksW = i2 + j;
            } else if (a(atomicReferenceArray, w) != null) {
                return false;
            }
        }
        a(atomicReferenceArray, w, e);
        eO(1 + j);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long j = this.consumerIndex.get();
        int eN = eN(j);
        AtomicReferenceArray<E> atomicReferenceArray = this.ksS;
        E a = a(atomicReferenceArray, eN);
        if (a == null) {
            return null;
        }
        a(atomicReferenceArray, eN, null);
        eP(j + 1);
        return a;
    }

    @Override // java.util.Queue
    public E peek() {
        return Ej(eN(this.consumerIndex.get()));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long cMm = cMm();
        while (true) {
            long cMn = cMn();
            long cMm2 = cMm();
            if (cMm == cMm2) {
                return (int) (cMn - cMm2);
            }
            cMm = cMm2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return cMn() == cMm();
    }

    private void eO(long j) {
        this.producerIndex.lazySet(j);
    }

    private void eP(long j) {
        this.consumerIndex.lazySet(j);
    }

    private long cMm() {
        return this.consumerIndex.get();
    }

    private long cMn() {
        return this.producerIndex.get();
    }
}
