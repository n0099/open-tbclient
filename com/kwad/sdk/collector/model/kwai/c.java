package com.kwad.sdk.collector.model.kwai;

import androidx.annotation.Nullable;
import com.kwad.sdk.utils.t;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c implements com.kwad.sdk.collector.model.d {
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public List<String> f39248b = new ArrayList();

    public String a() {
        return this.a;
    }

    public List<String> b() {
        return this.f39248b;
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
                this.f39248b.clear();
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    this.f39248b.add(optJSONArray.getString(i));
                }
            }
        } catch (Exception e2) {
            com.kwad.sdk.crash.a.a(e2);
            com.kwad.sdk.core.d.a.a(e2);
        }
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.a(jSONObject, "packageName", this.a);
        t.a(jSONObject, "paths", this.f39248b);
        return jSONObject;
    }
}
