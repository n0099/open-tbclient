package h.o.d.j;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import rx.internal.util.atomic.LinkedQueueNode;
/* loaded from: classes7.dex */
public abstract class b<E> extends AbstractQueue<E> {

    /* renamed from: e  reason: collision with root package name */
    public final AtomicReference<LinkedQueueNode<E>> f67950e = new AtomicReference<>();

    /* renamed from: f  reason: collision with root package name */
    public final AtomicReference<LinkedQueueNode<E>> f67951f = new AtomicReference<>();

    public final LinkedQueueNode<E> b() {
        return this.f67951f.get();
    }

    public final LinkedQueueNode<E> c() {
        return this.f67950e.get();
    }

    public final LinkedQueueNode<E> d() {
        return this.f67951f.get();
    }

    public final LinkedQueueNode<E> e() {
        return this.f67950e.get();
    }

    public final void f(LinkedQueueNode<E> linkedQueueNode) {
        this.f67951f.lazySet(linkedQueueNode);
    }

    public final void g(LinkedQueueNode<E> linkedQueueNode) {
        this.f67950e.lazySet(linkedQueueNode);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return d() == e();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> d2 = d();
        LinkedQueueNode<E> e2 = e();
        int i = 0;
        while (d2 != e2 && i < Integer.MAX_VALUE) {
            do {
                lvNext = d2.lvNext();
            } while (lvNext == null);
            i++;
            d2 = lvNext;
        }
        return i;
    }
}
