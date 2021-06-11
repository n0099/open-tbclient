package h.o.d.j;

import rx.internal.util.atomic.LinkedQueueNode;
/* loaded from: classes8.dex */
public final class y<E> extends a<E> {
    public y() {
        c(new LinkedQueueNode<>());
        e(this.producerNode);
        this.consumerNode.soNext(null);
    }

    @Override // java.util.Queue
    public boolean offer(E e2) {
        if (e2 != null) {
            LinkedQueueNode<E> linkedQueueNode = new LinkedQueueNode<>(e2);
            this.producerNode.soNext(linkedQueueNode);
            this.producerNode = linkedQueueNode;
            return true;
        }
        throw new NullPointerException("null elements not allowed");
    }

    @Override // java.util.Queue
    public E peek() {
        LinkedQueueNode<E> lvNext = this.consumerNode.lvNext();
        if (lvNext != null) {
            return lvNext.lpValue();
        }
        return null;
    }

    @Override // java.util.Queue
    public E poll() {
        LinkedQueueNode<E> lvNext = this.consumerNode.lvNext();
        if (lvNext != null) {
            E andNullValue = lvNext.getAndNullValue();
            this.consumerNode = lvNext;
            return andNullValue;
        }
        return null;
    }
}
