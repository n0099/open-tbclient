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
    private final ac<V> jFk;
    @GuardedBy("this")
    private final LinkedHashMap<K, V> jFl = new LinkedHashMap<>();
    @GuardedBy("this")
    private int jFm = 0;

    public g(ac<V> acVar) {
        this.jFk = acVar;
    }

    public synchronized int getCount() {
        return this.jFl.size();
    }

    public synchronized int getSizeInBytes() {
        return this.jFm;
    }

    @Nullable
    public synchronized K cwo() {
        return this.jFl.isEmpty() ? null : this.jFl.keySet().iterator().next();
    }

    public synchronized ArrayList<Map.Entry<K, V>> a(@Nullable Predicate<K> predicate) {
        ArrayList<Map.Entry<K, V>> arrayList;
        arrayList = new ArrayList<>(this.jFl.entrySet().size());
        for (Map.Entry<K, V> entry : this.jFl.entrySet()) {
            if (predicate == null || predicate.apply(entry.getKey())) {
                arrayList.add(entry);
            }
        }
        return arrayList;
    }

    @Nullable
    public synchronized V get(K k) {
        return this.jFl.get(k);
    }

    @Nullable
    public synchronized V put(K k, V v) {
        V remove;
        remove = this.jFl.remove(k);
        this.jFm -= aR(remove);
        this.jFl.put(k, v);
        this.jFm += aR(v);
        return remove;
    }

    @Nullable
    public synchronized V remove(K k) {
        V remove;
        remove = this.jFl.remove(k);
        this.jFm -= aR(remove);
        return remove;
    }

    private int aR(V v) {
        if (v == null) {
            return 0;
        }
        return this.jFk.aP(v);
    }
}
