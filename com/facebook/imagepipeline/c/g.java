package com.facebook.imagepipeline.c;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes3.dex */
public class g<K, V> {
    private final v<V> mZJ;
    @GuardedBy("this")
    private final LinkedHashMap<K, V> mZK = new LinkedHashMap<>();
    @GuardedBy("this")
    private int mZL = 0;

    public g(v<V> vVar) {
        this.mZJ = vVar;
    }

    public synchronized int getCount() {
        return this.mZK.size();
    }

    public synchronized int getSizeInBytes() {
        return this.mZL;
    }

    @Nullable
    public synchronized K dFL() {
        return this.mZK.isEmpty() ? null : this.mZK.keySet().iterator().next();
    }

    public synchronized ArrayList<Map.Entry<K, V>> a(@Nullable com.facebook.common.internal.h<K> hVar) {
        ArrayList<Map.Entry<K, V>> arrayList;
        arrayList = new ArrayList<>(this.mZK.entrySet().size());
        for (Map.Entry<K, V> entry : this.mZK.entrySet()) {
            if (hVar == null || hVar.aP(entry.getKey())) {
                arrayList.add(entry);
            }
        }
        return arrayList;
    }

    public synchronized boolean contains(K k) {
        return this.mZK.containsKey(k);
    }

    @Nullable
    public synchronized V get(K k) {
        return this.mZK.get(k);
    }

    @Nullable
    public synchronized V put(K k, V v) {
        V remove;
        remove = this.mZK.remove(k);
        this.mZL -= bh(remove);
        this.mZK.put(k, v);
        this.mZL += bh(v);
        return remove;
    }

    @Nullable
    public synchronized V remove(K k) {
        V remove;
        remove = this.mZK.remove(k);
        this.mZL -= bh(remove);
        return remove;
    }

    private int bh(V v) {
        if (v == null) {
            return 0;
        }
        return this.mZJ.bf(v);
    }
}
