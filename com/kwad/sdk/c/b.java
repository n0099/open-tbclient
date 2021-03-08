package com.kwad.sdk.c;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends c {
    private String b;

    public b(@Nullable JSONObject jSONObject) {
        super(jSONObject);
    }

    @Override // com.kwad.sdk.c.c
    protected String a(AdTemplate adTemplate) {
        return this.b;
    }

    public void a(String str) {
        this.b = str;
    }
}
