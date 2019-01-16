package rx.internal.util.atomic;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
abstract class b<E> extends AbstractQueue<E> {
    private final AtomicReference<LinkedQueueNode<E>> iQB = new AtomicReference<>();
    private final AtomicReference<LinkedQueueNode<E>> iQC = new AtomicReference<>();

    protected final LinkedQueueNode<E> cfV() {
        return this.iQB.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> cfW() {
        return this.iQB.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(LinkedQueueNode<E> linkedQueueNode) {
        this.iQB.lazySet(linkedQueueNode);
    }

    protected final LinkedQueueNode<E> cfX() {
        return this.iQC.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> cfY() {
        return this.iQC.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(LinkedQueueNode<E> linkedQueueNode) {
        this.iQC.lazySet(linkedQueueNode);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> cfX = cfX();
        LinkedQueueNode<E> cfV = cfV();
        int i = 0;
        while (cfX != cfV && i < Integer.MAX_VALUE) {
            do {
                lvNext = cfX.lvNext();
            } while (lvNext == null);
            i++;
            cfX = lvNext;
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return cfX() == cfV();
    }
}
