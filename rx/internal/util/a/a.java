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
        LinkedQueueNode<E> eGi = eGi();
        LinkedQueueNode<E> eGg = eGg();
        int i = 0;
        while (eGi != eGg && i < Integer.MAX_VALUE) {
            do {
                lvNext = eGi.lvNext();
            } while (lvNext == null);
            i++;
            eGi = lvNext;
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return eGi() == eGg();
    }
}
