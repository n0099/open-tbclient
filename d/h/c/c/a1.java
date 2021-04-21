package d.h.c.c;

import java.util.Iterator;
/* loaded from: classes6.dex */
public abstract class a1<F, T> implements Iterator<T> {

    /* renamed from: e  reason: collision with root package name */
    public final Iterator<? extends F> f67118e;

    public a1(Iterator<? extends F> it) {
        d.h.c.a.n.p(it);
        this.f67118e = it;
    }

    public abstract T a(F f2);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f67118e.hasNext();
    }

    @Override // java.util.Iterator
    public final T next() {
        return a(this.f67118e.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f67118e.remove();
    }
}
