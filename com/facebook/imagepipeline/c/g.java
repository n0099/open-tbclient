package com.facebook.imagepipeline.c;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes13.dex */
public class g<K, V> {
    private final v<V> muq;
    @GuardedBy("this")
    private final LinkedHashMap<K, V> mur = new LinkedHashMap<>();
    @GuardedBy("this")
    private int mus = 0;

    public g(v<V> vVar) {
        this.muq = vVar;
    }

    public synchronized int getCount() {
        return this.mur.size();
    }

    public synchronized int getSizeInBytes() {
        return this.mus;
    }

    @Nullable
    public synchronized K dxF() {
        return this.mur.isEmpty() ? null : this.mur.keySet().iterator().next();
    }

    public synchronized ArrayList<Map.Entry<K, V>> a(@Nullable com.facebook.common.internal.h<K> hVar) {
        ArrayList<Map.Entry<K, V>> arrayList;
        arrayList = new ArrayList<>(this.mur.entrySet().size());
        for (Map.Entry<K, V> entry : this.mur.entrySet()) {
            if (hVar == null || hVar.aO(entry.getKey())) {
                arrayList.add(entry);
            }
        }
        return arrayList;
    }

    public synchronized boolean contains(K k) {
        return this.mur.containsKey(k);
    }

    @Nullable
    public synchronized V get(K k) {
        return this.mur.get(k);
    }

    @Nullable
    public synchronized V put(K k, V v) {
        V remove;
        remove = this.mur.remove(k);
        this.mus -= bg(remove);
        this.mur.put(k, v);
        this.mus += bg(v);
        return remove;
    }

    @Nullable
    public synchronized V remove(K k) {
        V remove;
        remove = this.mur.remove(k);
        this.mus -= bg(remove);
        return remove;
    }

    private int bg(V v) {
        if (v == null) {
            return 0;
        }
        return this.muq.be(v);
    }
}
