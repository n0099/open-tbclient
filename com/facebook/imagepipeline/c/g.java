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
    private final v<V> mvA;
    @GuardedBy("this")
    private final LinkedHashMap<K, V> mvB = new LinkedHashMap<>();
    @GuardedBy("this")
    private int mvC = 0;

    public g(v<V> vVar) {
        this.mvA = vVar;
    }

    public synchronized int getCount() {
        return this.mvB.size();
    }

    public synchronized int getSizeInBytes() {
        return this.mvC;
    }

    @Nullable
    public synchronized K dxT() {
        return this.mvB.isEmpty() ? null : this.mvB.keySet().iterator().next();
    }

    public synchronized ArrayList<Map.Entry<K, V>> a(@Nullable com.facebook.common.internal.h<K> hVar) {
        ArrayList<Map.Entry<K, V>> arrayList;
        arrayList = new ArrayList<>(this.mvB.entrySet().size());
        for (Map.Entry<K, V> entry : this.mvB.entrySet()) {
            if (hVar == null || hVar.aO(entry.getKey())) {
                arrayList.add(entry);
            }
        }
        return arrayList;
    }

    public synchronized boolean contains(K k) {
        return this.mvB.containsKey(k);
    }

    @Nullable
    public synchronized V get(K k) {
        return this.mvB.get(k);
    }

    @Nullable
    public synchronized V put(K k, V v) {
        V remove;
        remove = this.mvB.remove(k);
        this.mvC -= bg(remove);
        this.mvB.put(k, v);
        this.mvC += bg(v);
        return remove;
    }

    @Nullable
    public synchronized V remove(K k) {
        V remove;
        remove = this.mvB.remove(k);
        this.mvC -= bg(remove);
        return remove;
    }

    private int bg(V v) {
        if (v == null) {
            return 0;
        }
        return this.mvA.be(v);
    }
}
