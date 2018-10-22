package rx.internal.util.atomic;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.a.h;
/* loaded from: classes2.dex */
abstract class a<E> extends AbstractQueue<E> {
    protected final AtomicReferenceArray<E> iDs;
    protected final int mask;

    public a(int i) {
        int yE = h.yE(i);
        this.mask = yE - 1;
        this.iDs = new AtomicReferenceArray<>(yE);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int t(long j, int i) {
        return ((int) j) & i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int dL(long j) {
        return ((int) j) & this.mask;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E a(AtomicReferenceArray<E> atomicReferenceArray, int i) {
        return atomicReferenceArray.get(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(AtomicReferenceArray<E> atomicReferenceArray, int i, E e) {
        atomicReferenceArray.lazySet(i, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E yB(int i) {
        return a(this.iDs, i);
    }
}
