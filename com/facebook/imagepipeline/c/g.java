package com.facebook.imagepipeline.c;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes8.dex */
public class g<K, V> {
    private final v<V> ntS;
    @GuardedBy("this")
    private final LinkedHashMap<K, V> ntT = new LinkedHashMap<>();
    @GuardedBy("this")
    private int ntU = 0;

    public g(v<V> vVar) {
        this.ntS = vVar;
    }

    public synchronized int getCount() {
        return this.ntT.size();
    }

    public synchronized int getSizeInBytes() {
        return this.ntU;
    }

    @Nullable
    public synchronized K dRU() {
        return this.ntT.isEmpty() ? null : this.ntT.keySet().iterator().next();
    }

    public synchronized ArrayList<Map.Entry<K, V>> a(@Nullable com.facebook.common.internal.h<K> hVar) {
        ArrayList<Map.Entry<K, V>> arrayList;
        arrayList = new ArrayList<>(this.ntT.entrySet().size());
        for (Map.Entry<K, V> entry : this.ntT.entrySet()) {
            if (hVar == null || hVar.aR(entry.getKey())) {
                arrayList.add(entry);
            }
        }
        return arrayList;
    }

    public synchronized boolean contains(K k) {
        return this.ntT.containsKey(k);
    }

    @Nullable
    public synchronized V get(K k) {
        return this.ntT.get(k);
    }

    @Nullable
    public synchronized V put(K k, V v) {
        V remove;
        remove = this.ntT.remove(k);
        this.ntU -= bj(remove);
        this.ntT.put(k, v);
        this.ntU += bj(v);
        return remove;
    }

    @Nullable
    public synchronized V remove(K k) {
        V remove;
        remove = this.ntT.remove(k);
        this.ntU -= bj(remove);
        return remove;
    }

    private int bj(V v) {
        if (v == null) {
            return 0;
        }
        return this.ntS.bh(v);
    }
}
