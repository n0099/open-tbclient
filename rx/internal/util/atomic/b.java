package rx.internal.util.atomic;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes15.dex */
abstract class b<E> extends AbstractQueue<E> {
    private final AtomicReference<LinkedQueueNode<E>> qkG = new AtomicReference<>();
    private final AtomicReference<LinkedQueueNode<E>> qkH = new AtomicReference<>();

    protected final LinkedQueueNode<E> eOV() {
        return this.qkG.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> eOW() {
        return this.qkG.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(LinkedQueueNode<E> linkedQueueNode) {
        this.qkG.lazySet(linkedQueueNode);
    }

    protected final LinkedQueueNode<E> eOX() {
        return this.qkH.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> eOY() {
        return this.qkH.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(LinkedQueueNode<E> linkedQueueNode) {
        this.qkH.lazySet(linkedQueueNode);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> eOX = eOX();
        LinkedQueueNode<E> eOV = eOV();
        int i = 0;
        while (eOX != eOV && i < Integer.MAX_VALUE) {
            do {
                lvNext = eOX.lvNext();
            } while (lvNext == null);
            i++;
            eOX = lvNext;
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return eOX() == eOV();
    }
}
