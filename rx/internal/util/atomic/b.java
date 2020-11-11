package rx.internal.util.atomic;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes16.dex */
abstract class b<E> extends AbstractQueue<E> {
    private final AtomicReference<LinkedQueueNode<E>> pPc = new AtomicReference<>();
    private final AtomicReference<LinkedQueueNode<E>> pPd = new AtomicReference<>();

    protected final LinkedQueueNode<E> eGg() {
        return this.pPc.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> eGh() {
        return this.pPc.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(LinkedQueueNode<E> linkedQueueNode) {
        this.pPc.lazySet(linkedQueueNode);
    }

    protected final LinkedQueueNode<E> eGi() {
        return this.pPd.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> eGj() {
        return this.pPd.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(LinkedQueueNode<E> linkedQueueNode) {
        this.pPd.lazySet(linkedQueueNode);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> eGi = eGi();
        LinkedQueueNode<E> eGg = eGg();
        int i = 0;
        while (eGi != eGg && i < Integer.MAX_VALUE) {
            do {
                lvNext = eGi.lvNext();
            } while (lvNext == null);
            i++;
            eGi = lvNext;
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return eGi() == eGg();
    }
}
