package h.o.d.j;

import h.o.d.k.i;
import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* loaded from: classes7.dex */
public abstract class a<E> extends AbstractQueue<E> {

    /* renamed from: e  reason: collision with root package name */
    public final AtomicReferenceArray<E> f67948e;

    /* renamed from: f  reason: collision with root package name */
    public final int f67949f;

    public a(int i) {
        int b2 = i.b(i);
        this.f67949f = b2 - 1;
        this.f67948e = new AtomicReferenceArray<>(b2);
    }

    public final int a(long j) {
        return this.f67949f & ((int) j);
    }

    public final int b(long j, int i) {
        return ((int) j) & i;
    }

    public final E c(int i) {
        return d(this.f67948e, i);
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    public final E d(AtomicReferenceArray<E> atomicReferenceArray, int i) {
        return atomicReferenceArray.get(i);
    }

    public final void e(AtomicReferenceArray<E> atomicReferenceArray, int i, E e2) {
        atomicReferenceArray.lazySet(i, e2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }
}
