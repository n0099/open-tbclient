package com.yxcorp.kuaishou.addfp.android.b;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(65536, null, z)) == null) ? new c(com.kwad.sdk.c.b.xm().xb()).a(z) : (String) invokeZ.objValue;
    }

    public static String b(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(65537, null, z)) == null) ? new c(com.kwad.sdk.c.b.xm().xa()).a(z) : (String) invokeZ.objValue;
    }

    public static String c(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(65538, null, z)) == null) ? new c(com.kwad.sdk.c.b.xm().xc()).a(z) : (String) invokeZ.objValue;
    }

    public static String d(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(65539, null, z)) == null) ? new c(com.kwad.sdk.c.b.xm().getOaid()).a(z) : (String) invokeZ.objValue;
    }

    public static String e(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeZ = interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, null, z)) == null) ? new c(com.kwad.sdk.c.b.xm().getIccId()).a(z) : (String) invokeZ.objValue;
    }
}
