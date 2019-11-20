package rx.internal.util.atomic;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* loaded from: classes2.dex */
public final class c<E> extends a<E> {
    private static final Integer kDL = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    final AtomicLong consumerIndex;
    long kDM;
    final int kDN;
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
        this.kDN = Math.min(i / 4, kDL.intValue());
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray<E> atomicReferenceArray = this.kDI;
        int i = this.mask;
        long j = this.producerIndex.get();
        int x = x(j, i);
        if (j >= this.kDM) {
            int i2 = this.kDN;
            if (a(atomicReferenceArray, x(i2 + j, i)) == null) {
                this.kDM = i2 + j;
            } else if (a(atomicReferenceArray, x) != null) {
                return false;
            }
        }
        a(atomicReferenceArray, x, e);
        eu(1 + j);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long j = this.consumerIndex.get();
        int et = et(j);
        AtomicReferenceArray<E> atomicReferenceArray = this.kDI;
        E a = a(atomicReferenceArray, et);
        if (a == null) {
            return null;
        }
        a(atomicReferenceArray, et, null);
        ev(j + 1);
        return a;
    }

    @Override // java.util.Queue
    public E peek() {
        return Du(et(this.consumerIndex.get()));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long cPl = cPl();
        while (true) {
            long cPm = cPm();
            long cPl2 = cPl();
            if (cPl == cPl2) {
                return (int) (cPm - cPl2);
            }
            cPl = cPl2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return cPm() == cPl();
    }

    private void eu(long j) {
        this.producerIndex.lazySet(j);
    }

    private void ev(long j) {
        this.consumerIndex.lazySet(j);
    }

    private long cPl() {
        return this.consumerIndex.get();
    }

    private long cPm() {
        return this.producerIndex.get();
    }
}
