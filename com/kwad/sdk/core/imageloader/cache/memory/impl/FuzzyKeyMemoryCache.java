package com.kwad.sdk.core.imageloader.cache.memory.impl;

import com.kwad.sdk.core.imageloader.cache.memory.MemoryCache;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
/* loaded from: classes8.dex */
public class FuzzyKeyMemoryCache implements MemoryCache {
    public final MemoryCache cache;
    public final Comparator<String> keyComparator;

    public FuzzyKeyMemoryCache(MemoryCache memoryCache, Comparator<String> comparator) {
        this.cache = memoryCache;
        this.keyComparator = comparator;
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.MemoryCache
    public void clear() {
        this.cache.clear();
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.MemoryCache
    public DecodedResult get(String str) {
        return this.cache.get(str);
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.MemoryCache
    public Collection<String> keys() {
        return this.cache.keys();
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.MemoryCache
    public boolean put(String str, DecodedResult decodedResult) {
        synchronized (this.cache) {
            String str2 = null;
            Iterator<String> it = this.cache.keys().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (this.keyComparator.compare(str, next) == 0) {
                    str2 = next;
                    break;
                }
            }
            if (str2 != null) {
                this.cache.remove(str2);
            }
        }
        return this.cache.put(str, decodedResult);
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.MemoryCache
    public DecodedResult remove(String str) {
        return this.cache.remove(str);
    }
}
