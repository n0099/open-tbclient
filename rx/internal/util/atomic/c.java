package rx.internal.util.atomic;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* loaded from: classes2.dex */
public final class c<E> extends a<E> {
    private static final Integer iQE = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    final AtomicLong consumerIndex;
    long iQF;
    final int iQG;
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
        this.iQG = Math.min(i / 4, iQE.intValue());
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray<E> atomicReferenceArray = this.iQB;
        int i = this.mask;
        long j = this.producerIndex.get();
        int t = t(j, i);
        if (j >= this.iQF) {
            int i2 = this.iQG;
            if (a(atomicReferenceArray, t(i2 + j, i)) == null) {
                this.iQF = i2 + j;
            } else if (a(atomicReferenceArray, t) != null) {
                return false;
            }
        }
        a(atomicReferenceArray, t, e);
        dT(1 + j);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long j = this.consumerIndex.get();
        int dS = dS(j);
        AtomicReferenceArray<E> atomicReferenceArray = this.iQB;
        E a = a(atomicReferenceArray, dS);
        if (a == null) {
            return null;
        }
        a(atomicReferenceArray, dS, null);
        dU(j + 1);
        return a;
    }

    @Override // java.util.Queue
    public E peek() {
        return zF(dS(this.consumerIndex.get()));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long cfZ = cfZ();
        while (true) {
            long cga = cga();
            long cfZ2 = cfZ();
            if (cfZ == cfZ2) {
                return (int) (cga - cfZ2);
            }
            cfZ = cfZ2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return cga() == cfZ();
    }

    private void dT(long j) {
        this.producerIndex.lazySet(j);
    }

    private void dU(long j) {
        this.consumerIndex.lazySet(j);
    }

    private long cfZ() {
        return this.consumerIndex.get();
    }

    private long cga() {
        return this.producerIndex.get();
    }
}
