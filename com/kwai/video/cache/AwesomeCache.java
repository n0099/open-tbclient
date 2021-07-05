package com.kwai.video.cache;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.video.cache.OfflineCacheVodAdaptiveTaskBuilder;
import com.kwai.video.hodor.util.Timber;
/* loaded from: classes7.dex */
public class AwesomeCache {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DATA_SOURCE_TYPE_ASYNC_V2 = 0;
    public static final int DATA_SOURCE_TYPE_LIVE = 1;
    public static final int DATA_SOURCE_TYPE_SEGMENT = 2;
    public static final int UPSTREAM_TYPE_CRONET = 3;
    public static final int UPSTREAM_TYPE_CURL = 0;
    public static final int UPSTREAM_TYPE_FFURL = 1;
    public static final int UPSTREAM_TYPE_P2SP = 2;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public @interface DataSourceType {
    }

    /* loaded from: classes7.dex */
    public static class OfflineCacheDataSpec {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int bandWidthThreshold;
        public int cacheMode;
        public int connectTimeoutMs;
        public long durMs;
        public boolean enableLimitSpeedWhenCancel;
        public String host;
        public String key;
        public long len;
        public int maxSpeedKbps;
        public long pos;
        public int readTimeoutMs;
        public int socketBufSizeKb;
        public String url;

        public OfflineCacheDataSpec() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public @interface UpstreamType {
    }

    /* loaded from: classes7.dex */
    public static class VodAdaptive {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int NET_WORK_TYPE_FIVE_G = 5;
        public static final int NET_WORK_TYPE_FOUR_G = 2;
        public static final int NET_WORK_TYPE_THREE_G = 3;
        public static final int NET_WORK_TYPE_TWO_G = 4;
        public static final int NET_WORK_TYPE_UNKNOW = 0;
        public static final int NET_WORK_TYPE_WIFI = 1;
        public transient /* synthetic */ FieldHolder $fh;

        public VodAdaptive() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static native String _vodAdaptiveGetHistoryData();

        public static native void _vodAdaptiveSetHistoryData(String str);

        public static String getHistoryData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? _vodAdaptiveGetHistoryData() : (String) invokeV.objValue;
        }

        public static void init(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65540, null, context) == null) {
                String vodAdaptiveData = PlayerPreferrenceUtil.getInstance().getVodAdaptiveData(context);
                if (TextUtils.isEmpty(vodAdaptiveData)) {
                    return;
                }
                setHistoryData(vodAdaptiveData);
            }
        }

        public static void setHistoryData(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str) == null) {
                _vodAdaptiveSetHistoryData(str);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1209887846, "Lcom/kwai/video/cache/AwesomeCache;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1209887846, "Lcom/kwai/video/cache/AwesomeCache;");
                return;
            }
        }
        AwesomeCacheInitConfig.waitSoLibReady();
    }

    public AwesomeCache() {
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

    public static native void _clearCacheDir();

    public static native long _getCachedBytesForKey(String str);

    public static native long _getTotalBytesForKey(String str);

    public static native boolean _importToCache(String str, String str2);

    public static native boolean _isFullyCached(String str);

    public static native long _newExportCachedFileTask(Object obj, String str, String str2, String str3, String str4);

    public static native long _newOfflineCacheVodAdaptiveTask(Object obj, Object obj2, Object obj3, Object obj4);

    public static native long _newOfflineCacheVodFileTask(Object obj, Object obj2, Object obj3);

    public static native long _newOfflineCachedFileTask(Object obj, String str, String str2, String str3);

    public static void clearCacheDir() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            _clearCacheDir();
        }
    }

    public static long getCachedBytesForKey(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) ? _getCachedBytesForKey(str) : invokeL.longValue;
    }

    public static int getCachedPercentForKey(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, str)) == null) {
            long cachedBytesForKey = getCachedBytesForKey(str);
            long totalBytesForKey = getTotalBytesForKey(str);
            Timber.i("[AwesomeCache] getCachedPercentForKey. key:%s cached:%d total:%d", str, Long.valueOf(cachedBytesForKey), Long.valueOf(totalBytesForKey));
            if (totalBytesForKey > 0) {
                return (int) ((cachedBytesForKey * 100) / totalBytesForKey);
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static long getTotalBytesForKey(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, null, str)) == null) ? _getTotalBytesForKey(str) : invokeL.longValue;
    }

    public static boolean importToCache(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, str, str2)) == null) ? _importToCache(str, str2) : invokeLL.booleanValue;
    }

    public static boolean isFullyCached(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65552, null, str)) == null) ? _isFullyCached(str) : invokeL.booleanValue;
    }

    public static CacheTask newExportCachedFileTask(String str, String str2, String str3, String str4) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65553, null, str, str2, str3, str4)) == null) {
            CacheTask cacheTask = new CacheTask();
            cacheTask.setNativeTask(_newExportCachedFileTask(cacheTask, str, str2, str3, str4));
            return cacheTask;
        }
        return (CacheTask) invokeLLLL.objValue;
    }

    public static OfflineCacheVodTask newOfflineCacheVodAdaptiveTask(OfflineCacheDataSpec offlineCacheDataSpec, AwesomeCacheCallback awesomeCacheCallback, OfflineCacheVodAdaptiveTaskBuilder.VodAdaptiveInit vodAdaptiveInit) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65554, null, offlineCacheDataSpec, awesomeCacheCallback, vodAdaptiveInit)) == null) {
            OfflineCacheVodTask offlineCacheVodTask = new OfflineCacheVodTask();
            offlineCacheVodTask.setNativeTask(_newOfflineCacheVodAdaptiveTask(offlineCacheVodTask, offlineCacheDataSpec, awesomeCacheCallback, vodAdaptiveInit));
            return offlineCacheVodTask;
        }
        return (OfflineCacheVodTask) invokeLLL.objValue;
    }

    public static OfflineCacheVodTask newOfflineCacheVodFileTask(OfflineCacheDataSpec offlineCacheDataSpec, AwesomeCacheCallback awesomeCacheCallback) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65555, null, offlineCacheDataSpec, awesomeCacheCallback)) == null) {
            OfflineCacheVodTask offlineCacheVodTask = new OfflineCacheVodTask();
            offlineCacheVodTask.setNativeTask(_newOfflineCacheVodFileTask(offlineCacheVodTask, offlineCacheDataSpec, awesomeCacheCallback));
            return offlineCacheVodTask;
        }
        return (OfflineCacheVodTask) invokeLL.objValue;
    }

    public static OfflineCacheTask newOfflineCachedFileTask(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65556, null, str, str2, str3)) == null) {
            OfflineCacheTask offlineCacheTask = new OfflineCacheTask();
            offlineCacheTask.setNativeTask(_newOfflineCachedFileTask(offlineCacheTask, str, str2, str3));
            return offlineCacheTask;
        }
        return (OfflineCacheTask) invokeLLL.objValue;
    }
}
