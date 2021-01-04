package rx.internal.util.atomic;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes15.dex */
abstract class b<E> extends AbstractQueue<E> {
    private final AtomicReference<LinkedQueueNode<E>> qiY = new AtomicReference<>();
    private final AtomicReference<LinkedQueueNode<E>> qiZ = new AtomicReference<>();

    protected final LinkedQueueNode<E> eOr() {
        return this.qiY.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> eOs() {
        return this.qiY.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(LinkedQueueNode<E> linkedQueueNode) {
        this.qiY.lazySet(linkedQueueNode);
    }

    protected final LinkedQueueNode<E> eOt() {
        return this.qiZ.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> eOu() {
        return this.qiZ.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(LinkedQueueNode<E> linkedQueueNode) {
        this.qiZ.lazySet(linkedQueueNode);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> eOt = eOt();
        LinkedQueueNode<E> eOr = eOr();
        int i = 0;
        while (eOt != eOr && i < Integer.MAX_VALUE) {
            do {
                lvNext = eOt.lvNext();
            } while (lvNext == null);
            i++;
            eOt = lvNext;
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return eOt() == eOr();
    }
}
