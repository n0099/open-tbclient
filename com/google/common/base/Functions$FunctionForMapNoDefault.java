package com.google.common.base;

import com.baidu.tbadk.core.data.SmallTailInfo;
import d.h.c.a.g;
import d.h.c.a.n;
import java.io.Serializable;
import java.util.Map;
/* loaded from: classes6.dex */
public class Functions$FunctionForMapNoDefault<K, V> implements g<K, V>, Serializable {
    public static final long serialVersionUID = 0;
    public final Map<K, V> map;

    public Functions$FunctionForMapNoDefault(Map<K, V> map) {
        n.p(map);
        this.map = map;
    }

    @Override // d.h.c.a.g
    public V apply(K k) {
        V v = this.map.get(k);
        n.k(v != null || this.map.containsKey(k), "Key '%s' not present in map", k);
        return v;
    }

    @Override // d.h.c.a.g
    public boolean equals(Object obj) {
        if (obj instanceof Functions$FunctionForMapNoDefault) {
            return this.map.equals(((Functions$FunctionForMapNoDefault) obj).map);
        }
        return false;
    }

    public int hashCode() {
        return this.map.hashCode();
    }

    public String toString() {
        return "Functions.forMap(" + this.map + SmallTailInfo.EMOTION_SUFFIX;
    }
}
