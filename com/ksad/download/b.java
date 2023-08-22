package com.ksad.download;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes10.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public static boolean aa;
    public static Context ab;
    public static File ac;
    public static a ad;
    public transient /* synthetic */ FieldHolder $fh;

    public static void D(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, context) == null) {
            ab = context.getApplicationContext();
        }
    }

    public static File M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? ac : (File) invokeV.objValue;
    }

    public static void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, aVar) == null) {
            ad = aVar;
        }
    }

    public static void b(DownloadTask downloadTask, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, downloadTask, str) == null) {
            ad.a(downloadTask, str);
        }
    }

    public static void b(File file) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, file) == null) {
            ac = file;
        }
    }

    public static Context getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) ? ab : (Context) invokeV.objValue;
    }
}
