package com.kwai.video.cache.util;

import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwai.video.cache.CacheSessionListener;
import com.kwai.video.hodor.anotations.CalledByNative;
import java.lang.ref.WeakReference;
/* loaded from: classes7.dex */
public class CacheSessionListenerBridge {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public CacheSessionListenerBridge() {
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

    public static CacheSessionListener getListener(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, obj)) == null) {
            if (obj == null) {
                return null;
            }
            return (CacheSessionListener) ((WeakReference) obj).get();
        }
        return (CacheSessionListener) invokeL.objValue;
    }

    @CalledByNative
    public static void onDownloadPaused(Object obj) {
        CacheSessionListener listener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, obj) == null) || (listener = getListener(obj)) == null) {
            return;
        }
        listener.onDownloadPaused();
    }

    @CalledByNative
    public static void onDownloadProgress(Object obj, long j, long j2) {
        CacheSessionListener listener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{obj, Long.valueOf(j), Long.valueOf(j2)}) == null) || (listener = getListener(obj)) == null) {
            return;
        }
        listener.onDownloadProgress(j, j2);
    }

    @CalledByNative
    public static void onDownloadResumed(Object obj) {
        CacheSessionListener listener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65540, null, obj) == null) || (listener = getListener(obj)) == null) {
            return;
        }
        listener.onDownloadResumed();
    }

    @CalledByNative
    public static void onDownloadStarted(Object obj, long j, String str, String str2, String str3, int i2, long j2) {
        CacheSessionListener listener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{obj, Long.valueOf(j), str, str2, str3, Integer.valueOf(i2), Long.valueOf(j2)}) == null) || (listener = getListener(obj)) == null) {
            return;
        }
        listener.onDownloadStarted(j, str, str2, str3, i2, j2);
    }

    @CalledByNative
    public static void onDownloadStopped(Object obj, int i2, long j, long j2, String str, int i3, String str2, String str3, String str4, String str5) {
        CacheSessionListener listener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{obj, Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), str, Integer.valueOf(i3), str2, str3, str4, str5}) == null) || (listener = getListener(obj)) == null) {
            return;
        }
        listener.onDownloadStopped(i2, j, j2, str, i3, str2, str3, str4, str5);
    }

    @CalledByNative
    public static void onSessionClosed(Object obj, int i2, long j, long j2, long j3, String str, boolean z) {
        CacheSessionListener listener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65543, null, new Object[]{obj, Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), str, Boolean.valueOf(z)}) == null) || (listener = getListener(obj)) == null) {
            return;
        }
        listener.onSessionClosed(i2, j, j2, j3, str, z);
    }

    @CalledByNative
    public static void onSessionStart(Object obj, String str, long j, long j2, long j3) {
        CacheSessionListener listener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65544, null, new Object[]{obj, str, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)}) == null) || (listener = getListener(obj)) == null) {
            return;
        }
        listener.onSessionStart(str, j, j2, j3);
    }
}
