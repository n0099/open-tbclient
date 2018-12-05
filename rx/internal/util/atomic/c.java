package rx.internal.util.atomic;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* loaded from: classes2.dex */
public final class c<E> extends a<E> {
    private static final Integer iMm = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    final AtomicLong consumerIndex;
    long iMn;
    final int iMo;
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
        this.iMo = Math.min(i / 4, iMm.intValue());
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray<E> atomicReferenceArray = this.iMj;
        int i = this.mask;
        long j = this.producerIndex.get();
        int t = t(j, i);
        if (j >= this.iMn) {
            int i2 = this.iMo;
            if (a(atomicReferenceArray, t(i2 + j, i)) == null) {
                this.iMn = i2 + j;
            } else if (a(atomicReferenceArray, t) != null) {
                return false;
            }
        }
        a(atomicReferenceArray, t, e);
        dO(1 + j);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long j = this.consumerIndex.get();
        int dN = dN(j);
        AtomicReferenceArray<E> atomicReferenceArray = this.iMj;
        E a = a(atomicReferenceArray, dN);
        if (a == null) {
            return null;
        }
        a(atomicReferenceArray, dN, null);
        dP(j + 1);
        return a;
    }

    @Override // java.util.Queue
    public E peek() {
        return zq(dN(this.consumerIndex.get()));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long ceB = ceB();
        while (true) {
            long ceC = ceC();
            long ceB2 = ceB();
            if (ceB == ceB2) {
                return (int) (ceC - ceB2);
            }
            ceB = ceB2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return ceC() == ceB();
    }

    private void dO(long j) {
        this.producerIndex.lazySet(j);
    }

    private void dP(long j) {
        this.consumerIndex.lazySet(j);
    }

    private long ceB() {
        return this.consumerIndex.get();
    }

    private long ceC() {
        return this.producerIndex.get();
    }
}
