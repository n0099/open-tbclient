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
    private final v<V> ntA;
    @GuardedBy("this")
    private final LinkedHashMap<K, V> ntB = new LinkedHashMap<>();
    @GuardedBy("this")
    private int ntC = 0;

    public g(v<V> vVar) {
        this.ntA = vVar;
    }

    public synchronized int getCount() {
        return this.ntB.size();
    }

    public synchronized int getSizeInBytes() {
        return this.ntC;
    }

    @Nullable
    public synchronized K dRL() {
        return this.ntB.isEmpty() ? null : this.ntB.keySet().iterator().next();
    }

    public synchronized ArrayList<Map.Entry<K, V>> a(@Nullable com.facebook.common.internal.h<K> hVar) {
        ArrayList<Map.Entry<K, V>> arrayList;
        arrayList = new ArrayList<>(this.ntB.entrySet().size());
        for (Map.Entry<K, V> entry : this.ntB.entrySet()) {
            if (hVar == null || hVar.aR(entry.getKey())) {
                arrayList.add(entry);
            }
        }
        return arrayList;
    }

    public synchronized boolean contains(K k) {
        return this.ntB.containsKey(k);
    }

    @Nullable
    public synchronized V get(K k) {
        return this.ntB.get(k);
    }

    @Nullable
    public synchronized V put(K k, V v) {
        V remove;
        remove = this.ntB.remove(k);
        this.ntC -= bj(remove);
        this.ntB.put(k, v);
        this.ntC += bj(v);
        return remove;
    }

    @Nullable
    public synchronized V remove(K k) {
        V remove;
        remove = this.ntB.remove(k);
        this.ntC -= bj(remove);
        return remove;
    }

    private int bj(V v) {
        if (v == null) {
            return 0;
        }
        return this.ntA.bh(v);
    }
}
