package rx.internal.util.atomic;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes6.dex */
abstract class b<E> extends AbstractQueue<E> {
    private final AtomicReference<LinkedQueueNode<E>> nUZ = new AtomicReference<>();
    private final AtomicReference<LinkedQueueNode<E>> nVa = new AtomicReference<>();

    protected final LinkedQueueNode<E> dYx() {
        return this.nUZ.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> dYy() {
        return this.nUZ.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(LinkedQueueNode<E> linkedQueueNode) {
        this.nUZ.lazySet(linkedQueueNode);
    }

    protected final LinkedQueueNode<E> dYz() {
        return this.nVa.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> dYA() {
        return this.nVa.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(LinkedQueueNode<E> linkedQueueNode) {
        this.nVa.lazySet(linkedQueueNode);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> dYz = dYz();
        LinkedQueueNode<E> dYx = dYx();
        int i = 0;
        while (dYz != dYx && i < Integer.MAX_VALUE) {
            do {
                lvNext = dYz.lvNext();
            } while (lvNext == null);
            i++;
            dYz = lvNext;
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return dYz() == dYx();
    }
}
