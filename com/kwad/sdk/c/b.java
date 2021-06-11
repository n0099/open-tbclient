package com.kwad.sdk.c;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b extends c {

    /* renamed from: b  reason: collision with root package name */
    public String f32409b;

    public b(@Nullable JSONObject jSONObject) {
        super(jSONObject);
    }

    @Override // com.kwad.sdk.c.c
    public String a(AdTemplate adTemplate) {
        return this.f32409b;
    }

    public void a(String str) {
        this.f32409b = str;
    }
}
