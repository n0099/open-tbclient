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
    private final v<V> pxa;
    @GuardedBy("this")
    private final LinkedHashMap<K, V> pxb = new LinkedHashMap<>();
    @GuardedBy("this")
    private int pxc = 0;

    public g(v<V> vVar) {
        this.pxa = vVar;
    }

    public synchronized int getCount() {
        return this.pxb.size();
    }

    public synchronized int getSizeInBytes() {
        return this.pxc;
    }

    @Nullable
    public synchronized K etr() {
        return this.pxb.isEmpty() ? null : this.pxb.keySet().iterator().next();
    }

    public synchronized ArrayList<Map.Entry<K, V>> a(@Nullable com.facebook.common.internal.h<K> hVar) {
        ArrayList<Map.Entry<K, V>> arrayList;
        arrayList = new ArrayList<>(this.pxb.entrySet().size());
        for (Map.Entry<K, V> entry : this.pxb.entrySet()) {
            if (hVar == null || hVar.apply(entry.getKey())) {
                arrayList.add(entry);
            }
        }
        return arrayList;
    }

    public synchronized boolean contains(K k) {
        return this.pxb.containsKey(k);
    }

    @Nullable
    public synchronized V get(K k) {
        return this.pxb.get(k);
    }

    @Nullable
    public synchronized V put(K k, V v) {
        V remove;
        remove = this.pxb.remove(k);
        this.pxc -= bs(remove);
        this.pxb.put(k, v);
        this.pxc += bs(v);
        return remove;
    }

    @Nullable
    public synchronized V remove(K k) {
        V remove;
        remove = this.pxb.remove(k);
        this.pxc -= bs(remove);
        return remove;
    }

    private int bs(V v) {
        if (v == null) {
            return 0;
        }
        return this.pxa.bq(v);
    }
}
