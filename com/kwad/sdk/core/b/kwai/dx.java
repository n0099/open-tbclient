package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class dx implements com.kwad.sdk.core.d<AdStyleInfo.PlayDetailInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static void a2(AdStyleInfo.PlayDetailInfo playDetailInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        playDetailInfo.type = jSONObject.optInt("type");
        AdStyleInfo.PlayDetailInfo.DetailWebCardInfo detailWebCardInfo = new AdStyleInfo.PlayDetailInfo.DetailWebCardInfo();
        playDetailInfo.detailWebCardInfo = detailWebCardInfo;
        detailWebCardInfo.parseJson(jSONObject.optJSONObject("detailWebCardInfo"));
        AdStyleInfo.PlayDetailInfo.DetailTopToolBarInfo detailTopToolBarInfo = new AdStyleInfo.PlayDetailInfo.DetailTopToolBarInfo();
        playDetailInfo.detailTopToolBarInfo = detailTopToolBarInfo;
        detailTopToolBarInfo.parseJson(jSONObject.optJSONObject("detailTopToolBarInfo"));
        AdStyleInfo.PlayDetailInfo.ActionBarInfo actionBarInfo = new AdStyleInfo.PlayDetailInfo.ActionBarInfo();
        playDetailInfo.actionBarInfo = actionBarInfo;
        actionBarInfo.parseJson(jSONObject.optJSONObject("actionBarInfo"));
        AdStyleInfo.PlayDetailInfo.PatchAdInfo patchAdInfo = new AdStyleInfo.PlayDetailInfo.PatchAdInfo();
        playDetailInfo.patchAdInfo = patchAdInfo;
        patchAdInfo.parseJson(jSONObject.optJSONObject("patchAdInfo"));
        AdStyleInfo.PlayDetailInfo.DetailCommonInfo detailCommonInfo = new AdStyleInfo.PlayDetailInfo.DetailCommonInfo();
        playDetailInfo.detailCommonInfo = detailCommonInfo;
        detailCommonInfo.parseJson(jSONObject.optJSONObject("detailCommonInfo"));
        AdStyleInfo.PlayDetailInfo.DrawAdInfo drawAdInfo = new AdStyleInfo.PlayDetailInfo.DrawAdInfo();
        playDetailInfo.drawAdInfo = drawAdInfo;
        drawAdInfo.parseJson(jSONObject.optJSONObject("drawAdInfo"));
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    public static JSONObject b2(AdStyleInfo.PlayDetailInfo playDetailInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.r.a(jSONObject, "type", playDetailInfo.type);
        com.kwad.sdk.utils.r.a(jSONObject, "detailWebCardInfo", playDetailInfo.detailWebCardInfo);
        com.kwad.sdk.utils.r.a(jSONObject, "detailTopToolBarInfo", playDetailInfo.detailTopToolBarInfo);
        com.kwad.sdk.utils.r.a(jSONObject, "actionBarInfo", playDetailInfo.actionBarInfo);
        com.kwad.sdk.utils.r.a(jSONObject, "patchAdInfo", playDetailInfo.patchAdInfo);
        com.kwad.sdk.utils.r.a(jSONObject, "detailCommonInfo", playDetailInfo.detailCommonInfo);
        com.kwad.sdk.utils.r.a(jSONObject, "drawAdInfo", playDetailInfo.drawAdInfo);
        return jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdStyleInfo.PlayDetailInfo playDetailInfo, JSONObject jSONObject) {
        a2(playDetailInfo, jSONObject);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.kwad.sdk.core.b, org.json.JSONObject] */
    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdStyleInfo.PlayDetailInfo playDetailInfo, JSONObject jSONObject) {
        return b2(playDetailInfo, jSONObject);
    }
}
