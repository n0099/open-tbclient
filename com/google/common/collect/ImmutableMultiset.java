package com.google.common.collect;

import com.google.common.collect.ImmutableCollection;
import d.g.c.a.n;
import d.g.c.c.c1;
import d.g.c.c.i0;
import d.g.c.c.k0;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
/* loaded from: classes6.dex */
public abstract class ImmutableMultiset<E> extends ImmutableMultisetGwtSerializationDependencies<E> implements i0<E> {
    public transient ImmutableList<E> asList;
    public transient ImmutableSet<i0.a<E>> entrySet;

    /* loaded from: classes6.dex */
    public final class EntrySet extends IndexedImmutableSet<i0.a<E>> {
        public static final long serialVersionUID = 0;

        public EntrySet() {
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (obj instanceof i0.a) {
                i0.a aVar = (i0.a) obj;
                return aVar.getCount() > 0 && ImmutableMultiset.this.count(aVar.getElement()) == aVar.getCount();
            }
            return false;
        }

        @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return ImmutableMultiset.this.hashCode();
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return ImmutableMultiset.this.isPartialView();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return ImmutableMultiset.this.elementSet().size();
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
        public Object writeReplace() {
            return new EntrySetSerializedForm(ImmutableMultiset.this);
        }

        public /* synthetic */ EntrySet(ImmutableMultiset immutableMultiset, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.IndexedImmutableSet
        public i0.a<E> get(int i2) {
            return ImmutableMultiset.this.getEntry(i2);
        }
    }

    /* loaded from: classes6.dex */
    public static class EntrySetSerializedForm<E> implements Serializable {
        public final ImmutableMultiset<E> multiset;

        public EntrySetSerializedForm(ImmutableMultiset<E> immutableMultiset) {
            this.multiset = immutableMultiset;
        }

        public Object readResolve() {
            return this.multiset.entrySet();
        }
    }

    /* loaded from: classes6.dex */
    public class a extends c1<E> {

        /* renamed from: e  reason: collision with root package name */
        public int f31233e;

        /* renamed from: f  reason: collision with root package name */
        public E f31234f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Iterator f31235g;

        public a(ImmutableMultiset immutableMultiset, Iterator it) {
            this.f31235g = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f31233e > 0 || this.f31235g.hasNext();
        }

        @Override // java.util.Iterator
        public E next() {
            if (this.f31233e <= 0) {
                i0.a aVar = (i0.a) this.f31235g.next();
                this.f31234f = (E) aVar.getElement();
                this.f31233e = aVar.getCount();
            }
            this.f31233e--;
            return this.f31234f;
        }
    }

    /* loaded from: classes6.dex */
    public static class b<E> extends ImmutableCollection.b<E> {

        /* renamed from: a  reason: collision with root package name */
        public k0<E> f31236a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f31237b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f31238c;

        public b() {
            this(4);
        }

        /* JADX DEBUG: Type inference failed for r1v3. Raw type applied. Possible types: d.g.c.c.k0<E>, d.g.c.c.k0<T> */
        /* JADX DEBUG: Type inference failed for r1v5. Raw type applied. Possible types: d.g.c.c.k0<E>, d.g.c.c.k0<T> */
        public static <T> k0<T> l(Iterable<T> iterable) {
            if (iterable instanceof RegularImmutableMultiset) {
                return (k0<E>) ((RegularImmutableMultiset) iterable).contents;
            }
            if (iterable instanceof AbstractMapBasedMultiset) {
                return (k0<E>) ((AbstractMapBasedMultiset) iterable).backingMap;
            }
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.ImmutableCollection.b
        /* renamed from: f */
        public b<E> a(E e2) {
            return j(e2, 1);
        }

        public b<E> g(E... eArr) {
            super.b(eArr);
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.google.common.collect.ImmutableMultiset$b<E> */
        /* JADX WARN: Multi-variable type inference failed */
        public b<E> h(Iterable<? extends E> iterable) {
            if (iterable instanceof i0) {
                i0 d2 = Multisets.d(iterable);
                k0 l = l(d2);
                if (l != null) {
                    k0<E> k0Var = this.f31236a;
                    k0Var.d(Math.max(k0Var.C(), l.C()));
                    for (int e2 = l.e(); e2 >= 0; e2 = l.s(e2)) {
                        j(l.i(e2), l.k(e2));
                    }
                } else {
                    Set<i0.a<E>> entrySet = d2.entrySet();
                    k0<E> k0Var2 = this.f31236a;
                    k0Var2.d(Math.max(k0Var2.C(), entrySet.size()));
                    for (i0.a<E> aVar : d2.entrySet()) {
                        j(aVar.getElement(), aVar.getCount());
                    }
                }
            } else {
                super.c(iterable);
            }
            return this;
        }

        public b<E> i(Iterator<? extends E> it) {
            super.d(it);
            return this;
        }

        public b<E> j(E e2, int i2) {
            if (i2 == 0) {
                return this;
            }
            if (this.f31237b) {
                this.f31236a = new k0<>((k0<? extends E>) this.f31236a);
                this.f31238c = false;
            }
            this.f31237b = false;
            n.p(e2);
            k0<E> k0Var = this.f31236a;
            k0Var.u(e2, i2 + k0Var.f(e2));
            return this;
        }

        public ImmutableMultiset<E> k() {
            if (this.f31236a.C() == 0) {
                return ImmutableMultiset.of();
            }
            if (this.f31238c) {
                this.f31236a = new k0<>((k0<? extends E>) this.f31236a);
                this.f31238c = false;
            }
            this.f31237b = true;
            return new RegularImmutableMultiset(this.f31236a);
        }

        public b(int i2) {
            this.f31237b = false;
            this.f31238c = false;
            this.f31236a = k0.c(i2);
        }

        public b(boolean z) {
            this.f31237b = false;
            this.f31238c = false;
            this.f31236a = null;
        }
    }

    public static <E> b<E> builder() {
        return new b<>();
    }

    public static <E> ImmutableMultiset<E> copyFromElements(E... eArr) {
        b bVar = new b();
        bVar.g(eArr);
        return bVar.k();
    }

    public static <E> ImmutableMultiset<E> copyFromEntries(Collection<? extends i0.a<? extends E>> collection) {
        b bVar = new b(collection.size());
        for (i0.a<? extends E> aVar : collection) {
            bVar.j(aVar.getElement(), aVar.getCount());
        }
        return bVar.k();
    }

    public static <E> ImmutableMultiset<E> copyOf(E[] eArr) {
        return copyFromElements(eArr);
    }

    private ImmutableSet<i0.a<E>> createEntrySet() {
        return isEmpty() ? ImmutableSet.of() : new EntrySet(this, null);
    }

    public static <E> ImmutableMultiset<E> of() {
        return RegularImmutableMultiset.EMPTY;
    }

    @Override // d.g.c.c.i0
    @Deprecated
    public final int add(E e2, int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public ImmutableList<E> asList() {
        ImmutableList<E> immutableList = this.asList;
        if (immutableList == null) {
            ImmutableList<E> asList = super.asList();
            this.asList = asList;
            return asList;
        }
        return immutableList;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return count(obj) > 0;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int copyIntoArray(Object[] objArr, int i2) {
        c1<i0.a<E>> it = entrySet().iterator();
        while (it.hasNext()) {
            i0.a<E> next = it.next();
            Arrays.fill(objArr, i2, next.getCount() + i2, next.getElement());
            i2 += next.getCount();
        }
        return i2;
    }

    public abstract /* synthetic */ int count(Object obj);

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.g.c.c.i0
    public abstract ImmutableSet<E> elementSet();

    @Override // java.util.Collection, d.g.c.c.i0
    public boolean equals(Object obj) {
        return Multisets.f(this, obj);
    }

    public abstract i0.a<E> getEntry(int i2);

    @Override // java.util.Collection, d.g.c.c.i0
    public int hashCode() {
        return Sets.b(entrySet());
    }

    @Override // d.g.c.c.i0
    @Deprecated
    public final int remove(Object obj, int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // d.g.c.c.i0
    @Deprecated
    public final int setCount(E e2, int i2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return entrySet().toString();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public abstract Object writeReplace();

    public static <E> ImmutableMultiset<E> copyOf(Iterable<? extends E> iterable) {
        if (iterable instanceof ImmutableMultiset) {
            ImmutableMultiset<E> immutableMultiset = (ImmutableMultiset) iterable;
            if (!immutableMultiset.isPartialView()) {
                return immutableMultiset;
            }
        }
        b bVar = new b(Multisets.h(iterable));
        bVar.h(iterable);
        return bVar.k();
    }

    public static <E> ImmutableMultiset<E> of(E e2) {
        return copyFromElements(e2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.g.c.c.i0
    public ImmutableSet<i0.a<E>> entrySet() {
        ImmutableSet<i0.a<E>> immutableSet = this.entrySet;
        if (immutableSet == null) {
            ImmutableSet<i0.a<E>> createEntrySet = createEntrySet();
            this.entrySet = createEntrySet;
            return createEntrySet;
        }
        return immutableSet;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public c1<E> iterator() {
        return new a(this, entrySet().iterator());
    }

    @Override // d.g.c.c.i0
    @Deprecated
    public final boolean setCount(E e2, int i2, int i3) {
        throw new UnsupportedOperationException();
    }

    public static <E> ImmutableMultiset<E> of(E e2, E e3) {
        return copyFromElements(e2, e3);
    }

    public static <E> ImmutableMultiset<E> of(E e2, E e3, E e4) {
        return copyFromElements(e2, e3, e4);
    }

    public static <E> ImmutableMultiset<E> of(E e2, E e3, E e4, E e5) {
        return copyFromElements(e2, e3, e4, e5);
    }

    public static <E> ImmutableMultiset<E> of(E e2, E e3, E e4, E e5, E e6) {
        return copyFromElements(e2, e3, e4, e5, e6);
    }

    public static <E> ImmutableMultiset<E> of(E e2, E e3, E e4, E e5, E e6, E e7, E... eArr) {
        return new b().a(e2).a(e3).a(e4).a(e5).a(e6).a(e7).g(eArr).k();
    }

    public static <E> ImmutableMultiset<E> copyOf(Iterator<? extends E> it) {
        b bVar = new b();
        bVar.i(it);
        return bVar.k();
    }
}
