package d.g.c.c;

import java.util.NoSuchElementException;
/* loaded from: classes6.dex */
public abstract class a<E> extends d1<E> {

    /* renamed from: e  reason: collision with root package name */
    public final int f69991e;

    /* renamed from: f  reason: collision with root package name */
    public int f69992f;

    public a(int i2) {
        this(i2, 0);
    }

    public abstract E a(int i2);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f69992f < this.f69991e;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f69992f > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final E next() {
        if (hasNext()) {
            int i2 = this.f69992f;
            this.f69992f = i2 + 1;
            return a(i2);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f69992f;
    }

    @Override // java.util.ListIterator
    public final E previous() {
        if (hasPrevious()) {
            int i2 = this.f69992f - 1;
            this.f69992f = i2;
            return a(i2);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f69992f - 1;
    }

    public a(int i2, int i3) {
        d.g.c.a.n.t(i3, i2);
        this.f69991e = i2;
        this.f69992f = i3;
    }
}
