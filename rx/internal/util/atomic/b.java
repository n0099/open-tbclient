package rx.internal.util.atomic;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
abstract class b<E> extends AbstractQueue<E> {
    private final AtomicReference<LinkedQueueNode<E>> iMk = new AtomicReference<>();
    private final AtomicReference<LinkedQueueNode<E>> iMl = new AtomicReference<>();

    protected final LinkedQueueNode<E> cex() {
        return this.iMk.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> cey() {
        return this.iMk.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(LinkedQueueNode<E> linkedQueueNode) {
        this.iMk.lazySet(linkedQueueNode);
    }

    protected final LinkedQueueNode<E> cez() {
        return this.iMl.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> ceA() {
        return this.iMl.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(LinkedQueueNode<E> linkedQueueNode) {
        this.iMl.lazySet(linkedQueueNode);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> cez = cez();
        LinkedQueueNode<E> cex = cex();
        int i = 0;
        while (cez != cex && i < Integer.MAX_VALUE) {
            do {
                lvNext = cez.lvNext();
            } while (lvNext == null);
            i++;
            cez = lvNext;
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return cez() == cex();
    }
}
