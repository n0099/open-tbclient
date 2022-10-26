package com.facebook.imagepipeline.cache;

import com.facebook.common.internal.Predicate;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.references.CloseableReference;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public interface MemoryCache {

    /* loaded from: classes7.dex */
    public interface CacheTrimStrategy {
        double getTrimRatio(MemoryTrimType memoryTrimType);
    }

    @Nullable
    CloseableReference cache(Object obj, CloseableReference closeableReference);

    boolean contains(Predicate predicate);

    boolean contains(Object obj);

    @Nullable
    CloseableReference get(Object obj);

    int getCount();

    int getSizeInBytes();

    void probe(Object obj);

    int removeAll(Predicate predicate);
}
