package com.kwad.sdk.commercial.f;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdTemplate;
@KsJson
/* loaded from: classes10.dex */
public class b extends com.kwad.sdk.commercial.d.a {
    public String anY;
    public String anZ;

    public static b zV() {
        return new b();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.commercial.d.a
    /* renamed from: bC */
    public final b setAdTemplate(AdTemplate adTemplate) {
        super.setAdTemplate(adTemplate);
        return this;
    }

    public final b cr(String str) {
        this.anY = str;
        return this;
    }

    public final b cs(String str) {
        this.anZ = str;
        return this;
    }
}
