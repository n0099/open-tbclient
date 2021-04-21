package d.h.c.c;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Queue;
/* loaded from: classes6.dex */
public abstract class z<E> extends r<E> implements Queue<E> {
    @Override // d.h.c.c.r, d.h.c.c.y
    public abstract /* bridge */ /* synthetic */ Object delegate();

    @Override // d.h.c.c.r, d.h.c.c.y
    public abstract /* bridge */ /* synthetic */ Collection delegate();

    @Override // d.h.c.c.r, d.h.c.c.y
    public abstract Queue<E> delegate();

    @Override // java.util.Queue
    public E element() {
        return delegate().element();
    }

    public abstract boolean offer(E e2);

    @Override // java.util.Queue
    public E peek() {
        return delegate().peek();
    }

    @Override // java.util.Queue
    public E poll() {
        return delegate().poll();
    }

    @Override // java.util.Queue
    public E remove() {
        return delegate().remove();
    }

    public boolean standardOffer(E e2) {
        try {
            return add(e2);
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    public E standardPeek() {
        try {
            return element();
        } catch (NoSuchElementException unused) {
            return null;
        }
    }

    public E standardPoll() {
        try {
            return remove();
        } catch (NoSuchElementException unused) {
            return null;
        }
    }
}
