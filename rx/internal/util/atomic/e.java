package rx.internal.util.atomic;
/* loaded from: classes5.dex */
public final class e<E> extends b<E> {
    public e() {
        LinkedQueueNode<E> linkedQueueNode = new LinkedQueueNode<>();
        a(linkedQueueNode);
        b(linkedQueueNode);
        linkedQueueNode.soNext(null);
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        if (e == null) {
            throw new NullPointerException("null elements not allowed");
        }
        LinkedQueueNode<E> linkedQueueNode = new LinkedQueueNode<>(e);
        ekL().soNext(linkedQueueNode);
        a(linkedQueueNode);
        return true;
    }

    @Override // java.util.Queue
    public E poll() {
        LinkedQueueNode<E> lvNext = ekN().lvNext();
        if (lvNext != null) {
            E andNullValue = lvNext.getAndNullValue();
            b(lvNext);
            return andNullValue;
        }
        return null;
    }

    @Override // java.util.Queue
    public E peek() {
        LinkedQueueNode<E> lvNext = ekN().lvNext();
        if (lvNext != null) {
            return lvNext.lpValue();
        }
        return null;
    }
}
