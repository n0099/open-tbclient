package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultimap;
import d.h.c.c.s0;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
/* loaded from: classes6.dex */
public abstract class AbstractSetMultimap<K, V> extends AbstractMapBasedMultimap<K, V> implements s0<K, V> {
    public static final long serialVersionUID = 7431625294878419160L;

    public AbstractSetMultimap(Map<K, Collection<V>> map) {
        super(map);
    }

    @Override // d.h.c.c.c, d.h.c.c.h0
    public Map<K, Collection<V>> asMap() {
        return super.asMap();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.AbstractMapBasedMultimap
    public abstract Set<V> createCollection();

    @Override // d.h.c.c.c, d.h.c.c.h0
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractMapBasedMultimap, d.h.c.c.h0, d.h.c.c.g0
    public /* bridge */ /* synthetic */ Collection get(Object obj) {
        return get((AbstractSetMultimap<K, V>) obj);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, d.h.c.c.c, d.h.c.c.h0
    public boolean put(K k, V v) {
        return super.put(k, v);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractMapBasedMultimap, d.h.c.c.c, d.h.c.c.h0, d.h.c.c.g0
    public /* bridge */ /* synthetic */ Collection replaceValues(Object obj, Iterable iterable) {
        return replaceValues((AbstractSetMultimap<K, V>) obj, iterable);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap
    public <E> Collection<E> unmodifiableCollectionSubclass(Collection<E> collection) {
        return Collections.unmodifiableSet((Set) collection);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap
    public Collection<V> wrapCollection(K k, Collection<V> collection) {
        return new AbstractMapBasedMultimap.n(k, (Set) collection);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.AbstractMapBasedMultimap
    public Set<V> createUnmodifiableEmptyCollection() {
        return Collections.emptySet();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.AbstractMapBasedMultimap, d.h.c.c.c, d.h.c.c.h0
    public Set<Map.Entry<K, V>> entries() {
        return (Set) super.entries();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, d.h.c.c.h0, d.h.c.c.g0
    public Set<V> get(K k) {
        return (Set) super.get((AbstractSetMultimap<K, V>) k);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.AbstractMapBasedMultimap, d.h.c.c.h0, d.h.c.c.g0
    public Set<V> removeAll(Object obj) {
        return (Set) super.removeAll(obj);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, d.h.c.c.c, d.h.c.c.h0, d.h.c.c.g0
    public Set<V> replaceValues(K k, Iterable<? extends V> iterable) {
        return (Set) super.replaceValues((AbstractSetMultimap<K, V>) k, (Iterable) iterable);
    }
}
