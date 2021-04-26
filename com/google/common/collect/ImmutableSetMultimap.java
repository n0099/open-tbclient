package com.google.common.collect;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import d.g.c.a.j;
import d.g.c.a.n;
import d.g.c.c.c1;
import d.g.c.c.h0;
import d.g.c.c.n0;
import d.g.c.c.r0;
import d.g.c.c.s0;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
/* loaded from: classes6.dex */
public class ImmutableSetMultimap<K, V> extends ImmutableMultimap<K, V> implements s0<K, V> {
    public static final long serialVersionUID = 0;
    public final transient ImmutableSet<V> emptySet;
    public transient ImmutableSet<Map.Entry<K, V>> entries;
    public transient ImmutableSetMultimap<V, K> inverse;

    /* loaded from: classes6.dex */
    public static final class EntrySet<K, V> extends ImmutableSet<Map.Entry<K, V>> {

        /* renamed from: e  reason: collision with root package name */
        public final transient ImmutableSetMultimap<K, V> f31887e;

        public EntrySet(ImmutableSetMultimap<K, V> immutableSetMultimap) {
            this.f31887e = immutableSetMultimap;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                return this.f31887e.containsEntry(entry.getKey(), entry.getValue());
            }
            return false;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f31887e.size();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public c1<Map.Entry<K, V>> iterator() {
            return this.f31887e.entryIterator();
        }
    }

    /* loaded from: classes6.dex */
    public static final class a<K, V> extends ImmutableMultimap.c<K, V> {
        @Override // com.google.common.collect.ImmutableMultimap.c
        public Collection<V> b() {
            return n0.g();
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMultimap.c
        public /* bridge */ /* synthetic */ ImmutableMultimap.c c(Object obj, Object obj2) {
            g(obj, obj2);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultimap.c
        public /* bridge */ /* synthetic */ ImmutableMultimap.c d(Map.Entry entry) {
            h(entry);
            return this;
        }

        public ImmutableSetMultimap<K, V> f() {
            Collection entrySet = this.f31865a.entrySet();
            Comparator<? super K> comparator = this.f31866b;
            if (comparator != null) {
                entrySet = Ordering.from(comparator).onKeys().immutableSortedCopy(entrySet);
            }
            return ImmutableSetMultimap.fromMapEntries(entrySet, this.f31867c);
        }

        public a<K, V> g(K k, V v) {
            super.c(k, v);
            return this;
        }

        public a<K, V> h(Map.Entry<? extends K, ? extends V> entry) {
            super.d(entry);
            return this;
        }

        public a<K, V> i(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            super.e(iterable);
            return this;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public static final r0.b<ImmutableSetMultimap> f31888a = r0.a(ImmutableSetMultimap.class, "emptySet");
    }

    public ImmutableSetMultimap(ImmutableMap<K, ImmutableSet<V>> immutableMap, int i2, Comparator<? super V> comparator) {
        super(immutableMap, i2);
        this.emptySet = emptySet(comparator);
    }

    public static <K, V> a<K, V> builder() {
        return new a<>();
    }

    public static <K, V> ImmutableSetMultimap<K, V> copyOf(h0<? extends K, ? extends V> h0Var) {
        return copyOf(h0Var, null);
    }

    public static <V> ImmutableSet<V> emptySet(Comparator<? super V> comparator) {
        if (comparator == null) {
            return ImmutableSet.of();
        }
        return ImmutableSortedSet.emptySet(comparator);
    }

    public static <K, V> ImmutableSetMultimap<K, V> fromMapEntries(Collection<? extends Map.Entry<? extends K, ? extends Collection<? extends V>>> collection, Comparator<? super V> comparator) {
        if (collection.isEmpty()) {
            return of();
        }
        ImmutableMap.b bVar = new ImmutableMap.b(collection.size());
        int i2 = 0;
        for (Map.Entry<? extends K, ? extends Collection<? extends V>> entry : collection) {
            K key = entry.getKey();
            ImmutableSet valueSet = valueSet(comparator, entry.getValue());
            if (!valueSet.isEmpty()) {
                bVar.c(key, valueSet);
                i2 += valueSet.size();
            }
        }
        return new ImmutableSetMultimap<>(bVar.a(), i2, comparator);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.collect.ImmutableSetMultimap$a */
    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.google.common.collect.ImmutableSetMultimap<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    private ImmutableSetMultimap<V, K> invert() {
        a builder = builder();
        c1 it = entries().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            builder.g(entry.getValue(), entry.getKey());
        }
        ImmutableSetMultimap<V, K> f2 = builder.f();
        f2.inverse = this;
        return f2;
    }

    public static <K, V> ImmutableSetMultimap<K, V> of() {
        return EmptyImmutableSetMultimap.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: com.google.common.collect.ImmutableMap$b */
    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        Comparator comparator = (Comparator) objectInputStream.readObject();
        int readInt = objectInputStream.readInt();
        if (readInt >= 0) {
            ImmutableMap.b builder = ImmutableMap.builder();
            int i2 = 0;
            for (int i3 = 0; i3 < readInt; i3++) {
                Object readObject = objectInputStream.readObject();
                int readInt2 = objectInputStream.readInt();
                if (readInt2 > 0) {
                    ImmutableSet.a valuesBuilder = valuesBuilder(comparator);
                    for (int i4 = 0; i4 < readInt2; i4++) {
                        valuesBuilder.a(objectInputStream.readObject());
                    }
                    ImmutableSet l = valuesBuilder.l();
                    if (l.size() == readInt2) {
                        builder.c(readObject, l);
                        i2 += readInt2;
                    } else {
                        throw new InvalidObjectException("Duplicate key-value pairs exist for key " + readObject);
                    }
                } else {
                    throw new InvalidObjectException("Invalid value count " + readInt2);
                }
            }
            try {
                ImmutableMultimap.d.f31868a.b(this, builder.a());
                ImmutableMultimap.d.f31869b.a(this, i2);
                b.f31888a.b(this, emptySet(comparator));
                return;
            } catch (IllegalArgumentException e2) {
                throw ((InvalidObjectException) new InvalidObjectException(e2.getMessage()).initCause(e2));
            }
        }
        throw new InvalidObjectException("Invalid key count " + readInt);
    }

    public static <V> ImmutableSet<V> valueSet(Comparator<? super V> comparator, Collection<? extends V> collection) {
        if (comparator == null) {
            return ImmutableSet.copyOf((Collection) collection);
        }
        return ImmutableSortedSet.copyOf((Comparator) comparator, (Collection) collection);
    }

    public static <V> ImmutableSet.a<V> valuesBuilder(Comparator<? super V> comparator) {
        return comparator == null ? new ImmutableSet.a<>() : new ImmutableSortedSet.a(comparator);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(valueComparator());
        r0.j(this, objectOutputStream);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, d.g.c.c.h0, d.g.c.c.g0
    public /* bridge */ /* synthetic */ ImmutableCollection get(Object obj) {
        return get((ImmutableSetMultimap<K, V>) obj);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, d.g.c.c.c, d.g.c.c.h0, d.g.c.c.g0
    @Deprecated
    public /* bridge */ /* synthetic */ ImmutableCollection replaceValues(Object obj, Iterable iterable) {
        return replaceValues((ImmutableSetMultimap<K, V>) obj, iterable);
    }

    public Comparator<? super V> valueComparator() {
        ImmutableSet<V> immutableSet = this.emptySet;
        if (immutableSet instanceof ImmutableSortedSet) {
            return ((ImmutableSortedSet) immutableSet).comparator();
        }
        return null;
    }

    public static <K, V> ImmutableSetMultimap<K, V> copyOf(h0<? extends K, ? extends V> h0Var, Comparator<? super V> comparator) {
        n.p(h0Var);
        if (h0Var.isEmpty() && comparator == null) {
            return of();
        }
        if (h0Var instanceof ImmutableSetMultimap) {
            ImmutableSetMultimap<K, V> immutableSetMultimap = (ImmutableSetMultimap) h0Var;
            if (!immutableSetMultimap.isPartialView()) {
                return immutableSetMultimap;
            }
        }
        return fromMapEntries(h0Var.asMap().entrySet(), comparator);
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K k, V v) {
        a builder = builder();
        builder.g(k, v);
        return builder.f();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, d.g.c.c.h0, d.g.c.c.g0
    public /* bridge */ /* synthetic */ Collection get(Object obj) {
        return get((ImmutableSetMultimap<K, V>) obj);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.ImmutableMultimap
    public ImmutableSetMultimap<V, K> inverse() {
        ImmutableSetMultimap<V, K> immutableSetMultimap = this.inverse;
        if (immutableSetMultimap == null) {
            ImmutableSetMultimap<V, K> invert = invert();
            this.inverse = invert;
            return invert;
        }
        return immutableSetMultimap;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, d.g.c.c.c, d.g.c.c.h0, d.g.c.c.g0
    @Deprecated
    public /* bridge */ /* synthetic */ Collection replaceValues(Object obj, Iterable iterable) {
        return replaceValues((ImmutableSetMultimap<K, V>) obj, iterable);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, d.g.c.c.h0, d.g.c.c.g0
    public /* bridge */ /* synthetic */ Set get(Object obj) {
        return get((ImmutableSetMultimap<K, V>) obj);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap, d.g.c.c.c, d.g.c.c.h0, d.g.c.c.g0
    @Deprecated
    public /* bridge */ /* synthetic */ Set replaceValues(Object obj, Iterable iterable) {
        return replaceValues((ImmutableSetMultimap<K, V>) obj, iterable);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.ImmutableMultimap, d.g.c.c.c, d.g.c.c.h0
    public ImmutableSet<Map.Entry<K, V>> entries() {
        ImmutableSet<Map.Entry<K, V>> immutableSet = this.entries;
        if (immutableSet == null) {
            EntrySet entrySet = new EntrySet(this);
            this.entries = entrySet;
            return entrySet;
        }
        return immutableSet;
    }

    @Override // com.google.common.collect.ImmutableMultimap, d.g.c.c.h0, d.g.c.c.g0
    public ImmutableSet<V> get(K k) {
        return (ImmutableSet) j.a((ImmutableSet) this.map.get(k), this.emptySet);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.ImmutableMultimap, d.g.c.c.h0, d.g.c.c.g0
    @Deprecated
    public ImmutableSet<V> removeAll(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableMultimap, d.g.c.c.c, d.g.c.c.h0, d.g.c.c.g0
    @Deprecated
    public ImmutableSet<V> replaceValues(K k, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K k, V v, K k2, V v2) {
        a builder = builder();
        builder.g(k, v);
        builder.g(k2, v2);
        return builder.f();
    }

    public static <K, V> ImmutableSetMultimap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        a aVar = new a();
        aVar.i(iterable);
        return aVar.f();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3) {
        a builder = builder();
        builder.g(k, v);
        builder.g(k2, v2);
        builder.g(k3, v3);
        return builder.f();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        a builder = builder();
        builder.g(k, v);
        builder.g(k2, v2);
        builder.g(k3, v3);
        builder.g(k4, v4);
        return builder.f();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        a builder = builder();
        builder.g(k, v);
        builder.g(k2, v2);
        builder.g(k3, v3);
        builder.g(k4, v4);
        builder.g(k5, v5);
        return builder.f();
    }
}
