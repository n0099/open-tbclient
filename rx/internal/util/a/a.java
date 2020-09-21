package rx.internal.util.a;

import java.util.Iterator;
import rx.internal.util.atomic.LinkedQueueNode;
/* loaded from: classes7.dex */
abstract class a<E> extends b<E> {
    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> eoK = eoK();
        LinkedQueueNode<E> eoI = eoI();
        int i = 0;
        while (eoK != eoI && i < Integer.MAX_VALUE) {
            do {
                lvNext = eoK.lvNext();
            } while (lvNext == null);
            i++;
            eoK = lvNext;
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return eoK() == eoI();
    }
}
