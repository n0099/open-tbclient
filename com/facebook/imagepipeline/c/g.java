package com.facebook.imagepipeline.c;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes13.dex */
public class g<K, V> {
    private final v<V> lQS;
    @GuardedBy("this")
    private final LinkedHashMap<K, V> lQT = new LinkedHashMap<>();
    @GuardedBy("this")
    private int lQU = 0;

    public g(v<V> vVar) {
        this.lQS = vVar;
    }

    public synchronized int getCount() {
        return this.lQT.size();
    }

    public synchronized int getSizeInBytes() {
        return this.lQU;
    }

    @Nullable
    public synchronized K dnU() {
        return this.lQT.isEmpty() ? null : this.lQT.keySet().iterator().next();
    }

    public synchronized ArrayList<Map.Entry<K, V>> a(@Nullable com.facebook.common.internal.h<K> hVar) {
        ArrayList<Map.Entry<K, V>> arrayList;
        arrayList = new ArrayList<>(this.lQT.entrySet().size());
        for (Map.Entry<K, V> entry : this.lQT.entrySet()) {
            if (hVar == null || hVar.aT(entry.getKey())) {
                arrayList.add(entry);
            }
        }
        return arrayList;
    }

    public synchronized boolean contains(K k) {
        return this.lQT.containsKey(k);
    }

    @Nullable
    public synchronized V get(K k) {
        return this.lQT.get(k);
    }

    @Nullable
    public synchronized V put(K k, V v) {
        V remove;
        remove = this.lQT.remove(k);
        this.lQU -= bl(remove);
        this.lQT.put(k, v);
        this.lQU += bl(v);
        return remove;
    }

    @Nullable
    public synchronized V remove(K k) {
        V remove;
        remove = this.lQT.remove(k);
        this.lQU -= bl(remove);
        return remove;
    }

    public synchronized ArrayList<V> b(@Nullable com.facebook.common.internal.h<K> hVar) {
        ArrayList<V> arrayList;
        arrayList = new ArrayList<>();
        Iterator<Map.Entry<K, V>> it = this.lQT.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (hVar == null || hVar.aT(next.getKey())) {
                arrayList.add(next.getValue());
                this.lQU -= bl(next.getValue());
                it.remove();
            }
        }
        return arrayList;
    }

    private int bl(V v) {
        if (v == null) {
            return 0;
        }
        return this.lQS.bj(v);
    }
}
