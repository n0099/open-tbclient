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
    private final ac<V> kgm;
    @GuardedBy("this")
    private final LinkedHashMap<K, V> kgn = new LinkedHashMap<>();
    @GuardedBy("this")
    private int kgo = 0;

    public g(ac<V> acVar) {
        this.kgm = acVar;
    }

    public synchronized int getCount() {
        return this.kgn.size();
    }

    public synchronized int getSizeInBytes() {
        return this.kgo;
    }

    @Nullable
    public synchronized K cHJ() {
        return this.kgn.isEmpty() ? null : this.kgn.keySet().iterator().next();
    }

    public synchronized ArrayList<Map.Entry<K, V>> a(@Nullable Predicate<K> predicate) {
        ArrayList<Map.Entry<K, V>> arrayList;
        arrayList = new ArrayList<>(this.kgn.entrySet().size());
        for (Map.Entry<K, V> entry : this.kgn.entrySet()) {
            if (predicate == null || predicate.apply(entry.getKey())) {
                arrayList.add(entry);
            }
        }
        return arrayList;
    }

    @Nullable
    public synchronized V get(K k) {
        return this.kgn.get(k);
    }

    @Nullable
    public synchronized V put(K k, V v) {
        V remove;
        remove = this.kgn.remove(k);
        this.kgo -= aT(remove);
        this.kgn.put(k, v);
        this.kgo += aT(v);
        return remove;
    }

    @Nullable
    public synchronized V remove(K k) {
        V remove;
        remove = this.kgn.remove(k);
        this.kgo -= aT(remove);
        return remove;
    }

    private int aT(V v) {
        if (v == null) {
            return 0;
        }
        return this.kgm.aR(v);
    }
}
