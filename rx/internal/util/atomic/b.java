package rx.internal.util.atomic;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes16.dex */
abstract class b<E> extends AbstractQueue<E> {
    private final AtomicReference<LinkedQueueNode<E>> oOl = new AtomicReference<>();
    private final AtomicReference<LinkedQueueNode<E>> oOm = new AtomicReference<>();

    protected final LinkedQueueNode<E> est() {
        return this.oOl.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> esu() {
        return this.oOl.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(LinkedQueueNode<E> linkedQueueNode) {
        this.oOl.lazySet(linkedQueueNode);
    }

    protected final LinkedQueueNode<E> esv() {
        return this.oOm.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> esw() {
        return this.oOm.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(LinkedQueueNode<E> linkedQueueNode) {
        this.oOm.lazySet(linkedQueueNode);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> esv = esv();
        LinkedQueueNode<E> est = est();
        int i = 0;
        while (esv != est && i < Integer.MAX_VALUE) {
            do {
                lvNext = esv.lvNext();
            } while (lvNext == null);
            i++;
            esv = lvNext;
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return esv() == est();
    }
}
