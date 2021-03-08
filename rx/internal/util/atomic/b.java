package rx.internal.util.atomic;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes4.dex */
abstract class b<E> extends AbstractQueue<E> {
    private final AtomicReference<LinkedQueueNode<E>> qrl = new AtomicReference<>();
    private final AtomicReference<LinkedQueueNode<E>> qrm = new AtomicReference<>();

    protected final LinkedQueueNode<E> eNl() {
        return this.qrl.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> eNm() {
        return this.qrl.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(LinkedQueueNode<E> linkedQueueNode) {
        this.qrl.lazySet(linkedQueueNode);
    }

    protected final LinkedQueueNode<E> eNn() {
        return this.qrm.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> eNo() {
        return this.qrm.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(LinkedQueueNode<E> linkedQueueNode) {
        this.qrm.lazySet(linkedQueueNode);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> eNn = eNn();
        LinkedQueueNode<E> eNl = eNl();
        int i = 0;
        while (eNn != eNl && i < Integer.MAX_VALUE) {
            do {
                lvNext = eNn.lvNext();
            } while (lvNext == null);
            i++;
            eNn = lvNext;
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return eNn() == eNl();
    }
}
