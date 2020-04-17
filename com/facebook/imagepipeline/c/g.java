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
    private final v<V> mau;
    @GuardedBy("this")
    private final LinkedHashMap<K, V> mav = new LinkedHashMap<>();
    @GuardedBy("this")
    private int maw = 0;

    public g(v<V> vVar) {
        this.mau = vVar;
    }

    public synchronized int getCount() {
        return this.mav.size();
    }

    public synchronized int getSizeInBytes() {
        return this.maw;
    }

    @Nullable
    public synchronized K dqp() {
        return this.mav.isEmpty() ? null : this.mav.keySet().iterator().next();
    }

    public synchronized ArrayList<Map.Entry<K, V>> a(@Nullable com.facebook.common.internal.h<K> hVar) {
        ArrayList<Map.Entry<K, V>> arrayList;
        arrayList = new ArrayList<>(this.mav.entrySet().size());
        for (Map.Entry<K, V> entry : this.mav.entrySet()) {
            if (hVar == null || hVar.aJ(entry.getKey())) {
                arrayList.add(entry);
            }
        }
        return arrayList;
    }

    public synchronized boolean contains(K k) {
        return this.mav.containsKey(k);
    }

    @Nullable
    public synchronized V get(K k) {
        return this.mav.get(k);
    }

    @Nullable
    public synchronized V put(K k, V v) {
        V remove;
        remove = this.mav.remove(k);
        this.maw -= bb(remove);
        this.mav.put(k, v);
        this.maw += bb(v);
        return remove;
    }

    @Nullable
    public synchronized V remove(K k) {
        V remove;
        remove = this.mav.remove(k);
        this.maw -= bb(remove);
        return remove;
    }

    private int bb(V v) {
        if (v == null) {
            return 0;
        }
        return this.mau.aZ(v);
    }
}
