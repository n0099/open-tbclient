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
    private final v<V> lQQ;
    @GuardedBy("this")
    private final LinkedHashMap<K, V> lQR = new LinkedHashMap<>();
    @GuardedBy("this")
    private int lQS = 0;

    public g(v<V> vVar) {
        this.lQQ = vVar;
    }

    public synchronized int getCount() {
        return this.lQR.size();
    }

    public synchronized int getSizeInBytes() {
        return this.lQS;
    }

    @Nullable
    public synchronized K dnS() {
        return this.lQR.isEmpty() ? null : this.lQR.keySet().iterator().next();
    }

    public synchronized ArrayList<Map.Entry<K, V>> a(@Nullable com.facebook.common.internal.h<K> hVar) {
        ArrayList<Map.Entry<K, V>> arrayList;
        arrayList = new ArrayList<>(this.lQR.entrySet().size());
        for (Map.Entry<K, V> entry : this.lQR.entrySet()) {
            if (hVar == null || hVar.aT(entry.getKey())) {
                arrayList.add(entry);
            }
        }
        return arrayList;
    }

    public synchronized boolean contains(K k) {
        return this.lQR.containsKey(k);
    }

    @Nullable
    public synchronized V get(K k) {
        return this.lQR.get(k);
    }

    @Nullable
    public synchronized V put(K k, V v) {
        V remove;
        remove = this.lQR.remove(k);
        this.lQS -= bl(remove);
        this.lQR.put(k, v);
        this.lQS += bl(v);
        return remove;
    }

    @Nullable
    public synchronized V remove(K k) {
        V remove;
        remove = this.lQR.remove(k);
        this.lQS -= bl(remove);
        return remove;
    }

    public synchronized ArrayList<V> b(@Nullable com.facebook.common.internal.h<K> hVar) {
        ArrayList<V> arrayList;
        arrayList = new ArrayList<>();
        Iterator<Map.Entry<K, V>> it = this.lQR.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (hVar == null || hVar.aT(next.getKey())) {
                arrayList.add(next.getValue());
                this.lQS -= bl(next.getValue());
                it.remove();
            }
        }
        return arrayList;
    }

    private int bl(V v) {
        if (v == null) {
            return 0;
        }
        return this.lQQ.bj(v);
    }
}
