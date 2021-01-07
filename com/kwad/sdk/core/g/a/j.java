package com.kwad.sdk.core.g.a;

import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.o;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class j implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public boolean f9473a;

    /* renamed from: b  reason: collision with root package name */
    public int f9474b;
    public int c;
    public List<Long> d;

    public j() {
        this.d = new ArrayList();
    }

    public j(int i) {
        this.d = new ArrayList();
        this.f9473a = true;
        this.f9474b = i;
    }

    public j(List<AdTemplate> list) {
        this.d = new ArrayList();
        this.f9473a = false;
        if (list != null) {
            this.c = list.size();
            for (AdTemplate adTemplate : list) {
                this.d.add(Long.valueOf(com.kwad.sdk.core.response.b.c.z(adTemplate)));
            }
        }
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "preload", this.f9473a);
        if (this.f9473a) {
            o.a(jSONObject, "requestVideoCount", this.f9474b);
        } else {
            o.a(jSONObject, "preloadedVideoCount", this.c);
            JSONArray jSONArray = new JSONArray();
            for (Long l : this.d) {
                jSONArray.put(l);
            }
            o.a(jSONObject, "preloadedVideoList", jSONArray);
        }
        return jSONObject;
    }
}
