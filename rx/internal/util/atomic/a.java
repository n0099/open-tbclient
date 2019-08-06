package rx.internal.util.atomic;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.a.h;
/* loaded from: classes2.dex */
abstract class a<E> extends AbstractQueue<E> {
    protected final AtomicReferenceArray<E> kBA;
    protected final int mask;

    public a(int i) {
        int EX = h.EX(i);
        this.mask = EX - 1;
        this.kBA = new AtomicReferenceArray<>(EX);
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
    public final int w(long j, int i) {
        return ((int) j) & i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int eW(long j) {
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
    public final E EU(int i) {
        return a(this.kBA, i);
    }
}
