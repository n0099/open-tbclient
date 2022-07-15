package com.kwad.components.ad.reward;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.components.core.page.DownloadLandPageActivity;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes5.dex */
public final class o {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(l lVar) {
        com.kwad.components.core.playable.a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, lVar) == null) {
            AdTemplate adTemplate = lVar.g;
            Context context = lVar.M;
            AdInfo i = com.kwad.sdk.core.response.a.d.i(adTemplate);
            if ((com.kwad.sdk.core.response.a.a.ar(i) && (aVar = lVar.l) != null && aVar.d()) || com.kwad.sdk.core.response.a.b.o(adTemplate) || com.kwad.components.ad.reward.kwai.b.d(i) || adTemplate.mXiaomiAppStoreDetailViewOpen || !com.kwad.sdk.core.response.a.a.I(i) || !com.kwad.sdk.core.response.a.a.x(i) || adTemplate.hasEnterAdWebViewLandPageActivity) {
                return;
            }
            lVar.g.hasEnterAdWebViewLandPageActivity = true;
            DownloadLandPageActivity.launch(context, adTemplate, true);
        }
    }
}
