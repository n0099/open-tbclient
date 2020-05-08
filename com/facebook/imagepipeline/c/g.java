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
    private final LinkedHashMap<K, V> maA = new LinkedHashMap<>();
    @GuardedBy("this")
    private int maB = 0;
    private final v<V> maz;

    public g(v<V> vVar) {
        this.maz = vVar;
    }

    public synchronized int getCount() {
        return this.maA.size();
    }

    public synchronized int getSizeInBytes() {
        return this.maB;
    }

    @Nullable
    public synchronized K dqm() {
        return this.maA.isEmpty() ? null : this.maA.keySet().iterator().next();
    }

    public synchronized ArrayList<Map.Entry<K, V>> a(@Nullable com.facebook.common.internal.h<K> hVar) {
        ArrayList<Map.Entry<K, V>> arrayList;
        arrayList = new ArrayList<>(this.maA.entrySet().size());
        for (Map.Entry<K, V> entry : this.maA.entrySet()) {
            if (hVar == null || hVar.aK(entry.getKey())) {
                arrayList.add(entry);
            }
        }
        return arrayList;
    }

    public synchronized boolean contains(K k) {
        return this.maA.containsKey(k);
    }

    @Nullable
    public synchronized V get(K k) {
        return this.maA.get(k);
    }

    @Nullable
    public synchronized V put(K k, V v) {
        V remove;
        remove = this.maA.remove(k);
        this.maB -= bc(remove);
        this.maA.put(k, v);
        this.maB += bc(v);
        return remove;
    }

    @Nullable
    public synchronized V remove(K k) {
        V remove;
        remove = this.maA.remove(k);
        this.maB -= bc(remove);
        return remove;
    }

    private int bc(V v) {
        if (v == null) {
            return 0;
        }
        return this.maz.ba(v);
    }
}
