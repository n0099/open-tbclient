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
    private final v<V> pkp;
    @GuardedBy("this")
    private final LinkedHashMap<K, V> pkq = new LinkedHashMap<>();
    @GuardedBy("this")
    private int pkr = 0;

    public g(v<V> vVar) {
        this.pkp = vVar;
    }

    public synchronized int getCount() {
        return this.pkq.size();
    }

    public synchronized int getSizeInBytes() {
        return this.pkr;
    }

    @Nullable
    public synchronized K esY() {
        return this.pkq.isEmpty() ? null : this.pkq.keySet().iterator().next();
    }

    public synchronized ArrayList<Map.Entry<K, V>> a(@Nullable com.facebook.common.internal.h<K> hVar) {
        ArrayList<Map.Entry<K, V>> arrayList;
        arrayList = new ArrayList<>(this.pkq.entrySet().size());
        for (Map.Entry<K, V> entry : this.pkq.entrySet()) {
            if (hVar == null || hVar.bb(entry.getKey())) {
                arrayList.add(entry);
            }
        }
        return arrayList;
    }

    public synchronized boolean contains(K k) {
        return this.pkq.containsKey(k);
    }

    @Nullable
    public synchronized V get(K k) {
        return this.pkq.get(k);
    }

    @Nullable
    public synchronized V put(K k, V v) {
        V remove;
        remove = this.pkq.remove(k);
        this.pkr -= bs(remove);
        this.pkq.put(k, v);
        this.pkr += bs(v);
        return remove;
    }

    @Nullable
    public synchronized V remove(K k) {
        V remove;
        remove = this.pkq.remove(k);
        this.pkr -= bs(remove);
        return remove;
    }

    private int bs(V v) {
        if (v == null) {
            return 0;
        }
        return this.pkp.bq(v);
    }
}
