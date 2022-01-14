package com.kwad.sdk.contentalliance.detail.video;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.m;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {
    public long a;

    /* renamed from: b  reason: collision with root package name */
    public long f55577b;

    /* renamed from: c  reason: collision with root package name */
    public long f55578c;

    /* renamed from: d  reason: collision with root package name */
    public int f55579d;

    public b() {
        this.f55577b = -1L;
    }

    public b(@NonNull AdTemplate adTemplate, long j2) {
        this.f55577b = -1L;
        this.a = com.kwad.sdk.core.response.a.d.p(adTemplate);
        this.f55577b = j2;
        this.f55578c = com.kwad.sdk.core.response.a.d.t(adTemplate);
        this.f55579d = com.kwad.sdk.core.response.a.d.f(adTemplate);
    }

    @NonNull
    public static b a(@NonNull AdTemplate adTemplate) {
        return new b(adTemplate, m.d(adTemplate));
    }

    public String a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("contentType", this.f55579d);
            jSONObject.put("adStyle", this.f55578c);
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
        return jSONObject.toString();
    }
}
