package com.kwad.sdk.core.scene;

import com.kwad.sdk.utils.r;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class EntryPackage extends URLPackage {
    public static final long serialVersionUID = 8251709184937662571L;
    public String entryId;
    public String entryPageSource;

    public EntryPackage() {
        this.entryPageSource = "unknown";
    }

    public EntryPackage(String str, int i) {
        super(str, i);
        this.entryPageSource = "unknown";
    }

    @Override // com.kwad.sdk.core.response.kwai.a, com.kwad.sdk.core.b
    public void parseJson(JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        this.entryPageSource = jSONObject.optString("entryPageSource");
        this.entryId = jSONObject.optString("entryId");
    }

    @Override // com.kwad.sdk.core.response.kwai.a, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        r.putValue(json, "entryPageSource", this.entryPageSource);
        r.putValue(json, "entryId", this.entryId);
        return json;
    }
}
