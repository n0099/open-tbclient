package com.kwad.sdk.core.response.model;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.b.d;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.utils.o;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class PhotoShareInfo extends BaseResultData implements com.kwad.sdk.core.b, Serializable {
    private static final long serialVersionUID = 1941263519515554943L;
    public ShareUrlInfo data = new ShareUrlInfo();

    /* loaded from: classes4.dex */
    public static class ShareUrlInfo implements com.kwad.sdk.core.b, Serializable {
        private static final long serialVersionUID = -7887599282226106153L;
        public String shareUrl;

        public void parseJson(@Nullable JSONObject jSONObject) {
            this.shareUrl = jSONObject.optString("shareUrl");
        }

        @Override // com.kwad.sdk.core.b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            o.a(jSONObject, "shareUrl", this.shareUrl);
            return jSONObject;
        }
    }

    public String getShareUrl() {
        return this.data != null ? this.data.shareUrl : "";
    }

    @Override // com.kwad.sdk.core.network.BaseResultData
    public boolean isDataEmpty() {
        return this.data == null;
    }

    @Override // com.kwad.sdk.core.network.BaseResultData
    public void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        try {
            this.data.parseJson(new JSONObject(d.b(jSONObject.optString("data"))));
        } catch (Exception e) {
            com.kwad.sdk.core.d.a.a(e);
        }
    }

    @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        o.a(json, "data", this.data);
        return json;
    }
}
