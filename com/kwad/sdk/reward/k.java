package com.kwad.sdk.reward;

import android.content.Context;
import com.kwad.sdk.core.page.AdWebViewLandPageActivityProxy;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes4.dex */
public class k {
    public static void a(a aVar) {
        com.kwad.sdk.widget.e eVar;
        AdTemplate adTemplate = aVar.f57419g;
        Context context = aVar.f57421i;
        AdInfo j2 = com.kwad.sdk.core.response.a.d.j(adTemplate);
        if ((com.kwad.sdk.core.response.a.a.an(j2) && (eVar = aVar.m) != null && eVar.e()) || com.kwad.sdk.core.response.a.b.j(adTemplate) || com.kwad.sdk.core.response.a.a.aG(j2) || adTemplate.mXiaomiAppStoreDetailViewOpen || !com.kwad.sdk.core.response.a.a.B(j2) || !com.kwad.sdk.core.response.a.a.r(j2)) {
            return;
        }
        AdWebViewLandPageActivityProxy.launch(context, adTemplate, true);
    }
}
