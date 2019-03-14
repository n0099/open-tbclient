package com.facebook.imagepipeline.c;

import com.android.internal.util.Predicate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;
@ThreadSafe
/* loaded from: classes2.dex */
public class g<K, V> {
    private final ac<V> jFP;
    @GuardedBy("this")
    private final LinkedHashMap<K, V> jFQ = new LinkedHashMap<>();
    @GuardedBy("this")
    private int jFR = 0;

    public g(ac<V> acVar) {
        this.jFP = acVar;
    }

    public synchronized int getCount() {
        return this.jFQ.size();
    }

    public synchronized int getSizeInBytes() {
        return this.jFR;
    }

    @Nullable
    public synchronized K cwv() {
        return this.jFQ.isEmpty() ? null : this.jFQ.keySet().iterator().next();
    }

    public synchronized ArrayList<Map.Entry<K, V>> a(@Nullable Predicate<K> predicate) {
        ArrayList<Map.Entry<K, V>> arrayList;
        arrayList = new ArrayList<>(this.jFQ.entrySet().size());
        for (Map.Entry<K, V> entry : this.jFQ.entrySet()) {
            if (predicate == null || predicate.apply(entry.getKey())) {
                arrayList.add(entry);
            }
        }
        return arrayList;
    }

    @Nullable
    public synchronized V get(K k) {
        return this.jFQ.get(k);
    }

    @Nullable
    public synchronized V put(K k, V v) {
        V remove;
        remove = this.jFQ.remove(k);
        this.jFR -= aV(remove);
        this.jFQ.put(k, v);
        this.jFR += aV(v);
        return remove;
    }

    @Nullable
    public synchronized V remove(K k) {
        V remove;
        remove = this.jFQ.remove(k);
        this.jFR -= aV(remove);
        return remove;
    }

    private int aV(V v) {
        if (v == null) {
            return 0;
        }
        return this.jFP.aT(v);
    }
}
