package com.kwad.sdk.c;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdTemplate;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b extends c {

    /* renamed from: c  reason: collision with root package name */
    public String f32663c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f32664d;

    public b(@Nullable JSONObject jSONObject) {
        super(jSONObject);
        this.f32664d = false;
    }

    @Override // com.kwad.sdk.c.c
    public String a(AdTemplate adTemplate) {
        return this.f32663c;
    }

    public void a(String str) {
        this.f32663c = str;
    }

    public void a(boolean z) {
        this.f32664d = z;
    }

    @Override // com.kwad.sdk.c.c
    public boolean a() {
        return this.f32664d ? this.f32666b : super.a();
    }
}
