package com.kwad.sdk.core.scene;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.o;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class URLPackage extends com.kwad.sdk.core.response.a.a implements Serializable {
    public static final String KEY_AUTHOR_ID = "authorId";
    public static final String KEY_TREND_ID = "trendId";
    public static final String KEY_TUBE_ID = "tubeId";
    public static final long serialVersionUID = -7365796297335816787L;
    public String identity;
    public transient JSONObject mJsonObjectParams;
    public int page;

    public URLPackage() {
    }

    public URLPackage(@NonNull String str, int i2) {
        this.page = i2;
        this.identity = str;
    }

    @Override // com.kwad.sdk.core.response.a.a
    public void afterParseJson(@Nullable JSONObject jSONObject) {
        super.afterParseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("params");
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        try {
            this.mJsonObjectParams = new JSONObject(optString);
        } catch (JSONException e2) {
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    @Override // com.kwad.sdk.core.response.a.a
    public void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        JSONObject jSONObject2 = this.mJsonObjectParams;
        if (jSONObject2 != null) {
            o.a(jSONObject, "params", jSONObject2.toString());
        }
    }

    public void putParams(String str, long j) {
        if (this.mJsonObjectParams == null) {
            this.mJsonObjectParams = new JSONObject();
        }
        o.a(this.mJsonObjectParams, str, j);
    }
}
