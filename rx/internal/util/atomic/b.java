package rx.internal.util.atomic;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes6.dex */
abstract class b<E> extends AbstractQueue<E> {
    private final AtomicReference<LinkedQueueNode<E>> nMm = new AtomicReference<>();
    private final AtomicReference<LinkedQueueNode<E>> nMn = new AtomicReference<>();

    protected final LinkedQueueNode<E> dUW() {
        return this.nMm.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> dUX() {
        return this.nMm.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(LinkedQueueNode<E> linkedQueueNode) {
        this.nMm.lazySet(linkedQueueNode);
    }

    protected final LinkedQueueNode<E> dUY() {
        return this.nMn.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> dUZ() {
        return this.nMn.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(LinkedQueueNode<E> linkedQueueNode) {
        this.nMn.lazySet(linkedQueueNode);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> dUY = dUY();
        LinkedQueueNode<E> dUW = dUW();
        int i = 0;
        while (dUY != dUW && i < Integer.MAX_VALUE) {
            do {
                lvNext = dUY.lvNext();
            } while (lvNext == null);
            i++;
            dUY = lvNext;
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return dUY() == dUW();
    }
}
