package com.facebook.imagepipeline.cache;

import com.facebook.common.internal.Predicate;
import com.facebook.common.references.CloseableReference;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public interface MemoryCache<K, V> {
    @Nullable
    CloseableReference<V> cache(K k2, CloseableReference<V> closeableReference);

    boolean contains(Predicate<K> predicate);

    boolean contains(K k2);

    @Nullable
    CloseableReference<V> get(K k2);

    int removeAll(Predicate<K> predicate);
}
