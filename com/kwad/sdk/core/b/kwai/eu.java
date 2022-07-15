package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class eu implements com.kwad.sdk.core.d<AdMatrixInfo.SplashActionBarInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(AdMatrixInfo.SplashActionBarInfo splashActionBarInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        splashActionBarInfo.title = jSONObject.optString("title");
        if (jSONObject.opt("title") == JSONObject.NULL) {
            splashActionBarInfo.title = "";
        }
        AdMatrixInfo.DownloadTexts downloadTexts = new AdMatrixInfo.DownloadTexts();
        splashActionBarInfo.downloadTexts = downloadTexts;
        downloadTexts.parseJson(jSONObject.optJSONObject("downloadTexts"));
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(AdMatrixInfo.SplashActionBarInfo splashActionBarInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "title", splashActionBarInfo.title);
        com.kwad.sdk.utils.r.a(jSONObject, "downloadTexts", splashActionBarInfo.downloadTexts);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.SplashActionBarInfo splashActionBarInfo, JSONObject jSONObject) {
        a2(splashActionBarInfo, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.SplashActionBarInfo splashActionBarInfo, JSONObject jSONObject) {
        return b2(splashActionBarInfo, jSONObject);
    }
}
