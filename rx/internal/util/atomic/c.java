package rx.internal.util.atomic;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* loaded from: classes2.dex */
public final class c<E> extends a<E> {
    private static final Integer iFf = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    final AtomicLong consumerIndex;
    long iFg;
    final int iFh;
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
        this.iFh = Math.min(i / 4, iFf.intValue());
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray<E> atomicReferenceArray = this.iFc;
        int i = this.mask;
        long j = this.producerIndex.get();
        int t = t(j, i);
        if (j >= this.iFg) {
            int i2 = this.iFh;
            if (a(atomicReferenceArray, t(i2 + j, i)) == null) {
                this.iFg = i2 + j;
            } else if (a(atomicReferenceArray, t) != null) {
                return false;
            }
        }
        a(atomicReferenceArray, t, e);
        dH(1 + j);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long j = this.consumerIndex.get();
        int dG = dG(j);
        AtomicReferenceArray<E> atomicReferenceArray = this.iFc;
        E a = a(atomicReferenceArray, dG);
        if (a == null) {
            return null;
        }
        a(atomicReferenceArray, dG, null);
        dI(j + 1);
        return a;
    }

    @Override // java.util.Queue
    public E peek() {
        return yU(dG(this.consumerIndex.get()));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long ccy = ccy();
        while (true) {
            long ccz = ccz();
            long ccy2 = ccy();
            if (ccy == ccy2) {
                return (int) (ccz - ccy2);
            }
            ccy = ccy2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return ccz() == ccy();
    }

    private void dH(long j) {
        this.producerIndex.lazySet(j);
    }

    private void dI(long j) {
        this.consumerIndex.lazySet(j);
    }

    private long ccy() {
        return this.consumerIndex.get();
    }

    private long ccz() {
        return this.producerIndex.get();
    }
}
