package com.kwad.sdk.core.response.model;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.a.d;
import com.kwad.sdk.core.a.e;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.utils.t;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class HotspotListResultData extends BaseResultData implements com.kwad.sdk.core.b {
    public static final String TAG = "HotspotListResultData";
    public static final long serialVersionUID = 5203393014166710381L;
    public final HotspotListData hotspotListData = new HotspotListData();

    @Override // com.kwad.sdk.core.network.BaseResultData
    public boolean isDataEmpty() {
        if (this.hotspotListData.trends.isEmpty()) {
            com.kwad.sdk.core.d.a.e(TAG, "trends list is empty");
            return true;
        }
        return false;
    }

    @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("data");
        e.a(jSONObject.optString("egid"));
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        try {
            this.hotspotListData.parseJson(new JSONObject(d.b(optString)));
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        t.a(new JSONObject(), "data", this.hotspotListData);
        return new JSONObject();
    }
}
