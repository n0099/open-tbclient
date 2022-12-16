package com.kwad.components.ad.reward.presenter;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes8.dex */
public final class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean r(com.kwad.components.ad.reward.k kVar) {
        InterceptResult invokeL;
        com.kwad.components.core.playable.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, kVar)) == null) {
            AdTemplate adTemplate = kVar.mAdTemplate;
            AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
            if ((com.kwad.sdk.core.response.a.a.aY(bQ) && (aVar = kVar.mk) != null && aVar.od()) || com.kwad.sdk.core.response.a.b.bg(adTemplate) || com.kwad.components.ad.reward.kwai.b.j(bQ) || adTemplate.mXiaomiAppStoreDetailViewOpen) {
                return false;
            }
            if (com.kwad.components.ad.reward.kwai.b.gh()) {
                return true;
            }
            return com.kwad.sdk.core.response.a.a.am(bQ) && com.kwad.sdk.core.response.a.a.aa(bQ);
        }
        return invokeL.booleanValue;
    }
}
