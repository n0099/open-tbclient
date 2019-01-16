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
    private final ac<V> ipX;
    @GuardedBy("this")
    private final LinkedHashMap<K, V> ipY = new LinkedHashMap<>();
    @GuardedBy("this")
    private int ipZ = 0;

    public g(ac<V> acVar) {
        this.ipX = acVar;
    }

    public synchronized int getCount() {
        return this.ipY.size();
    }

    public synchronized int getSizeInBytes() {
        return this.ipZ;
    }

    @Nullable
    public synchronized K bXh() {
        return this.ipY.isEmpty() ? null : this.ipY.keySet().iterator().next();
    }

    public synchronized ArrayList<Map.Entry<K, V>> a(@Nullable Predicate<K> predicate) {
        ArrayList<Map.Entry<K, V>> arrayList;
        arrayList = new ArrayList<>(this.ipY.entrySet().size());
        for (Map.Entry<K, V> entry : this.ipY.entrySet()) {
            if (predicate == null || predicate.apply(entry.getKey())) {
                arrayList.add(entry);
            }
        }
        return arrayList;
    }

    @Nullable
    public synchronized V get(K k) {
        return this.ipY.get(k);
    }

    @Nullable
    public synchronized V put(K k, V v) {
        V remove;
        remove = this.ipY.remove(k);
        this.ipZ -= aF(remove);
        this.ipY.put(k, v);
        this.ipZ += aF(v);
        return remove;
    }

    @Nullable
    public synchronized V remove(K k) {
        V remove;
        remove = this.ipY.remove(k);
        this.ipZ -= aF(remove);
        return remove;
    }

    private int aF(V v) {
        if (v == null) {
            return 0;
        }
        return this.ipX.aD(v);
    }
}
