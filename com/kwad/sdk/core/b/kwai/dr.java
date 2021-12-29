package com.kwad.sdk.core.b.kwai;

import com.kwad.sdk.core.response.model.PhotoShareInfo;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class dr implements com.kwad.sdk.core.d<PhotoShareInfo.ShareUrlInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public void a(PhotoShareInfo.ShareUrlInfo shareUrlInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        shareUrlInfo.shareUrl = jSONObject.optString("shareUrl");
        if (jSONObject.opt("shareUrl") == JSONObject.NULL) {
            shareUrlInfo.shareUrl = "";
        }
        shareUrlInfo.mediaShareItem = jSONObject.optString("mediaShareItem");
        if (jSONObject.opt("mediaShareItem") == JSONObject.NULL) {
            shareUrlInfo.mediaShareItem = "";
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.d
    public JSONObject b(PhotoShareInfo.ShareUrlInfo shareUrlInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject, "shareUrl", shareUrlInfo.shareUrl);
        com.kwad.sdk.utils.t.a(jSONObject, "mediaShareItem", shareUrlInfo.mediaShareItem);
        return jSONObject;
    }
}
