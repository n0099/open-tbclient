package kotlin.collections;

import com.baidu.live.tbadk.core.util.StringHelper;
import java.util.Collection;
import kotlin.TypeCastException;
@kotlin.h
/* loaded from: classes9.dex */
public abstract class a<E> implements Collection<E> {
    @Override // java.util.Collection
    public boolean add(E e) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public abstract int getSize();

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final int size() {
        return getSize();
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<? extends Object> collection) {
        kotlin.jvm.internal.q.n(collection, "elements");
        Collection<? extends Object> collection2 = collection;
        if (collection2.isEmpty()) {
            return true;
        }
        for (Object obj : collection2) {
            if (!contains(obj)) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return size() == 0;
    }

    public String toString() {
        String a2;
        a2 = o.a(this, (r14 & 1) != 0 ? ", " : ", ", (r14 & 2) != 0 ? "" : "[", (r14 & 4) != 0 ? "" : "]", (r14 & 8) != 0 ? -1 : 0, (r14 & 16) != 0 ? StringHelper.STRING_MORE : null, (r14 & 32) != 0 ? null : new AbstractCollection$toString$1(this));
        return a2;
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return kotlin.jvm.internal.n.r(this);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        kotlin.jvm.internal.q.n(tArr, com.baidu.fsg.base.statistics.b.j);
        T[] tArr2 = (T[]) kotlin.jvm.internal.n.a(this, tArr);
        if (tArr2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        return tArr2;
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        if ((this instanceof Collection) && isEmpty()) {
            return false;
        }
        for (E e : this) {
            if (kotlin.jvm.internal.q.l(e, obj)) {
                return true;
            }
        }
        return false;
    }
}
