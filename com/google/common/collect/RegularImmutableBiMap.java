package com.google.common.collect;

import com.google.common.collect.RegularImmutableMap;
import java.util.Map;
/* loaded from: classes6.dex */
public final class RegularImmutableBiMap<K, V> extends ImmutableBiMap<K, V> {
    public static final RegularImmutableBiMap<Object, Object> EMPTY = new RegularImmutableBiMap<>();
    public final transient Object[] alternatingKeysAndValues;

    /* renamed from: e  reason: collision with root package name */
    public final transient Object f31076e;

    /* renamed from: f  reason: collision with root package name */
    public final transient int f31077f;

    /* renamed from: g  reason: collision with root package name */
    public final transient int f31078g;

    /* renamed from: h  reason: collision with root package name */
    public final transient RegularImmutableBiMap<V, K> f31079h;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.google.common.collect.RegularImmutableBiMap<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    public RegularImmutableBiMap() {
        this.f31076e = null;
        this.alternatingKeysAndValues = new Object[0];
        this.f31077f = 0;
        this.f31078g = 0;
        this.f31079h = this;
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return new RegularImmutableMap.EntrySet(this, this.alternatingKeysAndValues, this.f31077f, this.f31078g);
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableSet<K> createKeySet() {
        return new RegularImmutableMap.KeySet(this, new RegularImmutableMap.KeysOrValuesAsList(this.alternatingKeysAndValues, this.f31077f, this.f31078g));
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public V get(Object obj) {
        return (V) RegularImmutableMap.get(this.f31076e, this.alternatingKeysAndValues, this.f31078g, this.f31077f, obj);
    }

    @Override // com.google.common.collect.ImmutableMap
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.Map
    public int size() {
        return this.f31078g;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.ImmutableBiMap, d.h.c.c.k
    public ImmutableBiMap<V, K> inverse() {
        return this.f31079h;
    }

    public RegularImmutableBiMap(Object[] objArr, int i) {
        this.alternatingKeysAndValues = objArr;
        this.f31078g = i;
        this.f31077f = 0;
        int chooseTableSize = i >= 2 ? ImmutableSet.chooseTableSize(i) : 0;
        this.f31076e = RegularImmutableMap.createHashTable(objArr, i, chooseTableSize, 0);
        this.f31079h = new RegularImmutableBiMap<>(RegularImmutableMap.createHashTable(objArr, i, chooseTableSize, 1), objArr, i, this);
    }

    public RegularImmutableBiMap(Object obj, Object[] objArr, int i, RegularImmutableBiMap<V, K> regularImmutableBiMap) {
        this.f31076e = obj;
        this.alternatingKeysAndValues = objArr;
        this.f31077f = 1;
        this.f31078g = i;
        this.f31079h = regularImmutableBiMap;
    }
}
