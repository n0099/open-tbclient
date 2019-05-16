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
    private final ac<V> jXX;
    @GuardedBy("this")
    private final LinkedHashMap<K, V> jXY = new LinkedHashMap<>();
    @GuardedBy("this")
    private int jXZ = 0;

    public g(ac<V> acVar) {
        this.jXX = acVar;
    }

    public synchronized int getCount() {
        return this.jXY.size();
    }

    public synchronized int getSizeInBytes() {
        return this.jXZ;
    }

    @Nullable
    public synchronized K cEk() {
        return this.jXY.isEmpty() ? null : this.jXY.keySet().iterator().next();
    }

    public synchronized ArrayList<Map.Entry<K, V>> a(@Nullable Predicate<K> predicate) {
        ArrayList<Map.Entry<K, V>> arrayList;
        arrayList = new ArrayList<>(this.jXY.entrySet().size());
        for (Map.Entry<K, V> entry : this.jXY.entrySet()) {
            if (predicate == null || predicate.apply(entry.getKey())) {
                arrayList.add(entry);
            }
        }
        return arrayList;
    }

    @Nullable
    public synchronized V get(K k) {
        return this.jXY.get(k);
    }

    @Nullable
    public synchronized V put(K k, V v) {
        V remove;
        remove = this.jXY.remove(k);
        this.jXZ -= aT(remove);
        this.jXY.put(k, v);
        this.jXZ += aT(v);
        return remove;
    }

    @Nullable
    public synchronized V remove(K k) {
        V remove;
        remove = this.jXY.remove(k);
        this.jXZ -= aT(remove);
        return remove;
    }

    private int aT(V v) {
        if (v == null) {
            return 0;
        }
        return this.jXX.aR(v);
    }
}
