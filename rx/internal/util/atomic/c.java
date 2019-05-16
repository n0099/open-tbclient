package rx.internal.util.atomic;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* loaded from: classes2.dex */
public final class c<E> extends a<E> {
    private static final Integer ksU = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    final AtomicLong consumerIndex;
    long ksV;
    final int ksW;
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
        this.ksW = Math.min(i / 4, ksU.intValue());
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray<E> atomicReferenceArray = this.ksR;
        int i = this.mask;
        long j = this.producerIndex.get();
        int w = w(j, i);
        if (j >= this.ksV) {
            int i2 = this.ksW;
            if (a(atomicReferenceArray, w(i2 + j, i)) == null) {
                this.ksV = i2 + j;
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
        AtomicReferenceArray<E> atomicReferenceArray = this.ksR;
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
        long cMk = cMk();
        while (true) {
            long cMl = cMl();
            long cMk2 = cMk();
            if (cMk == cMk2) {
                return (int) (cMl - cMk2);
            }
            cMk = cMk2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return cMl() == cMk();
    }

    private void eO(long j) {
        this.producerIndex.lazySet(j);
    }

    private void eP(long j) {
        this.consumerIndex.lazySet(j);
    }

    private long cMk() {
        return this.consumerIndex.get();
    }

    private long cMl() {
        return this.producerIndex.get();
    }
}
