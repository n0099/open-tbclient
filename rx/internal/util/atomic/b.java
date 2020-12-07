package rx.internal.util.atomic;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes12.dex */
abstract class b<E> extends AbstractQueue<E> {
    private final AtomicReference<LinkedQueueNode<E>> pHt = new AtomicReference<>();
    private final AtomicReference<LinkedQueueNode<E>> pHu = new AtomicReference<>();

    protected final LinkedQueueNode<E> eGi() {
        return this.pHt.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> eGj() {
        return this.pHt.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(LinkedQueueNode<E> linkedQueueNode) {
        this.pHt.lazySet(linkedQueueNode);
    }

    protected final LinkedQueueNode<E> eGk() {
        return this.pHu.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> eGl() {
        return this.pHu.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(LinkedQueueNode<E> linkedQueueNode) {
        this.pHu.lazySet(linkedQueueNode);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> eGk = eGk();
        LinkedQueueNode<E> eGi = eGi();
        int i = 0;
        while (eGk != eGi && i < Integer.MAX_VALUE) {
            do {
                lvNext = eGk.lvNext();
            } while (lvNext == null);
            i++;
            eGk = lvNext;
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return eGk() == eGi();
    }
}
