package rx.internal.util.atomic;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes6.dex */
abstract class b<E> extends AbstractQueue<E> {
    private final AtomicReference<LinkedQueueNode<E>> npp = new AtomicReference<>();
    private final AtomicReference<LinkedQueueNode<E>> npq = new AtomicReference<>();

    protected final LinkedQueueNode<E> dQc() {
        return this.npp.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> dQd() {
        return this.npp.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(LinkedQueueNode<E> linkedQueueNode) {
        this.npp.lazySet(linkedQueueNode);
    }

    protected final LinkedQueueNode<E> dQe() {
        return this.npq.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> dQf() {
        return this.npq.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(LinkedQueueNode<E> linkedQueueNode) {
        this.npq.lazySet(linkedQueueNode);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> dQe = dQe();
        LinkedQueueNode<E> dQc = dQc();
        int i = 0;
        while (dQe != dQc && i < Integer.MAX_VALUE) {
            do {
                lvNext = dQe.lvNext();
            } while (lvNext == null);
            i++;
            dQe = lvNext;
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return dQe() == dQc();
    }
}
