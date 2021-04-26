package io.reactivex.flowables;

import io.reactivex.Flowable;
import io.reactivex.annotations.Nullable;
/* loaded from: classes7.dex */
public abstract class GroupedFlowable<K, T> extends Flowable<T> {
    public final K key;

    public GroupedFlowable(@Nullable K k) {
        this.key = k;
    }

    @Nullable
    public K getKey() {
        return this.key;
    }
}
