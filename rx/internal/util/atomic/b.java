package rx.internal.util.atomic;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes5.dex */
abstract class b<E> extends AbstractQueue<E> {
    private final AtomicReference<LinkedQueueNode<E>> opn = new AtomicReference<>();
    private final AtomicReference<LinkedQueueNode<E>> opo = new AtomicReference<>();

    protected final LinkedQueueNode<E> ekK() {
        return this.opn.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> ekL() {
        return this.opn.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(LinkedQueueNode<E> linkedQueueNode) {
        this.opn.lazySet(linkedQueueNode);
    }

    protected final LinkedQueueNode<E> ekM() {
        return this.opo.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> ekN() {
        return this.opo.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(LinkedQueueNode<E> linkedQueueNode) {
        this.opo.lazySet(linkedQueueNode);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> ekM = ekM();
        LinkedQueueNode<E> ekK = ekK();
        int i = 0;
        while (ekM != ekK && i < Integer.MAX_VALUE) {
            do {
                lvNext = ekM.lvNext();
            } while (lvNext == null);
            i++;
            ekM = lvNext;
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return ekM() == ekK();
    }
}
