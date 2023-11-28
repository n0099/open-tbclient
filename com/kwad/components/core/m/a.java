package com.kwad.components.core.m;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ay;
import com.kwad.sdk.utils.g;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a extends l<com.kwad.components.core.request.a, AdResultData> {
    public ImpInfo Mp;

    public a(ImpInfo impInfo) {
        this.Mp = impInfo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.sdk.core.network.l
    /* renamed from: j */
    public void afterParseData(AdResultData adResultData) {
        super.afterParseData(adResultData);
        k(adResultData);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.network.l
    @NonNull
    /* renamed from: Z */
    public AdResultData parseData(String str) {
        JSONObject jSONObject = new JSONObject(str);
        AdResultData adResultData = new AdResultData(this.Mp.adScene);
        adResultData.parseJson(jSONObject);
        return adResultData;
    }

    private void k(final AdResultData adResultData) {
        g.execute(new ay() { // from class: com.kwad.components.core.m.a.1
            @Override // com.kwad.sdk.utils.ay
            public final void doTask() {
                JSONObject json;
                AdResultData adResultData2 = adResultData;
                if (adResultData2 != null && (json = adResultData2.toJson()) != null) {
                    c.i("AdNetworking", "ad result: " + json);
                }
            }
        });
        for (AdTemplate adTemplate : adResultData.getProceedTemplateList()) {
            AdInfo dP = e.dP(adTemplate);
            if (com.kwad.sdk.core.response.b.a.bd(dP)) {
                if (com.kwad.sdk.core.response.b.a.ba(dP).size() == 0) {
                    com.kwad.components.core.o.a.pX().f(adTemplate, 21005);
                }
            } else if (com.kwad.sdk.core.response.b.a.bh(dP) && TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.K(dP))) {
                com.kwad.components.core.o.a.pX().f(adTemplate, 21006);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.network.a
    @NonNull
    /* renamed from: mt */
    public com.kwad.components.core.request.a createRequest() {
        return new com.kwad.components.core.request.a(this.Mp);
    }
}
