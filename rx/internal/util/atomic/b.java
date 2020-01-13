package rx.internal.util.atomic;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes5.dex */
abstract class b<E> extends AbstractQueue<E> {
    private final AtomicReference<LinkedQueueNode<E>> nya = new AtomicReference<>();
    private final AtomicReference<LinkedQueueNode<E>> nyb = new AtomicReference<>();

    protected final LinkedQueueNode<E> dNt() {
        return this.nya.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> dNu() {
        return this.nya.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(LinkedQueueNode<E> linkedQueueNode) {
        this.nya.lazySet(linkedQueueNode);
    }

    protected final LinkedQueueNode<E> dNv() {
        return this.nyb.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> dNw() {
        return this.nyb.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(LinkedQueueNode<E> linkedQueueNode) {
        this.nyb.lazySet(linkedQueueNode);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> dNv = dNv();
        LinkedQueueNode<E> dNt = dNt();
        int i = 0;
        while (dNv != dNt && i < Integer.MAX_VALUE) {
            do {
                lvNext = dNv.lvNext();
            } while (lvNext == null);
            i++;
            dNv = lvNext;
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return dNv() == dNt();
    }
}
