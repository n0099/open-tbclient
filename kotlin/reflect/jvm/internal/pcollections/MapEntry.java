package kotlin.reflect.jvm.internal.pcollections;

import java.io.Serializable;
/* loaded from: classes9.dex */
public final class MapEntry<K, V> implements Serializable {
    public final K key;
    public final V value;

    public MapEntry(K k, V v) {
        this.key = k;
        this.value = v;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MapEntry)) {
            return false;
        }
        MapEntry mapEntry = (MapEntry) obj;
        K k = this.key;
        if (k == null) {
            if (mapEntry.key != null) {
                return false;
            }
        } else if (!k.equals(mapEntry.key)) {
            return false;
        }
        V v = this.value;
        V v2 = mapEntry.value;
        if (v == null) {
            if (v2 != null) {
                return false;
            }
        } else if (!v.equals(v2)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode;
        K k = this.key;
        int i = 0;
        if (k == null) {
            hashCode = 0;
        } else {
            hashCode = k.hashCode();
        }
        V v = this.value;
        if (v != null) {
            i = v.hashCode();
        }
        return hashCode ^ i;
    }

    public String toString() {
        return this.key + "=" + this.value;
    }
}
