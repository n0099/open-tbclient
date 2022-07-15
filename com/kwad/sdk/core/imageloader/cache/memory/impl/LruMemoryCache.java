package com.kwad.sdk.core.imageloader.cache.memory.impl;

import com.kwad.sdk.core.imageloader.cache.memory.MemoryCache;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.utils.aj;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class LruMemoryCache implements MemoryCache {
    public final LinkedHashMap<String, DecodedResult> map;
    public final int maxSize;
    public int size;

    public LruMemoryCache(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.maxSize = i;
        this.map = new LinkedHashMap<>(0, 0.75f, true);
    }

    private int sizeOf(String str, DecodedResult decodedResult) {
        return decodedResult.getByteSize();
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x006e, code lost:
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void trimToSize(int i) {
        while (true) {
            synchronized (this) {
                if (this.size >= 0 && (!this.map.isEmpty() || this.size == 0)) {
                    if (this.size <= i || this.map.isEmpty()) {
                        break;
                    }
                    Map.Entry<String, DecodedResult> next = this.map.entrySet().iterator().next();
                    if (next == null) {
                        return;
                    }
                    String key = next.getKey();
                    this.map.remove(key);
                    this.size -= sizeOf(key, next.getValue());
                } else {
                    break;
                }
            }
        }
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.MemoryCache
    public void clear() {
        trimToSize(-1);
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.MemoryCache
    public final DecodedResult get(String str) {
        DecodedResult decodedResult;
        aj.a(str, "key");
        synchronized (this) {
            decodedResult = this.map.get(str);
        }
        return decodedResult;
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.MemoryCache
    public Collection<String> keys() {
        HashSet hashSet;
        synchronized (this) {
            hashSet = new HashSet(this.map.keySet());
        }
        return hashSet;
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.MemoryCache
    public final boolean put(String str, DecodedResult decodedResult) {
        aj.a(str, "key");
        aj.a(decodedResult, "value");
        synchronized (this) {
            this.size += sizeOf(str, decodedResult);
            DecodedResult put = this.map.put(str, decodedResult);
            if (put != null) {
                this.size -= sizeOf(str, put);
            }
        }
        trimToSize(this.maxSize);
        return true;
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.MemoryCache
    public final DecodedResult remove(String str) {
        DecodedResult remove;
        aj.a(str, "key");
        synchronized (this) {
            remove = this.map.remove(str);
            if (remove != null) {
                this.size -= sizeOf(str, remove);
            }
        }
        return remove;
    }

    public final synchronized String toString() {
        return String.format("LruCache[maxSize=%d]", Integer.valueOf(this.maxSize));
    }
}
