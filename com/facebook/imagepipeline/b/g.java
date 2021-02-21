package com.facebook.imagepipeline.b;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes5.dex */
public class g<K, V> {
    private final v<V> pHI;
    @GuardedBy("this")
    private final LinkedHashMap<K, V> pHJ = new LinkedHashMap<>();
    @GuardedBy("this")
    private int pHK = 0;

    public g(v<V> vVar) {
        this.pHI = vVar;
    }

    public synchronized int getCount() {
        return this.pHJ.size();
    }

    public synchronized int getSizeInBytes() {
        return this.pHK;
    }

    @Nullable
    public synchronized K evR() {
        return this.pHJ.isEmpty() ? null : this.pHJ.keySet().iterator().next();
    }

    public synchronized ArrayList<Map.Entry<K, V>> a(@Nullable com.facebook.common.internal.h<K> hVar) {
        ArrayList<Map.Entry<K, V>> arrayList;
        arrayList = new ArrayList<>(this.pHJ.entrySet().size());
        for (Map.Entry<K, V> entry : this.pHJ.entrySet()) {
            if (hVar == null || hVar.apply(entry.getKey())) {
                arrayList.add(entry);
            }
        }
        return arrayList;
    }

    public synchronized boolean contains(K k) {
        return this.pHJ.containsKey(k);
    }

    @Nullable
    public synchronized V get(K k) {
        return this.pHJ.get(k);
    }

    @Nullable
    public synchronized V put(K k, V v) {
        V remove;
        remove = this.pHJ.remove(k);
        this.pHK -= bs(remove);
        this.pHJ.put(k, v);
        this.pHK += bs(v);
        return remove;
    }

    @Nullable
    public synchronized V remove(K k) {
        V remove;
        remove = this.pHJ.remove(k);
        this.pHK -= bs(remove);
        return remove;
    }

    public synchronized ArrayList<V> b(@Nullable com.facebook.common.internal.h<K> hVar) {
        ArrayList<V> arrayList;
        arrayList = new ArrayList<>();
        Iterator<Map.Entry<K, V>> it = this.pHJ.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (hVar == null || hVar.apply(next.getKey())) {
                arrayList.add(next.getValue());
                this.pHK -= bs(next.getValue());
                it.remove();
            }
        }
        return arrayList;
    }

    private int bs(V v) {
        if (v == null) {
            return 0;
        }
        return this.pHI.bq(v);
    }
}
