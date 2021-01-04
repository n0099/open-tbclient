package com.facebook.imagepipeline.b;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes6.dex */
public class g<K, V> {
    private final v<V> pzT;
    @GuardedBy("this")
    private final LinkedHashMap<K, V> pzU = new LinkedHashMap<>();
    @GuardedBy("this")
    private int pzV = 0;

    public g(v<V> vVar) {
        this.pzT = vVar;
    }

    public synchronized int getCount() {
        return this.pzU.size();
    }

    public synchronized int getSizeInBytes() {
        return this.pzV;
    }

    @Nullable
    public synchronized K ewH() {
        return this.pzU.isEmpty() ? null : this.pzU.keySet().iterator().next();
    }

    public synchronized ArrayList<Map.Entry<K, V>> a(@Nullable com.facebook.common.internal.h<K> hVar) {
        ArrayList<Map.Entry<K, V>> arrayList;
        arrayList = new ArrayList<>(this.pzU.entrySet().size());
        for (Map.Entry<K, V> entry : this.pzU.entrySet()) {
            if (hVar == null || hVar.apply(entry.getKey())) {
                arrayList.add(entry);
            }
        }
        return arrayList;
    }

    @Nullable
    public synchronized V get(K k) {
        return this.pzU.get(k);
    }

    @Nullable
    public synchronized V put(K k, V v) {
        V remove;
        remove = this.pzU.remove(k);
        this.pzV -= bs(remove);
        this.pzU.put(k, v);
        this.pzV += bs(v);
        return remove;
    }

    @Nullable
    public synchronized V remove(K k) {
        V remove;
        remove = this.pzU.remove(k);
        this.pzV -= bs(remove);
        return remove;
    }

    private int bs(V v) {
        if (v == null) {
            return 0;
        }
        return this.pzT.bq(v);
    }
}
