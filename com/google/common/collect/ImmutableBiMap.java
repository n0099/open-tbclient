package com.google.common.collect;

import com.google.common.collect.ImmutableMap;
import d.h.c.c.k;
import d.h.c.c.m;
import java.util.Collection;
import java.util.Map;
/* loaded from: classes6.dex */
public abstract class ImmutableBiMap<K, V> extends ImmutableMap<K, V> implements k<K, V> {

    /* loaded from: classes6.dex */
    public static class SerializedForm extends ImmutableMap.SerializedForm {
        public static final long serialVersionUID = 0;

        public SerializedForm(ImmutableBiMap<?, ?> immutableBiMap) {
            super(immutableBiMap);
        }

        @Override // com.google.common.collect.ImmutableMap.SerializedForm
        public Object readResolve() {
            return createMap(new a());
        }
    }

    /* loaded from: classes6.dex */
    public static final class a<K, V> extends ImmutableMap.b<K, V> {
        public a() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMap.b
        public /* bridge */ /* synthetic */ ImmutableMap.b c(Object obj, Object obj2) {
            i(obj, obj2);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.b
        public /* bridge */ /* synthetic */ ImmutableMap.b d(Map.Entry entry) {
            j(entry);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.b
        public /* bridge */ /* synthetic */ ImmutableMap.b e(Iterable iterable) {
            k(iterable);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.b
        public /* bridge */ /* synthetic */ ImmutableMap.b f(Map map) {
            l(map);
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.common.collect.ImmutableMap.b
        /* renamed from: h */
        public ImmutableBiMap<K, V> a() {
            if (this.f30892c == 0) {
                return ImmutableBiMap.of();
            }
            g();
            this.f30893d = true;
            return new RegularImmutableBiMap(this.f30891b, this.f30892c);
        }

        public a<K, V> i(K k, V v) {
            super.c(k, v);
            return this;
        }

        public a<K, V> j(Map.Entry<? extends K, ? extends V> entry) {
            super.d(entry);
            return this;
        }

        public a<K, V> k(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            super.e(iterable);
            return this;
        }

        public a<K, V> l(Map<? extends K, ? extends V> map) {
            super.f(map);
            return this;
        }

        public a(int i) {
            super(i);
        }
    }

    public static <K, V> a<K, V> builder() {
        return new a<>();
    }

    public static <K, V> a<K, V> builderWithExpectedSize(int i) {
        m.b(i, "expectedSize");
        return new a<>(i);
    }

    public static <K, V> ImmutableBiMap<K, V> copyOf(Map<? extends K, ? extends V> map) {
        if (map instanceof ImmutableBiMap) {
            ImmutableBiMap<K, V> immutableBiMap = (ImmutableBiMap) map;
            if (!immutableBiMap.isPartialView()) {
                return immutableBiMap;
            }
        }
        return copyOf((Iterable) map.entrySet());
    }

    public static <K, V> ImmutableBiMap<K, V> of() {
        return RegularImmutableBiMap.EMPTY;
    }

    @Override // d.h.c.c.k
    @Deprecated
    public V forcePut(K k, V v) {
        throw new UnsupportedOperationException();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.h.c.c.k
    public abstract ImmutableBiMap<V, K> inverse();

    @Override // com.google.common.collect.ImmutableMap
    public Object writeReplace() {
        return new SerializedForm(this);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k, V v) {
        m.a(k, v);
        return new RegularImmutableBiMap(new Object[]{k, v}, 1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.ImmutableMap
    public final ImmutableSet<V> createValues() {
        throw new AssertionError("should never be called");
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k, V v, K k2, V v2) {
        m.a(k, v);
        m.a(k2, v2);
        return new RegularImmutableBiMap(new Object[]{k, v, k2, v2}, 2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.ImmutableMap, java.util.Map, d.h.c.c.k
    public ImmutableSet<V> values() {
        return inverse().keySet();
    }

    public static <K, V> ImmutableBiMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        a aVar = new a(iterable instanceof Collection ? ((Collection) iterable).size() : 4);
        aVar.k(iterable);
        return aVar.a();
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3) {
        m.a(k, v);
        m.a(k2, v2);
        m.a(k3, v3);
        return new RegularImmutableBiMap(new Object[]{k, v, k2, v2, k3, v3}, 3);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        m.a(k, v);
        m.a(k2, v2);
        m.a(k3, v3);
        m.a(k4, v4);
        return new RegularImmutableBiMap(new Object[]{k, v, k2, v2, k3, v3, k4, v4}, 4);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        m.a(k, v);
        m.a(k2, v2);
        m.a(k3, v3);
        m.a(k4, v4);
        m.a(k5, v5);
        return new RegularImmutableBiMap(new Object[]{k, v, k2, v2, k3, v3, k4, v4, k5, v5}, 5);
    }
}
