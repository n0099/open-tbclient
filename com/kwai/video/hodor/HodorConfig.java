package com.kwai.video.hodor;

import android.content.Context;
import com.kwai.video.cache.AwesomeCacheInitConfig;
import com.kwai.video.hodor.util.FileUtils;
import java.io.File;
/* loaded from: classes4.dex */
public class HodorConfig {
    public static final int DEFAULT_CONNECT_TIMEOUT_MS = 3000;
    public static final int HodorQueueMode_LowConsume = 0;
    public static final int HodorQueueMode_None = -1;
    public static final int HodorQueueMode_Normal = 1;
    private static final long MB = 1048576;
    private static final long MEDIA_CACHE_LIMIT_MB_DEFAULT = 256;
    private static final long MEDIA_CACHE_LIMIT_MB_MIN = 10;
    private static long sMediaDirAvialbleMB;
    private static String sMediaDirFullPath;
    private static String sResourceDirFullPath;

    /* loaded from: classes4.dex */
    public @interface HodorQueueMode {
    }

    static {
        AwesomeCacheInitConfig.waitSoLibReady();
    }

    public static native void enalbeCronetForAllTask(boolean z);

    public static native long getCacheV2ScopeMaxBytes();

    public static native int getHodorQueueMode();

    public static long getMediaDirAvialbleMB() {
        return sMediaDirAvialbleMB;
    }

    public static String getMediaDirFullPath() {
        return sMediaDirFullPath;
    }

    private static long getReasonableMediaCacheBytesLimit(String str) {
        long availableBytes = FileUtils.getAvailableBytes(str);
        sMediaDirAvialbleMB = availableBytes / 1048576;
        return (long) Math.max(1.048576E7d, Math.min(availableBytes * 0.5d, 2.68435456E8d));
    }

    public static String getResourceDirFullPath() {
        return sResourceDirFullPath;
    }

    public static native int getTcpMaxConnects();

    public static void init(Context context) {
        File defaultCacheDir = FileUtils.getDefaultCacheDir(context, true);
        String absolutePath = defaultCacheDir == null ? "." : defaultCacheDir.getAbsolutePath();
        sMediaDirFullPath = setMediaCacheDirectoryPath(absolutePath);
        setMediaCacheBytesLimit(getReasonableMediaCacheBytesLimit(absolutePath));
        File defaultCacheDir2 = FileUtils.getDefaultCacheDir(context, false);
        sResourceDirFullPath = setResourceCacheDirectoryPath(defaultCacheDir2 == null ? "." : defaultCacheDir2.getAbsolutePath());
        initCacheManager();
    }

    private static native void initCacheManager();

    public static native boolean isCronetEnalbedForAllTask();

    public static native void setCacheV2ScopeMaxBytes(long j);

    public static native int setHodorQueueMode(@HodorQueueMode int i);

    public static native void setKlogParam(Object obj);

    public static native long setMediaCacheBytesLimit(long j);

    public static native String setMediaCacheDirectoryPath(String str);

    public static native void setPreloadV3VodBufferLowRatio(double d);

    public static native void setPreloadV3VodCacheKbThresholdWhenPrepare(int i);

    public static native void setPreloadV3VodPausePreloadMaxCountDueToBufferLow(int i);

    public static native String setResourceCacheDirectoryPath(String str);

    public static native int setTcpMaxConnects(int i);
}
