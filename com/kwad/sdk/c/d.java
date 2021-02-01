package com.kwad.sdk.c;

import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d {
    public static c a(AdTemplate adTemplate, boolean z, JSONObject jSONObject) {
        if (com.kwad.sdk.core.response.b.c.C(adTemplate)) {
            return new a(jSONObject).a(z);
        }
        if (com.kwad.sdk.core.response.b.b.p(adTemplate)) {
            return new c(jSONObject);
        }
        return null;
    }
}
