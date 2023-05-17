package com.facebook.imagepipeline.cache;

import com.facebook.common.internal.Predicate;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.references.CloseableReference;
import javax.annotation.Nullable;
/* loaded from: classes8.dex */
public interface MemoryCache<K, V> {

    /* loaded from: classes8.dex */
    public interface CacheTrimStrategy {
        double getTrimRatio(MemoryTrimType memoryTrimType);
    }

    @Nullable
    CloseableReference<V> cache(K k, CloseableReference<V> closeableReference);

    boolean contains(Predicate<K> predicate);

    boolean contains(K k);

    @Nullable
    CloseableReference<V> get(K k);

    int getCount();

    int getSizeInBytes();

    void probe(K k);

    int removeAll(Predicate<K> predicate);
}
