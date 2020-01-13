package com.facebook.imagepipeline.c;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes12.dex */
public class g<K, V> {
    private final v<V> lQe;
    @GuardedBy("this")
    private final LinkedHashMap<K, V> lQf = new LinkedHashMap<>();
    @GuardedBy("this")
    private int lQg = 0;

    public g(v<V> vVar) {
        this.lQe = vVar;
    }

    public synchronized int getCount() {
        return this.lQf.size();
    }

    public synchronized int getSizeInBytes() {
        return this.lQg;
    }

    @Nullable
    public synchronized K dmD() {
        return this.lQf.isEmpty() ? null : this.lQf.keySet().iterator().next();
    }

    public synchronized ArrayList<Map.Entry<K, V>> a(@Nullable com.facebook.common.internal.h<K> hVar) {
        ArrayList<Map.Entry<K, V>> arrayList;
        arrayList = new ArrayList<>(this.lQf.entrySet().size());
        for (Map.Entry<K, V> entry : this.lQf.entrySet()) {
            if (hVar == null || hVar.aR(entry.getKey())) {
                arrayList.add(entry);
            }
        }
        return arrayList;
    }

    public synchronized boolean contains(K k) {
        return this.lQf.containsKey(k);
    }

    @Nullable
    public synchronized V get(K k) {
        return this.lQf.get(k);
    }

    @Nullable
    public synchronized V put(K k, V v) {
        V remove;
        remove = this.lQf.remove(k);
        this.lQg -= bj(remove);
        this.lQf.put(k, v);
        this.lQg += bj(v);
        return remove;
    }

    @Nullable
    public synchronized V remove(K k) {
        V remove;
        remove = this.lQf.remove(k);
        this.lQg -= bj(remove);
        return remove;
    }

    public synchronized ArrayList<V> b(@Nullable com.facebook.common.internal.h<K> hVar) {
        ArrayList<V> arrayList;
        arrayList = new ArrayList<>();
        Iterator<Map.Entry<K, V>> it = this.lQf.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (hVar == null || hVar.aR(next.getKey())) {
                arrayList.add(next.getValue());
                this.lQg -= bj(next.getValue());
                it.remove();
            }
        }
        return arrayList;
    }

    private int bj(V v) {
        if (v == null) {
            return 0;
        }
        return this.lQe.bh(v);
    }
}
