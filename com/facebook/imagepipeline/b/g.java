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
    private final v<V> pJN;
    @GuardedBy("this")
    private final LinkedHashMap<K, V> pJO = new LinkedHashMap<>();
    @GuardedBy("this")
    private int pJP = 0;

    public g(v<V> vVar) {
        this.pJN = vVar;
    }

    public synchronized int getCount() {
        return this.pJO.size();
    }

    public synchronized int getSizeInBytes() {
        return this.pJP;
    }

    @Nullable
    public synchronized K ewa() {
        return this.pJO.isEmpty() ? null : this.pJO.keySet().iterator().next();
    }

    public synchronized ArrayList<Map.Entry<K, V>> a(@Nullable com.facebook.common.internal.h<K> hVar) {
        ArrayList<Map.Entry<K, V>> arrayList;
        arrayList = new ArrayList<>(this.pJO.entrySet().size());
        for (Map.Entry<K, V> entry : this.pJO.entrySet()) {
            if (hVar == null || hVar.apply(entry.getKey())) {
                arrayList.add(entry);
            }
        }
        return arrayList;
    }

    public synchronized boolean contains(K k) {
        return this.pJO.containsKey(k);
    }

    @Nullable
    public synchronized V get(K k) {
        return this.pJO.get(k);
    }

    @Nullable
    public synchronized V put(K k, V v) {
        V remove;
        remove = this.pJO.remove(k);
        this.pJP -= bu(remove);
        this.pJO.put(k, v);
        this.pJP += bu(v);
        return remove;
    }

    @Nullable
    public synchronized V remove(K k) {
        V remove;
        remove = this.pJO.remove(k);
        this.pJP -= bu(remove);
        return remove;
    }

    public synchronized ArrayList<V> b(@Nullable com.facebook.common.internal.h<K> hVar) {
        ArrayList<V> arrayList;
        arrayList = new ArrayList<>();
        Iterator<Map.Entry<K, V>> it = this.pJO.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (hVar == null || hVar.apply(next.getKey())) {
                arrayList.add(next.getValue());
                this.pJP -= bu(next.getValue());
                it.remove();
            }
        }
        return arrayList;
    }

    private int bu(V v) {
        if (v == null) {
            return 0;
        }
        return this.pJN.bs(v);
    }
}
