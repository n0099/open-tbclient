package d.g.c.c;

import java.util.Iterator;
/* loaded from: classes6.dex */
public abstract class t<T> extends y implements Iterator<T> {
    public abstract Iterator<T> b();

    @Override // java.util.Iterator
    public boolean hasNext() {
        return b().hasNext();
    }

    public T next() {
        return b().next();
    }
}
