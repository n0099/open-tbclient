package com.google.common.collect;

import com.google.common.collect.ImmutableMap;
import d.h.c.a.n;
import d.h.c.c.c1;
import d.h.c.c.f0;
import java.io.Serializable;
import java.lang.Enum;
import java.util.EnumMap;
import java.util.Map;
/* loaded from: classes6.dex */
public final class ImmutableEnumMap<K extends Enum<K>, V> extends ImmutableMap.IteratorBasedImmutableMap<K, V> {

    /* renamed from: e  reason: collision with root package name */
    public final transient EnumMap<K, V> f30882e;

    /* loaded from: classes6.dex */
    public static class EnumSerializedForm<K extends Enum<K>, V> implements Serializable {
        public static final long serialVersionUID = 0;
        public final EnumMap<K, V> delegate;

        public EnumSerializedForm(EnumMap<K, V> enumMap) {
            this.delegate = enumMap;
        }

        public Object readResolve() {
            return new ImmutableEnumMap(this.delegate);
        }
    }

    public static <K extends Enum<K>, V> ImmutableMap<K, V> asImmutable(EnumMap<K, V> enumMap) {
        int size = enumMap.size();
        if (size != 0) {
            if (size != 1) {
                return new ImmutableEnumMap(enumMap);
            }
            Map.Entry entry = (Map.Entry) f0.h(enumMap.entrySet());
            return ImmutableMap.of(entry.getKey(), entry.getValue());
        }
        return ImmutableMap.of();
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public boolean containsKey(Object obj) {
        return this.f30882e.containsKey(obj);
    }

    @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap
    public c1<Map.Entry<K, V>> entryIterator() {
        return Maps.G(this.f30882e.entrySet().iterator());
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ImmutableEnumMap) {
            obj = ((ImmutableEnumMap) obj).f30882e;
        }
        return this.f30882e.equals(obj);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public V get(Object obj) {
        return this.f30882e.get(obj);
    }

    @Override // com.google.common.collect.ImmutableMap
    public boolean isPartialView() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableMap
    public c1<K> keyIterator() {
        return Iterators.x(this.f30882e.keySet().iterator());
    }

    @Override // java.util.Map
    public int size() {
        return this.f30882e.size();
    }

    @Override // com.google.common.collect.ImmutableMap
    public Object writeReplace() {
        return new EnumSerializedForm(this.f30882e);
    }

    public ImmutableEnumMap(EnumMap<K, V> enumMap) {
        this.f30882e = enumMap;
        n.d(!enumMap.isEmpty());
    }
}
