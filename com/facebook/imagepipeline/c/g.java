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
    private final ac<V> ilE;
    @GuardedBy("this")
    private final LinkedHashMap<K, V> ilF = new LinkedHashMap<>();
    @GuardedBy("this")
    private int ilG = 0;

    public g(ac<V> acVar) {
        this.ilE = acVar;
    }

    public synchronized int getCount() {
        return this.ilF.size();
    }

    public synchronized int getSizeInBytes() {
        return this.ilG;
    }

    @Nullable
    public synchronized K bVI() {
        return this.ilF.isEmpty() ? null : this.ilF.keySet().iterator().next();
    }

    public synchronized ArrayList<Map.Entry<K, V>> a(@Nullable Predicate<K> predicate) {
        ArrayList<Map.Entry<K, V>> arrayList;
        arrayList = new ArrayList<>(this.ilF.entrySet().size());
        for (Map.Entry<K, V> entry : this.ilF.entrySet()) {
            if (predicate == null || predicate.apply(entry.getKey())) {
                arrayList.add(entry);
            }
        }
        return arrayList;
    }

    @Nullable
    public synchronized V get(K k) {
        return this.ilF.get(k);
    }

    @Nullable
    public synchronized V put(K k, V v) {
        V remove;
        remove = this.ilF.remove(k);
        this.ilG -= aF(remove);
        this.ilF.put(k, v);
        this.ilG += aF(v);
        return remove;
    }

    @Nullable
    public synchronized V remove(K k) {
        V remove;
        remove = this.ilF.remove(k);
        this.ilG -= aF(remove);
        return remove;
    }

    private int aF(V v) {
        if (v == null) {
            return 0;
        }
        return this.ilE.aD(v);
    }
}
