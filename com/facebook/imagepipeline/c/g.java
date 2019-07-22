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
    private final ac<V> kfg;
    @GuardedBy("this")
    private final LinkedHashMap<K, V> kfh = new LinkedHashMap<>();
    @GuardedBy("this")
    private int kfi = 0;

    public g(ac<V> acVar) {
        this.kfg = acVar;
    }

    public synchronized int getCount() {
        return this.kfh.size();
    }

    public synchronized int getSizeInBytes() {
        return this.kfi;
    }

    @Nullable
    public synchronized K cHo() {
        return this.kfh.isEmpty() ? null : this.kfh.keySet().iterator().next();
    }

    public synchronized ArrayList<Map.Entry<K, V>> a(@Nullable Predicate<K> predicate) {
        ArrayList<Map.Entry<K, V>> arrayList;
        arrayList = new ArrayList<>(this.kfh.entrySet().size());
        for (Map.Entry<K, V> entry : this.kfh.entrySet()) {
            if (predicate == null || predicate.apply(entry.getKey())) {
                arrayList.add(entry);
            }
        }
        return arrayList;
    }

    @Nullable
    public synchronized V get(K k) {
        return this.kfh.get(k);
    }

    @Nullable
    public synchronized V put(K k, V v) {
        V remove;
        remove = this.kfh.remove(k);
        this.kfi -= aT(remove);
        this.kfh.put(k, v);
        this.kfi += aT(v);
        return remove;
    }

    @Nullable
    public synchronized V remove(K k) {
        V remove;
        remove = this.kfh.remove(k);
        this.kfi -= aT(remove);
        return remove;
    }

    private int aT(V v) {
        if (v == null) {
            return 0;
        }
        return this.kfg.aR(v);
    }
}
