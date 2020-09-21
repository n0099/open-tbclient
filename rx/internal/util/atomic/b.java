package rx.internal.util.atomic;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes7.dex */
abstract class b<E> extends AbstractQueue<E> {
    private final AtomicReference<LinkedQueueNode<E>> oyW = new AtomicReference<>();
    private final AtomicReference<LinkedQueueNode<E>> oyX = new AtomicReference<>();

    protected final LinkedQueueNode<E> eoI() {
        return this.oyW.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> eoJ() {
        return this.oyW.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(LinkedQueueNode<E> linkedQueueNode) {
        this.oyW.lazySet(linkedQueueNode);
    }

    protected final LinkedQueueNode<E> eoK() {
        return this.oyX.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> eoL() {
        return this.oyX.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(LinkedQueueNode<E> linkedQueueNode) {
        this.oyX.lazySet(linkedQueueNode);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> eoK = eoK();
        LinkedQueueNode<E> eoI = eoI();
        int i = 0;
        while (eoK != eoI && i < Integer.MAX_VALUE) {
            do {
                lvNext = eoK.lvNext();
            } while (lvNext == null);
            i++;
            eoK = lvNext;
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return eoK() == eoI();
    }
}
