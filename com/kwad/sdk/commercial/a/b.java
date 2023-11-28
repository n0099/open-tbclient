package com.kwad.sdk.commercial.a;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.model.AdTemplate;
@KsJson
/* loaded from: classes10.dex */
public class b extends com.kwad.sdk.commercial.d.a {
    public String anD;
    public int anE;
    public int status;

    public static b zQ() {
        return new b();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.commercial.d.a
    /* renamed from: aU */
    public final b setAdTemplate(AdTemplate adTemplate) {
        super.setAdTemplate(adTemplate);
        return this;
    }

    public final b bV(int i) {
        this.status = i;
        return this;
    }

    public final b bW(int i) {
        this.anE = i;
        return this;
    }

    public final b cn(String str) {
        this.anD = str;
        return this;
    }
}
