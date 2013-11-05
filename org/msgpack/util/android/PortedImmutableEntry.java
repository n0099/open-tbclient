package org.msgpack.util.android;

import java.io.Serializable;
import java.util.Map;
/* loaded from: classes.dex */
public class PortedImmutableEntry<K, V> implements Serializable, Map.Entry<K, V> {
    private static final long serialVersionUID = -4564047655287765373L;
    private final K key;
    private final V value;

    public PortedImmutableEntry(K k, V v) {
        this.key = k;
        this.value = v;
    }

    public PortedImmutableEntry(Map.Entry<? extends K, ? extends V> entry) {
        this.key = entry.getKey();
        this.value = entry.getValue();
    }

    @Override // java.util.Map.Entry
    public K getKey() {
        return this.key;
    }

    @Override // java.util.Map.Entry
    public V getValue() {
        return this.value;
    }

    @Override // java.util.Map.Entry
    public V setValue(V v) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map.Entry
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            if (this.key != null ? this.key.equals(entry.getKey()) : entry.getKey() == null) {
                if (this.value == null) {
                    if (entry.getValue() == null) {
                        return true;
                    }
                } else if (this.value.equals(entry.getValue())) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        return (this.key == null ? 0 : this.key.hashCode()) ^ (this.value != null ? this.value.hashCode() : 0);
    }

    public String toString() {
        return this.key + "=" + this.value;
    }
}
