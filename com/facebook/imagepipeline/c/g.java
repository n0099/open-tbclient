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
    private final v<V> lSJ;
    @GuardedBy("this")
    private final LinkedHashMap<K, V> lSK = new LinkedHashMap<>();
    @GuardedBy("this")
    private int lSL = 0;

    public g(v<V> vVar) {
        this.lSJ = vVar;
    }

    public synchronized int getCount() {
        return this.lSK.size();
    }

    public synchronized int getSizeInBytes() {
        return this.lSL;
    }

    @Nullable
    public synchronized K dos() {
        return this.lSK.isEmpty() ? null : this.lSK.keySet().iterator().next();
    }

    public synchronized ArrayList<Map.Entry<K, V>> a(@Nullable com.facebook.common.internal.h<K> hVar) {
        ArrayList<Map.Entry<K, V>> arrayList;
        arrayList = new ArrayList<>(this.lSK.entrySet().size());
        for (Map.Entry<K, V> entry : this.lSK.entrySet()) {
            if (hVar == null || hVar.aT(entry.getKey())) {
                arrayList.add(entry);
            }
        }
        return arrayList;
    }

    public synchronized boolean contains(K k) {
        return this.lSK.containsKey(k);
    }

    @Nullable
    public synchronized V get(K k) {
        return this.lSK.get(k);
    }

    @Nullable
    public synchronized V put(K k, V v) {
        V remove;
        remove = this.lSK.remove(k);
        this.lSL -= bl(remove);
        this.lSK.put(k, v);
        this.lSL += bl(v);
        return remove;
    }

    @Nullable
    public synchronized V remove(K k) {
        V remove;
        remove = this.lSK.remove(k);
        this.lSL -= bl(remove);
        return remove;
    }

    public synchronized ArrayList<V> b(@Nullable com.facebook.common.internal.h<K> hVar) {
        ArrayList<V> arrayList;
        arrayList = new ArrayList<>();
        Iterator<Map.Entry<K, V>> it = this.lSK.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (hVar == null || hVar.aT(next.getKey())) {
                arrayList.add(next.getValue());
                this.lSL -= bl(next.getValue());
                it.remove();
            }
        }
        return arrayList;
    }

    private int bl(V v) {
        if (v == null) {
            return 0;
        }
        return this.lSJ.bj(v);
    }
}
