package d.h.c.c;

import java.util.NoSuchElementException;
/* loaded from: classes6.dex */
public abstract class g<T> extends c1<T> {

    /* renamed from: e  reason: collision with root package name */
    public T f67132e;

    public g(T t) {
        this.f67132e = t;
    }

    public abstract T a(T t);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f67132e != null;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (hasNext()) {
            try {
                return this.f67132e;
            } finally {
                this.f67132e = a(this.f67132e);
            }
        }
        throw new NoSuchElementException();
    }
}
