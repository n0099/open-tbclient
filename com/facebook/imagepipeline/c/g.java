package com.facebook.imagepipeline.c;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes17.dex */
public class g<K, V> {
    private final v<V> oVx;
    @GuardedBy("this")
    private final LinkedHashMap<K, V> oVy = new LinkedHashMap<>();
    @GuardedBy("this")
    private int oVz = 0;

    public g(v<V> vVar) {
        this.oVx = vVar;
    }

    public synchronized int getCount() {
        return this.oVy.size();
    }

    public synchronized int getSizeInBytes() {
        return this.oVz;
    }

    @Nullable
    public synchronized K enp() {
        return this.oVy.isEmpty() ? null : this.oVy.keySet().iterator().next();
    }

    public synchronized ArrayList<Map.Entry<K, V>> a(@Nullable com.facebook.common.internal.h<K> hVar) {
        ArrayList<Map.Entry<K, V>> arrayList;
        arrayList = new ArrayList<>(this.oVy.entrySet().size());
        for (Map.Entry<K, V> entry : this.oVy.entrySet()) {
            if (hVar == null || hVar.bb(entry.getKey())) {
                arrayList.add(entry);
            }
        }
        return arrayList;
    }

    public synchronized boolean contains(K k) {
        return this.oVy.containsKey(k);
    }

    @Nullable
    public synchronized V get(K k) {
        return this.oVy.get(k);
    }

    @Nullable
    public synchronized V put(K k, V v) {
        V remove;
        remove = this.oVy.remove(k);
        this.oVz -= bt(remove);
        this.oVy.put(k, v);
        this.oVz += bt(v);
        return remove;
    }

    @Nullable
    public synchronized V remove(K k) {
        V remove;
        remove = this.oVy.remove(k);
        this.oVz -= bt(remove);
        return remove;
    }

    private int bt(V v) {
        if (v == null) {
            return 0;
        }
        return this.oVx.br(v);
    }
}
