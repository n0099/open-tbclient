package rx.internal.util.atomic;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes14.dex */
abstract class b<E> extends AbstractQueue<E> {
    private final AtomicReference<LinkedQueueNode<E>> qge = new AtomicReference<>();
    private final AtomicReference<LinkedQueueNode<E>> qgf = new AtomicReference<>();

    protected final LinkedQueueNode<E> eLf() {
        return this.qge.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> eLg() {
        return this.qge.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(LinkedQueueNode<E> linkedQueueNode) {
        this.qge.lazySet(linkedQueueNode);
    }

    protected final LinkedQueueNode<E> eLh() {
        return this.qgf.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> eLi() {
        return this.qgf.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(LinkedQueueNode<E> linkedQueueNode) {
        this.qgf.lazySet(linkedQueueNode);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> eLh = eLh();
        LinkedQueueNode<E> eLf = eLf();
        int i = 0;
        while (eLh != eLf && i < Integer.MAX_VALUE) {
            do {
                lvNext = eLh.lvNext();
            } while (lvNext == null);
            i++;
            eLh = lvNext;
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return eLh() == eLf();
    }
}
