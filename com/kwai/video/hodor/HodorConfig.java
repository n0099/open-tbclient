package com.kwai.video.hodor;

import android.content.Context;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.video.cache.AwesomeCacheInitConfig;
import com.kwai.video.hodor.util.FileUtils;
import java.io.File;
/* loaded from: classes7.dex */
public class HodorConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_CONNECT_TIMEOUT_MS = 3000;
    public static final int HodorQueueMode_LowConsume = 0;
    public static final int HodorQueueMode_None = -1;
    public static final int HodorQueueMode_Normal = 1;
    public static final long MB = 1048576;
    public static final long MEDIA_CACHE_LIMIT_MB_DEFAULT = 256;
    public static final long MEDIA_CACHE_LIMIT_MB_MIN = 10;
    public static long sMediaDirAvialbleMB;
    public static String sMediaDirFullPath;
    public static String sResourceDirFullPath;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public @interface HodorQueueMode {
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1182798979, "Lcom/kwai/video/hodor/HodorConfig;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1182798979, "Lcom/kwai/video/hodor/HodorConfig;");
                return;
            }
        }
        AwesomeCacheInitConfig.waitSoLibReady();
    }

    public HodorConfig() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static native void enalbeCronetForAllTask(boolean z);

    public static native long getCacheV2ScopeMaxBytes();

    public static native int getHodorQueueMode();

    public static long getMediaDirAvialbleMB() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) ? sMediaDirAvialbleMB : invokeV.longValue;
    }

    public static String getMediaDirFullPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? sMediaDirFullPath : (String) invokeV.objValue;
    }

    public static long getReasonableMediaCacheBytesLimit(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            long availableBytes = FileUtils.getAvailableBytes(str);
            sMediaDirAvialbleMB = availableBytes / 1048576;
            return (long) Math.max(1.048576E7d, Math.min(availableBytes * 0.5d, 2.68435456E8d));
        }
        return invokeL.longValue;
    }

    public static String getResourceDirFullPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? sResourceDirFullPath : (String) invokeV.objValue;
    }

    public static native int getTcpMaxConnects();

    public static void init(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, context) == null) {
            File defaultCacheDir = FileUtils.getDefaultCacheDir(context, true);
            String absolutePath = defaultCacheDir == null ? "." : defaultCacheDir.getAbsolutePath();
            sMediaDirFullPath = setMediaCacheDirectoryPath(absolutePath);
            setMediaCacheBytesLimit(getReasonableMediaCacheBytesLimit(absolutePath));
            File defaultCacheDir2 = FileUtils.getDefaultCacheDir(context, false);
            sResourceDirFullPath = setResourceCacheDirectoryPath(defaultCacheDir2 != null ? defaultCacheDir2.getAbsolutePath() : ".");
            initCacheManager();
        }
    }

    public static native void initCacheManager();

    public static native boolean isCronetEnalbedForAllTask();

    public static native void setCacheV2ScopeMaxBytes(long j);

    public static native int setHodorQueueMode(@HodorQueueMode int i2);

    public static native void setKlogParam(Object obj);

    public static native long setMediaCacheBytesLimit(long j);

    public static native String setMediaCacheDirectoryPath(String str);

    public static native void setPreloadV3VodBufferLowRatio(double d2);

    public static native void setPreloadV3VodCacheKbThresholdWhenPrepare(int i2);

    public static native void setPreloadV3VodPausePreloadMaxCountDueToBufferLow(int i2);

    public static native String setResourceCacheDirectoryPath(String str);

    public static native int setTcpMaxConnects(int i2);
}
