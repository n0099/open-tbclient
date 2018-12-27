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
    private final ac<V> ioQ;
    @GuardedBy("this")
    private final LinkedHashMap<K, V> ioR = new LinkedHashMap<>();
    @GuardedBy("this")
    private int ioS = 0;

    public g(ac<V> acVar) {
        this.ioQ = acVar;
    }

    public synchronized int getCount() {
        return this.ioR.size();
    }

    public synchronized int getSizeInBytes() {
        return this.ioS;
    }

    @Nullable
    public synchronized K bWz() {
        return this.ioR.isEmpty() ? null : this.ioR.keySet().iterator().next();
    }

    public synchronized ArrayList<Map.Entry<K, V>> a(@Nullable Predicate<K> predicate) {
        ArrayList<Map.Entry<K, V>> arrayList;
        arrayList = new ArrayList<>(this.ioR.entrySet().size());
        for (Map.Entry<K, V> entry : this.ioR.entrySet()) {
            if (predicate == null || predicate.apply(entry.getKey())) {
                arrayList.add(entry);
            }
        }
        return arrayList;
    }

    @Nullable
    public synchronized V get(K k) {
        return this.ioR.get(k);
    }

    @Nullable
    public synchronized V put(K k, V v) {
        V remove;
        remove = this.ioR.remove(k);
        this.ioS -= aF(remove);
        this.ioR.put(k, v);
        this.ioS += aF(v);
        return remove;
    }

    @Nullable
    public synchronized V remove(K k) {
        V remove;
        remove = this.ioR.remove(k);
        this.ioS -= aF(remove);
        return remove;
    }

    private int aF(V v) {
        if (v == null) {
            return 0;
        }
        return this.ioQ.aD(v);
    }
}
