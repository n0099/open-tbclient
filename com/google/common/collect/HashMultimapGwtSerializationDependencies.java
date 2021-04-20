package com.google.common.collect;

import java.util.Collection;
import java.util.Map;
/* loaded from: classes6.dex */
public abstract class HashMultimapGwtSerializationDependencies<K, V> extends AbstractSetMultimap<K, V> {
    public HashMultimapGwtSerializationDependencies(Map<K, Collection<V>> map) {
        super(map);
    }
}
