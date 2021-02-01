package com.kwad.sdk.core.response.model;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.b.d;
import com.kwad.sdk.core.b.e;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.utils.o;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class TrendListResultData extends BaseResultData implements com.kwad.sdk.core.b {
    private static final String TAG = "FeedResultData";
    private static final long serialVersionUID = -2356227162833699895L;
    @NonNull
    public List<TrendInfo> trends = new ArrayList();

    @Override // com.kwad.sdk.core.network.BaseResultData
    public boolean isDataEmpty() {
        if (this.trends.isEmpty()) {
            com.kwad.sdk.core.d.a.d(TAG, "trends list is empty");
            return true;
        }
        com.kwad.sdk.core.d.a.a(TAG, "trends size = " + this.trends.size());
        return false;
    }

    @Override // com.kwad.sdk.core.network.BaseResultData
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
            JSONArray jSONArray = new JSONObject(d.b(optString)).getJSONArray("trends");
            if (jSONArray.length() > 0) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    TrendInfo trendInfo = new TrendInfo();
                    trendInfo.parseJson(jSONArray.optJSONObject(i));
                    this.trends.add(trendInfo);
                }
            }
        } catch (Exception e) {
            com.kwad.sdk.core.d.a.a(e);
        }
    }

    @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        o.a(new JSONObject(), "trends", this.trends);
        return new JSONObject();
    }
}
