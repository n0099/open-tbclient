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
        LinkedQueueNode<E> cfp = cfp();
        LinkedQueueNode<E> cfn = cfn();
        int i = 0;
        while (cfp != cfn && i < Integer.MAX_VALUE) {
            do {
                lvNext = cfp.lvNext();
            } while (lvNext == null);
            i++;
            cfp = lvNext;
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return cfp() == cfn();
    }
}
