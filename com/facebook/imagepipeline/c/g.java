package com.facebook.imagepipeline.c;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes12.dex */
public class g<K, V> {
    private final v<V> nDQ;
    @GuardedBy("this")
    private final LinkedHashMap<K, V> nDR = new LinkedHashMap<>();
    @GuardedBy("this")
    private int nDS = 0;

    public g(v<V> vVar) {
        this.nDQ = vVar;
    }

    public synchronized int getCount() {
        return this.nDR.size();
    }

    public synchronized int getSizeInBytes() {
        return this.nDS;
    }

    @Nullable
    public synchronized K dVS() {
        return this.nDR.isEmpty() ? null : this.nDR.keySet().iterator().next();
    }

    public synchronized ArrayList<Map.Entry<K, V>> a(@Nullable com.facebook.common.internal.h<K> hVar) {
        ArrayList<Map.Entry<K, V>> arrayList;
        arrayList = new ArrayList<>(this.nDR.entrySet().size());
        for (Map.Entry<K, V> entry : this.nDR.entrySet()) {
            if (hVar == null || hVar.aT(entry.getKey())) {
                arrayList.add(entry);
            }
        }
        return arrayList;
    }

    public synchronized boolean contains(K k) {
        return this.nDR.containsKey(k);
    }

    @Nullable
    public synchronized V get(K k) {
        return this.nDR.get(k);
    }

    @Nullable
    public synchronized V put(K k, V v) {
        V remove;
        remove = this.nDR.remove(k);
        this.nDS -= bl(remove);
        this.nDR.put(k, v);
        this.nDS += bl(v);
        return remove;
    }

    @Nullable
    public synchronized V remove(K k) {
        V remove;
        remove = this.nDR.remove(k);
        this.nDS -= bl(remove);
        return remove;
    }

    private int bl(V v) {
        if (v == null) {
            return 0;
        }
        return this.nDQ.bj(v);
    }
}
