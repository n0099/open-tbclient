package rx.internal.util.atomic;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes6.dex */
abstract class b<E> extends AbstractQueue<E> {
    private final AtomicReference<LinkedQueueNode<E>> mUi = new AtomicReference<>();
    private final AtomicReference<LinkedQueueNode<E>> mUj = new AtomicReference<>();

    protected final LinkedQueueNode<E> dIl() {
        return this.mUi.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> dIm() {
        return this.mUi.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(LinkedQueueNode<E> linkedQueueNode) {
        this.mUi.lazySet(linkedQueueNode);
    }

    protected final LinkedQueueNode<E> dIn() {
        return this.mUj.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> dIo() {
        return this.mUj.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(LinkedQueueNode<E> linkedQueueNode) {
        this.mUj.lazySet(linkedQueueNode);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> dIn = dIn();
        LinkedQueueNode<E> dIl = dIl();
        int i = 0;
        while (dIn != dIl && i < Integer.MAX_VALUE) {
            do {
                lvNext = dIn.lvNext();
            } while (lvNext == null);
            i++;
            dIn = lvNext;
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return dIn() == dIl();
    }
}
