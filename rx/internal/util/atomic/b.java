package rx.internal.util.atomic;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes5.dex */
abstract class b<E> extends AbstractQueue<E> {
    private final AtomicReference<LinkedQueueNode<E>> nyf = new AtomicReference<>();
    private final AtomicReference<LinkedQueueNode<E>> nyg = new AtomicReference<>();

    protected final LinkedQueueNode<E> dNv() {
        return this.nyf.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> dNw() {
        return this.nyf.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(LinkedQueueNode<E> linkedQueueNode) {
        this.nyf.lazySet(linkedQueueNode);
    }

    protected final LinkedQueueNode<E> dNx() {
        return this.nyg.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> dNy() {
        return this.nyg.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(LinkedQueueNode<E> linkedQueueNode) {
        this.nyg.lazySet(linkedQueueNode);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> dNx = dNx();
        LinkedQueueNode<E> dNv = dNv();
        int i = 0;
        while (dNx != dNv && i < Integer.MAX_VALUE) {
            do {
                lvNext = dNx.lvNext();
            } while (lvNext == null);
            i++;
            dNx = lvNext;
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return dNx() == dNv();
    }
}
