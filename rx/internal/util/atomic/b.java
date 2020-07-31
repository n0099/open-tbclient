package rx.internal.util.atomic;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes6.dex */
abstract class b<E> extends AbstractQueue<E> {
    private final AtomicReference<LinkedQueueNode<E>> nUX = new AtomicReference<>();
    private final AtomicReference<LinkedQueueNode<E>> nUY = new AtomicReference<>();

    protected final LinkedQueueNode<E> dYw() {
        return this.nUX.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> dYx() {
        return this.nUX.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(LinkedQueueNode<E> linkedQueueNode) {
        this.nUX.lazySet(linkedQueueNode);
    }

    protected final LinkedQueueNode<E> dYy() {
        return this.nUY.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> dYz() {
        return this.nUY.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(LinkedQueueNode<E> linkedQueueNode) {
        this.nUY.lazySet(linkedQueueNode);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> dYy = dYy();
        LinkedQueueNode<E> dYw = dYw();
        int i = 0;
        while (dYy != dYw && i < Integer.MAX_VALUE) {
            do {
                lvNext = dYy.lvNext();
            } while (lvNext == null);
            i++;
            dYy = lvNext;
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return dYy() == dYw();
    }
}
