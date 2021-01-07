package com.facebook.imagepipeline.b;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes5.dex */
public class g<K, V> {
    private final v<V> pBA;
    @GuardedBy("this")
    private final LinkedHashMap<K, V> pBB = new LinkedHashMap<>();
    @GuardedBy("this")
    private int pBC = 0;

    public g(v<V> vVar) {
        this.pBA = vVar;
    }

    public synchronized int getCount() {
        return this.pBB.size();
    }

    public synchronized int getSizeInBytes() {
        return this.pBC;
    }

    @Nullable
    public synchronized K exj() {
        return this.pBB.isEmpty() ? null : this.pBB.keySet().iterator().next();
    }

    public synchronized ArrayList<Map.Entry<K, V>> a(@Nullable com.facebook.common.internal.h<K> hVar) {
        ArrayList<Map.Entry<K, V>> arrayList;
        arrayList = new ArrayList<>(this.pBB.entrySet().size());
        for (Map.Entry<K, V> entry : this.pBB.entrySet()) {
            if (hVar == null || hVar.apply(entry.getKey())) {
                arrayList.add(entry);
            }
        }
        return arrayList;
    }

    public synchronized boolean contains(K k) {
        return this.pBB.containsKey(k);
    }

    @Nullable
    public synchronized V get(K k) {
        return this.pBB.get(k);
    }

    @Nullable
    public synchronized V put(K k, V v) {
        V remove;
        remove = this.pBB.remove(k);
        this.pBC -= bs(remove);
        this.pBB.put(k, v);
        this.pBC += bs(v);
        return remove;
    }

    @Nullable
    public synchronized V remove(K k) {
        V remove;
        remove = this.pBB.remove(k);
        this.pBC -= bs(remove);
        return remove;
    }

    private int bs(V v) {
        if (v == null) {
            return 0;
        }
        return this.pBA.bq(v);
    }
}
