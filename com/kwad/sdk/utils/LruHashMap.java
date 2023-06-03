package com.kwad.sdk.utils;

import java.util.LinkedHashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class LruHashMap<K, V> extends LinkedHashMap<K, V> {
    public static final float DEFAULT_LOAD_FACTOR = 0.75f;
    public final long maxSize;

    public LruHashMap(long j) {
        super(((int) Math.ceil(((float) j) / 0.75f)) + 1, 0.75f, true);
        this.maxSize = j;
    }

    public long getMaxSize() {
        return this.maxSize;
    }

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<K, V> entry) {
        return ((long) size()) > this.maxSize;
    }
}
