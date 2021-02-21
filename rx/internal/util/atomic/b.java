package rx.internal.util.atomic;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes5.dex */
abstract class b<E> extends AbstractQueue<E> {
    private final AtomicReference<LinkedQueueNode<E>> qqJ = new AtomicReference<>();
    private final AtomicReference<LinkedQueueNode<E>> qqK = new AtomicReference<>();

    protected final LinkedQueueNode<E> eND() {
        return this.qqJ.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> eNE() {
        return this.qqJ.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(LinkedQueueNode<E> linkedQueueNode) {
        this.qqJ.lazySet(linkedQueueNode);
    }

    protected final LinkedQueueNode<E> eNF() {
        return this.qqK.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> eNG() {
        return this.qqK.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(LinkedQueueNode<E> linkedQueueNode) {
        this.qqK.lazySet(linkedQueueNode);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> eNF = eNF();
        LinkedQueueNode<E> eND = eND();
        int i = 0;
        while (eNF != eND && i < Integer.MAX_VALUE) {
            do {
                lvNext = eNF.lvNext();
            } while (lvNext == null);
            i++;
            eNF = lvNext;
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return eNF() == eND();
    }
}
