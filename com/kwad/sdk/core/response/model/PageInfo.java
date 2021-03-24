package com.kwad.sdk.core.response.model;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.o;
import java.io.Serializable;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class PageInfo implements com.kwad.sdk.core.b, Serializable {
    public static final long serialVersionUID = -86839485012202592L;
    public int pageType;

    public void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.pageType = jSONObject.optInt("pageType");
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "pageType", this.pageType);
        return jSONObject;
    }
}
