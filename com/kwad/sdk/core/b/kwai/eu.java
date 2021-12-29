package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class eu implements com.kwad.sdk.core.d<AdStyleInfo.PlayDetailInfo.WidgetAdInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(AdStyleInfo.PlayDetailInfo.WidgetAdInfo widgetAdInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        widgetAdInfo.widgetAdIcon = jSONObject.optString("widgetAdIcon");
        if (jSONObject.opt("widgetAdIcon") == JSONObject.NULL) {
            widgetAdInfo.widgetAdIcon = "";
        }
        widgetAdInfo.downloadStartLabel = jSONObject.optString("downloadStartLabel", new String("开始下载"));
        widgetAdInfo.downloadOngoingLabel = jSONObject.optString("downloadOngoingLabel", new String("下载中"));
        widgetAdInfo.downloadResumeLabel = jSONObject.optString("downloadResumeLabel", new String("恢复下载"));
        widgetAdInfo.installAppLabel = jSONObject.optString("installAppLabel", new String("开始安装"));
        widgetAdInfo.openAppLabel = jSONObject.optString("openAppLabel", new String("立刻打开"));
        widgetAdInfo.type = jSONObject.optInt("type");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(AdStyleInfo.PlayDetailInfo.WidgetAdInfo widgetAdInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "widgetAdIcon", widgetAdInfo.widgetAdIcon);
        com.kwad.sdk.utils.t.a(jSONObject, "downloadStartLabel", widgetAdInfo.downloadStartLabel);
        com.kwad.sdk.utils.t.a(jSONObject, "downloadOngoingLabel", widgetAdInfo.downloadOngoingLabel);
        com.kwad.sdk.utils.t.a(jSONObject, "downloadResumeLabel", widgetAdInfo.downloadResumeLabel);
        com.kwad.sdk.utils.t.a(jSONObject, "installAppLabel", widgetAdInfo.installAppLabel);
        com.kwad.sdk.utils.t.a(jSONObject, "openAppLabel", widgetAdInfo.openAppLabel);
        com.kwad.sdk.utils.t.a(jSONObject, "type", widgetAdInfo.type);
        return jSONObject;
    }
}
