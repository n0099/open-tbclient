package rx.internal.util.atomic;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes6.dex */
abstract class b<E> extends AbstractQueue<E> {
    private final AtomicReference<LinkedQueueNode<E>> nAH = new AtomicReference<>();
    private final AtomicReference<LinkedQueueNode<E>> nAI = new AtomicReference<>();

    protected final LinkedQueueNode<E> dPl() {
        return this.nAH.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> dPm() {
        return this.nAH.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(LinkedQueueNode<E> linkedQueueNode) {
        this.nAH.lazySet(linkedQueueNode);
    }

    protected final LinkedQueueNode<E> dPn() {
        return this.nAI.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> dPo() {
        return this.nAI.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(LinkedQueueNode<E> linkedQueueNode) {
        this.nAI.lazySet(linkedQueueNode);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> dPn = dPn();
        LinkedQueueNode<E> dPl = dPl();
        int i = 0;
        while (dPn != dPl && i < Integer.MAX_VALUE) {
            do {
                lvNext = dPn.lvNext();
            } while (lvNext == null);
            i++;
            dPn = lvNext;
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return dPn() == dPl();
    }
}
