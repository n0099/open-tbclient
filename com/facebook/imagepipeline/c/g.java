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
    private final ac<V> jFE;
    @GuardedBy("this")
    private final LinkedHashMap<K, V> jFF = new LinkedHashMap<>();
    @GuardedBy("this")
    private int jFG = 0;

    public g(ac<V> acVar) {
        this.jFE = acVar;
    }

    public synchronized int getCount() {
        return this.jFF.size();
    }

    public synchronized int getSizeInBytes() {
        return this.jFG;
    }

    @Nullable
    public synchronized K cwi() {
        return this.jFF.isEmpty() ? null : this.jFF.keySet().iterator().next();
    }

    public synchronized ArrayList<Map.Entry<K, V>> a(@Nullable Predicate<K> predicate) {
        ArrayList<Map.Entry<K, V>> arrayList;
        arrayList = new ArrayList<>(this.jFF.entrySet().size());
        for (Map.Entry<K, V> entry : this.jFF.entrySet()) {
            if (predicate == null || predicate.apply(entry.getKey())) {
                arrayList.add(entry);
            }
        }
        return arrayList;
    }

    @Nullable
    public synchronized V get(K k) {
        return this.jFF.get(k);
    }

    @Nullable
    public synchronized V put(K k, V v) {
        V remove;
        remove = this.jFF.remove(k);
        this.jFG -= aU(remove);
        this.jFF.put(k, v);
        this.jFG += aU(v);
        return remove;
    }

    @Nullable
    public synchronized V remove(K k) {
        V remove;
        remove = this.jFF.remove(k);
        this.jFG -= aU(remove);
        return remove;
    }

    private int aU(V v) {
        if (v == null) {
            return 0;
        }
        return this.jFE.aS(v);
    }
}
