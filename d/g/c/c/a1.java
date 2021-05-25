package d.g.c.c;

import java.util.Iterator;
/* loaded from: classes6.dex */
public abstract class a1<F, T> implements Iterator<T> {

    /* renamed from: e  reason: collision with root package name */
    public final Iterator<? extends F> f66262e;

    public a1(Iterator<? extends F> it) {
        d.g.c.a.n.p(it);
        this.f66262e = it;
    }

    public abstract T a(F f2);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f66262e.hasNext();
    }

    @Override // java.util.Iterator
    public final T next() {
        return a(this.f66262e.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f66262e.remove();
    }
}
