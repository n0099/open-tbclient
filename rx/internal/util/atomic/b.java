package rx.internal.util.atomic;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes4.dex */
abstract class b<E> extends AbstractQueue<E> {
    private final AtomicReference<LinkedQueueNode<E>> mVR = new AtomicReference<>();
    private final AtomicReference<LinkedQueueNode<E>> mVS = new AtomicReference<>();

    protected final LinkedQueueNode<E> dGS() {
        return this.mVR.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> dGT() {
        return this.mVR.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(LinkedQueueNode<E> linkedQueueNode) {
        this.mVR.lazySet(linkedQueueNode);
    }

    protected final LinkedQueueNode<E> dGU() {
        return this.mVS.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> dGV() {
        return this.mVS.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(LinkedQueueNode<E> linkedQueueNode) {
        this.mVS.lazySet(linkedQueueNode);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> dGU = dGU();
        LinkedQueueNode<E> dGS = dGS();
        int i = 0;
        while (dGU != dGS && i < Integer.MAX_VALUE) {
            do {
                lvNext = dGU.lvNext();
            } while (lvNext == null);
            i++;
            dGU = lvNext;
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return dGU() == dGS();
    }
}
