package com.facebook.imagepipeline.b;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes5.dex */
public class g<K, V> {
    private final v<V> pHi;
    @GuardedBy("this")
    private final LinkedHashMap<K, V> pHj = new LinkedHashMap<>();
    @GuardedBy("this")
    private int pHk = 0;

    public g(v<V> vVar) {
        this.pHi = vVar;
    }

    public synchronized int getCount() {
        return this.pHj.size();
    }

    public synchronized int getSizeInBytes() {
        return this.pHk;
    }

    @Nullable
    public synchronized K evJ() {
        return this.pHj.isEmpty() ? null : this.pHj.keySet().iterator().next();
    }

    public synchronized ArrayList<Map.Entry<K, V>> a(@Nullable com.facebook.common.internal.h<K> hVar) {
        ArrayList<Map.Entry<K, V>> arrayList;
        arrayList = new ArrayList<>(this.pHj.entrySet().size());
        for (Map.Entry<K, V> entry : this.pHj.entrySet()) {
            if (hVar == null || hVar.apply(entry.getKey())) {
                arrayList.add(entry);
            }
        }
        return arrayList;
    }

    public synchronized boolean contains(K k) {
        return this.pHj.containsKey(k);
    }

    @Nullable
    public synchronized V get(K k) {
        return this.pHj.get(k);
    }

    @Nullable
    public synchronized V put(K k, V v) {
        V remove;
        remove = this.pHj.remove(k);
        this.pHk -= bs(remove);
        this.pHj.put(k, v);
        this.pHk += bs(v);
        return remove;
    }

    @Nullable
    public synchronized V remove(K k) {
        V remove;
        remove = this.pHj.remove(k);
        this.pHk -= bs(remove);
        return remove;
    }

    public synchronized ArrayList<V> b(@Nullable com.facebook.common.internal.h<K> hVar) {
        ArrayList<V> arrayList;
        arrayList = new ArrayList<>();
        Iterator<Map.Entry<K, V>> it = this.pHj.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (hVar == null || hVar.apply(next.getKey())) {
                arrayList.add(next.getValue());
                this.pHk -= bs(next.getValue());
                it.remove();
            }
        }
        return arrayList;
    }

    private int bs(V v) {
        if (v == null) {
            return 0;
        }
        return this.pHi.bq(v);
    }
}
