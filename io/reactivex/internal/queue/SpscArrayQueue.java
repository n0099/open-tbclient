package io.reactivex.internal.queue;

import f.b.x.c.e;
import f.b.x.i.h;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* loaded from: classes7.dex */
public final class SpscArrayQueue<E> extends AtomicReferenceArray<E> implements e<E> {
    public static final Integer MAX_LOOK_AHEAD_STEP = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    public static final long serialVersionUID = -1296597691183856449L;
    public final AtomicLong consumerIndex;
    public final int lookAheadStep;
    public final int mask;
    public final AtomicLong producerIndex;
    public long producerLookAhead;

    public SpscArrayQueue(int i) {
        super(h.a(i));
        this.mask = length() - 1;
        this.producerIndex = new AtomicLong();
        this.consumerIndex = new AtomicLong();
        this.lookAheadStep = Math.min(i / 4, MAX_LOOK_AHEAD_STEP.intValue());
    }

    public int calcElementOffset(long j) {
        return this.mask & ((int) j);
    }

    public int calcElementOffset(long j, int i) {
        return ((int) j) & i;
    }

    @Override // f.b.x.c.f
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    @Override // f.b.x.c.f
    public boolean isEmpty() {
        return this.producerIndex.get() == this.consumerIndex.get();
    }

    public E lvElement(int i) {
        return get(i);
    }

    @Override // f.b.x.c.f
    public boolean offer(E e2) {
        if (e2 != null) {
            int i = this.mask;
            long j = this.producerIndex.get();
            int calcElementOffset = calcElementOffset(j, i);
            if (j >= this.producerLookAhead) {
                long j2 = this.lookAheadStep + j;
                if (lvElement(calcElementOffset(j2, i)) == null) {
                    this.producerLookAhead = j2;
                } else if (lvElement(calcElementOffset) != null) {
                    return false;
                }
            }
            soElement(calcElementOffset, e2);
            soProducerIndex(j + 1);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    @Override // f.b.x.c.e, f.b.x.c.f
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

    public void soConsumerIndex(long j) {
        this.consumerIndex.lazySet(j);
    }

    public void soElement(int i, E e2) {
        lazySet(i, e2);
    }

    public void soProducerIndex(long j) {
        this.producerIndex.lazySet(j);
    }

    public boolean offer(E e2, E e3) {
        return offer(e2) && offer(e3);
    }
}
