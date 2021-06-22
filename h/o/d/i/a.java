package h.o.d.i;

import h.o.d.j.i;
import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* loaded from: classes8.dex */
public abstract class a<E> extends AbstractQueue<E> {

    /* renamed from: e  reason: collision with root package name */
    public final AtomicReferenceArray<E> f72046e;

    /* renamed from: f  reason: collision with root package name */
    public final int f72047f;

    public a(int i2) {
        int b2 = i.b(i2);
        this.f72047f = b2 - 1;
        this.f72046e = new AtomicReferenceArray<>(b2);
    }

    public final int a(long j) {
        return this.f72047f & ((int) j);
    }

    public final int b(long j, int i2) {
        return ((int) j) & i2;
    }

    public final E c(int i2) {
        return d(this.f72046e, i2);
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    public final E d(AtomicReferenceArray<E> atomicReferenceArray, int i2) {
        return atomicReferenceArray.get(i2);
    }

    public final void e(AtomicReferenceArray<E> atomicReferenceArray, int i2, E e2) {
        atomicReferenceArray.lazySet(i2, e2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }
}
