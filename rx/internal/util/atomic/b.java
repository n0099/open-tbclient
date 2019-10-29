package rx.internal.util.atomic;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
abstract class b<E> extends AbstractQueue<E> {
    private final AtomicReference<LinkedQueueNode<E>> kEA = new AtomicReference<>();
    private final AtomicReference<LinkedQueueNode<E>> kEB = new AtomicReference<>();

    protected final LinkedQueueNode<E> cPj() {
        return this.kEA.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> cPk() {
        return this.kEA.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(LinkedQueueNode<E> linkedQueueNode) {
        this.kEA.lazySet(linkedQueueNode);
    }

    protected final LinkedQueueNode<E> cPl() {
        return this.kEB.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> cPm() {
        return this.kEB.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(LinkedQueueNode<E> linkedQueueNode) {
        this.kEB.lazySet(linkedQueueNode);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> cPl = cPl();
        LinkedQueueNode<E> cPj = cPj();
        int i = 0;
        while (cPl != cPj && i < Integer.MAX_VALUE) {
            do {
                lvNext = cPl.lvNext();
            } while (lvNext == null);
            i++;
            cPl = lvNext;
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return cPl() == cPj();
    }
}
