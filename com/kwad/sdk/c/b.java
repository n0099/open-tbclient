package com.kwad.sdk.c;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b extends c {

    /* renamed from: b  reason: collision with root package name */
    private String f8551b;

    public b(@Nullable JSONObject jSONObject) {
        super(jSONObject);
    }

    @Override // com.kwad.sdk.c.c
    protected String a(AdTemplate adTemplate) {
        return this.f8551b;
    }

    public void a(String str) {
        this.f8551b = str;
    }
}
