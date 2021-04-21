package com.google.common.base;

import com.baidu.tbadk.core.data.SmallTailInfo;
import d.h.c.a.g;
import d.h.c.a.k;
import d.h.c.a.n;
import java.io.Serializable;
import java.util.Map;
/* loaded from: classes6.dex */
public class Functions$ForMapWithDefault<K, V> implements g<K, V>, Serializable {
    public static final long serialVersionUID = 0;
    public final V defaultValue;
    public final Map<K, ? extends V> map;

    public Functions$ForMapWithDefault(Map<K, ? extends V> map, V v) {
        n.p(map);
        this.map = map;
        this.defaultValue = v;
    }

    @Override // d.h.c.a.g
    public V apply(K k) {
        V v = this.map.get(k);
        return (v != null || this.map.containsKey(k)) ? v : this.defaultValue;
    }

    @Override // d.h.c.a.g
    public boolean equals(Object obj) {
        if (obj instanceof Functions$ForMapWithDefault) {
            Functions$ForMapWithDefault functions$ForMapWithDefault = (Functions$ForMapWithDefault) obj;
            return this.map.equals(functions$ForMapWithDefault.map) && k.a(this.defaultValue, functions$ForMapWithDefault.defaultValue);
        }
        return false;
    }

    public int hashCode() {
        return k.b(this.map, this.defaultValue);
    }

    public String toString() {
        return "Functions.forMap(" + this.map + ", defaultValue=" + this.defaultValue + SmallTailInfo.EMOTION_SUFFIX;
    }
}
