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
    private final ac<V> icH;
    @GuardedBy("this")
    private final LinkedHashMap<K, V> icI = new LinkedHashMap<>();
    @GuardedBy("this")
    private int icJ = 0;

    public g(ac<V> acVar) {
        this.icH = acVar;
    }

    public synchronized int getCount() {
        return this.icI.size();
    }

    public synchronized int getSizeInBytes() {
        return this.icJ;
    }

    @Nullable
    public synchronized K bUi() {
        return this.icI.isEmpty() ? null : this.icI.keySet().iterator().next();
    }

    public synchronized ArrayList<Map.Entry<K, V>> a(@Nullable Predicate<K> predicate) {
        ArrayList<Map.Entry<K, V>> arrayList;
        arrayList = new ArrayList<>(this.icI.entrySet().size());
        for (Map.Entry<K, V> entry : this.icI.entrySet()) {
            if (predicate == null || predicate.apply(entry.getKey())) {
                arrayList.add(entry);
            }
        }
        return arrayList;
    }

    @Nullable
    public synchronized V get(K k) {
        return this.icI.get(k);
    }

    @Nullable
    public synchronized V put(K k, V v) {
        V remove;
        remove = this.icI.remove(k);
        this.icJ -= aF(remove);
        this.icI.put(k, v);
        this.icJ += aF(v);
        return remove;
    }

    @Nullable
    public synchronized V remove(K k) {
        V remove;
        remove = this.icI.remove(k);
        this.icJ -= aF(remove);
        return remove;
    }

    private int aF(V v) {
        if (v == null) {
            return 0;
        }
        return this.icH.aD(v);
    }
}
