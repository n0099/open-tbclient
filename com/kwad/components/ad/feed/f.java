package com.kwad.components.ad.feed;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes8.dex */
public final class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String d(@NonNull AdTemplate adTemplate) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, adTemplate)) == null) {
            String ad = com.kwad.sdk.core.response.a.a.ad(com.kwad.sdk.core.response.a.d.bQ(adTemplate));
            if (com.kwad.components.core.a.b.lR()) {
                String str = adTemplate.fromCache ? "【cache】" : "";
                return str + ad;
            }
            return ad;
        }
        return (String) invokeL.objValue;
    }
}
