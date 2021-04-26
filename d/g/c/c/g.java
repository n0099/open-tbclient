package d.g.c.c;

import java.util.NoSuchElementException;
/* loaded from: classes6.dex */
public abstract class g<T> extends c1<T> {

    /* renamed from: e  reason: collision with root package name */
    public T f65547e;

    public g(T t) {
        this.f65547e = t;
    }

    public abstract T a(T t);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f65547e != null;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (hasNext()) {
            try {
                return this.f65547e;
            } finally {
                this.f65547e = a(this.f65547e);
            }
        }
        throw new NoSuchElementException();
    }
}
