package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class ca implements com.kwad.sdk.core.d<AdStyleInfo.FeedAdInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(AdStyleInfo.FeedAdInfo feedAdInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        feedAdInfo.templateConfig = jSONObject.optString("templateConfig");
        if (jSONObject.opt("templateConfig") == JSONObject.NULL) {
            feedAdInfo.templateConfig = "";
        }
        feedAdInfo.heightRatio = jSONObject.optDouble("heightRatio");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(AdStyleInfo.FeedAdInfo feedAdInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String str = feedAdInfo.templateConfig;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "templateConfig", feedAdInfo.templateConfig);
        }
        double d = feedAdInfo.heightRatio;
        if (d != 0.0d) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "heightRatio", d);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdStyleInfo.FeedAdInfo feedAdInfo, JSONObject jSONObject) {
        a2(feedAdInfo, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdStyleInfo.FeedAdInfo feedAdInfo, JSONObject jSONObject) {
        return b2(feedAdInfo, jSONObject);
    }
}
