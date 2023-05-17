package com.huawei.hms.hatool;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.LinkedHashMap;
/* loaded from: classes9.dex */
public abstract class l1 {
    public static /* synthetic */ Interceptable $ic;
    public static j1 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized j1 a() {
        InterceptResult invokeV;
        j1 j1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (l1.class) {
                if (a == null) {
                    a = o1.c().b();
                }
                j1Var = a;
            }
            return j1Var;
        }
        return (j1) invokeV.objValue;
    }

    public static void a(int i, String str, LinkedHashMap<String, String> linkedHashMap) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeILL(65537, null, i, str, linkedHashMap) == null) && a() != null && w0.b().a()) {
            if (i == 1 || i == 0) {
                a.a(i, str, linkedHashMap);
                return;
            }
            y.d("hmsSdk", "Data type no longer collects range.type: " + i);
        }
    }

    @Deprecated
    public static void a(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, context, str, str2) == null) || a() == null) {
            return;
        }
        a.a(context, str, str2);
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? o1.c().a() : invokeV.booleanValue;
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) && a() != null && w0.b().a()) {
            a.a(-1);
        }
    }
}
