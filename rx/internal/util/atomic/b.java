package rx.internal.util.atomic;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes5.dex */
abstract class b<E> extends AbstractQueue<E> {
    private final AtomicReference<LinkedQueueNode<E>> qqj = new AtomicReference<>();
    private final AtomicReference<LinkedQueueNode<E>> qqk = new AtomicReference<>();

    protected final LinkedQueueNode<E> eNv() {
        return this.qqj.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> eNw() {
        return this.qqj.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(LinkedQueueNode<E> linkedQueueNode) {
        this.qqj.lazySet(linkedQueueNode);
    }

    protected final LinkedQueueNode<E> eNx() {
        return this.qqk.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> eNy() {
        return this.qqk.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(LinkedQueueNode<E> linkedQueueNode) {
        this.qqk.lazySet(linkedQueueNode);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> eNx = eNx();
        LinkedQueueNode<E> eNv = eNv();
        int i = 0;
        while (eNx != eNv && i < Integer.MAX_VALUE) {
            do {
                lvNext = eNx.lvNext();
            } while (lvNext == null);
            i++;
            eNx = lvNext;
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return eNx() == eNv();
    }
}
