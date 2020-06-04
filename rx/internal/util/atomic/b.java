package rx.internal.util.atomic;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes6.dex */
abstract class b<E> extends AbstractQueue<E> {
    private final AtomicReference<LinkedQueueNode<E>> nqz = new AtomicReference<>();
    private final AtomicReference<LinkedQueueNode<E>> nqA = new AtomicReference<>();

    protected final LinkedQueueNode<E> dQq() {
        return this.nqz.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> dQr() {
        return this.nqz.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(LinkedQueueNode<E> linkedQueueNode) {
        this.nqz.lazySet(linkedQueueNode);
    }

    protected final LinkedQueueNode<E> dQs() {
        return this.nqA.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> dQt() {
        return this.nqA.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(LinkedQueueNode<E> linkedQueueNode) {
        this.nqA.lazySet(linkedQueueNode);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> dQs = dQs();
        LinkedQueueNode<E> dQq = dQq();
        int i = 0;
        while (dQs != dQq && i < Integer.MAX_VALUE) {
            do {
                lvNext = dQs.lvNext();
            } while (lvNext == null);
            i++;
            dQs = lvNext;
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return dQs() == dQq();
    }
}
