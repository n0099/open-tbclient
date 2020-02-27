package rx.internal.util.atomic;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes6.dex */
abstract class b<E> extends AbstractQueue<E> {
    private final AtomicReference<LinkedQueueNode<E>> nyH = new AtomicReference<>();
    private final AtomicReference<LinkedQueueNode<E>> nyI = new AtomicReference<>();

    protected final LinkedQueueNode<E> dOI() {
        return this.nyH.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> dOJ() {
        return this.nyH.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(LinkedQueueNode<E> linkedQueueNode) {
        this.nyH.lazySet(linkedQueueNode);
    }

    protected final LinkedQueueNode<E> dOK() {
        return this.nyI.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> dOL() {
        return this.nyI.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(LinkedQueueNode<E> linkedQueueNode) {
        this.nyI.lazySet(linkedQueueNode);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> dOK = dOK();
        LinkedQueueNode<E> dOI = dOI();
        int i = 0;
        while (dOK != dOI && i < Integer.MAX_VALUE) {
            do {
                lvNext = dOK.lvNext();
            } while (lvNext == null);
            i++;
            dOK = lvNext;
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return dOK() == dOI();
    }
}
