package com.google.common.collect;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
/* loaded from: classes6.dex */
public abstract class AbstractSortedKeySortedSetMultimap<K, V> extends AbstractSortedSetMultimap<K, V> {
    public AbstractSortedKeySortedSetMultimap(SortedMap<K, Collection<V>> sortedMap) {
        super(sortedMap);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, d.h.c.c.c
    public Set<K> createKeySet() {
        return createMaybeNavigableKeySet();
    }

    @Override // com.google.common.collect.AbstractSortedSetMultimap, d.h.c.c.x0
    public abstract /* synthetic */ Comparator<? super V> valueComparator();

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.AbstractSortedSetMultimap, com.google.common.collect.AbstractSetMultimap, d.h.c.c.c, d.h.c.c.h0
    public SortedMap<K, Collection<V>> asMap() {
        return (SortedMap) super.asMap();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.AbstractMapBasedMultimap
    public SortedMap<K, Collection<V>> backingMap() {
        return (SortedMap) super.backingMap();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.h.c.c.c, d.h.c.c.h0
    public SortedSet<K> keySet() {
        return (SortedSet) super.keySet();
    }
}
