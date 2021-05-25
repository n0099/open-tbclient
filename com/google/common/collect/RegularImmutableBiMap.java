package com.google.common.collect;

import com.google.common.collect.RegularImmutableMap;
import java.util.Map;
/* loaded from: classes6.dex */
public final class RegularImmutableBiMap<K, V> extends ImmutableBiMap<K, V> {
    public static final RegularImmutableBiMap<Object, Object> EMPTY = new RegularImmutableBiMap<>();
    public final transient Object[] alternatingKeysAndValues;

    /* renamed from: e  reason: collision with root package name */
    public final transient Object f31219e;

    /* renamed from: f  reason: collision with root package name */
    public final transient int f31220f;

    /* renamed from: g  reason: collision with root package name */
    public final transient int f31221g;

    /* renamed from: h  reason: collision with root package name */
    public final transient RegularImmutableBiMap<V, K> f31222h;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.google.common.collect.RegularImmutableBiMap<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    public RegularImmutableBiMap() {
        this.f31219e = null;
        this.alternatingKeysAndValues = new Object[0];
        this.f31220f = 0;
        this.f31221g = 0;
        this.f31222h = this;
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return new RegularImmutableMap.EntrySet(this, this.alternatingKeysAndValues, this.f31220f, this.f31221g);
    }

    @Override // com.google.common.collect.ImmutableMap
    public ImmutableSet<K> createKeySet() {
        return new RegularImmutableMap.KeySet(this, new RegularImmutableMap.KeysOrValuesAsList(this.alternatingKeysAndValues, this.f31220f, this.f31221g));
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public V get(Object obj) {
        return (V) RegularImmutableMap.get(this.f31219e, this.alternatingKeysAndValues, this.f31221g, this.f31220f, obj);
    }

    @Override // com.google.common.collect.ImmutableMap
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.Map
    public int size() {
        return this.f31221g;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.common.collect.ImmutableBiMap, d.g.c.c.k
    public ImmutableBiMap<V, K> inverse() {
        return this.f31222h;
    }

    public RegularImmutableBiMap(Object[] objArr, int i2) {
        this.alternatingKeysAndValues = objArr;
        this.f31221g = i2;
        this.f31220f = 0;
        int chooseTableSize = i2 >= 2 ? ImmutableSet.chooseTableSize(i2) : 0;
        this.f31219e = RegularImmutableMap.createHashTable(objArr, i2, chooseTableSize, 0);
        this.f31222h = new RegularImmutableBiMap<>(RegularImmutableMap.createHashTable(objArr, i2, chooseTableSize, 1), objArr, i2, this);
    }

    public RegularImmutableBiMap(Object obj, Object[] objArr, int i2, RegularImmutableBiMap<V, K> regularImmutableBiMap) {
        this.f31219e = obj;
        this.alternatingKeysAndValues = objArr;
        this.f31220f = 1;
        this.f31221g = i2;
        this.f31222h = regularImmutableBiMap;
    }
}
