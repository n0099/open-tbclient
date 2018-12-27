package rx.internal.util.atomic;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes2.dex */
abstract class b<E> extends AbstractQueue<E> {
    private final AtomicReference<LinkedQueueNode<E>> iPu = new AtomicReference<>();
    private final AtomicReference<LinkedQueueNode<E>> iPv = new AtomicReference<>();

    protected final LinkedQueueNode<E> cfn() {
        return this.iPu.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> cfo() {
        return this.iPu.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(LinkedQueueNode<E> linkedQueueNode) {
        this.iPu.lazySet(linkedQueueNode);
    }

    protected final LinkedQueueNode<E> cfp() {
        return this.iPv.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LinkedQueueNode<E> cfq() {
        return this.iPv.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(LinkedQueueNode<E> linkedQueueNode) {
        this.iPv.lazySet(linkedQueueNode);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> cfp = cfp();
        LinkedQueueNode<E> cfn = cfn();
        int i = 0;
        while (cfp != cfn && i < Integer.MAX_VALUE) {
            do {
                lvNext = cfp.lvNext();
            } while (lvNext == null);
            i++;
            cfp = lvNext;
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return cfp() == cfn();
    }
}
