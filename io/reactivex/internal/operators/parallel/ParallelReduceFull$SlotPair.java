package io.reactivex.internal.operators.parallel;

import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes7.dex */
public final class ParallelReduceFull$SlotPair<T> extends AtomicInteger {
    public static final long serialVersionUID = 473971317683868662L;
    public T first;
    public final AtomicInteger releaseIndex = new AtomicInteger();
    public T second;

    public boolean releaseSlot() {
        return this.releaseIndex.incrementAndGet() == 2;
    }

    public int tryAcquireSlot() {
        int i;
        do {
            i = get();
            if (i >= 2) {
                return -1;
            }
        } while (!compareAndSet(i, i + 1));
        return i;
    }
}
