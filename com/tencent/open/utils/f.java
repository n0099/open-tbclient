package com.tencent.open.utils;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes8.dex */
public final class f {
    public static /* synthetic */ Interceptable $ic;
    public static Context a;
    public transient /* synthetic */ FieldHolder $fh;

    public static final Context a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            Context context = a;
            if (context == null) {
                return null;
            }
            return context;
        }
        return (Context) invokeV.objValue;
    }

    public static final String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (a() == null) {
                return "";
            }
            return a().getPackageName();
        }
        return (String) invokeV.objValue;
    }

    public static final File c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (a() == null) {
                return null;
            }
            return a().getFilesDir();
        }
        return (File) invokeV.objValue;
    }

    public static final File d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            Context a2 = a();
            if (a2 != null) {
                return a2.getCacheDir();
            }
            return null;
        }
        return (File) invokeV.objValue;
    }

    public static final File e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return a((String) null);
        }
        return (File) invokeV.objValue;
    }

    public static final File a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            return l.h(a(), str);
        }
        return (File) invokeL.objValue;
    }

    public static final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, context) == null) {
            a = context;
        }
    }
}
