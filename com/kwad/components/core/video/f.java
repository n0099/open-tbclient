package com.kwad.components.core.video;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.core.diskcache.a.c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ab;
import java.io.File;
/* loaded from: classes7.dex */
public final class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(@NonNull String str, String str2, c.a aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, str, str2, aVar)) == null) {
            String dI = ab.dI(str2);
            long currentTimeMillis = System.currentTimeMillis();
            com.kwad.sdk.core.e.b.i("VideoCacheHelper", "start cache video key:" + dI + "--url:" + str);
            boolean b = com.kwad.sdk.core.diskcache.a.a.sS().b(str, str2, aVar);
            long currentTimeMillis2 = System.currentTimeMillis();
            com.kwad.sdk.core.e.b.i("VideoCacheHelper", "finish cache video key:" + dI + "--cache time:" + (currentTimeMillis2 - currentTimeMillis) + "--success:" + b);
            return b;
        }
        return invokeLLL.booleanValue;
    }

    public static boolean h(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, adTemplate)) == null) {
            File ad = com.kwad.sdk.core.diskcache.a.a.sS().ad(com.kwad.sdk.core.response.a.a.A(com.kwad.sdk.core.response.a.d.bQ(adTemplate)));
            return ad != null && ad.exists();
        }
        return invokeL.booleanValue;
    }
}
