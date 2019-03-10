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
    private final ac<V> jFX;
    @GuardedBy("this")
    private final LinkedHashMap<K, V> jFY = new LinkedHashMap<>();
    @GuardedBy("this")
    private int jFZ = 0;

    public g(ac<V> acVar) {
        this.jFX = acVar;
    }

    public synchronized int getCount() {
        return this.jFY.size();
    }

    public synchronized int getSizeInBytes() {
        return this.jFZ;
    }

    @Nullable
    public synchronized K cws() {
        return this.jFY.isEmpty() ? null : this.jFY.keySet().iterator().next();
    }

    public synchronized ArrayList<Map.Entry<K, V>> a(@Nullable Predicate<K> predicate) {
        ArrayList<Map.Entry<K, V>> arrayList;
        arrayList = new ArrayList<>(this.jFY.entrySet().size());
        for (Map.Entry<K, V> entry : this.jFY.entrySet()) {
            if (predicate == null || predicate.apply(entry.getKey())) {
                arrayList.add(entry);
            }
        }
        return arrayList;
    }

    @Nullable
    public synchronized V get(K k) {
        return this.jFY.get(k);
    }

    @Nullable
    public synchronized V put(K k, V v) {
        V remove;
        remove = this.jFY.remove(k);
        this.jFZ -= aV(remove);
        this.jFY.put(k, v);
        this.jFZ += aV(v);
        return remove;
    }

    @Nullable
    public synchronized V remove(K k) {
        V remove;
        remove = this.jFY.remove(k);
        this.jFZ -= aV(remove);
        return remove;
    }

    private int aV(V v) {
        if (v == null) {
            return 0;
        }
        return this.jFX.aT(v);
    }
}
