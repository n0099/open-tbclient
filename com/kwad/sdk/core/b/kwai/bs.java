package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class bs implements com.kwad.sdk.core.d<AdStyleInfo.PlayDetailInfo.DrawAdInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(AdStyleInfo.PlayDetailInfo.DrawAdInfo drawAdInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        drawAdInfo.forcedWatch = jSONObject.optBoolean("forcedWatch");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(AdStyleInfo.PlayDetailInfo.DrawAdInfo drawAdInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "forcedWatch", drawAdInfo.forcedWatch);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdStyleInfo.PlayDetailInfo.DrawAdInfo drawAdInfo, JSONObject jSONObject) {
        a2(drawAdInfo, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdStyleInfo.PlayDetailInfo.DrawAdInfo drawAdInfo, JSONObject jSONObject) {
        return b2(drawAdInfo, jSONObject);
    }
}
