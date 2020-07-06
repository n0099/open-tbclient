package rx.internal.util.atomic;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes6.dex */
abstract class b<E> extends AbstractQueue<E> {
    private final AtomicReference<LinkedQueueNode<E>> nMp = new AtomicReference<>();
    private final AtomicReference<LinkedQueueNode<E>> nMq = new AtomicReference<>();

    protected final LinkedQueueNode<E> dVa() {
        return this.nMp.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> dVb() {
        return this.nMp.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(LinkedQueueNode<E> linkedQueueNode) {
        this.nMp.lazySet(linkedQueueNode);
    }

    protected final LinkedQueueNode<E> dVc() {
        return this.nMq.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> dVd() {
        return this.nMq.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(LinkedQueueNode<E> linkedQueueNode) {
        this.nMq.lazySet(linkedQueueNode);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> dVc = dVc();
        LinkedQueueNode<E> dVa = dVa();
        int i = 0;
        while (dVc != dVa && i < Integer.MAX_VALUE) {
            do {
                lvNext = dVc.lvNext();
            } while (lvNext == null);
            i++;
            dVc = lvNext;
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return dVc() == dVa();
    }
}
