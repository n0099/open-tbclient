package rx.internal.util.atomic;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes6.dex */
abstract class b<E> extends AbstractQueue<E> {
    private final AtomicReference<LinkedQueueNode<E>> nyJ = new AtomicReference<>();
    private final AtomicReference<LinkedQueueNode<E>> nyK = new AtomicReference<>();

    protected final LinkedQueueNode<E> dOK() {
        return this.nyJ.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> dOL() {
        return this.nyJ.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(LinkedQueueNode<E> linkedQueueNode) {
        this.nyJ.lazySet(linkedQueueNode);
    }

    protected final LinkedQueueNode<E> dOM() {
        return this.nyK.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> dON() {
        return this.nyK.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(LinkedQueueNode<E> linkedQueueNode) {
        this.nyK.lazySet(linkedQueueNode);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> dOM = dOM();
        LinkedQueueNode<E> dOK = dOK();
        int i = 0;
        while (dOM != dOK && i < Integer.MAX_VALUE) {
            do {
                lvNext = dOM.lvNext();
            } while (lvNext == null);
            i++;
            dOM = lvNext;
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return dOM() == dOK();
    }
}
