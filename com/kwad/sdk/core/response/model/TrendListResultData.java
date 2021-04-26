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
/* loaded from: classes6.dex */
public class TrendListResultData extends BaseResultData implements com.kwad.sdk.core.b {
    public static final String TAG = "FeedResultData";
    public static final long serialVersionUID = -2356227162833699895L;
    @NonNull
    public List<TrendInfo> trends = new ArrayList();

    @Override // com.kwad.sdk.core.network.BaseResultData
    public boolean isDataEmpty() {
        if (this.trends.isEmpty()) {
            com.kwad.sdk.core.d.a.e(TAG, "trends list is empty");
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
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    TrendInfo trendInfo = new TrendInfo();
                    trendInfo.parseJson(jSONArray.optJSONObject(i2));
                    this.trends.add(trendInfo);
                }
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    @Override // com.kwad.sdk.core.network.BaseResultData, com.kwad.sdk.core.b
    public JSONObject toJson() {
        o.a(new JSONObject(), "trends", this.trends);
        return new JSONObject();
    }
}
