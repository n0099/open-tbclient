package d.g.c.c;

import java.util.NoSuchElementException;
/* loaded from: classes6.dex */
public abstract class a<E> extends d1<E> {

    /* renamed from: e  reason: collision with root package name */
    public final int f65531e;

    /* renamed from: f  reason: collision with root package name */
    public int f65532f;

    public a(int i2) {
        this(i2, 0);
    }

    public abstract E a(int i2);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f65532f < this.f65531e;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f65532f > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final E next() {
        if (hasNext()) {
            int i2 = this.f65532f;
            this.f65532f = i2 + 1;
            return a(i2);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f65532f;
    }

    @Override // java.util.ListIterator
    public final E previous() {
        if (hasPrevious()) {
            int i2 = this.f65532f - 1;
            this.f65532f = i2;
            return a(i2);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f65532f - 1;
    }

    public a(int i2, int i3) {
        d.g.c.a.n.t(i3, i2);
        this.f65531e = i2;
        this.f65532f = i3;
    }
}
