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
    private final ac<V> jFj;
    @GuardedBy("this")
    private final LinkedHashMap<K, V> jFk = new LinkedHashMap<>();
    @GuardedBy("this")
    private int jFl = 0;

    public g(ac<V> acVar) {
        this.jFj = acVar;
    }

    public synchronized int getCount() {
        return this.jFk.size();
    }

    public synchronized int getSizeInBytes() {
        return this.jFl;
    }

    @Nullable
    public synchronized K cwo() {
        return this.jFk.isEmpty() ? null : this.jFk.keySet().iterator().next();
    }

    public synchronized ArrayList<Map.Entry<K, V>> a(@Nullable Predicate<K> predicate) {
        ArrayList<Map.Entry<K, V>> arrayList;
        arrayList = new ArrayList<>(this.jFk.entrySet().size());
        for (Map.Entry<K, V> entry : this.jFk.entrySet()) {
            if (predicate == null || predicate.apply(entry.getKey())) {
                arrayList.add(entry);
            }
        }
        return arrayList;
    }

    @Nullable
    public synchronized V get(K k) {
        return this.jFk.get(k);
    }

    @Nullable
    public synchronized V put(K k, V v) {
        V remove;
        remove = this.jFk.remove(k);
        this.jFl -= aR(remove);
        this.jFk.put(k, v);
        this.jFl += aR(v);
        return remove;
    }

    @Nullable
    public synchronized V remove(K k) {
        V remove;
        remove = this.jFk.remove(k);
        this.jFl -= aR(remove);
        return remove;
    }

    private int aR(V v) {
        if (v == null) {
            return 0;
        }
        return this.jFj.aP(v);
    }
}
