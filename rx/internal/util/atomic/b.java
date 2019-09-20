package rx.internal.util.atomic;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
abstract class b<E> extends AbstractQueue<E> {
    private final AtomicReference<LinkedQueueNode<E>> kDT = new AtomicReference<>();
    private final AtomicReference<LinkedQueueNode<E>> kDU = new AtomicReference<>();

    protected final LinkedQueueNode<E> cRe() {
        return this.kDT.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> cRf() {
        return this.kDT.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(LinkedQueueNode<E> linkedQueueNode) {
        this.kDT.lazySet(linkedQueueNode);
    }

    protected final LinkedQueueNode<E> cRg() {
        return this.kDU.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> cRh() {
        return this.kDU.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(LinkedQueueNode<E> linkedQueueNode) {
        this.kDU.lazySet(linkedQueueNode);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> cRg = cRg();
        LinkedQueueNode<E> cRe = cRe();
        int i = 0;
        while (cRg != cRe && i < Integer.MAX_VALUE) {
            do {
                lvNext = cRg.lvNext();
            } while (lvNext == null);
            i++;
            cRg = lvNext;
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return cRg() == cRe();
    }
}
