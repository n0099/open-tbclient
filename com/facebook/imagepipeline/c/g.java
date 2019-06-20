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
    private final ac<V> jYb;
    @GuardedBy("this")
    private final LinkedHashMap<K, V> jYc = new LinkedHashMap<>();
    @GuardedBy("this")
    private int jYd = 0;

    public g(ac<V> acVar) {
        this.jYb = acVar;
    }

    public synchronized int getCount() {
        return this.jYc.size();
    }

    public synchronized int getSizeInBytes() {
        return this.jYd;
    }

    @Nullable
    public synchronized K cEl() {
        return this.jYc.isEmpty() ? null : this.jYc.keySet().iterator().next();
    }

    public synchronized ArrayList<Map.Entry<K, V>> a(@Nullable Predicate<K> predicate) {
        ArrayList<Map.Entry<K, V>> arrayList;
        arrayList = new ArrayList<>(this.jYc.entrySet().size());
        for (Map.Entry<K, V> entry : this.jYc.entrySet()) {
            if (predicate == null || predicate.apply(entry.getKey())) {
                arrayList.add(entry);
            }
        }
        return arrayList;
    }

    @Nullable
    public synchronized V get(K k) {
        return this.jYc.get(k);
    }

    @Nullable
    public synchronized V put(K k, V v) {
        V remove;
        remove = this.jYc.remove(k);
        this.jYd -= aT(remove);
        this.jYc.put(k, v);
        this.jYd += aT(v);
        return remove;
    }

    @Nullable
    public synchronized V remove(K k) {
        V remove;
        remove = this.jYc.remove(k);
        this.jYd -= aT(remove);
        return remove;
    }

    private int aT(V v) {
        if (v == null) {
            return 0;
        }
        return this.jYb.aR(v);
    }
}
