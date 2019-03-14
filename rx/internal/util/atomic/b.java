package rx.internal.util.atomic;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
abstract class b<E> extends AbstractQueue<E> {
    private final AtomicReference<LinkedQueueNode<E>> kbk = new AtomicReference<>();
    private final AtomicReference<LinkedQueueNode<E>> kbl = new AtomicReference<>();

    protected final LinkedQueueNode<E> cEL() {
        return this.kbk.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> cEM() {
        return this.kbk.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(LinkedQueueNode<E> linkedQueueNode) {
        this.kbk.lazySet(linkedQueueNode);
    }

    protected final LinkedQueueNode<E> cEN() {
        return this.kbl.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> cEO() {
        return this.kbl.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(LinkedQueueNode<E> linkedQueueNode) {
        this.kbl.lazySet(linkedQueueNode);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> cEN = cEN();
        LinkedQueueNode<E> cEL = cEL();
        int i = 0;
        while (cEN != cEL && i < Integer.MAX_VALUE) {
            do {
                lvNext = cEN.lvNext();
            } while (lvNext == null);
            i++;
            cEN = lvNext;
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return cEN() == cEL();
    }
}
