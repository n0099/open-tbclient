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
    private final ac<V> icG;
    @GuardedBy("this")
    private final LinkedHashMap<K, V> icH = new LinkedHashMap<>();
    @GuardedBy("this")
    private int icI = 0;

    public g(ac<V> acVar) {
        this.icG = acVar;
    }

    public synchronized int getCount() {
        return this.icH.size();
    }

    public synchronized int getSizeInBytes() {
        return this.icI;
    }

    @Nullable
    public synchronized K bUi() {
        return this.icH.isEmpty() ? null : this.icH.keySet().iterator().next();
    }

    public synchronized ArrayList<Map.Entry<K, V>> a(@Nullable Predicate<K> predicate) {
        ArrayList<Map.Entry<K, V>> arrayList;
        arrayList = new ArrayList<>(this.icH.entrySet().size());
        for (Map.Entry<K, V> entry : this.icH.entrySet()) {
            if (predicate == null || predicate.apply(entry.getKey())) {
                arrayList.add(entry);
            }
        }
        return arrayList;
    }

    @Nullable
    public synchronized V get(K k) {
        return this.icH.get(k);
    }

    @Nullable
    public synchronized V put(K k, V v) {
        V remove;
        remove = this.icH.remove(k);
        this.icI -= aF(remove);
        this.icH.put(k, v);
        this.icI += aF(v);
        return remove;
    }

    @Nullable
    public synchronized V remove(K k) {
        V remove;
        remove = this.icH.remove(k);
        this.icI -= aF(remove);
        return remove;
    }

    private int aF(V v) {
        if (v == null) {
            return 0;
        }
        return this.icG.aD(v);
    }
}
