package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class ac implements com.kwad.sdk.core.d<AdInfo.AdTrackInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(AdInfo.AdTrackInfo adTrackInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adTrackInfo.type = jSONObject.optInt("type");
        adTrackInfo.urls = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("url");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                adTrackInfo.urls.add((String) optJSONArray.opt(i));
            }
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(AdInfo.AdTrackInfo adTrackInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = adTrackInfo.type;
        if (i != 0) {
            com.kwad.sdk.utils.r.putValue(jSONObject, "type", i);
        }
        com.kwad.sdk.utils.r.putValue(jSONObject, "url", adTrackInfo.urls);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdInfo.AdTrackInfo adTrackInfo, JSONObject jSONObject) {
        a2(adTrackInfo, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdInfo.AdTrackInfo adTrackInfo, JSONObject jSONObject) {
        return b2(adTrackInfo, jSONObject);
    }
}
