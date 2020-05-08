package rx.internal.util.atomic;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes6.dex */
abstract class b<E> extends AbstractQueue<E> {
    private final AtomicReference<LinkedQueueNode<E>> mUm = new AtomicReference<>();
    private final AtomicReference<LinkedQueueNode<E>> mUn = new AtomicReference<>();

    protected final LinkedQueueNode<E> dIh() {
        return this.mUm.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> dIi() {
        return this.mUm.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(LinkedQueueNode<E> linkedQueueNode) {
        this.mUm.lazySet(linkedQueueNode);
    }

    protected final LinkedQueueNode<E> dIj() {
        return this.mUn.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> dIk() {
        return this.mUn.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(LinkedQueueNode<E> linkedQueueNode) {
        this.mUn.lazySet(linkedQueueNode);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> dIj = dIj();
        LinkedQueueNode<E> dIh = dIh();
        int i = 0;
        while (dIj != dIh && i < Integer.MAX_VALUE) {
            do {
                lvNext = dIj.lvNext();
            } while (lvNext == null);
            i++;
            dIj = lvNext;
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return dIj() == dIh();
    }
}
