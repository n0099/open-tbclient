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
        LinkedQueueNode<E> cMk = cMk();
        LinkedQueueNode<E> cMi = cMi();
        int i = 0;
        while (cMk != cMi && i < Integer.MAX_VALUE) {
            do {
                lvNext = cMk.lvNext();
            } while (lvNext == null);
            i++;
            cMk = lvNext;
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return cMk() == cMi();
    }
}
