package h.o.d.j;

import h.o.d.k.i;
import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* loaded from: classes7.dex */
public abstract class a<E> extends AbstractQueue<E> {

    /* renamed from: e  reason: collision with root package name */
    public final AtomicReferenceArray<E> f69105e;

    /* renamed from: f  reason: collision with root package name */
    public final int f69106f;

    public a(int i) {
        int b2 = i.b(i);
        this.f69106f = b2 - 1;
        this.f69105e = new AtomicReferenceArray<>(b2);
    }

    public final int a(long j) {
        return this.f69106f & ((int) j);
    }

    public final int b(long j, int i) {
        return ((int) j) & i;
    }

    public final E c(int i) {
        return d(this.f69105e, i);
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
