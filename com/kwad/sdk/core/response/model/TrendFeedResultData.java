package com.kwad.sdk.core.response.model;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.b.d;
import com.kwad.sdk.core.b.e;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.o;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class TrendFeedResultData extends BaseResultData implements com.kwad.sdk.core.b {
    public static final String TAG = "TrendsResultData";
    public static final long serialVersionUID = -1619392774105464372L;
    @NonNull
    public List<AdTemplate> adTemplateList = new ArrayList();
    public final SceneImpl mRequestAdScene;
    public final TrendInfo mTrendInfo;

    public TrendFeedResultData(@NonNull SceneImpl sceneImpl, @NonNull TrendInfo trendInfo) {
        this.mRequestAdScene = sceneImpl;
        this.mTrendInfo = trendInfo;
    }

    public boolean isAdResultDataEmpty() {
        String str;
        if (this.adTemplateList.isEmpty()) {
            str = "adTemplateList is empty";
        } else {
            com.kwad.sdk.core.d.a.a(TAG, "adTemplateList size = " + this.adTemplateList.size());
            List<AdInfo> list = this.adTemplateList.get(0).adInfoList;
            if (list.isEmpty()) {
                str = "adInfoList is empty";
            } else if (list.get(0) != null) {
                return false;
            } else {
                str = "adInfo is null";
            }
        }
        com.kwad.sdk.core.d.a.d(TAG, str);
        return true;
    }

    @Override // com.kwad.sdk.core.network.BaseResultData
    public boolean isDataEmpty() {
        if (this.adTemplateList.isEmpty()) {
            com.kwad.sdk.core.d.a.d(TAG, "adTemplateList is empty");
            return true;
        }
        return false;
    }

    @Override // com.kwad.sdk.core.network.BaseResultData
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
                    if (adTemplate.photoInfo != null) {
                        adTemplate.photoInfo.trendInfo = this.mTrendInfo;
                    }
                    adTemplate.mAdScene = this.mRequestAdScene;
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
        o.a(json, "impAdInfo", this.adTemplateList);
        return json;
    }
}
