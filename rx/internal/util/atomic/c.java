package rx.internal.util.atomic;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* loaded from: classes2.dex */
public final class c<E> extends a<E> {
    private static final Integer iDu = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    final AtomicLong consumerIndex;
    long iDv;
    final int iDw;
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
        this.iDw = Math.min(i / 4, iDu.intValue());
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray<E> atomicReferenceArray = this.iDr;
        int i = this.mask;
        long j = this.producerIndex.get();
        int t = t(j, i);
        if (j >= this.iDv) {
            int i2 = this.iDw;
            if (a(atomicReferenceArray, t(i2 + j, i)) == null) {
                this.iDv = i2 + j;
            } else if (a(atomicReferenceArray, t) != null) {
                return false;
            }
        }
        a(atomicReferenceArray, t, e);
        dM(1 + j);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long j = this.consumerIndex.get();
        int dL = dL(j);
        AtomicReferenceArray<E> atomicReferenceArray = this.iDr;
        E a = a(atomicReferenceArray, dL);
        if (a == null) {
            return null;
        }
        a(atomicReferenceArray, dL, null);
        dN(j + 1);
        return a;
    }

    @Override // java.util.Queue
    public E peek() {
        return yB(dL(this.consumerIndex.get()));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long cdb = cdb();
        while (true) {
            long cdc = cdc();
            long cdb2 = cdb();
            if (cdb == cdb2) {
                return (int) (cdc - cdb2);
            }
            cdb = cdb2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return cdc() == cdb();
    }

    private void dM(long j) {
        this.producerIndex.lazySet(j);
    }

    private void dN(long j) {
        this.consumerIndex.lazySet(j);
    }

    private long cdb() {
        return this.consumerIndex.get();
    }

    private long cdc() {
        return this.producerIndex.get();
    }
}
