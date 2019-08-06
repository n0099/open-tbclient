package rx.internal.util.atomic;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* loaded from: classes2.dex */
public final class c<E> extends a<E> {
    private static final Integer kBD = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    final AtomicLong consumerIndex;
    long kBE;
    final int kBF;
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
        this.kBF = Math.min(i / 4, kBD.intValue());
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray<E> atomicReferenceArray = this.kBA;
        int i = this.mask;
        long j = this.producerIndex.get();
        int w = w(j, i);
        if (j >= this.kBE) {
            int i2 = this.kBF;
            if (a(atomicReferenceArray, w(i2 + j, i)) == null) {
                this.kBE = i2 + j;
            } else if (a(atomicReferenceArray, w) != null) {
                return false;
            }
        }
        a(atomicReferenceArray, w, e);
        eX(1 + j);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long j = this.consumerIndex.get();
        int eW = eW(j);
        AtomicReferenceArray<E> atomicReferenceArray = this.kBA;
        E a = a(atomicReferenceArray, eW);
        if (a == null) {
            return null;
        }
        a(atomicReferenceArray, eW, null);
        eY(j + 1);
        return a;
    }

    @Override // java.util.Queue
    public E peek() {
        return EU(eW(this.consumerIndex.get()));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long cQw = cQw();
        while (true) {
            long cQx = cQx();
            long cQw2 = cQw();
            if (cQw == cQw2) {
                return (int) (cQx - cQw2);
            }
            cQw = cQw2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return cQx() == cQw();
    }

    private void eX(long j) {
        this.producerIndex.lazySet(j);
    }

    private void eY(long j) {
        this.consumerIndex.lazySet(j);
    }

    private long cQw() {
        return this.consumerIndex.get();
    }

    private long cQx() {
        return this.producerIndex.get();
    }
}
