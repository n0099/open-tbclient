package com.kwad.sdk.core.response.kwai;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.b;
import com.kwad.sdk.core.b.kwai.cf;
import com.kwad.sdk.core.d;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a implements b {
    public List<d<a>> mHolders;

    private List<d<a>> getHolders() {
        if (this.mHolders == null) {
            this.mHolders = new ArrayList();
            for (Class<?> cls = getClass(); cls != null && a.class.isAssignableFrom(cls); cls = cls.getSuperclass()) {
                d<a> a = cf.a(cls);
                if (a != null) {
                    this.mHolders.add(0, a);
                }
            }
        }
        return this.mHolders;
    }

    public void afterParseJson(@Nullable JSONObject jSONObject) {
    }

    public void afterToJson(JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        List<d<a>> holders = getHolders();
        for (int size = holders.size() - 1; size >= 0; size--) {
            holders.get(size).a(this, jSONObject);
        }
        afterParseJson(jSONObject);
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        List<d<a>> holders = getHolders();
        JSONObject jSONObject = new JSONObject();
        for (int size = holders.size() - 1; size >= 0; size--) {
            holders.get(size).b(this, jSONObject);
        }
        afterToJson(jSONObject);
        return jSONObject;
    }
}
