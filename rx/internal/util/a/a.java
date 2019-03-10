package rx.internal.util.a;

import java.util.Iterator;
import rx.internal.util.atomic.LinkedQueueNode;
/* loaded from: classes2.dex */
abstract class a<E> extends b<E> {
    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> cEK = cEK();
        LinkedQueueNode<E> cEI = cEI();
        int i = 0;
        while (cEK != cEI && i < Integer.MAX_VALUE) {
            do {
                lvNext = cEK.lvNext();
            } while (lvNext == null);
            i++;
            cEK = lvNext;
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return cEK() == cEI();
    }
}
