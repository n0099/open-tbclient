package com.kwad.components.ad.reward;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.components.core.page.DownloadLandPageActivity;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes8.dex */
public final class n {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void g(k kVar) {
        com.kwad.components.core.playable.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, kVar) == null) {
            AdTemplate adTemplate = kVar.mAdTemplate;
            Context context = kVar.mContext;
            AdInfo bQ = com.kwad.sdk.core.response.a.d.bQ(adTemplate);
            if ((com.kwad.sdk.core.response.a.a.aY(bQ) && (aVar = kVar.mk) != null && aVar.od()) || com.kwad.sdk.core.response.a.b.bg(adTemplate) || com.kwad.components.ad.reward.kwai.b.j(bQ) || adTemplate.mXiaomiAppStoreDetailViewOpen || !com.kwad.sdk.core.response.a.a.am(bQ) || !com.kwad.sdk.core.response.a.a.aa(bQ) || adTemplate.hasEnterAdWebViewLandPageActivity) {
                return;
            }
            kVar.mAdTemplate.hasEnterAdWebViewLandPageActivity = true;
            DownloadLandPageActivity.launch(context, adTemplate, true);
        }
    }
}
