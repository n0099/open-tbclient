package d.g.c.c;

import com.google.common.collect.Iterators;
import com.google.common.collect.Multisets;
import d.g.c.c.i0;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
/* loaded from: classes6.dex */
public abstract class x<E> extends r<E> implements i0<E> {
    public int add(E e2, int i2) {
        return delegate().add(e2, i2);
    }

    @Override // d.g.c.c.i0
    public int count(Object obj) {
        return delegate().count(obj);
    }

    @Override // d.g.c.c.r, d.g.c.c.y
    public abstract i0<E> delegate();

    @Override // d.g.c.c.r, d.g.c.c.y
    public abstract /* bridge */ /* synthetic */ Object delegate();

    @Override // d.g.c.c.r, d.g.c.c.y
    public abstract /* bridge */ /* synthetic */ Collection delegate();

    public abstract Set<E> elementSet();

    public abstract Set<i0.a<E>> entrySet();

    @Override // java.util.Collection, d.g.c.c.i0
    public boolean equals(Object obj) {
        return obj == this || delegate().equals(obj);
    }

    @Override // java.util.Collection, d.g.c.c.i0
    public int hashCode() {
        return delegate().hashCode();
    }

    public int remove(Object obj, int i2) {
        return delegate().remove(obj, i2);
    }

    public int setCount(E e2, int i2) {
        return delegate().setCount(e2, i2);
    }

    public boolean standardAdd(E e2) {
        add(e2, 1);
        return true;
    }

    @Override // d.g.c.c.r
    public boolean standardAddAll(Collection<? extends E> collection) {
        return Multisets.c(this, collection);
    }

    @Override // d.g.c.c.r
    public void standardClear() {
        Iterators.d(entrySet().iterator());
    }

    @Override // d.g.c.c.r
    public boolean standardContains(Object obj) {
        return count(obj) > 0;
    }

    public int standardCount(Object obj) {
        for (i0.a<E> aVar : entrySet()) {
            if (d.g.c.a.k.a(aVar.getElement(), obj)) {
                return aVar.getCount();
            }
        }
        return 0;
    }

    public boolean standardEquals(Object obj) {
        return Multisets.f(this, obj);
    }

    public int standardHashCode() {
        return entrySet().hashCode();
    }

    public Iterator<E> standardIterator() {
        return Multisets.i(this);
    }

    @Override // d.g.c.c.r
    public boolean standardRemove(Object obj) {
        return remove(obj, 1) > 0;
    }

    @Override // d.g.c.c.r
    public boolean standardRemoveAll(Collection<?> collection) {
        return Multisets.k(this, collection);
    }

    @Override // d.g.c.c.r
    public boolean standardRetainAll(Collection<?> collection) {
        return Multisets.l(this, collection);
    }

    public int standardSetCount(E e2, int i2) {
        return Multisets.m(this, e2, i2);
    }

    public int standardSize() {
        return Multisets.j(this);
    }

    @Override // d.g.c.c.r
    public String standardToString() {
        return entrySet().toString();
    }

    public boolean setCount(E e2, int i2, int i3) {
        return delegate().setCount(e2, i2, i3);
    }

    public boolean standardSetCount(E e2, int i2, int i3) {
        return Multisets.n(this, e2, i2, i3);
    }
}
