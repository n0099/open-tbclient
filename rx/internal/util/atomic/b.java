package rx.internal.util.atomic;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
abstract class b<E> extends AbstractQueue<E> {
    private final AtomicReference<LinkedQueueNode<E>> kAv = new AtomicReference<>();
    private final AtomicReference<LinkedQueueNode<E>> kAw = new AtomicReference<>();

    protected final LinkedQueueNode<E> cPX() {
        return this.kAv.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> cPY() {
        return this.kAv.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(LinkedQueueNode<E> linkedQueueNode) {
        this.kAv.lazySet(linkedQueueNode);
    }

    protected final LinkedQueueNode<E> cPZ() {
        return this.kAw.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> cQa() {
        return this.kAw.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(LinkedQueueNode<E> linkedQueueNode) {
        this.kAw.lazySet(linkedQueueNode);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> cPZ = cPZ();
        LinkedQueueNode<E> cPX = cPX();
        int i = 0;
        while (cPZ != cPX && i < Integer.MAX_VALUE) {
            do {
                lvNext = cPZ.lvNext();
            } while (lvNext == null);
            i++;
            cPZ = lvNext;
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return cPZ() == cPX();
    }
}
