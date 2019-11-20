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
    private final ac<V> kgd;
    @GuardedBy("this")
    private final LinkedHashMap<K, V> kge = new LinkedHashMap<>();
    @GuardedBy("this")
    private int kgf = 0;

    public g(ac<V> acVar) {
        this.kgd = acVar;
    }

    public synchronized int getCount() {
        return this.kge.size();
    }

    public synchronized int getSizeInBytes() {
        return this.kgf;
    }

    @Nullable
    public synchronized K cFs() {
        return this.kge.isEmpty() ? null : this.kge.keySet().iterator().next();
    }

    public synchronized ArrayList<Map.Entry<K, V>> a(@Nullable Predicate<K> predicate) {
        ArrayList<Map.Entry<K, V>> arrayList;
        arrayList = new ArrayList<>(this.kge.entrySet().size());
        for (Map.Entry<K, V> entry : this.kge.entrySet()) {
            if (predicate == null || predicate.apply(entry.getKey())) {
                arrayList.add(entry);
            }
        }
        return arrayList;
    }

    @Nullable
    public synchronized V get(K k) {
        return this.kge.get(k);
    }

    @Nullable
    public synchronized V put(K k, V v) {
        V remove;
        remove = this.kge.remove(k);
        this.kgf -= aO(remove);
        this.kge.put(k, v);
        this.kgf += aO(v);
        return remove;
    }

    @Nullable
    public synchronized V remove(K k) {
        V remove;
        remove = this.kge.remove(k);
        this.kgf -= aO(remove);
        return remove;
    }

    private int aO(V v) {
        if (v == null) {
            return 0;
        }
        return this.kgd.aM(v);
    }
}
