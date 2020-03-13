package rx.internal.util.atomic;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes6.dex */
abstract class b<E> extends AbstractQueue<E> {
    private final AtomicReference<LinkedQueueNode<E>> nyU = new AtomicReference<>();
    private final AtomicReference<LinkedQueueNode<E>> nyV = new AtomicReference<>();

    protected final LinkedQueueNode<E> dOL() {
        return this.nyU.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> dOM() {
        return this.nyU.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(LinkedQueueNode<E> linkedQueueNode) {
        this.nyU.lazySet(linkedQueueNode);
    }

    protected final LinkedQueueNode<E> dON() {
        return this.nyV.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> dOO() {
        return this.nyV.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(LinkedQueueNode<E> linkedQueueNode) {
        this.nyV.lazySet(linkedQueueNode);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> dON = dON();
        LinkedQueueNode<E> dOL = dOL();
        int i = 0;
        while (dON != dOL && i < Integer.MAX_VALUE) {
            do {
                lvNext = dON.lvNext();
            } while (lvNext == null);
            i++;
            dON = lvNext;
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return dON() == dOL();
    }
}
