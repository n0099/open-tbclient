package d.g.c.c;

import java.util.NoSuchElementException;
/* loaded from: classes6.dex */
public abstract class g<T> extends c1<T> {

    /* renamed from: e  reason: collision with root package name */
    public T f66233e;

    public g(T t) {
        this.f66233e = t;
    }

    public abstract T a(T t);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f66233e != null;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (hasNext()) {
            try {
                return this.f66233e;
            } finally {
                this.f66233e = a(this.f66233e);
            }
        }
        throw new NoSuchElementException();
    }
}
