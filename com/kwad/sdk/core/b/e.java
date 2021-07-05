package com.kwad.sdk.core.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.utils.ae;
/* loaded from: classes7.dex */
public final class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            Context context = KsAdSDKImpl.get().getContext();
            return context == null ? "" : ae.e(context);
        }
        return (String) invokeV.objValue;
    }

    public static void a(Context context, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, context, str) == null) || context == null || TextUtils.isEmpty(str)) {
            return;
        }
        ae.e(context, str);
    }

    public static void a(String str) {
        Context context;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, str) == null) || (context = KsAdSDKImpl.get().getContext()) == null) {
            return;
        }
        if (com.kwad.sdk.d.f37023a == 1) {
            com.kwad.sdk.plugin.a aVar = (com.kwad.sdk.plugin.a) com.kwad.sdk.plugin.g.a(com.kwad.sdk.plugin.a.class);
            if (aVar != null) {
                aVar.a(context, str);
                return;
            }
            return;
        }
        com.kwad.sdk.plugin.b bVar = (com.kwad.sdk.plugin.b) com.kwad.sdk.plugin.g.a(com.kwad.sdk.plugin.b.class);
        if (bVar != null) {
            bVar.a(context, str);
        }
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            Context context = KsAdSDKImpl.get().getContext();
            return context == null ? "" : ae.f(context);
        }
        return (String) invokeV.objValue;
    }
}
