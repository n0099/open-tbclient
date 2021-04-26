package com.google.common.collect;

import d.g.c.a.n;
import d.g.c.c.k;
import d.g.c.c.r0;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.Enum;
import java.util.EnumMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes6.dex */
public final class EnumBiMap<K extends Enum<K>, V extends Enum<V>> extends AbstractBiMap<K, V> {
    public static final long serialVersionUID = 0;
    public transient Class<K> keyType;
    public transient Class<V> valueType;

    public EnumBiMap(Class<K> cls, Class<V> cls2) {
        super(new EnumMap(cls), new EnumMap(cls2));
        this.keyType = cls;
        this.valueType = cls2;
    }

    public static <K extends Enum<K>, V extends Enum<V>> EnumBiMap<K, V> create(Class<K> cls, Class<V> cls2) {
        return new EnumBiMap<>(cls, cls2);
    }

    public static <K extends Enum<K>> Class<K> inferKeyType(Map<K, ?> map) {
        if (map instanceof EnumBiMap) {
            return ((EnumBiMap) map).keyType();
        }
        if (map instanceof EnumHashBiMap) {
            return ((EnumHashBiMap) map).keyType();
        }
        n.d(!map.isEmpty());
        return map.keySet().iterator().next().getDeclaringClass();
    }

    public static <V extends Enum<V>> Class<V> inferValueType(Map<?, V> map) {
        if (map instanceof EnumBiMap) {
            return ((EnumBiMap) map).valueType;
        }
        n.d(!map.isEmpty());
        return map.values().iterator().next().getDeclaringClass();
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.keyType = (Class) objectInputStream.readObject();
        this.valueType = (Class) objectInputStream.readObject();
        setDelegates(new EnumMap(this.keyType), new EnumMap(this.valueType));
        r0.b(this, objectInputStream);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.keyType);
        objectOutputStream.writeObject(this.valueType);
        r0.i(this, objectOutputStream);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.collect.EnumBiMap<K extends java.lang.Enum<K>, V extends java.lang.Enum<V>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractBiMap
    public /* bridge */ /* synthetic */ Object checkKey(Object obj) {
        return checkKey((EnumBiMap<K, V>) ((Enum) obj));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.common.collect.EnumBiMap<K extends java.lang.Enum<K>, V extends java.lang.Enum<V>> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractBiMap
    public /* bridge */ /* synthetic */ Object checkValue(Object obj) {
        return checkValue((EnumBiMap<K, V>) ((Enum) obj));
    }

    @Override // com.google.common.collect.AbstractBiMap, d.g.c.c.u, java.util.Map
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // com.google.common.collect.AbstractBiMap, d.g.c.c.u, java.util.Map
    public /* bridge */ /* synthetic */ boolean containsValue(Object obj) {
        return super.containsValue(obj);
    }

    @Override // com.google.common.collect.AbstractBiMap, d.g.c.c.u, java.util.Map
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.AbstractBiMap, d.g.c.c.k
    public /* bridge */ /* synthetic */ k inverse() {
        return super.inverse();
    }

    @Override // com.google.common.collect.AbstractBiMap, d.g.c.c.u, java.util.Map
    public /* bridge */ /* synthetic */ Set keySet() {
        return super.keySet();
    }

    public Class<K> keyType() {
        return this.keyType;
    }

    @Override // com.google.common.collect.AbstractBiMap, d.g.c.c.u, java.util.Map
    public /* bridge */ /* synthetic */ void putAll(Map map) {
        super.putAll(map);
    }

    public Class<V> valueType() {
        return this.valueType;
    }

    @Override // com.google.common.collect.AbstractBiMap, d.g.c.c.u, java.util.Map, d.g.c.c.k
    public /* bridge */ /* synthetic */ Set values() {
        return super.values();
    }

    public static <K extends Enum<K>, V extends Enum<V>> EnumBiMap<K, V> create(Map<K, V> map) {
        EnumBiMap<K, V> create = create(inferKeyType(map), inferValueType(map));
        create.putAll(map);
        return create;
    }

    public K checkKey(K k) {
        n.p(k);
        return k;
    }

    public V checkValue(V v) {
        n.p(v);
        return v;
    }
}
