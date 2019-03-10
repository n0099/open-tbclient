package rx.internal.util.atomic;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
abstract class b<E> extends AbstractQueue<E> {
    private final AtomicReference<LinkedQueueNode<E>> kbs = new AtomicReference<>();
    private final AtomicReference<LinkedQueueNode<E>> kbt = new AtomicReference<>();

    protected final LinkedQueueNode<E> cEI() {
        return this.kbs.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> cEJ() {
        return this.kbs.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(LinkedQueueNode<E> linkedQueueNode) {
        this.kbs.lazySet(linkedQueueNode);
    }

    protected final LinkedQueueNode<E> cEK() {
        return this.kbt.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> cEL() {
        return this.kbt.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(LinkedQueueNode<E> linkedQueueNode) {
        this.kbt.lazySet(linkedQueueNode);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> cEK = cEK();
        LinkedQueueNode<E> cEI = cEI();
        int i = 0;
        while (cEK != cEI && i < Integer.MAX_VALUE) {
            do {
                lvNext = cEK.lvNext();
            } while (lvNext == null);
            i++;
            cEK = lvNext;
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return cEK() == cEI();
    }
}
