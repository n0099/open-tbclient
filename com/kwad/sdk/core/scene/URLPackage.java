package com.kwad.sdk.core.scene;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.b;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.o;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class URLPackage implements b, Serializable {
    public static final String KEY_AUTHOR_ID = "authorId";
    public static final String KEY_TREND_ID = "trendId";
    public static final String KEY_TUBE_ID = "tubeId";
    public static final long serialVersionUID = -7365796297335816787L;
    public String identity;
    public transient JSONObject mJsonObjectParams;
    public int page;
    public String params;

    public URLPackage() {
    }

    public URLPackage(@NonNull String str, int i) {
        this.page = i;
        this.identity = str;
    }

    public void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.page = jSONObject.optInt("page");
        this.identity = jSONObject.optString("identity");
        String optString = jSONObject.optString("params");
        this.params = optString;
        try {
            if (ag.a(optString)) {
                return;
            }
            this.mJsonObjectParams = new JSONObject(this.params);
        } catch (JSONException unused) {
        }
    }

    public void putParams(String str, long j) {
        if (this.mJsonObjectParams == null) {
            this.mJsonObjectParams = new JSONObject();
        }
        o.a(this.mJsonObjectParams, str, j);
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "page", this.page);
        o.a(jSONObject, "identity", this.identity);
        JSONObject jSONObject2 = this.mJsonObjectParams;
        if (jSONObject2 != null) {
            o.a(jSONObject, "params", jSONObject2.toString());
        }
        return jSONObject;
    }
}
