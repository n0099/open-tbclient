package h.o.d.i;

import rx.internal.util.atomic.LinkedQueueNode;
/* loaded from: classes8.dex */
public final class e<E> extends b<E> {
    public e() {
        LinkedQueueNode<E> linkedQueueNode = new LinkedQueueNode<>();
        g(linkedQueueNode);
        f(linkedQueueNode);
        linkedQueueNode.soNext(null);
    }

    @Override // java.util.Queue
    public boolean offer(E e2) {
        if (e2 != null) {
            LinkedQueueNode<E> linkedQueueNode = new LinkedQueueNode<>(e2);
            c().soNext(linkedQueueNode);
            g(linkedQueueNode);
            return true;
        }
        throw new NullPointerException("null elements not allowed");
    }

    @Override // java.util.Queue
    public E peek() {
        LinkedQueueNode<E> lvNext = b().lvNext();
        if (lvNext != null) {
            return lvNext.lpValue();
        }
        return null;
    }

    @Override // java.util.Queue
    public E poll() {
        LinkedQueueNode<E> lvNext = b().lvNext();
        if (lvNext != null) {
            E andNullValue = lvNext.getAndNullValue();
            f(lvNext);
            return andNullValue;
        }
        return null;
    }
}
