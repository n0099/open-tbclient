package d.g.c.c;

import java.util.Iterator;
/* loaded from: classes6.dex */
public abstract class a1<F, T> implements Iterator<T> {

    /* renamed from: e  reason: collision with root package name */
    public final Iterator<? extends F> f65533e;

    public a1(Iterator<? extends F> it) {
        d.g.c.a.n.p(it);
        this.f65533e = it;
    }

    public abstract T a(F f2);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f65533e.hasNext();
    }

    @Override // java.util.Iterator
    public final T next() {
        return a(this.f65533e.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f65533e.remove();
    }
}
