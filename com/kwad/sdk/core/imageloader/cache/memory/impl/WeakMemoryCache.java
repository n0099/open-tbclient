package com.kwad.sdk.core.imageloader.cache.memory.impl;

import com.kwad.sdk.core.imageloader.cache.memory.BaseMemoryCache;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
/* loaded from: classes4.dex */
public class WeakMemoryCache extends BaseMemoryCache {
    @Override // com.kwad.sdk.core.imageloader.cache.memory.BaseMemoryCache
    protected Reference<DecodedResult> createReference(DecodedResult decodedResult) {
        return new WeakReference(decodedResult);
    }
}
