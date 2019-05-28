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
    private final ac<V> jXY;
    @GuardedBy("this")
    private final LinkedHashMap<K, V> jXZ = new LinkedHashMap<>();
    @GuardedBy("this")
    private int jYa = 0;

    public g(ac<V> acVar) {
        this.jXY = acVar;
    }

    public synchronized int getCount() {
        return this.jXZ.size();
    }

    public synchronized int getSizeInBytes() {
        return this.jYa;
    }

    @Nullable
    public synchronized K cEm() {
        return this.jXZ.isEmpty() ? null : this.jXZ.keySet().iterator().next();
    }

    public synchronized ArrayList<Map.Entry<K, V>> a(@Nullable Predicate<K> predicate) {
        ArrayList<Map.Entry<K, V>> arrayList;
        arrayList = new ArrayList<>(this.jXZ.entrySet().size());
        for (Map.Entry<K, V> entry : this.jXZ.entrySet()) {
            if (predicate == null || predicate.apply(entry.getKey())) {
                arrayList.add(entry);
            }
        }
        return arrayList;
    }

    @Nullable
    public synchronized V get(K k) {
        return this.jXZ.get(k);
    }

    @Nullable
    public synchronized V put(K k, V v) {
        V remove;
        remove = this.jXZ.remove(k);
        this.jYa -= aT(remove);
        this.jXZ.put(k, v);
        this.jYa += aT(v);
        return remove;
    }

    @Nullable
    public synchronized V remove(K k) {
        V remove;
        remove = this.jXZ.remove(k);
        this.jYa -= aT(remove);
        return remove;
    }

    private int aT(V v) {
        if (v == null) {
            return 0;
        }
        return this.jXY.aR(v);
    }
}
