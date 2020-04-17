package io.reactivex.internal.queue;

import io.reactivex.internal.a.f;
import io.reactivex.internal.util.h;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* loaded from: classes7.dex */
public final class SpscArrayQueue<E> extends AtomicReferenceArray<E> implements f<E> {
    private static final Integer MAX_LOOK_AHEAD_STEP = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    private static final long serialVersionUID = -1296597691183856449L;
    final AtomicLong consumerIndex;
    final int lookAheadStep;
    final int mask;
    final AtomicLong producerIndex;
    long producerLookAhead;

    public SpscArrayQueue(int i) {
        super(h.Ja(i));
        this.mask = length() - 1;
        this.producerIndex = new AtomicLong();
        this.consumerIndex = new AtomicLong();
        this.lookAheadStep = Math.min(i / 4, MAX_LOOK_AHEAD_STEP.intValue());
    }

    @Override // io.reactivex.internal.a.g
    public boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        int i = this.mask;
        long j = this.producerIndex.get();
        int calcElementOffset = calcElementOffset(j, i);
        if (j >= this.producerLookAhead) {
            int i2 = this.lookAheadStep;
            if (lvElement(calcElementOffset(i2 + j, i)) == null) {
                this.producerLookAhead = i2 + j;
            } else if (lvElement(calcElementOffset) != null) {
                return false;
            }
        }
        soElement(calcElementOffset, e);
        soProducerIndex(1 + j);
        return true;
    }

    public boolean offer(E e, E e2) {
        return offer(e) && offer(e2);
    }

    @Override // io.reactivex.internal.a.f, io.reactivex.internal.a.g
    public E poll() {
        long j = this.consumerIndex.get();
        int calcElementOffset = calcElementOffset(j);
        E lvElement = lvElement(calcElementOffset);
        if (lvElement == null) {
            return null;
        }
        soConsumerIndex(j + 1);
        soElement(calcElementOffset, null);
        return lvElement;
    }

    @Override // io.reactivex.internal.a.g
    public boolean isEmpty() {
        return this.producerIndex.get() == this.consumerIndex.get();
    }

    void soProducerIndex(long j) {
        this.producerIndex.lazySet(j);
    }

    void soConsumerIndex(long j) {
        this.consumerIndex.lazySet(j);
    }

    @Override // io.reactivex.internal.a.g
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    int calcElementOffset(long j, int i) {
        return ((int) j) & i;
    }

    int calcElementOffset(long j) {
        return ((int) j) & this.mask;
    }

    void soElement(int i, E e) {
        lazySet(i, e);
    }

    E lvElement(int i) {
        return get(i);
    }
}
