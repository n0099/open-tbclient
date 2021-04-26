package com.kwad.sdk.core.c.a;

import com.kwad.sdk.core.response.model.PhotoShareInfo;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class bf implements com.kwad.sdk.core.c<PhotoShareInfo.ShareUrlInfo> {
    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public void a(PhotoShareInfo.ShareUrlInfo shareUrlInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        shareUrlInfo.shareUrl = jSONObject.optString("shareUrl");
        shareUrlInfo.mediaShareItem = jSONObject.optString("mediaShareItem");
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.core.c
    public JSONObject b(PhotoShareInfo.ShareUrlInfo shareUrlInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        com.kwad.sdk.utils.o.a(jSONObject, "shareUrl", shareUrlInfo.shareUrl);
        com.kwad.sdk.utils.o.a(jSONObject, "mediaShareItem", shareUrlInfo.mediaShareItem);
        return jSONObject;
    }
}
