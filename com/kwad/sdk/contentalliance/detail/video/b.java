package com.kwad.sdk.contentalliance.detail.video;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.CameraActivityConfig;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.m;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b {
    public long a;
    public long b;
    public long c;
    public int d;

    public b() {
        this.b = -1L;
    }

    public b(@NonNull AdTemplate adTemplate, long j) {
        this.b = -1L;
        this.a = com.kwad.sdk.core.response.a.d.p(adTemplate);
        this.b = j;
        this.c = com.kwad.sdk.core.response.a.d.t(adTemplate);
        this.d = com.kwad.sdk.core.response.a.d.f(adTemplate);
    }

    @NonNull
    public static b a(@NonNull AdTemplate adTemplate) {
        return new b(adTemplate, m.d(adTemplate));
    }

    public String a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CameraActivityConfig.KEY_CONTENT_TYPE, this.d);
            jSONObject.put("adStyle", this.c);
        } catch (JSONException e) {
            com.kwad.sdk.core.d.a.a(e);
        }
        return jSONObject.toString();
    }
}
