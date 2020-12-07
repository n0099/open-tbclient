package com.facebook.imagepipeline.b;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes7.dex */
public class g<K, V> {
    private final v<V> pkn;
    @GuardedBy("this")
    private final LinkedHashMap<K, V> pko = new LinkedHashMap<>();
    @GuardedBy("this")
    private int pkp = 0;

    public g(v<V> vVar) {
        this.pkn = vVar;
    }

    public synchronized int getCount() {
        return this.pko.size();
    }

    public synchronized int getSizeInBytes() {
        return this.pkp;
    }

    @Nullable
    public synchronized K esX() {
        return this.pko.isEmpty() ? null : this.pko.keySet().iterator().next();
    }

    public synchronized ArrayList<Map.Entry<K, V>> a(@Nullable com.facebook.common.internal.h<K> hVar) {
        ArrayList<Map.Entry<K, V>> arrayList;
        arrayList = new ArrayList<>(this.pko.entrySet().size());
        for (Map.Entry<K, V> entry : this.pko.entrySet()) {
            if (hVar == null || hVar.bb(entry.getKey())) {
                arrayList.add(entry);
            }
        }
        return arrayList;
    }

    public synchronized boolean contains(K k) {
        return this.pko.containsKey(k);
    }

    @Nullable
    public synchronized V get(K k) {
        return this.pko.get(k);
    }

    @Nullable
    public synchronized V put(K k, V v) {
        V remove;
        remove = this.pko.remove(k);
        this.pkp -= bs(remove);
        this.pko.put(k, v);
        this.pkp += bs(v);
        return remove;
    }

    @Nullable
    public synchronized V remove(K k) {
        V remove;
        remove = this.pko.remove(k);
        this.pkp -= bs(remove);
        return remove;
    }

    private int bs(V v) {
        if (v == null) {
            return 0;
        }
        return this.pkn.bq(v);
    }
}
