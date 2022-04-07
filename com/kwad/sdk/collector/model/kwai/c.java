package com.kwad.sdk.collector.model.kwai;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.t;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c implements com.kwad.sdk.collector.model.d {
    public String a;
    public List<String> b = new ArrayList();

    public String a() {
        return this.a;
    }

    public List<String> b() {
        return this.b;
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.a = jSONObject.optString("packageName");
            JSONArray optJSONArray = jSONObject.optJSONArray("paths");
            if (optJSONArray != null) {
                this.b.clear();
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    this.b.add(optJSONArray.getString(i));
                }
            }
        } catch (Exception e) {
            com.kwad.sdk.crash.a.a(e);
            com.kwad.sdk.core.d.a.a(e);
        }
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.a(jSONObject, "packageName", this.a);
        t.a(jSONObject, "paths", this.b);
        return jSONObject;
    }
}
