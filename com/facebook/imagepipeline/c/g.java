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
    private final ac<V> ipY;
    @GuardedBy("this")
    private final LinkedHashMap<K, V> ipZ = new LinkedHashMap<>();
    @GuardedBy("this")
    private int iqa = 0;

    public g(ac<V> acVar) {
        this.ipY = acVar;
    }

    public synchronized int getCount() {
        return this.ipZ.size();
    }

    public synchronized int getSizeInBytes() {
        return this.iqa;
    }

    @Nullable
    public synchronized K bXh() {
        return this.ipZ.isEmpty() ? null : this.ipZ.keySet().iterator().next();
    }

    public synchronized ArrayList<Map.Entry<K, V>> a(@Nullable Predicate<K> predicate) {
        ArrayList<Map.Entry<K, V>> arrayList;
        arrayList = new ArrayList<>(this.ipZ.entrySet().size());
        for (Map.Entry<K, V> entry : this.ipZ.entrySet()) {
            if (predicate == null || predicate.apply(entry.getKey())) {
                arrayList.add(entry);
            }
        }
        return arrayList;
    }

    @Nullable
    public synchronized V get(K k) {
        return this.ipZ.get(k);
    }

    @Nullable
    public synchronized V put(K k, V v) {
        V remove;
        remove = this.ipZ.remove(k);
        this.iqa -= aF(remove);
        this.ipZ.put(k, v);
        this.iqa += aF(v);
        return remove;
    }

    @Nullable
    public synchronized V remove(K k) {
        V remove;
        remove = this.ipZ.remove(k);
        this.iqa -= aF(remove);
        return remove;
    }

    private int aF(V v) {
        if (v == null) {
            return 0;
        }
        return this.ipY.aD(v);
    }
}
