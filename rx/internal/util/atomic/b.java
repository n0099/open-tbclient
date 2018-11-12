package rx.internal.util.atomic;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
abstract class b<E> extends AbstractQueue<E> {
    private final AtomicReference<LinkedQueueNode<E>> iFd = new AtomicReference<>();
    private final AtomicReference<LinkedQueueNode<E>> iFe = new AtomicReference<>();

    protected final LinkedQueueNode<E> ccu() {
        return this.iFd.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> ccv() {
        return this.iFd.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(LinkedQueueNode<E> linkedQueueNode) {
        this.iFd.lazySet(linkedQueueNode);
    }

    protected final LinkedQueueNode<E> ccw() {
        return this.iFe.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> ccx() {
        return this.iFe.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(LinkedQueueNode<E> linkedQueueNode) {
        this.iFe.lazySet(linkedQueueNode);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> ccw = ccw();
        LinkedQueueNode<E> ccu = ccu();
        int i = 0;
        while (ccw != ccu && i < Integer.MAX_VALUE) {
            do {
                lvNext = ccw.lvNext();
            } while (lvNext == null);
            i++;
            ccw = lvNext;
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return ccw() == ccu();
    }
}
