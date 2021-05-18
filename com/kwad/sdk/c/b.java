package com.kwad.sdk.c;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b extends c {

    /* renamed from: c  reason: collision with root package name */
    public String f31908c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f31909d;

    public b(@Nullable JSONObject jSONObject) {
        super(jSONObject);
        this.f31909d = false;
    }

    @Override // com.kwad.sdk.c.c
    public String a(AdTemplate adTemplate) {
        return this.f31908c;
    }

    public void a(String str) {
        this.f31908c = str;
    }

    public void a(boolean z) {
        this.f31909d = z;
    }

    @Override // com.kwad.sdk.c.c
    public boolean a() {
        return this.f31909d ? this.f31911b : super.a();
    }
}
