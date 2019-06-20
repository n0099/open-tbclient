package rx.internal.util.atomic;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
abstract class b<E> extends AbstractQueue<E> {
    private final AtomicReference<LinkedQueueNode<E>> ksW = new AtomicReference<>();
    private final AtomicReference<LinkedQueueNode<E>> ksX = new AtomicReference<>();

    protected final LinkedQueueNode<E> cMh() {
        return this.ksW.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> cMi() {
        return this.ksW.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(LinkedQueueNode<E> linkedQueueNode) {
        this.ksW.lazySet(linkedQueueNode);
    }

    protected final LinkedQueueNode<E> cMj() {
        return this.ksX.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> cMk() {
        return this.ksX.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(LinkedQueueNode<E> linkedQueueNode) {
        this.ksX.lazySet(linkedQueueNode);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> cMj = cMj();
        LinkedQueueNode<E> cMh = cMh();
        int i = 0;
        while (cMj != cMh && i < Integer.MAX_VALUE) {
            do {
                lvNext = cMj.lvNext();
            } while (lvNext == null);
            i++;
            cMj = lvNext;
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return cMj() == cMh();
    }
}
