package d.g.c.c;

import com.google.common.collect.Multisets;
import d.g.c.c.i0;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
/* loaded from: classes6.dex */
public abstract class d<E> extends AbstractCollection<E> implements i0<E> {
    public transient Set<E> elementSet;
    public transient Set<i0.a<E>> entrySet;

    /* loaded from: classes6.dex */
    public class a extends Multisets.c<E> {
        public a() {
        }

        @Override // com.google.common.collect.Multisets.c
        public i0<E> b() {
            return d.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return d.this.elementIterator();
        }
    }

    /* loaded from: classes6.dex */
    public class b extends Multisets.d<E> {
        public b() {
        }

        @Override // com.google.common.collect.Multisets.d
        public i0<E> b() {
            return d.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<i0.a<E>> iterator() {
            return d.this.entryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return d.this.distinctElements();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean add(E e2) {
        add(e2, 1);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean addAll(Collection<? extends E> collection) {
        return Multisets.c(this, collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public abstract void clear();

    @Override // java.util.AbstractCollection, java.util.Collection, d.g.c.c.i0
    public boolean contains(Object obj) {
        return count(obj) > 0;
    }

    public Set<E> createElementSet() {
        return new a();
    }

    public Set<i0.a<E>> createEntrySet() {
        return new b();
    }

    public abstract int distinctElements();

    public abstract Iterator<E> elementIterator();

    public Set<E> elementSet() {
        Set<E> set = this.elementSet;
        if (set == null) {
            Set<E> createElementSet = createElementSet();
            this.elementSet = createElementSet;
            return createElementSet;
        }
        return set;
    }

    public abstract Iterator<i0.a<E>> entryIterator();

    public Set<i0.a<E>> entrySet() {
        Set<i0.a<E>> set = this.entrySet;
        if (set == null) {
            Set<i0.a<E>> createEntrySet = createEntrySet();
            this.entrySet = createEntrySet;
            return createEntrySet;
        }
        return set;
    }

    @Override // java.util.Collection, d.g.c.c.i0
    public final boolean equals(Object obj) {
        return Multisets.f(this, obj);
    }

    @Override // java.util.Collection, d.g.c.c.i0
    public final int hashCode() {
        return entrySet().hashCode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return entrySet().isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, d.g.c.c.i0
    public final boolean remove(Object obj) {
        return remove(obj, 1) > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean removeAll(Collection<?> collection) {
        return Multisets.k(this, collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean retainAll(Collection<?> collection) {
        return Multisets.l(this, collection);
    }

    public int setCount(E e2, int i) {
        return Multisets.m(this, e2, i);
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return entrySet().toString();
    }

    public int add(E e2, int i) {
        throw new UnsupportedOperationException();
    }

    public int remove(Object obj, int i) {
        throw new UnsupportedOperationException();
    }

    public boolean setCount(E e2, int i, int i2) {
        return Multisets.n(this, e2, i, i2);
    }
}
