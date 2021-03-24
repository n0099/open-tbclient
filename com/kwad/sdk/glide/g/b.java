package com.kwad.sdk.glide.g;

import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
/* loaded from: classes6.dex */
public final class b<K, V> extends ArrayMap<K, V> {

    /* renamed from: a  reason: collision with root package name */
    public int f35210a;

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public void clear() {
        this.f35210a = 0;
        super.clear();
    }

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public int hashCode() {
        if (this.f35210a == 0) {
            this.f35210a = super.hashCode();
        }
        return this.f35210a;
    }

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public V put(K k, V v) {
        this.f35210a = 0;
        return (V) super.put(k, v);
    }

    @Override // androidx.collection.SimpleArrayMap
    public void putAll(SimpleArrayMap<? extends K, ? extends V> simpleArrayMap) {
        this.f35210a = 0;
        super.putAll(simpleArrayMap);
    }

    @Override // androidx.collection.SimpleArrayMap
    public V removeAt(int i) {
        this.f35210a = 0;
        return (V) super.removeAt(i);
    }

    @Override // androidx.collection.SimpleArrayMap
    public V setValueAt(int i, V v) {
        this.f35210a = 0;
        return (V) super.setValueAt(i, v);
    }
}
