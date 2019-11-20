package rx.internal.util.atomic;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
abstract class b<E> extends AbstractQueue<E> {
    private final AtomicReference<LinkedQueueNode<E>> kDJ = new AtomicReference<>();
    private final AtomicReference<LinkedQueueNode<E>> kDK = new AtomicReference<>();

    protected final LinkedQueueNode<E> cPh() {
        return this.kDJ.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> cPi() {
        return this.kDJ.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(LinkedQueueNode<E> linkedQueueNode) {
        this.kDJ.lazySet(linkedQueueNode);
    }

    protected final LinkedQueueNode<E> cPj() {
        return this.kDK.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> cPk() {
        return this.kDK.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(LinkedQueueNode<E> linkedQueueNode) {
        this.kDK.lazySet(linkedQueueNode);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> cPj = cPj();
        LinkedQueueNode<E> cPh = cPh();
        int i = 0;
        while (cPj != cPh && i < Integer.MAX_VALUE) {
            do {
                lvNext = cPj.lvNext();
            } while (lvNext == null);
            i++;
            cPj = lvNext;
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return cPj() == cPh();
    }
}
