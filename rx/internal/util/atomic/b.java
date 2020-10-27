package rx.internal.util.atomic;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes16.dex */
abstract class b<E> extends AbstractQueue<E> {
    private final AtomicReference<LinkedQueueNode<E>> pFI = new AtomicReference<>();
    private final AtomicReference<LinkedQueueNode<E>> pFJ = new AtomicReference<>();

    protected final LinkedQueueNode<E> eCr() {
        return this.pFI.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> eCs() {
        return this.pFI.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(LinkedQueueNode<E> linkedQueueNode) {
        this.pFI.lazySet(linkedQueueNode);
    }

    protected final LinkedQueueNode<E> eCt() {
        return this.pFJ.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> eCu() {
        return this.pFJ.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(LinkedQueueNode<E> linkedQueueNode) {
        this.pFJ.lazySet(linkedQueueNode);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> eCt = eCt();
        LinkedQueueNode<E> eCr = eCr();
        int i = 0;
        while (eCt != eCr && i < Integer.MAX_VALUE) {
            do {
                lvNext = eCt.lvNext();
            } while (lvNext == null);
            i++;
            eCt = lvNext;
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return eCt() == eCr();
    }
}
