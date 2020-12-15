package rx.internal.util.a;

import java.util.Iterator;
import rx.internal.util.atomic.LinkedQueueNode;
/* loaded from: classes12.dex */
abstract class a<E> extends b<E> {
    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> eGl = eGl();
        LinkedQueueNode<E> eGj = eGj();
        int i = 0;
        while (eGl != eGj && i < Integer.MAX_VALUE) {
            do {
                lvNext = eGl.lvNext();
            } while (lvNext == null);
            i++;
            eGl = lvNext;
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return eGl() == eGj();
    }
}
