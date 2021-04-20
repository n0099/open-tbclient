package com.google.common.collect;

import d.g.c.c.b;
import java.io.Serializable;
/* loaded from: classes6.dex */
public class ImmutableEntry<K, V> extends b<K, V> implements Serializable {
    public static final long serialVersionUID = 0;
    public final K key;
    public final V value;

    public ImmutableEntry(K k, V v) {
        this.key = k;
        this.value = v;
    }

    @Override // d.g.c.c.b, java.util.Map.Entry
    public final K getKey() {
        return this.key;
    }

    @Override // d.g.c.c.b, java.util.Map.Entry
    public final V getValue() {
        return this.value;
    }

    @Override // d.g.c.c.b, java.util.Map.Entry
    public final V setValue(V v) {
        throw new UnsupportedOperationException();
    }
}
