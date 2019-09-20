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
    private final ac<V> kiK;
    @GuardedBy("this")
    private final LinkedHashMap<K, V> kiL = new LinkedHashMap<>();
    @GuardedBy("this")
    private int kiM = 0;

    public g(ac<V> acVar) {
        this.kiK = acVar;
    }

    public synchronized int getCount() {
        return this.kiL.size();
    }

    public synchronized int getSizeInBytes() {
        return this.kiM;
    }

    @Nullable
    public synchronized K cIx() {
        return this.kiL.isEmpty() ? null : this.kiL.keySet().iterator().next();
    }

    public synchronized ArrayList<Map.Entry<K, V>> a(@Nullable Predicate<K> predicate) {
        ArrayList<Map.Entry<K, V>> arrayList;
        arrayList = new ArrayList<>(this.kiL.entrySet().size());
        for (Map.Entry<K, V> entry : this.kiL.entrySet()) {
            if (predicate == null || predicate.apply(entry.getKey())) {
                arrayList.add(entry);
            }
        }
        return arrayList;
    }

    @Nullable
    public synchronized V get(K k) {
        return this.kiL.get(k);
    }

    @Nullable
    public synchronized V put(K k, V v) {
        V remove;
        remove = this.kiL.remove(k);
        this.kiM -= aT(remove);
        this.kiL.put(k, v);
        this.kiM += aT(v);
        return remove;
    }

    @Nullable
    public synchronized V remove(K k) {
        V remove;
        remove = this.kiL.remove(k);
        this.kiM -= aT(remove);
        return remove;
    }

    private int aT(V v) {
        if (v == null) {
            return 0;
        }
        return this.kiK.aR(v);
    }
}
