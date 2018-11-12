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
    private final ac<V> ieu;
    @GuardedBy("this")
    private final LinkedHashMap<K, V> iev = new LinkedHashMap<>();
    @GuardedBy("this")
    private int iew = 0;

    public g(ac<V> acVar) {
        this.ieu = acVar;
    }

    public synchronized int getCount() {
        return this.iev.size();
    }

    public synchronized int getSizeInBytes() {
        return this.iew;
    }

    @Nullable
    public synchronized K bTD() {
        return this.iev.isEmpty() ? null : this.iev.keySet().iterator().next();
    }

    public synchronized ArrayList<Map.Entry<K, V>> a(@Nullable Predicate<K> predicate) {
        ArrayList<Map.Entry<K, V>> arrayList;
        arrayList = new ArrayList<>(this.iev.entrySet().size());
        for (Map.Entry<K, V> entry : this.iev.entrySet()) {
            if (predicate == null || predicate.apply(entry.getKey())) {
                arrayList.add(entry);
            }
        }
        return arrayList;
    }

    @Nullable
    public synchronized V get(K k) {
        return this.iev.get(k);
    }

    @Nullable
    public synchronized V put(K k, V v) {
        V remove;
        remove = this.iev.remove(k);
        this.iew -= aE(remove);
        this.iev.put(k, v);
        this.iew += aE(v);
        return remove;
    }

    @Nullable
    public synchronized V remove(K k) {
        V remove;
        remove = this.iev.remove(k);
        this.iew -= aE(remove);
        return remove;
    }

    private int aE(V v) {
        if (v == null) {
            return 0;
        }
        return this.ieu.aC(v);
    }
}
