package io.reactivex.internal.queue;

import io.reactivex.annotations.Nullable;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.util.Pow2;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* loaded from: classes7.dex */
public final class SpscLinkedArrayQueue<T> implements SimplePlainQueue<T> {
    public AtomicReferenceArray<Object> consumerBuffer;
    public final int consumerMask;
    public AtomicReferenceArray<Object> producerBuffer;
    public long producerLookAhead;
    public int producerLookAheadStep;
    public final int producerMask;
    public static final int MAX_LOOK_AHEAD_STEP = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    public static final Object HAS_NEXT = new Object();
    public final AtomicLong producerIndex = new AtomicLong();
    public final AtomicLong consumerIndex = new AtomicLong();

    public SpscLinkedArrayQueue(int i2) {
        int roundToPowerOfTwo = Pow2.roundToPowerOfTwo(Math.max(8, i2));
        int i3 = roundToPowerOfTwo - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(roundToPowerOfTwo + 1);
        this.producerBuffer = atomicReferenceArray;
        this.producerMask = i3;
        adjustLookAheadStep(roundToPowerOfTwo);
        this.consumerBuffer = atomicReferenceArray;
        this.consumerMask = i3;
        this.producerLookAhead = i3 - 1;
        soProducerIndex(0L);
    }

    private void adjustLookAheadStep(int i2) {
        this.producerLookAheadStep = Math.min(i2 / 4, MAX_LOOK_AHEAD_STEP);
    }

    public static int calcDirectOffset(int i2) {
        return i2;
    }

    public static int calcWrappedOffset(long j, int i2) {
        return calcDirectOffset(((int) j) & i2);
    }

    private long lpConsumerIndex() {
        return this.consumerIndex.get();
    }

    private long lpProducerIndex() {
        return this.producerIndex.get();
    }

    private long lvConsumerIndex() {
        return this.consumerIndex.get();
    }

    public static <E> Object lvElement(AtomicReferenceArray<Object> atomicReferenceArray, int i2) {
        return atomicReferenceArray.get(i2);
    }

    private AtomicReferenceArray<Object> lvNextBufferAndUnlink(AtomicReferenceArray<Object> atomicReferenceArray, int i2) {
        int calcDirectOffset = calcDirectOffset(i2);
        AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) lvElement(atomicReferenceArray, calcDirectOffset);
        soElement(atomicReferenceArray, calcDirectOffset, null);
        return atomicReferenceArray2;
    }

    private long lvProducerIndex() {
        return this.producerIndex.get();
    }

    private T newBufferPeek(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i2) {
        this.consumerBuffer = atomicReferenceArray;
        return (T) lvElement(atomicReferenceArray, calcWrappedOffset(j, i2));
    }

    private T newBufferPoll(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i2) {
        this.consumerBuffer = atomicReferenceArray;
        int calcWrappedOffset = calcWrappedOffset(j, i2);
        T t = (T) lvElement(atomicReferenceArray, calcWrappedOffset);
        if (t != null) {
            soElement(atomicReferenceArray, calcWrappedOffset, null);
            soConsumerIndex(j + 1);
        }
        return t;
    }

    private void resize(AtomicReferenceArray<Object> atomicReferenceArray, long j, int i2, T t, long j2) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.producerBuffer = atomicReferenceArray2;
        this.producerLookAhead = (j2 + j) - 1;
        soElement(atomicReferenceArray2, i2, t);
        soNext(atomicReferenceArray, atomicReferenceArray2);
        soElement(atomicReferenceArray, i2, HAS_NEXT);
        soProducerIndex(j + 1);
    }

    private void soConsumerIndex(long j) {
        this.consumerIndex.lazySet(j);
    }

    public static void soElement(AtomicReferenceArray<Object> atomicReferenceArray, int i2, Object obj) {
        atomicReferenceArray.lazySet(i2, obj);
    }

    private void soNext(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        soElement(atomicReferenceArray, calcDirectOffset(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private void soProducerIndex(long j) {
        this.producerIndex.lazySet(j);
    }

    private boolean writeToQueue(AtomicReferenceArray<Object> atomicReferenceArray, T t, long j, int i2) {
        soElement(atomicReferenceArray, i2, t);
        soProducerIndex(j + 1);
        return true;
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean isEmpty() {
        return lvProducerIndex() == lvConsumerIndex();
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(T t) {
        if (t != null) {
            AtomicReferenceArray<Object> atomicReferenceArray = this.producerBuffer;
            long lpProducerIndex = lpProducerIndex();
            int i2 = this.producerMask;
            int calcWrappedOffset = calcWrappedOffset(lpProducerIndex, i2);
            if (lpProducerIndex < this.producerLookAhead) {
                return writeToQueue(atomicReferenceArray, t, lpProducerIndex, calcWrappedOffset);
            }
            long j = this.producerLookAheadStep + lpProducerIndex;
            if (lvElement(atomicReferenceArray, calcWrappedOffset(j, i2)) == null) {
                this.producerLookAhead = j - 1;
                return writeToQueue(atomicReferenceArray, t, lpProducerIndex, calcWrappedOffset);
            } else if (lvElement(atomicReferenceArray, calcWrappedOffset(1 + lpProducerIndex, i2)) == null) {
                return writeToQueue(atomicReferenceArray, t, lpProducerIndex, calcWrappedOffset);
            } else {
                resize(atomicReferenceArray, lpProducerIndex, calcWrappedOffset, t, i2);
                return true;
            }
        }
        throw new NullPointerException("Null is not a valid element");
    }

    public T peek() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.consumerBuffer;
        long lpConsumerIndex = lpConsumerIndex();
        int i2 = this.consumerMask;
        T t = (T) lvElement(atomicReferenceArray, calcWrappedOffset(lpConsumerIndex, i2));
        return t == HAS_NEXT ? newBufferPeek(lvNextBufferAndUnlink(atomicReferenceArray, i2 + 1), lpConsumerIndex, i2) : t;
    }

    @Override // io.reactivex.internal.fuseable.SimplePlainQueue, io.reactivex.internal.fuseable.SimpleQueue
    @Nullable
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.consumerBuffer;
        long lpConsumerIndex = lpConsumerIndex();
        int i2 = this.consumerMask;
        int calcWrappedOffset = calcWrappedOffset(lpConsumerIndex, i2);
        T t = (T) lvElement(atomicReferenceArray, calcWrappedOffset);
        boolean z = t == HAS_NEXT;
        if (t == null || z) {
            if (z) {
                return newBufferPoll(lvNextBufferAndUnlink(atomicReferenceArray, i2 + 1), lpConsumerIndex, i2);
            }
            return null;
        }
        soElement(atomicReferenceArray, calcWrappedOffset, null);
        soConsumerIndex(lpConsumerIndex + 1);
        return t;
    }

    public int size() {
        long lvConsumerIndex = lvConsumerIndex();
        while (true) {
            long lvProducerIndex = lvProducerIndex();
            long lvConsumerIndex2 = lvConsumerIndex();
            if (lvConsumerIndex == lvConsumerIndex2) {
                return (int) (lvProducerIndex - lvConsumerIndex2);
            }
            lvConsumerIndex = lvConsumerIndex2;
        }
    }

    @Override // io.reactivex.internal.fuseable.SimpleQueue
    public boolean offer(T t, T t2) {
        AtomicReferenceArray<Object> atomicReferenceArray = this.producerBuffer;
        long lvProducerIndex = lvProducerIndex();
        int i2 = this.producerMask;
        long j = 2 + lvProducerIndex;
        if (lvElement(atomicReferenceArray, calcWrappedOffset(j, i2)) == null) {
            int calcWrappedOffset = calcWrappedOffset(lvProducerIndex, i2);
            soElement(atomicReferenceArray, calcWrappedOffset + 1, t2);
            soElement(atomicReferenceArray, calcWrappedOffset, t);
            soProducerIndex(j);
            return true;
        }
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
        this.producerBuffer = atomicReferenceArray2;
        int calcWrappedOffset2 = calcWrappedOffset(lvProducerIndex, i2);
        soElement(atomicReferenceArray2, calcWrappedOffset2 + 1, t2);
        soElement(atomicReferenceArray2, calcWrappedOffset2, t);
        soNext(atomicReferenceArray, atomicReferenceArray2);
        soElement(atomicReferenceArray, calcWrappedOffset2, HAS_NEXT);
        soProducerIndex(j);
        return true;
    }
}
