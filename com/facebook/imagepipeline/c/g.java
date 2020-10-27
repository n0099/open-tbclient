package com.facebook.imagepipeline.c;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes12.dex */
public class g<K, V> {
    private final v<V> oKB;
    @GuardedBy("this")
    private final LinkedHashMap<K, V> oKC = new LinkedHashMap<>();
    @GuardedBy("this")
    private int oKD = 0;

    public g(v<V> vVar) {
        this.oKB = vVar;
    }

    public synchronized int getCount() {
        return this.oKC.size();
    }

    public synchronized int getSizeInBytes() {
        return this.oKD;
    }

    @Nullable
    public synchronized K ejB() {
        return this.oKC.isEmpty() ? null : this.oKC.keySet().iterator().next();
    }

    public synchronized ArrayList<Map.Entry<K, V>> a(@Nullable com.facebook.common.internal.h<K> hVar) {
        ArrayList<Map.Entry<K, V>> arrayList;
        arrayList = new ArrayList<>(this.oKC.entrySet().size());
        for (Map.Entry<K, V> entry : this.oKC.entrySet()) {
            if (hVar == null || hVar.ba(entry.getKey())) {
                arrayList.add(entry);
            }
        }
        return arrayList;
    }

    public synchronized boolean contains(K k) {
        return this.oKC.containsKey(k);
    }

    @Nullable
    public synchronized V get(K k) {
        return this.oKC.get(k);
    }

    @Nullable
    public synchronized V put(K k, V v) {
        V remove;
        remove = this.oKC.remove(k);
        this.oKD -= bs(remove);
        this.oKC.put(k, v);
        this.oKD += bs(v);
        return remove;
    }

    @Nullable
    public synchronized V remove(K k) {
        V remove;
        remove = this.oKC.remove(k);
        this.oKD -= bs(remove);
        return remove;
    }

    private int bs(V v) {
        if (v == null) {
            return 0;
        }
        return this.oKB.bq(v);
    }
}
