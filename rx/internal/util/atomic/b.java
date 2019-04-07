package rx.internal.util.atomic;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
abstract class b<E> extends AbstractQueue<E> {
    private final AtomicReference<LinkedQueueNode<E>> kaC = new AtomicReference<>();
    private final AtomicReference<LinkedQueueNode<E>> kaD = new AtomicReference<>();

    protected final LinkedQueueNode<E> cEA() {
        return this.kaC.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> cEB() {
        return this.kaC.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(LinkedQueueNode<E> linkedQueueNode) {
        this.kaC.lazySet(linkedQueueNode);
    }

    protected final LinkedQueueNode<E> cEC() {
        return this.kaD.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> cED() {
        return this.kaD.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(LinkedQueueNode<E> linkedQueueNode) {
        this.kaD.lazySet(linkedQueueNode);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> cEC = cEC();
        LinkedQueueNode<E> cEA = cEA();
        int i = 0;
        while (cEC != cEA && i < Integer.MAX_VALUE) {
            do {
                lvNext = cEC.lvNext();
            } while (lvNext == null);
            i++;
            cEC = lvNext;
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return cEC() == cEA();
    }
}
