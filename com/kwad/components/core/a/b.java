package com.kwad.components.core.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.components.DevelopMangerComponents;
/* loaded from: classes5.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, eVar) == null) {
            int a = eVar.a();
            a("使用缓存策略: " + a);
        }
    }

    public static void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, str) == null) {
            DevelopMangerComponents developMangerComponents = (DevelopMangerComponents) com.kwad.sdk.components.c.a(DevelopMangerComponents.class);
        }
    }
}
