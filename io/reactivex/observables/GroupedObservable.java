package io.reactivex.observables;

import io.reactivex.Observable;
import io.reactivex.annotations.Nullable;
/* loaded from: classes7.dex */
public abstract class GroupedObservable<K, T> extends Observable<T> {
    public final K key;

    public GroupedObservable(@Nullable K k) {
        this.key = k;
    }

    @Nullable
    public K getKey() {
        return this.key;
    }
}
