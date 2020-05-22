package rx.internal.util.atomic;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* loaded from: classes6.dex */
public final class c<E> extends a<E> {
    private static final Integer MAX_LOOK_AHEAD_STEP = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    final AtomicLong consumerIndex;
    final int lookAheadStep;
    final AtomicLong producerIndex;
    long producerLookAhead;

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
        this.lookAheadStep = Math.min(i / 4, MAX_LOOK_AHEAD_STEP.intValue());
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray<E> atomicReferenceArray = this.nJo;
        int i = this.mask;
        long j = this.producerIndex.get();
        int calcElementOffset = calcElementOffset(j, i);
        if (j >= this.producerLookAhead) {
            int i2 = this.lookAheadStep;
            if (b(atomicReferenceArray, calcElementOffset(i2 + j, i)) == null) {
                this.producerLookAhead = i2 + j;
            } else if (b(atomicReferenceArray, calcElementOffset) != null) {
                return false;
            }
        }
        a(atomicReferenceArray, calcElementOffset, e);
        soProducerIndex(1 + j);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        long j = this.consumerIndex.get();
        int calcElementOffset = calcElementOffset(j);
        AtomicReferenceArray<E> atomicReferenceArray = this.nJo;
        E b = b(atomicReferenceArray, calcElementOffset);
        if (b == null) {
            return null;
        }
        a(atomicReferenceArray, calcElementOffset, null);
        soConsumerIndex(j + 1);
        return b;
    }

    @Override // java.util.Queue
    public E peek() {
        return lvElement(calcElementOffset(this.consumerIndex.get()));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        long dKN = dKN();
        while (true) {
            long dKM = dKM();
            long dKN2 = dKN();
            if (dKN == dKN2) {
                return (int) (dKM - dKN2);
            }
            dKN = dKN2;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return dKM() == dKN();
    }

    private void soProducerIndex(long j) {
        this.producerIndex.lazySet(j);
    }

    private void soConsumerIndex(long j) {
        this.consumerIndex.lazySet(j);
    }

    private long dKN() {
        return this.consumerIndex.get();
    }

    private long dKM() {
        return this.producerIndex.get();
    }
}
