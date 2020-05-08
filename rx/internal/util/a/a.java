package rx.internal.util.a;

import java.util.Iterator;
import rx.internal.util.atomic.LinkedQueueNode;
/* loaded from: classes6.dex */
abstract class a<E> extends b<E> {
    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> dIj = dIj();
        LinkedQueueNode<E> dIh = dIh();
        int i = 0;
        while (dIj != dIh && i < Integer.MAX_VALUE) {
            do {
                lvNext = dIj.lvNext();
            } while (lvNext == null);
            i++;
            dIj = lvNext;
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return dIj() == dIh();
    }
}
