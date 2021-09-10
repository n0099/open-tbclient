package com.kwad.sdk.core.download;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.view.InputDeviceCompat;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.KsAdSDKImpl;
/* loaded from: classes10.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f71675a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(303278474, "Lcom/kwad/sdk/core/download/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(303278474, "Lcom/kwad/sdk/core/download/c;");
                return;
            }
        }
        f71675a = KsAdSDKImpl.get().isDebugLogEnable();
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            if (f71675a) {
                com.kwad.sdk.core.d.a.a("DownloadMonitor", "onDownloadStart(), id=" + str);
            }
            Intent intent = new Intent(a.f71612b);
            Bundle bundle = new Bundle();
            bundle.putString("RESULT_DOWNLOAD_ID", str);
            intent.putExtras(bundle);
            Context context = KsAdSDKImpl.get().getContext();
            if (context != null) {
                context.sendBroadcast(intent, context.getPackageName() + ".permission.KW_SDK_BROADCAST");
            }
        }
    }

    public static void a(String str, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(65538, null, str, i2, i3, i4) == null) {
            if (f71675a) {
                com.kwad.sdk.core.d.a.a("DownloadMonitor", "onProgressUpdate(), id=" + str + " progress=" + i2);
            }
            Intent intent = new Intent(a.f71613c);
            Bundle bundle = new Bundle();
            bundle.putString("RESULT_DOWNLOAD_ID", str);
            bundle.putInt("KEY_RESULT_PROGRESS", i2);
            bundle.putInt("KEY_RESULT_PROGRESS_SOFARBYTES", i3);
            bundle.putInt("KEY_RESULT_PROGRESS_TOTALBYTES", i4);
            intent.putExtras(bundle);
            Context context = KsAdSDKImpl.get().getContext();
            if (context != null) {
                context.sendBroadcast(intent, context.getPackageName() + ".permission.KW_SDK_BROADCAST");
            }
        }
    }

    public static void a(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(65539, null, str, i2, str2) == null) {
            if (f71675a) {
                com.kwad.sdk.core.d.a.a("DownloadMonitor", "onDownloadFail(), id=" + str + " error=" + i2);
            }
            Intent intent = new Intent(a.f71615e);
            Bundle bundle = new Bundle();
            bundle.putString("RESULT_DOWNLOAD_ID", str);
            bundle.putInt("KEY_RESULT_ERROR_CODE", i2);
            bundle.putString("KEY_RESULT_ERROR_MSG", str2);
            intent.putExtras(bundle);
            Context context = KsAdSDKImpl.get().getContext();
            if (context != null) {
                context.sendBroadcast(intent, context.getPackageName() + ".permission.KW_SDK_BROADCAST");
            }
        }
    }

    public static void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2) == null) {
            if (f71675a) {
                com.kwad.sdk.core.d.a.a("DownloadMonitor", "onDownloadFinished(), id=" + str);
            }
            Intent intent = new Intent(a.f71614d);
            Bundle bundle = new Bundle();
            bundle.putString("RESULT_DOWNLOAD_ID", str);
            bundle.putString("KEY_REUSLT_FILEPATH", str2);
            intent.putExtras(bundle);
            Context context = KsAdSDKImpl.get().getContext();
            if (context != null) {
                context.sendBroadcast(intent, context.getPackageName() + ".permission.KW_SDK_BROADCAST");
            }
        }
    }

    public static void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str) == null) {
            if (f71675a) {
                com.kwad.sdk.core.d.a.a("DownloadMonitor", "onDownloadPaused(), id=" + str);
            }
            Intent intent = new Intent(a.f71616f);
            Bundle bundle = new Bundle();
            bundle.putString("RESULT_DOWNLOAD_ID", str);
            intent.putExtras(bundle);
            Context context = KsAdSDKImpl.get().getContext();
            if (context != null) {
                context.sendBroadcast(intent, context.getPackageName() + ".permission.KW_SDK_BROADCAST");
            }
        }
    }

    public static void c(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, str) == null) {
            if (f71675a) {
                com.kwad.sdk.core.d.a.a("DownloadMonitor", "onDownloadResumed(), id=" + str);
            }
            Intent intent = new Intent(a.f71617g);
            Bundle bundle = new Bundle();
            bundle.putString("RESULT_DOWNLOAD_ID", str);
            intent.putExtras(bundle);
            Context context = KsAdSDKImpl.get().getContext();
            if (context != null) {
                context.sendBroadcast(intent, context.getPackageName() + ".permission.KW_SDK_BROADCAST");
            }
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, str) == null) {
            if (f71675a) {
                com.kwad.sdk.core.d.a.a("DownloadMonitor", "onDownloadCanceled(), id=" + str);
            }
            Intent intent = new Intent(a.f71618h);
            Bundle bundle = new Bundle();
            bundle.putString("RESULT_DOWNLOAD_ID", str);
            intent.putExtras(bundle);
            Context context = KsAdSDKImpl.get().getContext();
            if (context != null) {
                context.sendBroadcast(intent, context.getPackageName() + ".permission.KW_SDK_BROADCAST");
            }
        }
    }

    public static void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, str) == null) {
            if (f71675a) {
                com.kwad.sdk.core.d.a.a("DownloadMonitor", "onDownloadCanceled(), id=" + str);
            }
            Intent intent = new Intent(a.m);
            Bundle bundle = new Bundle();
            bundle.putString("RESULT_DOWNLOAD_ID", str);
            intent.putExtras(bundle);
            Context context = KsAdSDKImpl.get().getContext();
            if (context != null) {
                context.sendBroadcast(intent, context.getPackageName() + ".permission.KW_SDK_BROADCAST");
            }
        }
    }
}
