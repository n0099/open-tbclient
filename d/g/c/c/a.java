package d.g.c.c;

import java.util.NoSuchElementException;
/* loaded from: classes6.dex */
public abstract class a<E> extends d1<E> {

    /* renamed from: e  reason: collision with root package name */
    public final int f66969e;

    /* renamed from: f  reason: collision with root package name */
    public int f66970f;

    public a(int i) {
        this(i, 0);
    }

    public abstract E a(int i);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f66970f < this.f66969e;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f66970f > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final E next() {
        if (hasNext()) {
            int i = this.f66970f;
            this.f66970f = i + 1;
            return a(i);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f66970f;
    }

    @Override // java.util.ListIterator
    public final E previous() {
        if (hasPrevious()) {
            int i = this.f66970f - 1;
            this.f66970f = i;
            return a(i);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f66970f - 1;
    }

    public a(int i, int i2) {
        d.g.c.a.n.t(i2, i);
        this.f66969e = i;
        this.f66970f = i2;
    }
}
