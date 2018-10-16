package rx.internal.util.atomic;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
abstract class b<E> extends AbstractQueue<E> {
    private final AtomicReference<LinkedQueueNode<E>> iDs = new AtomicReference<>();
    private final AtomicReference<LinkedQueueNode<E>> iDt = new AtomicReference<>();

    protected final LinkedQueueNode<E> ccX() {
        return this.iDs.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> ccY() {
        return this.iDs.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(LinkedQueueNode<E> linkedQueueNode) {
        this.iDs.lazySet(linkedQueueNode);
    }

    protected final LinkedQueueNode<E> ccZ() {
        return this.iDt.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> cda() {
        return this.iDt.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(LinkedQueueNode<E> linkedQueueNode) {
        this.iDt.lazySet(linkedQueueNode);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> ccZ = ccZ();
        LinkedQueueNode<E> ccX = ccX();
        int i = 0;
        while (ccZ != ccX && i < Integer.MAX_VALUE) {
            do {
                lvNext = ccZ.lvNext();
            } while (lvNext == null);
            i++;
            ccZ = lvNext;
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return ccZ() == ccX();
    }
}
