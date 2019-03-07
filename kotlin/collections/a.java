package kotlin.collections;

import java.util.Collection;
/* loaded from: classes2.dex */
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
        kotlin.jvm.internal.p.k(collection, "elements");
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
        String a;
        a = n.a(this, (r14 & 1) != 0 ? ", " : ", ", (r14 & 2) != 0 ? "" : "[", (r14 & 4) != 0 ? "" : "]", (r14 & 8) != 0 ? -1 : 0, (r14 & 16) != 0 ? "..." : null, (r14 & 32) != 0 ? null : new AbstractCollection$toString$1(this));
        return a;
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        Object[] k = kotlin.jvm.internal.n.k(this);
        kotlin.jvm.internal.p.j(k, "kotlin.jvm.internal.Coll…Array.toArray(collection)");
        return k;
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        kotlin.jvm.internal.p.k(tArr, "array");
        T[] tArr2 = (T[]) kotlin.jvm.internal.n.a(this, tArr);
        kotlin.jvm.internal.p.j(tArr2, "kotlin.jvm.internal.Coll…oArray(collection, array)");
        return tArr2;
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        if ((this instanceof Collection) && isEmpty()) {
            return false;
        }
        for (E e : this) {
            if (kotlin.jvm.internal.p.h(e, obj)) {
                return true;
            }
        }
        return false;
    }
}
