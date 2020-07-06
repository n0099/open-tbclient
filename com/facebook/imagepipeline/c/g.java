package com.facebook.imagepipeline.c;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes13.dex */
public class g<K, V> {
    private final v<V> mRC;
    @GuardedBy("this")
    private final LinkedHashMap<K, V> mRD = new LinkedHashMap<>();
    @GuardedBy("this")
    private int mRE = 0;

    public g(v<V> vVar) {
        this.mRC = vVar;
    }

    public synchronized int getCount() {
        return this.mRD.size();
    }

    public synchronized int getSizeInBytes() {
        return this.mRE;
    }

    @Nullable
    public synchronized K dCz() {
        return this.mRD.isEmpty() ? null : this.mRD.keySet().iterator().next();
    }

    public synchronized ArrayList<Map.Entry<K, V>> a(@Nullable com.facebook.common.internal.h<K> hVar) {
        ArrayList<Map.Entry<K, V>> arrayList;
        arrayList = new ArrayList<>(this.mRD.entrySet().size());
        for (Map.Entry<K, V> entry : this.mRD.entrySet()) {
            if (hVar == null || hVar.aP(entry.getKey())) {
                arrayList.add(entry);
            }
        }
        return arrayList;
    }

    public synchronized boolean contains(K k) {
        return this.mRD.containsKey(k);
    }

    @Nullable
    public synchronized V get(K k) {
        return this.mRD.get(k);
    }

    @Nullable
    public synchronized V put(K k, V v) {
        V remove;
        remove = this.mRD.remove(k);
        this.mRE -= bh(remove);
        this.mRD.put(k, v);
        this.mRE += bh(v);
        return remove;
    }

    @Nullable
    public synchronized V remove(K k) {
        V remove;
        remove = this.mRD.remove(k);
        this.mRE -= bh(remove);
        return remove;
    }

    private int bh(V v) {
        if (v == null) {
            return 0;
        }
        return this.mRC.bf(v);
    }
}
