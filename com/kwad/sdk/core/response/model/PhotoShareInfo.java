package com.kwad.sdk.core.response.model;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.a.d;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.utils.t;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class PhotoShareInfo extends BaseResultData implements com.kwad.sdk.core.b, Serializable {
    public static final long serialVersionUID = 1941263519515554943L;
    public ShareUrlInfo data = new ShareUrlInfo();

    /* loaded from: classes3.dex */
    public static class ShareUrlInfo extends com.kwad.sdk.core.response.kwai.a implements Serializable {
        public static final long serialVersionUID = -7887599282226106153L;
        public String mediaShareItem;
        public String shareUrl;
    }

    public String getMediaShareItem() {
        ShareUrlInfo shareUrlInfo = this.data;
        return shareUrlInfo != null ? shareUrlInfo.mediaShareItem : "";
    }

    public String getShareUrl() {
        ShareUrlInfo shareUrlInfo = this.data;
        return shareUrlInfo != null ? shareUrlInfo.shareUrl : "";
    }

    @Override // com.kwad.sdk.core.network.BaseResultData
    public boolean isDataEmpty() {
        return this.data == null;
    }

    @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            this.data.parseJson(new JSONObject(d.b(jSONObject.optString("data"))));
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        t.a(json, "data", this.data);
        return json;
    }
}
