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
    private final v<V> oTU;
    @GuardedBy("this")
    private final LinkedHashMap<K, V> oTV = new LinkedHashMap<>();
    @GuardedBy("this")
    private int oTW = 0;

    public g(v<V> vVar) {
        this.oTU = vVar;
    }

    public synchronized int getCount() {
        return this.oTV.size();
    }

    public synchronized int getSizeInBytes() {
        return this.oTW;
    }

    @Nullable
    public synchronized K enr() {
        return this.oTV.isEmpty() ? null : this.oTV.keySet().iterator().next();
    }

    public synchronized ArrayList<Map.Entry<K, V>> a(@Nullable com.facebook.common.internal.h<K> hVar) {
        ArrayList<Map.Entry<K, V>> arrayList;
        arrayList = new ArrayList<>(this.oTV.entrySet().size());
        for (Map.Entry<K, V> entry : this.oTV.entrySet()) {
            if (hVar == null || hVar.ba(entry.getKey())) {
                arrayList.add(entry);
            }
        }
        return arrayList;
    }

    public synchronized boolean contains(K k) {
        return this.oTV.containsKey(k);
    }

    @Nullable
    public synchronized V get(K k) {
        return this.oTV.get(k);
    }

    @Nullable
    public synchronized V put(K k, V v) {
        V remove;
        remove = this.oTV.remove(k);
        this.oTW -= bs(remove);
        this.oTV.put(k, v);
        this.oTW += bs(v);
        return remove;
    }

    @Nullable
    public synchronized V remove(K k) {
        V remove;
        remove = this.oTV.remove(k);
        this.oTW -= bs(remove);
        return remove;
    }

    private int bs(V v) {
        if (v == null) {
            return 0;
        }
        return this.oTU.bq(v);
    }
}
