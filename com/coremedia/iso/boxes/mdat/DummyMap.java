package com.coremedia.iso.boxes.mdat;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes12.dex */
public class DummyMap<K, V> implements Map<K, V> {
    static final /* synthetic */ boolean $assertionsDisabled;
    HashSet<K> keys = new HashSet<>();
    V value;

    static {
        $assertionsDisabled = !DummyMap.class.desiredAssertionStatus();
    }

    public DummyMap(V v) {
        this.value = v;
    }

    public Comparator<? super K> comparator() {
        return null;
    }

    public void addKeys(K[] kArr) {
        Collections.addAll(this.keys, kArr);
    }

    @Override // java.util.Map
    public int size() {
        return this.keys.size();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.keys.isEmpty();
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
    public V get(Object obj) {
        if (this.keys.contains(obj)) {
            return this.value;
        }
        return null;
    }

    @Override // java.util.Map
    public V put(K k, V v) {
        if ($assertionsDisabled || this.value == v) {
            this.keys.add(k);
            return this.value;
        }
        throw new AssertionError();
    }

    @Override // java.util.Map
    public V remove(Object obj) {
        V v = get(obj);
        this.keys.remove(obj);
        return v;
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        for (K k : map.keySet()) {
            if (!$assertionsDisabled && map.get(k) != this.value) {
                throw new AssertionError();
            }
            this.keys.add(k);
        }
    }

    @Override // java.util.Map
    public void clear() {
        this.keys.clear();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return this.keys;
    }

    @Override // java.util.Map
    public Collection<V> values() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        throw new UnsupportedOperationException();
    }
}
