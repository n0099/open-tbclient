package rx.internal.util.atomic;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
abstract class b<E> extends AbstractQueue<E> {
    private final AtomicReference<LinkedQueueNode<E>> ksS = new AtomicReference<>();
    private final AtomicReference<LinkedQueueNode<E>> ksT = new AtomicReference<>();

    protected final LinkedQueueNode<E> cMg() {
        return this.ksS.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> cMh() {
        return this.ksS.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(LinkedQueueNode<E> linkedQueueNode) {
        this.ksS.lazySet(linkedQueueNode);
    }

    protected final LinkedQueueNode<E> cMi() {
        return this.ksT.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> cMj() {
        return this.ksT.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(LinkedQueueNode<E> linkedQueueNode) {
        this.ksT.lazySet(linkedQueueNode);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> cMi = cMi();
        LinkedQueueNode<E> cMg = cMg();
        int i = 0;
        while (cMi != cMg && i < Integer.MAX_VALUE) {
            do {
                lvNext = cMi.lvNext();
            } while (lvNext == null);
            i++;
            cMi = lvNext;
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return cMi() == cMg();
    }
}
