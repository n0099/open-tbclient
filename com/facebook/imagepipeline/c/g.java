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
    private final v<V> nTj;
    @GuardedBy("this")
    private final LinkedHashMap<K, V> nTk = new LinkedHashMap<>();
    @GuardedBy("this")
    private int nTl = 0;

    public g(v<V> vVar) {
        this.nTj = vVar;
    }

    public synchronized int getCount() {
        return this.nTk.size();
    }

    public synchronized int getSizeInBytes() {
        return this.nTl;
    }

    @Nullable
    public synchronized K dZD() {
        return this.nTk.isEmpty() ? null : this.nTk.keySet().iterator().next();
    }

    public synchronized ArrayList<Map.Entry<K, V>> a(@Nullable com.facebook.common.internal.h<K> hVar) {
        ArrayList<Map.Entry<K, V>> arrayList;
        arrayList = new ArrayList<>(this.nTk.entrySet().size());
        for (Map.Entry<K, V> entry : this.nTk.entrySet()) {
            if (hVar == null || hVar.aW(entry.getKey())) {
                arrayList.add(entry);
            }
        }
        return arrayList;
    }

    public synchronized boolean contains(K k) {
        return this.nTk.containsKey(k);
    }

    @Nullable
    public synchronized V get(K k) {
        return this.nTk.get(k);
    }

    @Nullable
    public synchronized V put(K k, V v) {
        V remove;
        remove = this.nTk.remove(k);
        this.nTl -= bo(remove);
        this.nTk.put(k, v);
        this.nTl += bo(v);
        return remove;
    }

    @Nullable
    public synchronized V remove(K k) {
        V remove;
        remove = this.nTk.remove(k);
        this.nTl -= bo(remove);
        return remove;
    }

    private int bo(V v) {
        if (v == null) {
            return 0;
        }
        return this.nTj.bm(v);
    }
}
