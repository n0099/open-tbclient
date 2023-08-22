package com.kwad.sdk.core.b.kwai;

import com.baidu.tieba.im.dispatcher.AiBotChatDispatcher;
import com.kwad.sdk.core.response.model.TemplateConfig;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class fq implements com.kwad.sdk.core.d<TemplateConfig> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(TemplateConfig templateConfig, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        templateConfig.h5Url = jSONObject.optString(AiBotChatDispatcher.AI_SINGLE_H5_URL);
        if (jSONObject.opt(AiBotChatDispatcher.AI_SINGLE_H5_URL) == JSONObject.NULL) {
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
        String str = templateConfig.h5Url;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, AiBotChatDispatcher.AI_SINGLE_H5_URL, templateConfig.h5Url);
        }
        String str2 = templateConfig.h5Version;
        if (str2 != null && !str2.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "h5Version", templateConfig.h5Version);
        }
        String str3 = templateConfig.h5Checksum;
        if (str3 != null && !str3.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "h5Checksum", templateConfig.h5Checksum);
        }
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
