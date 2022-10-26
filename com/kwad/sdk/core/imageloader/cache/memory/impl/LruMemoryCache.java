package com.kwad.sdk.core.imageloader.cache.memory.impl;

import com.kwad.sdk.core.imageloader.cache.memory.MemoryCache;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.utils.am;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class LruMemoryCache implements MemoryCache {
    public final LinkedHashMap map;
    public final int maxSize;
    public int size;

    public LruMemoryCache(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.maxSize = i;
        this.map = new LinkedHashMap(0, 0.75f, true);
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
                    Map.Entry entry = (Map.Entry) this.map.entrySet().iterator().next();
                    if (entry == null) {
                        return;
                    }
                    String str = (String) entry.getKey();
                    this.map.remove(str);
                    this.size -= sizeOf(str, (DecodedResult) entry.getValue());
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
        am.T(str, "key");
        synchronized (this) {
            decodedResult = (DecodedResult) this.map.get(str);
        }
        return decodedResult;
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.MemoryCache
    public Collection keys() {
        HashSet hashSet;
        synchronized (this) {
            hashSet = new HashSet(this.map.keySet());
        }
        return hashSet;
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.MemoryCache
    public final boolean put(String str, DecodedResult decodedResult) {
        am.T(str, "key");
        am.e(decodedResult, "value");
        synchronized (this) {
            this.size += sizeOf(str, decodedResult);
            DecodedResult decodedResult2 = (DecodedResult) this.map.put(str, decodedResult);
            if (decodedResult2 != null) {
                this.size -= sizeOf(str, decodedResult2);
            }
        }
        trimToSize(this.maxSize);
        return true;
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.MemoryCache
    public final DecodedResult remove(String str) {
        DecodedResult decodedResult;
        am.T(str, "key");
        synchronized (this) {
            decodedResult = (DecodedResult) this.map.remove(str);
            if (decodedResult != null) {
                this.size -= sizeOf(str, decodedResult);
            }
        }
        return decodedResult;
    }

    public final synchronized String toString() {
        return String.format("LruCache[maxSize=%d]", Integer.valueOf(this.maxSize));
    }
}
