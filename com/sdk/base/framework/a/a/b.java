package com.sdk.base.framework.a.a;

import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes8.dex */
public final class b<K, V> extends ConcurrentHashMap<K, Long> {
    public b() {
    }

    public b(int i, float f) {
        super(0, 0.75f, 16);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    /* renamed from: b */
    public synchronized Long get(Object obj) {
        return containsKey(obj) ? (Long) super.get(obj) : null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    /* renamed from: a */
    public final synchronized Long remove(Object obj) {
        return (Long) super.remove(obj);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Long */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    /* renamed from: a */
    public final synchronized Long put(K k, Long l) {
        if (containsKey(k)) {
            remove(k);
        }
        return (Long) super.put(k, l);
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public final synchronized void clear() {
        super.clear();
    }

    @Override // java.util.concurrent.ConcurrentHashMap, java.util.AbstractMap, java.util.Map
    public final synchronized boolean containsKey(Object obj) {
        boolean z;
        Long l = (Long) super.get(obj);
        if (l == null || System.currentTimeMillis() >= l.longValue()) {
            remove(obj);
            z = false;
        } else {
            z = true;
        }
        return z;
    }
}
