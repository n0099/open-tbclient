package com.kwad.sdk.core.response.model;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.o;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class PreloadData implements com.kwad.sdk.core.b, Serializable {
    public static final long serialVersionUID = 5545639829734330536L;
    public boolean isPreload = false;
    public long mCacheTime = 0;

    public void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.isPreload = jSONObject.optBoolean("isPreload");
        this.mCacheTime = jSONObject.optLong("mCacheTime");
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "isPreload", this.isPreload);
        o.a(jSONObject, "mCacheTime", this.mCacheTime);
        return jSONObject;
    }
}
