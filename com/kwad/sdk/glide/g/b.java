package com.kwad.sdk.glide.g;

import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
/* loaded from: classes7.dex */
public final class b<K, V> extends ArrayMap<K, V> {

    /* renamed from: a  reason: collision with root package name */
    public int f35992a;

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public void clear() {
        this.f35992a = 0;
        super.clear();
    }

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public int hashCode() {
        if (this.f35992a == 0) {
            this.f35992a = super.hashCode();
        }
        return this.f35992a;
    }

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public V put(K k, V v) {
        this.f35992a = 0;
        return (V) super.put(k, v);
    }

    @Override // androidx.collection.SimpleArrayMap
    public void putAll(SimpleArrayMap<? extends K, ? extends V> simpleArrayMap) {
        this.f35992a = 0;
        super.putAll(simpleArrayMap);
    }

    @Override // androidx.collection.SimpleArrayMap
    public V removeAt(int i2) {
        this.f35992a = 0;
        return (V) super.removeAt(i2);
    }

    @Override // androidx.collection.SimpleArrayMap
    public V setValueAt(int i2, V v) {
        this.f35992a = 0;
        return (V) super.setValueAt(i2, v);
    }
}
