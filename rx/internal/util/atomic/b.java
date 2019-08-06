package rx.internal.util.atomic;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
abstract class b<E> extends AbstractQueue<E> {
    private final AtomicReference<LinkedQueueNode<E>> kBB = new AtomicReference<>();
    private final AtomicReference<LinkedQueueNode<E>> kBC = new AtomicReference<>();

    protected final LinkedQueueNode<E> cQs() {
        return this.kBB.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> cQt() {
        return this.kBB.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(LinkedQueueNode<E> linkedQueueNode) {
        this.kBB.lazySet(linkedQueueNode);
    }

    protected final LinkedQueueNode<E> cQu() {
        return this.kBC.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> cQv() {
        return this.kBC.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(LinkedQueueNode<E> linkedQueueNode) {
        this.kBC.lazySet(linkedQueueNode);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> cQu = cQu();
        LinkedQueueNode<E> cQs = cQs();
        int i = 0;
        while (cQu != cQs && i < Integer.MAX_VALUE) {
            do {
                lvNext = cQu.lvNext();
            } while (lvNext == null);
            i++;
            cQu = lvNext;
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return cQu() == cQs();
    }
}
