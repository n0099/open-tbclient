package com.facebook.imagepipeline.b;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes5.dex */
public class g<K, V> {
    private final v<V> pwZ;
    @GuardedBy("this")
    private final LinkedHashMap<K, V> pxa = new LinkedHashMap<>();
    @GuardedBy("this")
    private int pxb = 0;

    public g(v<V> vVar) {
        this.pwZ = vVar;
    }

    public synchronized int getCount() {
        return this.pxa.size();
    }

    public synchronized int getSizeInBytes() {
        return this.pxb;
    }

    @Nullable
    public synchronized K etr() {
        return this.pxa.isEmpty() ? null : this.pxa.keySet().iterator().next();
    }

    public synchronized ArrayList<Map.Entry<K, V>> a(@Nullable com.facebook.common.internal.h<K> hVar) {
        ArrayList<Map.Entry<K, V>> arrayList;
        arrayList = new ArrayList<>(this.pxa.entrySet().size());
        for (Map.Entry<K, V> entry : this.pxa.entrySet()) {
            if (hVar == null || hVar.apply(entry.getKey())) {
                arrayList.add(entry);
            }
        }
        return arrayList;
    }

    public synchronized boolean contains(K k) {
        return this.pxa.containsKey(k);
    }

    @Nullable
    public synchronized V get(K k) {
        return this.pxa.get(k);
    }

    @Nullable
    public synchronized V put(K k, V v) {
        V remove;
        remove = this.pxa.remove(k);
        this.pxb -= bs(remove);
        this.pxa.put(k, v);
        this.pxb += bs(v);
        return remove;
    }

    @Nullable
    public synchronized V remove(K k) {
        V remove;
        remove = this.pxa.remove(k);
        this.pxb -= bs(remove);
        return remove;
    }

    private int bs(V v) {
        if (v == null) {
            return 0;
        }
        return this.pwZ.bq(v);
    }
}
