package com.kwad.sdk.contentalliance.kwai.kwai;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.CameraActivityConfig;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class a {
    public long a;
    public long b;
    public long c;
    public int d;

    public a() {
        this.b = -1L;
    }

    public a(@NonNull AdTemplate adTemplate, long j) {
        this.b = -1L;
        this.a = d.n(adTemplate);
        this.b = j;
        this.c = d.d(adTemplate);
        this.d = d.e(adTemplate);
    }

    @NonNull
    public static a a(@NonNull AdTemplate adTemplate) {
        return new a(adTemplate, k.d(adTemplate));
    }

    public final String a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CameraActivityConfig.KEY_CONTENT_TYPE, this.d);
            jSONObject.put("adStyle", this.c);
        } catch (JSONException e) {
            com.kwad.sdk.core.d.b.a(e);
        }
        return jSONObject.toString();
    }
}
