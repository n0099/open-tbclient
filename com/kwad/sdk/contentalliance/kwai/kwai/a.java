package com.kwad.sdk.contentalliance.kwai.kwai;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.CameraActivityConfig;
import com.kwad.sdk.core.response.a.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.k;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class a {
    public long adStyle;
    public long clickTime;
    public int contentType;
    public long photoId;

    public a() {
        this.clickTime = -1L;
    }

    public a(@NonNull AdTemplate adTemplate, long j) {
        this.clickTime = -1L;
        this.photoId = d.bV(adTemplate);
        this.clickTime = j;
        this.adStyle = d.bL(adTemplate);
        this.contentType = d.bM(adTemplate);
    }

    @NonNull
    public static a al(@NonNull AdTemplate adTemplate) {
        return new a(adTemplate, k.ck(adTemplate));
    }

    public final String rB() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(CameraActivityConfig.KEY_CONTENT_TYPE, this.contentType);
            jSONObject.put("adStyle", this.adStyle);
        } catch (JSONException e) {
            com.kwad.sdk.core.e.b.printStackTrace(e);
        }
        return jSONObject.toString();
    }
}
