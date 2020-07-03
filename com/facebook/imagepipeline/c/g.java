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
    @GuardedBy("this")
    private final LinkedHashMap<K, V> mRA = new LinkedHashMap<>();
    @GuardedBy("this")
    private int mRB = 0;
    private final v<V> mRz;

    public g(v<V> vVar) {
        this.mRz = vVar;
    }

    public synchronized int getCount() {
        return this.mRA.size();
    }

    public synchronized int getSizeInBytes() {
        return this.mRB;
    }

    @Nullable
    public synchronized K dCv() {
        return this.mRA.isEmpty() ? null : this.mRA.keySet().iterator().next();
    }

    public synchronized ArrayList<Map.Entry<K, V>> a(@Nullable com.facebook.common.internal.h<K> hVar) {
        ArrayList<Map.Entry<K, V>> arrayList;
        arrayList = new ArrayList<>(this.mRA.entrySet().size());
        for (Map.Entry<K, V> entry : this.mRA.entrySet()) {
            if (hVar == null || hVar.aP(entry.getKey())) {
                arrayList.add(entry);
            }
        }
        return arrayList;
    }

    public synchronized boolean contains(K k) {
        return this.mRA.containsKey(k);
    }

    @Nullable
    public synchronized V get(K k) {
        return this.mRA.get(k);
    }

    @Nullable
    public synchronized V put(K k, V v) {
        V remove;
        remove = this.mRA.remove(k);
        this.mRB -= bh(remove);
        this.mRA.put(k, v);
        this.mRB += bh(v);
        return remove;
    }

    @Nullable
    public synchronized V remove(K k) {
        V remove;
        remove = this.mRA.remove(k);
        this.mRB -= bh(remove);
        return remove;
    }

    private int bh(V v) {
        if (v == null) {
            return 0;
        }
        return this.mRz.bf(v);
    }
}
