package rx.internal.util.a;

import java.util.Iterator;
import rx.internal.util.atomic.LinkedQueueNode;
/* loaded from: classes16.dex */
abstract class a<E> extends b<E> {
    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> eCt = eCt();
        LinkedQueueNode<E> eCr = eCr();
        int i = 0;
        while (eCt != eCr && i < Integer.MAX_VALUE) {
            do {
                lvNext = eCt.lvNext();
            } while (lvNext == null);
            i++;
            eCt = lvNext;
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return eCt() == eCr();
    }
}
