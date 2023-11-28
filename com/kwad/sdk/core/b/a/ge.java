package com.kwad.sdk.core.b.a;

import com.kwad.components.ad.feed.monitor.FeedPageInfo;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class ge implements com.kwad.sdk.core.d<FeedPageInfo.a> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(FeedPageInfo.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        aVar.materialType = jSONObject.optInt("material_type");
        aVar.materialUrl = jSONObject.optString("material_url");
        if (JSONObject.NULL.toString().equals(aVar.materialUrl)) {
            aVar.materialUrl = "";
        }
        aVar.creativeId = jSONObject.optLong("creative_id");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(FeedPageInfo.a aVar, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        int i = aVar.materialType;
        if (i != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "material_type", i);
        }
        String str = aVar.materialUrl;
        if (str != null && !str.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "material_url", aVar.materialUrl);
        }
        long j = aVar.creativeId;
        if (j != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject, "creative_id", j);
        }
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(FeedPageInfo.a aVar, JSONObject jSONObject) {
        a2(aVar, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(FeedPageInfo.a aVar, JSONObject jSONObject) {
        return b2(aVar, jSONObject);
    }
}
