package com.facebook.imagepipeline.core;

import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.cache.disk.FileCache;
/* loaded from: classes6.dex */
public interface FileCacheFactory {
    FileCache get(DiskCacheConfig diskCacheConfig);
}
