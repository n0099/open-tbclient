package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.PhotoAd;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class cx implements com.kwad.sdk.core.d<PhotoAd> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(PhotoAd photoAd, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        photoAd.requestPatchAd = jSONObject.optBoolean("requestPatchAd", new Boolean("false").booleanValue());
        photoAd.requestPatchEc = jSONObject.optBoolean("requestPatchEc", new Boolean("false").booleanValue());
        photoAd.widgetAdPosition = jSONObject.optInt("widgetAdPosition");
        photoAd.requestWidgetAd = jSONObject.optBoolean("requestWidgetAd", new Boolean("false").booleanValue());
        photoAd.requestBannerAd = jSONObject.optBoolean("requestBannerAd", new Boolean("false").booleanValue());
        photoAd.requestAggregateAd = jSONObject.optBoolean("requestAggregateAd", new Boolean("false").booleanValue());
        photoAd.requestDynamicRewardAd = jSONObject.optBoolean("requestDynamicRewardAd", new Boolean("true").booleanValue());
        photoAd.requestInsertScreenAd = jSONObject.optBoolean("requestInsertScreenAd", new Boolean("false").booleanValue());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(PhotoAd photoAd, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "requestPatchAd", photoAd.requestPatchAd);
        com.kwad.sdk.utils.t.a(jSONObject, "requestPatchEc", photoAd.requestPatchEc);
        com.kwad.sdk.utils.t.a(jSONObject, "widgetAdPosition", photoAd.widgetAdPosition);
        com.kwad.sdk.utils.t.a(jSONObject, "requestWidgetAd", photoAd.requestWidgetAd);
        com.kwad.sdk.utils.t.a(jSONObject, "requestBannerAd", photoAd.requestBannerAd);
        com.kwad.sdk.utils.t.a(jSONObject, "requestAggregateAd", photoAd.requestAggregateAd);
        com.kwad.sdk.utils.t.a(jSONObject, "requestDynamicRewardAd", photoAd.requestDynamicRewardAd);
        com.kwad.sdk.utils.t.a(jSONObject, "requestInsertScreenAd", photoAd.requestInsertScreenAd);
        return jSONObject;
    }
}
