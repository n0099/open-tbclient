package com.kwad.sdk.core.a;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.utils.as;
/* loaded from: classes2.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            Context context = KsAdSDKImpl.get().getContext();
            return context == null ? "" : as.a(context);
        }
        return (String) invokeV.objValue;
    }

    public static void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, context, str) == null) || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        as.g(context, str);
    }

    public static void a(String str) {
        Context context;
        com.kwad.sdk.plugin.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, str) == null) || (context = KsAdSDKImpl.get().getContext()) == null || (aVar = (com.kwad.sdk.plugin.a) com.kwad.sdk.plugin.f.a(com.kwad.sdk.plugin.a.class)) == null) {
            return;
        }
        aVar.a(context, str);
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            Context context = KsAdSDKImpl.get().getContext();
            return context == null ? "" : as.c(context);
        }
        return (String) invokeV.objValue;
    }
}
