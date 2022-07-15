package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.PageInfo;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class dr implements com.kwad.sdk.core.d<PageInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(PageInfo pageInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        pageInfo.pageType = jSONObject.optInt("pageType");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(PageInfo pageInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "pageType", pageInfo.pageType);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(PageInfo pageInfo, JSONObject jSONObject) {
        a2(pageInfo, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(PageInfo pageInfo, JSONObject jSONObject) {
        return b2(pageInfo, jSONObject);
    }
}
