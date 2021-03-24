package io.reactivex.internal.queue;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class MpscLinkedQueue$LinkedQueueNode<E> extends AtomicReference<MpscLinkedQueue$LinkedQueueNode<E>> {
    public static final long serialVersionUID = 2404266111789071508L;
    public E value;

    public MpscLinkedQueue$LinkedQueueNode() {
    }

    public E getAndNullValue() {
        E lpValue = lpValue();
        spValue(null);
        return lpValue;
    }

    public E lpValue() {
        return this.value;
    }

    public MpscLinkedQueue$LinkedQueueNode<E> lvNext() {
        return get();
    }

    public void soNext(MpscLinkedQueue$LinkedQueueNode<E> mpscLinkedQueue$LinkedQueueNode) {
        lazySet(mpscLinkedQueue$LinkedQueueNode);
    }

    public void spValue(E e2) {
        this.value = e2;
    }

    public MpscLinkedQueue$LinkedQueueNode(E e2) {
        spValue(e2);
    }
}
