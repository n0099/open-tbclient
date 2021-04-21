package com.google.common.collect;

import d.h.c.c.g0;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public abstract class AbstractListMultimap<K, V> extends AbstractMapBasedMultimap<K, V> implements g0<K, V> {
    public static final long serialVersionUID = 6588350623831699109L;

    public AbstractListMultimap(Map<K, Collection<V>> map) {
        super(map);
    }

    @Override // d.h.c.c.c, d.h.c.c.h0
    public Map<K, Collection<V>> asMap() {
        return super.asMap();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.AbstractMapBasedMultimap
    public abstract List<V> createCollection();

    @Override // d.h.c.c.c, d.h.c.c.h0
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractMapBasedMultimap, d.h.c.c.h0, d.h.c.c.g0
    public /* bridge */ /* synthetic */ Collection get(Object obj) {
        return get((AbstractListMultimap<K, V>) obj);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, d.h.c.c.c, d.h.c.c.h0
    public boolean put(K k, V v) {
        return super.put(k, v);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractMapBasedMultimap, d.h.c.c.c, d.h.c.c.h0, d.h.c.c.g0
    public /* bridge */ /* synthetic */ Collection replaceValues(Object obj, Iterable iterable) {
        return replaceValues((AbstractListMultimap<K, V>) obj, iterable);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap
    public <E> Collection<E> unmodifiableCollectionSubclass(Collection<E> collection) {
        return Collections.unmodifiableList((List) collection);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap
    public Collection<V> wrapCollection(K k, Collection<V> collection) {
        return wrapList(k, (List) collection, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.AbstractMapBasedMultimap
    public List<V> createUnmodifiableEmptyCollection() {
        return Collections.emptyList();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, d.h.c.c.h0, d.h.c.c.g0
    public List<V> get(K k) {
        return (List) super.get((AbstractListMultimap<K, V>) k);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.AbstractMapBasedMultimap, d.h.c.c.h0, d.h.c.c.g0
    public List<V> removeAll(Object obj) {
        return (List) super.removeAll(obj);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, d.h.c.c.c, d.h.c.c.h0, d.h.c.c.g0
    public List<V> replaceValues(K k, Iterable<? extends V> iterable) {
        return (List) super.replaceValues((AbstractListMultimap<K, V>) k, (Iterable) iterable);
    }
}
