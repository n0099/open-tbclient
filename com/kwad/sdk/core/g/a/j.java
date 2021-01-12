package com.kwad.sdk.core.g.a;

import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.o;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class j implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public boolean f9173a;

    /* renamed from: b  reason: collision with root package name */
    public int f9174b;
    public int c;
    public List<Long> d;

    public j() {
        this.d = new ArrayList();
    }

    public j(int i) {
        this.d = new ArrayList();
        this.f9173a = true;
        this.f9174b = i;
    }

    public j(List<AdTemplate> list) {
        this.d = new ArrayList();
        this.f9173a = false;
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
        o.a(jSONObject, "preload", this.f9173a);
        if (this.f9173a) {
            o.a(jSONObject, "requestVideoCount", this.f9174b);
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
