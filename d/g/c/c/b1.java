package d.g.c.c;

import com.google.common.collect.Iterators;
import java.util.ListIterator;
/* loaded from: classes6.dex */
public abstract class b1<F, T> extends a1<F, T> implements ListIterator<T> {
    public b1(ListIterator<? extends F> listIterator) {
        super(listIterator);
    }

    @Override // java.util.ListIterator
    public void add(T t) {
        throw new UnsupportedOperationException();
    }

    public final ListIterator<? extends F> b() {
        return Iterators.c(this.f70097e);
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return b().hasPrevious();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return b().nextIndex();
    }

    @Override // java.util.ListIterator
    public final T previous() {
        return a(b().previous());
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return b().previousIndex();
    }

    public void set(T t) {
        throw new UnsupportedOperationException();
    }
}
