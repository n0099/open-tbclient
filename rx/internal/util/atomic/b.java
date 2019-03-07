package rx.internal.util.atomic;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
abstract class b<E> extends AbstractQueue<E> {
    private final AtomicReference<LinkedQueueNode<E>> kaZ = new AtomicReference<>();
    private final AtomicReference<LinkedQueueNode<E>> kba = new AtomicReference<>();

    protected final LinkedQueueNode<E> cEy() {
        return this.kaZ.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> cEz() {
        return this.kaZ.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(LinkedQueueNode<E> linkedQueueNode) {
        this.kaZ.lazySet(linkedQueueNode);
    }

    protected final LinkedQueueNode<E> cEA() {
        return this.kba.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> cEB() {
        return this.kba.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(LinkedQueueNode<E> linkedQueueNode) {
        this.kba.lazySet(linkedQueueNode);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> cEA = cEA();
        LinkedQueueNode<E> cEy = cEy();
        int i = 0;
        while (cEA != cEy && i < Integer.MAX_VALUE) {
            do {
                lvNext = cEA.lvNext();
            } while (lvNext == null);
            i++;
            cEA = lvNext;
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return cEA() == cEy();
    }
}
