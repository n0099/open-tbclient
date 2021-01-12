package com.kwad.sdk.core.scene;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.b;
import com.kwad.sdk.utils.ag;
import com.kwad.sdk.utils.o;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class URLPackage implements b, Serializable {
    public static final String KEY_AUTHOR_ID = "authorId";
    public static final String KEY_TREND_ID = "trendId";
    public static final String KEY_TUBE_ID = "tubeId";
    private static final long serialVersionUID = -7365796297335816787L;
    public String identity;
    private transient JSONObject mJsonObjectParams;
    public int page;
    private String params;

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
        this.params = jSONObject.optString("params");
        try {
            if (ag.a(this.params)) {
                return;
            }
            this.mJsonObjectParams = new JSONObject(this.params);
        } catch (JSONException e) {
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
        if (this.mJsonObjectParams != null) {
            o.a(jSONObject, "params", this.mJsonObjectParams.toString());
        }
        return jSONObject;
    }
}
