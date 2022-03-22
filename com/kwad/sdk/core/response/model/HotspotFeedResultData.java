package com.kwad.sdk.core.response.model;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.a.d;
import com.kwad.sdk.core.a.e;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.t;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class HotspotFeedResultData extends BaseResultData implements com.kwad.sdk.core.b {
    public static final String TAG = "TrendsResultData";
    public static final long serialVersionUID = -1619392774105464372L;
    @NonNull
    public List<AdTemplate> adTemplateList = new ArrayList();
    public final HotspotInfo mHotspotInfo;
    public final SceneImpl mScene;

    public HotspotFeedResultData(@NonNull SceneImpl sceneImpl, @NonNull HotspotInfo hotspotInfo) {
        this.mScene = sceneImpl;
        this.mHotspotInfo = hotspotInfo;
    }

    @Override // com.kwad.sdk.core.network.BaseResultData
    public boolean isDataEmpty() {
        if (this.adTemplateList.isEmpty()) {
            com.kwad.sdk.core.d.a.e(TAG, "adTemplateList is empty");
            return true;
        }
        return false;
    }

    @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        e.a(jSONObject.optString("egid"));
        try {
            JSONObject jSONObject2 = new JSONObject(d.b(jSONObject.optString("data")));
            long optLong = jSONObject2.optLong("llsid");
            String optString = jSONObject2.optString("extra");
            JSONArray optJSONArray = jSONObject2.optJSONArray("feeds");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                return;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    AdTemplate adTemplate = new AdTemplate();
                    adTemplate.parseJson(optJSONObject);
                    adTemplate.llsid = optLong;
                    adTemplate.extra = optString;
                    adTemplate.photoInfo.mHotspotInfo = this.mHotspotInfo;
                    adTemplate.mAdScene = this.mScene;
                    this.adTemplateList.add(adTemplate);
                }
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        t.a(json, "impAdInfo", this.adTemplateList);
        return json;
    }
}
