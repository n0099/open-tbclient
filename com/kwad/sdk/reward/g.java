package com.kwad.sdk.reward;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.core.diskcache.b.c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.w;
import java.io.File;
/* loaded from: classes10.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, adTemplate)) == null) {
            if (b(adTemplate)) {
                return true;
            }
            String a2 = com.kwad.sdk.core.response.b.a.a(com.kwad.sdk.core.response.b.c.i(adTemplate));
            String a3 = w.a(a2);
            long currentTimeMillis = System.currentTimeMillis();
            com.kwad.sdk.core.d.a.c("VideoCacheHelper", "start cache video key:" + a3 + "--url:" + a2);
            c.a aVar = new c.a();
            boolean a4 = com.kwad.sdk.core.diskcache.b.a.a().a(a2, aVar);
            long currentTimeMillis2 = System.currentTimeMillis();
            com.kwad.sdk.core.d.a.c("VideoCacheHelper", "finish cache video key:" + a3 + "--cache time:" + (currentTimeMillis2 - currentTimeMillis) + "--success:" + a4);
            if (a4) {
                com.kwad.sdk.core.report.d.a(adTemplate, 1);
            } else {
                com.kwad.sdk.core.report.d.a(adTemplate, 1, aVar.f71207a);
            }
            return a4;
        }
        return invokeL.booleanValue;
    }

    public static boolean a(@NonNull String str, String str2, c.a aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, str, str2, aVar)) == null) {
            String a2 = w.a(str2);
            long currentTimeMillis = System.currentTimeMillis();
            com.kwad.sdk.core.d.a.c("VideoCacheHelper", "start cache video key:" + a2 + "--url:" + str);
            boolean a3 = com.kwad.sdk.core.diskcache.b.a.a().a(str, str2, aVar);
            long currentTimeMillis2 = System.currentTimeMillis();
            com.kwad.sdk.core.d.a.c("VideoCacheHelper", "finish cache video key:" + a2 + "--cache time:" + (currentTimeMillis2 - currentTimeMillis) + "--success:" + a3);
            return a3;
        }
        return invokeLLL.booleanValue;
    }

    public static boolean b(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, adTemplate)) == null) {
            File b2 = com.kwad.sdk.core.diskcache.b.a.a().b(com.kwad.sdk.core.response.b.a.a(com.kwad.sdk.core.response.b.c.i(adTemplate)));
            return b2 != null && b2.exists();
        }
        return invokeL.booleanValue;
    }
}
