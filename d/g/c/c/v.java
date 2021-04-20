package d.g.c.c;

import java.util.Map;
/* loaded from: classes6.dex */
public abstract class v<K, V> extends y implements Map.Entry<K, V> {
    public abstract Map.Entry<K, V> b();

    public boolean equals(Object obj) {
        return b().equals(obj);
    }

    @Override // java.util.Map.Entry
    public K getKey() {
        return b().getKey();
    }

    public V getValue() {
        return b().getValue();
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        return b().hashCode();
    }

    public V setValue(V v) {
        return b().setValue(v);
    }

    public boolean standardEquals(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            return d.g.c.a.k.a(getKey(), entry.getKey()) && d.g.c.a.k.a(getValue(), entry.getValue());
        }
        return false;
    }
}
