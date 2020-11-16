package rx.internal.util.atomic;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes14.dex */
abstract class b<E> extends AbstractQueue<E> {
    private final AtomicReference<LinkedQueueNode<E>> pQF = new AtomicReference<>();
    private final AtomicReference<LinkedQueueNode<E>> pQG = new AtomicReference<>();

    protected final LinkedQueueNode<E> eGh() {
        return this.pQF.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> eGi() {
        return this.pQF.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(LinkedQueueNode<E> linkedQueueNode) {
        this.pQF.lazySet(linkedQueueNode);
    }

    protected final LinkedQueueNode<E> eGj() {
        return this.pQG.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> eGk() {
        return this.pQG.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(LinkedQueueNode<E> linkedQueueNode) {
        this.pQG.lazySet(linkedQueueNode);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> eGj = eGj();
        LinkedQueueNode<E> eGh = eGh();
        int i = 0;
        while (eGj != eGh && i < Integer.MAX_VALUE) {
            do {
                lvNext = eGj.lvNext();
            } while (lvNext == null);
            i++;
            eGj = lvNext;
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return eGj() == eGh();
    }
}
