package com.facebook.imagepipeline.cache;

import android.app.ActivityManager;
import android.os.Build;
import com.baidu.tbadk.TbConfig;
import com.facebook.common.internal.Supplier;
/* loaded from: classes4.dex */
public class DefaultBitmapMemoryCacheParamsSupplier implements Supplier<MemoryCacheParams> {
    public static final int MAX_CACHE_ENTRIES = 256;
    public static final int MAX_CACHE_ENTRY_SIZE = Integer.MAX_VALUE;
    public static final int MAX_EVICTION_QUEUE_ENTRIES = Integer.MAX_VALUE;
    public static final int MAX_EVICTION_QUEUE_SIZE = Integer.MAX_VALUE;
    public final ActivityManager mActivityManager;

    public DefaultBitmapMemoryCacheParamsSupplier(ActivityManager activityManager) {
        this.mActivityManager = activityManager;
    }

    private int getMaxCacheSize() {
        int min = Math.min(this.mActivityManager.getMemoryClass() * 1048576, Integer.MAX_VALUE);
        if (min < 33554432) {
            return 4194304;
        }
        if (min < 67108864) {
            return TbConfig.THREAD_GIF_MIN_USE_MEMORY;
        }
        if (Build.VERSION.SDK_INT < 11) {
            return 8388608;
        }
        return min / 4;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.facebook.common.internal.Supplier
    public MemoryCacheParams get() {
        return new MemoryCacheParams(getMaxCacheSize(), 256, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
    }
}
