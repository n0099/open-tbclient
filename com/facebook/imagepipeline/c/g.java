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
    private final v<V> mZL;
    @GuardedBy("this")
    private final LinkedHashMap<K, V> mZM = new LinkedHashMap<>();
    @GuardedBy("this")
    private int mZN = 0;

    public g(v<V> vVar) {
        this.mZL = vVar;
    }

    public synchronized int getCount() {
        return this.mZM.size();
    }

    public synchronized int getSizeInBytes() {
        return this.mZN;
    }

    @Nullable
    public synchronized K dFM() {
        return this.mZM.isEmpty() ? null : this.mZM.keySet().iterator().next();
    }

    public synchronized ArrayList<Map.Entry<K, V>> a(@Nullable com.facebook.common.internal.h<K> hVar) {
        ArrayList<Map.Entry<K, V>> arrayList;
        arrayList = new ArrayList<>(this.mZM.entrySet().size());
        for (Map.Entry<K, V> entry : this.mZM.entrySet()) {
            if (hVar == null || hVar.aP(entry.getKey())) {
                arrayList.add(entry);
            }
        }
        return arrayList;
    }

    public synchronized boolean contains(K k) {
        return this.mZM.containsKey(k);
    }

    @Nullable
    public synchronized V get(K k) {
        return this.mZM.get(k);
    }

    @Nullable
    public synchronized V put(K k, V v) {
        V remove;
        remove = this.mZM.remove(k);
        this.mZN -= bh(remove);
        this.mZM.put(k, v);
        this.mZN += bh(v);
        return remove;
    }

    @Nullable
    public synchronized V remove(K k) {
        V remove;
        remove = this.mZM.remove(k);
        this.mZN -= bh(remove);
        return remove;
    }

    private int bh(V v) {
        if (v == null) {
            return 0;
        }
        return this.mZL.bf(v);
    }
}
