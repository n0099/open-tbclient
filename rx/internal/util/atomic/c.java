package rx.internal.util.atomic;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* loaded from: classes2.dex */
public final class c<E> extends a<E> {
    private static final Integer kEC = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    final AtomicLong consumerIndex;
    long kED;
    final int kEE;
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
        this.kEE = Math.min(i / 4, kEC.intValue());
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray<E> atomicReferenceArray = this.kEz;
        int i = this.mask;
        long j = this.producerIndex.get();
        int x = x(j, i);
        if (j >= this.kED) {
            int i2 = this.kEE;
            if (a(atomicReferenceArray, x(i2 + j, i)) == null) {
                this.kED = i2 + j;
            } else if (a(atomicReferenceArray, x) != null) {
                return false;
            }
        }
        a(atomicReferenceArray, x, e);
        ev(1 + j);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long j = this.consumerIndex.get();
        int eu = eu(j);
        AtomicReferenceArray<E> atomicReferenceArray = this.kEz;
        E a = a(atomicReferenceArray, eu);
        if (a == null) {
            return null;
        }
        a(atomicReferenceArray, eu, null);
        ew(j + 1);
        return a;
    }

    @Override // java.util.Queue
    public E peek() {
        return Dv(eu(this.consumerIndex.get()));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long cPn = cPn();
        while (true) {
            long cPo = cPo();
            long cPn2 = cPn();
            if (cPn == cPn2) {
                return (int) (cPo - cPn2);
            }
            cPn = cPn2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return cPo() == cPn();
    }

    private void ev(long j) {
        this.producerIndex.lazySet(j);
    }

    private void ew(long j) {
        this.consumerIndex.lazySet(j);
    }

    private long cPn() {
        return this.consumerIndex.get();
    }

    private long cPo() {
        return this.producerIndex.get();
    }
}
