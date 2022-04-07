package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class da implements com.kwad.sdk.core.d<AdStyleInfo.PlayDetailInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(AdStyleInfo.PlayDetailInfo playDetailInfo, JSONObject jSONObject) {
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
        AdStyleInfo.PlayDetailInfo.WidgetAdInfo widgetAdInfo = new AdStyleInfo.PlayDetailInfo.WidgetAdInfo();
        playDetailInfo.widgetAdInfo = widgetAdInfo;
        widgetAdInfo.parseJson(jSONObject.optJSONObject("widgetAdInfo"));
        AdStyleInfo.PlayDetailInfo.DetailCommonInfo detailCommonInfo = new AdStyleInfo.PlayDetailInfo.DetailCommonInfo();
        playDetailInfo.detailCommonInfo = detailCommonInfo;
        detailCommonInfo.parseJson(jSONObject.optJSONObject("detailCommonInfo"));
        AdStyleInfo.PlayDetailInfo.DrawAdInfo drawAdInfo = new AdStyleInfo.PlayDetailInfo.DrawAdInfo();
        playDetailInfo.drawAdInfo = drawAdInfo;
        drawAdInfo.parseJson(jSONObject.optJSONObject("drawAdInfo"));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(AdStyleInfo.PlayDetailInfo playDetailInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "type", playDetailInfo.type);
        com.kwad.sdk.utils.t.a(jSONObject, "detailWebCardInfo", playDetailInfo.detailWebCardInfo);
        com.kwad.sdk.utils.t.a(jSONObject, "detailTopToolBarInfo", playDetailInfo.detailTopToolBarInfo);
        com.kwad.sdk.utils.t.a(jSONObject, "actionBarInfo", playDetailInfo.actionBarInfo);
        com.kwad.sdk.utils.t.a(jSONObject, "patchAdInfo", playDetailInfo.patchAdInfo);
        com.kwad.sdk.utils.t.a(jSONObject, "widgetAdInfo", playDetailInfo.widgetAdInfo);
        com.kwad.sdk.utils.t.a(jSONObject, "detailCommonInfo", playDetailInfo.detailCommonInfo);
        com.kwad.sdk.utils.t.a(jSONObject, "drawAdInfo", playDetailInfo.drawAdInfo);
        return jSONObject;
    }
}
