package rx.internal.util.atomic;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.a.h;
/* loaded from: classes6.dex */
abstract class a<E> extends AbstractQueue<E> {
    protected final int mask;
    protected final AtomicReferenceArray<E> ogm;

    public a(int i) {
        int KU = h.KU(i);
        this.mask = KU - 1;
        this.ogm = new AtomicReferenceArray<>(KU);
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
    public final int calcElementOffset(long j, int i) {
        return ((int) j) & i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int calcElementOffset(long j) {
        return ((int) j) & this.mask;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E b(AtomicReferenceArray<E> atomicReferenceArray, int i) {
        return atomicReferenceArray.get(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(AtomicReferenceArray<E> atomicReferenceArray, int i, E e) {
        atomicReferenceArray.lazySet(i, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E lvElement(int i) {
        return b(this.ogm, i);
    }
}
