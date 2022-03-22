package com.kwad.sdk.reward;

import android.content.Context;
import com.kwad.sdk.core.page.AdWebViewLandPageActivityProxy;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
/* loaded from: classes7.dex */
public class k {
    public static void a(a aVar) {
        com.kwad.sdk.widget.e eVar;
        AdTemplate adTemplate = aVar.f40747g;
        Context context = aVar.i;
        AdInfo j = com.kwad.sdk.core.response.a.d.j(adTemplate);
        if ((com.kwad.sdk.core.response.a.a.an(j) && (eVar = aVar.m) != null && eVar.e()) || com.kwad.sdk.core.response.a.b.j(adTemplate) || com.kwad.sdk.core.response.a.a.aG(j) || adTemplate.mXiaomiAppStoreDetailViewOpen || !com.kwad.sdk.core.response.a.a.B(j) || !com.kwad.sdk.core.response.a.a.r(j)) {
            return;
        }
        AdWebViewLandPageActivityProxy.launch(context, adTemplate, true);
    }
}
