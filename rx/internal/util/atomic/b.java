package rx.internal.util.atomic;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
abstract class b<E> extends AbstractQueue<E> {
    private final AtomicReference<LinkedQueueNode<E>> ksT = new AtomicReference<>();
    private final AtomicReference<LinkedQueueNode<E>> ksU = new AtomicReference<>();

    protected final LinkedQueueNode<E> cMi() {
        return this.ksT.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> cMj() {
        return this.ksT.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(LinkedQueueNode<E> linkedQueueNode) {
        this.ksT.lazySet(linkedQueueNode);
    }

    protected final LinkedQueueNode<E> cMk() {
        return this.ksU.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> cMl() {
        return this.ksU.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(LinkedQueueNode<E> linkedQueueNode) {
        this.ksU.lazySet(linkedQueueNode);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> cMk = cMk();
        LinkedQueueNode<E> cMi = cMi();
        int i = 0;
        while (cMk != cMi && i < Integer.MAX_VALUE) {
            do {
                lvNext = cMk.lvNext();
            } while (lvNext == null);
            i++;
            cMk = lvNext;
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return cMk() == cMi();
    }
}
