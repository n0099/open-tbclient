package com.kwad.components.core.h;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.components.core.k.kwai.b;
import com.kwad.components.core.response.model.AdResultData;
import com.kwad.sdk.core.network.m;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a extends m<com.kwad.components.core.k.a, AdResultData> {
    public b EI;

    public a(b bVar) {
        this.EI = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.m
    /* renamed from: d */
    public void afterParseData(AdResultData adResultData) {
        super.afterParseData(adResultData);
        e(adResultData);
    }

    public static void e(AdResultData adResultData) {
        com.kwad.components.core.j.a og;
        int i;
        for (AdTemplate adTemplate : adResultData.getProceedTemplateList()) {
            AdInfo bQ = d.bQ(adTemplate);
            if (com.kwad.sdk.core.response.a.a.aC(bQ)) {
                if (com.kwad.sdk.core.response.a.a.aA(bQ).size() == 0) {
                    og = com.kwad.components.core.j.a.og();
                    i = 21005;
                    og.e(adTemplate, i);
                }
            } else if (com.kwad.sdk.core.response.a.a.aE(bQ) && TextUtils.isEmpty(com.kwad.sdk.core.response.a.a.A(bQ))) {
                og = com.kwad.components.core.j.a.og();
                i = 21006;
                og.e(adTemplate, i);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.network.m
    @NonNull
    /* renamed from: ah */
    public AdResultData parseData(String str) {
        JSONObject jSONObject = new JSONObject(str);
        AdResultData adResultData = new AdResultData(this.EI.HS);
        adResultData.parseJson(jSONObject);
        return adResultData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.network.a
    @NonNull
    /* renamed from: fe */
    public com.kwad.components.core.k.a createRequest() {
        return new com.kwad.components.core.k.a(this.EI);
    }
}
