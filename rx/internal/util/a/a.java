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
        LinkedQueueNode<E> eNx = eNx();
        LinkedQueueNode<E> eNv = eNv();
        int i = 0;
        while (eNx != eNv && i < Integer.MAX_VALUE) {
            do {
                lvNext = eNx.lvNext();
            } while (lvNext == null);
            i++;
            eNx = lvNext;
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return eNx() == eNv();
    }
}
