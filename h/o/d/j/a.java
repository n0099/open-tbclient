package h.o.d.j;

import java.util.Iterator;
import rx.internal.util.atomic.LinkedQueueNode;
/* loaded from: classes7.dex */
public abstract class a<E> extends b<E> {
    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return d() == b();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> d2 = d();
        LinkedQueueNode<E> b2 = b();
        int i2 = 0;
        while (d2 != b2 && i2 < Integer.MAX_VALUE) {
            do {
                lvNext = d2.lvNext();
            } while (lvNext == null);
            i2++;
            d2 = lvNext;
        }
        return i2;
    }
}
