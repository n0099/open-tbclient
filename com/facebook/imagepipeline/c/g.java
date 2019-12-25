package com.facebook.imagepipeline.c;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes11.dex */
public class g<K, V> {
    private final v<V> lMs;
    @GuardedBy("this")
    private final LinkedHashMap<K, V> lMt = new LinkedHashMap<>();
    @GuardedBy("this")
    private int lMu = 0;

    public g(v<V> vVar) {
        this.lMs = vVar;
    }

    public synchronized int getCount() {
        return this.lMt.size();
    }

    public synchronized int getSizeInBytes() {
        return this.lMu;
    }

    @Nullable
    public synchronized K dly() {
        return this.lMt.isEmpty() ? null : this.lMt.keySet().iterator().next();
    }

    public synchronized ArrayList<Map.Entry<K, V>> a(@Nullable com.facebook.common.internal.h<K> hVar) {
        ArrayList<Map.Entry<K, V>> arrayList;
        arrayList = new ArrayList<>(this.lMt.entrySet().size());
        for (Map.Entry<K, V> entry : this.lMt.entrySet()) {
            if (hVar == null || hVar.aR(entry.getKey())) {
                arrayList.add(entry);
            }
        }
        return arrayList;
    }

    public synchronized boolean contains(K k) {
        return this.lMt.containsKey(k);
    }

    @Nullable
    public synchronized V get(K k) {
        return this.lMt.get(k);
    }

    @Nullable
    public synchronized V put(K k, V v) {
        V remove;
        remove = this.lMt.remove(k);
        this.lMu -= bi(remove);
        this.lMt.put(k, v);
        this.lMu += bi(v);
        return remove;
    }

    @Nullable
    public synchronized V remove(K k) {
        V remove;
        remove = this.lMt.remove(k);
        this.lMu -= bi(remove);
        return remove;
    }

    public synchronized ArrayList<V> b(@Nullable com.facebook.common.internal.h<K> hVar) {
        ArrayList<V> arrayList;
        arrayList = new ArrayList<>();
        Iterator<Map.Entry<K, V>> it = this.lMt.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (hVar == null || hVar.aR(next.getKey())) {
                arrayList.add(next.getValue());
                this.lMu -= bi(next.getValue());
                it.remove();
            }
        }
        return arrayList;
    }

    private int bi(V v) {
        if (v == null) {
            return 0;
        }
        return this.lMs.bg(v);
    }
}
