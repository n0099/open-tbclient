package com.kwad.sdk.contentalliance.a.a;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.CameraActivityConfig;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.l;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class a {
    public long adStyle;
    public long clickTime;
    public int contentType;
    public long photoId;

    public a() {
        this.clickTime = -1L;
    }

    public final String Ag() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CameraActivityConfig.KEY_CONTENT_TYPE, this.contentType);
            jSONObject.put("adStyle", this.adStyle);
        } catch (JSONException e) {
            c.printStackTrace(e);
        }
        return jSONObject.toString();
    }

    public a(@NonNull AdTemplate adTemplate, long j) {
        this.clickTime = -1L;
        this.photoId = e.dV(adTemplate);
        this.clickTime = j;
        this.adStyle = e.dK(adTemplate);
        this.contentType = e.dL(adTemplate);
    }

    @NonNull
    public static a bE(@NonNull AdTemplate adTemplate) {
        return new a(adTemplate, l.el(adTemplate));
    }
}
