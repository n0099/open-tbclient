package com.kwad.sdk.contentalliance.detail.video;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.m;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public long f55789b;

    /* renamed from: c  reason: collision with root package name */
    public long f55790c;

    /* renamed from: d  reason: collision with root package name */
    public int f55791d;

    public b() {
        this.f55789b = -1L;
    }

    public b(@NonNull AdTemplate adTemplate, long j2) {
        this.f55789b = -1L;
        this.a = com.kwad.sdk.core.response.a.d.p(adTemplate);
        this.f55789b = j2;
        this.f55790c = com.kwad.sdk.core.response.a.d.t(adTemplate);
        this.f55791d = com.kwad.sdk.core.response.a.d.f(adTemplate);
    }

    @NonNull
    public static b a(@NonNull AdTemplate adTemplate) {
        return new b(adTemplate, m.d(adTemplate));
    }

    public String a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("contentType", this.f55791d);
            jSONObject.put("adStyle", this.f55790c);
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
        return jSONObject.toString();
    }
}
