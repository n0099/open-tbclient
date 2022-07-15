package com.kwad.components.ad.reward.presenter;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes5.dex */
public final class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(com.kwad.components.ad.reward.l lVar) {
        InterceptResult invokeL;
        com.kwad.components.core.playable.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, lVar)) == null) {
            AdTemplate adTemplate = lVar.g;
            AdInfo i = com.kwad.sdk.core.response.a.d.i(adTemplate);
            return ((com.kwad.sdk.core.response.a.a.ar(i) && (aVar = lVar.l) != null && aVar.d()) || com.kwad.sdk.core.response.a.b.o(adTemplate) || com.kwad.components.ad.reward.kwai.b.d(i) || adTemplate.mXiaomiAppStoreDetailViewOpen || !com.kwad.sdk.core.response.a.a.I(i) || !com.kwad.sdk.core.response.a.a.x(i)) ? false : true;
        }
        return invokeL.booleanValue;
    }
}
