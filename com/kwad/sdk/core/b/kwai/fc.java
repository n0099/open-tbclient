package com.kwad.sdk.core.b.kwai;

import com.baidu.ugc.editvideo.subtitle.SubtitleLog;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class fc implements com.kwad.sdk.core.d<AdMatrixInfo.SplashSlideInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(AdMatrixInfo.SplashSlideInfo splashSlideInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        splashSlideInfo.title = jSONObject.optString("title");
        if (jSONObject.opt("title") == JSONObject.NULL) {
            splashSlideInfo.title = "";
        }
        splashSlideInfo.subtitle = jSONObject.optString(SubtitleLog.TAG);
        if (jSONObject.opt(SubtitleLog.TAG) == JSONObject.NULL) {
            splashSlideInfo.subtitle = "";
        }
        splashSlideInfo.style = jSONObject.optInt("style");
        splashSlideInfo.convertDistance = jSONObject.optInt("convertDistance");
        AdMatrixInfo.DownloadTexts downloadTexts = new AdMatrixInfo.DownloadTexts();
        splashSlideInfo.downloadTexts = downloadTexts;
        downloadTexts.parseJson(jSONObject.optJSONObject("downloadTexts"));
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(AdMatrixInfo.SplashSlideInfo splashSlideInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "title", splashSlideInfo.title);
        com.kwad.sdk.utils.r.a(jSONObject, SubtitleLog.TAG, splashSlideInfo.subtitle);
        com.kwad.sdk.utils.r.a(jSONObject, "style", splashSlideInfo.style);
        com.kwad.sdk.utils.r.a(jSONObject, "convertDistance", splashSlideInfo.convertDistance);
        com.kwad.sdk.utils.r.a(jSONObject, "downloadTexts", splashSlideInfo.downloadTexts);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.SplashSlideInfo splashSlideInfo, JSONObject jSONObject) {
        a2(splashSlideInfo, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.SplashSlideInfo splashSlideInfo, JSONObject jSONObject) {
        return b2(splashSlideInfo, jSONObject);
    }
}
