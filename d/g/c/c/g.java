package d.g.c.c;

import java.util.NoSuchElementException;
/* loaded from: classes6.dex */
public abstract class g<T> extends c1<T> {

    /* renamed from: e  reason: collision with root package name */
    public T f70111e;

    public g(T t) {
        this.f70111e = t;
    }

    public abstract T a(T t);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f70111e != null;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (hasNext()) {
            try {
                return this.f70111e;
            } finally {
                this.f70111e = a(this.f70111e);
            }
        }
        throw new NoSuchElementException();
    }
}
