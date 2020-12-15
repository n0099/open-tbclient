package rx.internal.util.atomic;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes12.dex */
abstract class b<E> extends AbstractQueue<E> {
    private final AtomicReference<LinkedQueueNode<E>> pHv = new AtomicReference<>();
    private final AtomicReference<LinkedQueueNode<E>> pHw = new AtomicReference<>();

    protected final LinkedQueueNode<E> eGj() {
        return this.pHv.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> eGk() {
        return this.pHv.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(LinkedQueueNode<E> linkedQueueNode) {
        this.pHv.lazySet(linkedQueueNode);
    }

    protected final LinkedQueueNode<E> eGl() {
        return this.pHw.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> eGm() {
        return this.pHw.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(LinkedQueueNode<E> linkedQueueNode) {
        this.pHw.lazySet(linkedQueueNode);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> eGl = eGl();
        LinkedQueueNode<E> eGj = eGj();
        int i = 0;
        while (eGl != eGj && i < Integer.MAX_VALUE) {
            do {
                lvNext = eGl.lvNext();
            } while (lvNext == null);
            i++;
            eGl = lvNext;
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return eGl() == eGj();
    }
}
