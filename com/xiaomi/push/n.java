package com.xiaomi.push;

import android.content.Context;
import android.preference.PreferenceManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Map;
/* loaded from: classes8.dex */
public abstract class n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, context) == null) {
        }
    }

    public static void a(Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(65537, null, context, str, z) == null) {
            a(context);
            PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean(str, z).commit();
        }
    }

    public static void a(Map<String, String> map, String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65538, null, map, str, str2) == null) || map == null || str == null || str2 == null) {
            return;
        }
        map.put(str, str2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m569a(Context context, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65539, null, context, str, z)) == null) {
            a(context);
            return PreferenceManager.getDefaultSharedPreferences(context).getBoolean(str, z);
        }
        return invokeLLZ.booleanValue;
    }
}
