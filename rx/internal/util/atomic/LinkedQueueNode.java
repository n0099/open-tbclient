package rx.internal.util.atomic;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
public final class LinkedQueueNode<E> extends AtomicReference<LinkedQueueNode<E>> {
    public static final long serialVersionUID = 2404266111789071508L;
    public E value;

    public LinkedQueueNode() {
    }

    public E getAndNullValue() {
        E lpValue = lpValue();
        spValue(null);
        return lpValue;
    }

    public E lpValue() {
        return this.value;
    }

    public LinkedQueueNode<E> lvNext() {
        return get();
    }

    public void soNext(LinkedQueueNode<E> linkedQueueNode) {
        lazySet(linkedQueueNode);
    }

    public void spValue(E e2) {
        this.value = e2;
    }

    public LinkedQueueNode(E e2) {
        spValue(e2);
    }
}
