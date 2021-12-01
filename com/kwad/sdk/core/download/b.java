package com.kwad.sdk.core.download;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.KsAdSDKImpl;
/* loaded from: classes2.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(303278443, "Lcom/kwad/sdk/core/download/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(303278443, "Lcom/kwad/sdk/core/download/b;");
                return;
            }
        }
        a = KsAdSDKImpl.get().isDebugLogEnable();
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            if (a) {
                com.kwad.sdk.core.d.a.a("DownloadMonitor", "onDownloadStart(), id=" + str);
            }
            DownloadStatusManager.a().a(str);
        }
    }

    public static void a(String str, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(65538, null, str, i2, i3, i4) == null) {
            if (a) {
                com.kwad.sdk.core.d.a.a("DownloadMonitor", "onProgressUpdate(), id=" + str + " progress=" + i2 + " soFarBytes=" + i3 + " totalBytes=" + i4);
            }
            DownloadStatusManager.a().a(str, i2, i3, i4);
        }
    }

    public static void a(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65539, null, str, i2, str2) == null) {
            if (a) {
                com.kwad.sdk.core.d.a.a("DownloadMonitor", "onDownloadFail(), id=" + str + " errorCode=" + i2 + " errorMsg=" + str2);
            }
            DownloadStatusManager.a().a(str, i2, str2);
        }
    }

    public static void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2) == null) {
            if (a) {
                com.kwad.sdk.core.d.a.a("DownloadMonitor", "onDownloadFinished(), id=" + str + " filePath=" + str2);
            }
            DownloadStatusManager.a().a(str, str2);
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            if (a) {
                com.kwad.sdk.core.d.a.a("DownloadMonitor", "onDownloadPaused(), id=" + str);
            }
            DownloadStatusManager.a().b(str);
        }
    }

    public static void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, str) == null) {
            if (a) {
                com.kwad.sdk.core.d.a.a("DownloadMonitor", "onDownloadResumed(), id=" + str);
            }
            DownloadStatusManager.a().c(str);
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, str) == null) {
            if (a) {
                com.kwad.sdk.core.d.a.a("DownloadMonitor", "onDownloadCanceled(), id=" + str);
            }
            DownloadStatusManager.a().d(str);
        }
    }

    public static void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, str) == null) {
            if (a) {
                com.kwad.sdk.core.d.a.a("DownloadMonitor", "onLowStorage(), id=" + str);
            }
            DownloadStatusManager.a().e(str);
        }
    }
}
