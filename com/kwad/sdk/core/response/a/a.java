package com.kwad.sdk.core.response.a;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.b;
import com.kwad.sdk.core.c;
import com.kwad.sdk.core.c.a.al;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a implements b {
    public List<c<a>> mHolders;

    private List<c<a>> getHolders() {
        if (this.mHolders == null) {
            this.mHolders = new ArrayList();
            for (Class<?> cls = getClass(); cls != null && a.class.isAssignableFrom(cls); cls = cls.getSuperclass()) {
                c<a> a2 = al.a(cls);
                if (a2 != null) {
                    this.mHolders.add(0, a2);
                }
            }
        }
        return this.mHolders;
    }

    public void afterParseJson(@Nullable JSONObject jSONObject) {
    }

    public void afterToJson(JSONObject jSONObject) {
    }

    public void parseJson(@Nullable JSONObject jSONObject) {
        for (c<a> cVar : getHolders()) {
            cVar.a(this, jSONObject);
        }
        afterParseJson(jSONObject);
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        List<c<a>> holders = getHolders();
        JSONObject jSONObject = new JSONObject();
        for (c<a> cVar : holders) {
            cVar.b(this, jSONObject);
        }
        afterToJson(jSONObject);
        return jSONObject;
    }
}
