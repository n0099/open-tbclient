package com.kwad.sdk.reward;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.kwad.sdk.core.page.AdWebViewLandPageActivityProxy;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes2.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(a aVar) {
        com.kwad.sdk.widget.e eVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, aVar) == null) {
            AdTemplate adTemplate = aVar.f58874g;
            Context context = aVar.f58876i;
            AdInfo j2 = com.kwad.sdk.core.response.a.d.j(adTemplate);
            if ((com.kwad.sdk.core.response.a.a.an(j2) && (eVar = aVar.m) != null && eVar.e()) || com.kwad.sdk.core.response.a.b.j(adTemplate) || com.kwad.sdk.core.response.a.a.aG(j2) || adTemplate.mXiaomiAppStoreDetailViewOpen || !com.kwad.sdk.core.response.a.a.B(j2) || !com.kwad.sdk.core.response.a.a.r(j2)) {
                return;
            }
            AdWebViewLandPageActivityProxy.launch(context, adTemplate, true);
        }
    }
}
