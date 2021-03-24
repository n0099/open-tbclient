package com.coremedia.iso.boxes.mdat;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes6.dex */
public class DummyMap<K, V> implements Map<K, V> {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public HashSet<K> keys = new HashSet<>();
    public V value;

    public DummyMap(V v) {
        this.value = v;
    }

    public void addKeys(K[] kArr) {
        Collections.addAll(this.keys, kArr);
    }

    @Override // java.util.Map
    public void clear() {
        this.keys.clear();
    }

    public Comparator<? super K> comparator() {
        return null;
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.keys.contains(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return this.value == obj;
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public V get(Object obj) {
        if (this.keys.contains(obj)) {
            return this.value;
        }
        return null;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.keys.isEmpty();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return this.keys;
    }

    @Override // java.util.Map
    public V put(K k, V v) {
        this.keys.add(k);
        return this.value;
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        for (K k : map.keySet()) {
            this.keys.add(k);
        }
    }

    @Override // java.util.Map
    public V remove(Object obj) {
        V v = get(obj);
        this.keys.remove(obj);
        return v;
    }

    @Override // java.util.Map
    public int size() {
        return this.keys.size();
    }

    @Override // java.util.Map
    public Collection<V> values() {
        throw new UnsupportedOperationException();
    }
}
