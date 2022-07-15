package com.kwad.components.core.video;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.diskcache.a.c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.z;
import java.io.File;
/* loaded from: classes5.dex */
public final class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, adTemplate)) == null) {
            File b = com.kwad.sdk.core.diskcache.a.a.a().b(com.kwad.sdk.core.response.a.a.b(com.kwad.sdk.core.response.a.d.i(adTemplate)));
            return b != null && b.exists();
        }
        return invokeL.booleanValue;
    }

    public static boolean a(@NonNull AdTemplate adTemplate, int i) {
        InterceptResult invokeLI;
        boolean a;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, adTemplate, i)) == null) {
            String b = com.kwad.sdk.core.response.a.a.b(com.kwad.sdk.core.response.a.d.i(adTemplate));
            if (TextUtils.isEmpty(b)) {
                return false;
            }
            c.a aVar = new c.a();
            if (i < 0) {
                if (a(adTemplate)) {
                    return true;
                }
                a = com.kwad.sdk.core.diskcache.a.a.a().a(b, aVar);
            } else if (i <= 0) {
                return true;
            } else {
                a = com.kwad.sdk.core.videocache.b.a.a(KsAdSDKImpl.get().getContext()).a(b, i * 1024);
            }
            com.kwad.components.core.i.a a2 = com.kwad.components.core.i.a.a();
            if (a) {
                a2.a(adTemplate, 1);
            } else {
                a2.a(adTemplate, 1, aVar.a);
            }
            return a;
        }
        return invokeLI.booleanValue;
    }

    public static boolean a(@NonNull String str, String str2, c.a aVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, str, str2, aVar)) == null) {
            String a = z.a(str2);
            long currentTimeMillis = System.currentTimeMillis();
            com.kwad.sdk.core.d.b.c("VideoCacheHelper", "start cache video key:" + a + "--url:" + str);
            boolean a2 = com.kwad.sdk.core.diskcache.a.a.a().a(str, str2, aVar);
            long currentTimeMillis2 = System.currentTimeMillis();
            com.kwad.sdk.core.d.b.c("VideoCacheHelper", "finish cache video key:" + a + "--cache time:" + (currentTimeMillis2 - currentTimeMillis) + "--success:" + a2);
            return a2;
        }
        return invokeLLL.booleanValue;
    }
}
