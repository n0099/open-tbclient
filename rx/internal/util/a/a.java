package rx.internal.util.a;

import java.util.Iterator;
import rx.internal.util.atomic.LinkedQueueNode;
/* loaded from: classes15.dex */
abstract class a<E> extends b<E> {
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
