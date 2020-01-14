package rx.internal.util.a;

import java.util.Iterator;
import rx.internal.util.atomic.LinkedQueueNode;
/* loaded from: classes5.dex */
abstract class a<E> extends b<E> {
    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> dNx = dNx();
        LinkedQueueNode<E> dNv = dNv();
        int i = 0;
        while (dNx != dNv && i < Integer.MAX_VALUE) {
            do {
                lvNext = dNx.lvNext();
            } while (lvNext == null);
            i++;
            dNx = lvNext;
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return dNx() == dNv();
    }
}
