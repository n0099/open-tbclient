package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.TemplateConfig;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class fi implements com.kwad.sdk.core.d<TemplateConfig> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(TemplateConfig templateConfig, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        templateConfig.h5Url = jSONObject.optString("h5Url");
        if (jSONObject.opt("h5Url") == JSONObject.NULL) {
            templateConfig.h5Url = "";
        }
        templateConfig.h5Version = jSONObject.optString("h5Version");
        if (jSONObject.opt("h5Version") == JSONObject.NULL) {
            templateConfig.h5Version = "";
        }
        templateConfig.h5Checksum = jSONObject.optString("h5Checksum");
        if (jSONObject.opt("h5Checksum") == JSONObject.NULL) {
            templateConfig.h5Checksum = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(TemplateConfig templateConfig, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "h5Url", templateConfig.h5Url);
        com.kwad.sdk.utils.r.a(jSONObject, "h5Version", templateConfig.h5Version);
        com.kwad.sdk.utils.r.a(jSONObject, "h5Checksum", templateConfig.h5Checksum);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(TemplateConfig templateConfig, JSONObject jSONObject) {
        a2(templateConfig, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(TemplateConfig templateConfig, JSONObject jSONObject) {
        return b2(templateConfig, jSONObject);
    }
}
