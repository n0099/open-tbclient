package com.kwad.sdk.live.mode;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.utils.t;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class LiveInfoResultData extends BaseResultData {
    public static final long serialVersionUID = -2695767546208947458L;
    public List<LiveInfo> liveInfoList = new ArrayList();
    public String pcursor;

    @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        this.pcursor = jSONObject.optString("pcursor");
        JSONArray optJSONArray = jSONObject.optJSONArray("feeds");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return;
        }
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
            if (optJSONObject != null) {
                LiveInfo liveInfo = new LiveInfo();
                liveInfo.pcursor = this.pcursor;
                liveInfo.parseJson(optJSONObject);
                this.liveInfoList.add(liveInfo);
            }
        }
    }

    @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        t.a(json, "pcursor", this.pcursor);
        t.a(json, "feeds", this.liveInfoList);
        return json;
    }
}
