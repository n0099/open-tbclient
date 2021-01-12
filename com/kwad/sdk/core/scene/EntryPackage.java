package com.kwad.sdk.core.scene;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.utils.o;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class EntryPackage extends URLPackage {
    private static final long serialVersionUID = 8251709184937662571L;
    public String entryId;
    public String entryPageSource;

    public EntryPackage() {
        this.entryPageSource = "unknown";
    }

    public EntryPackage(@NonNull String str, int i) {
        super(str, i);
        this.entryPageSource = "unknown";
    }

    @Override // com.kwad.sdk.core.scene.URLPackage
    public void parseJson(@Nullable JSONObject jSONObject) {
        super.parseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        this.entryPageSource = jSONObject.optString("entryPageSource");
        this.entryId = jSONObject.optString("entryId");
    }

    @Override // com.kwad.sdk.core.scene.URLPackage, com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject json = super.toJson();
        o.a(json, "entryPageSource", this.entryPageSource);
        o.a(json, "entryId", this.entryId);
        return json;
    }
}
