package com.kwad.sdk.core.g.a;

import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.o;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class j implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public boolean f34295a;

    /* renamed from: b  reason: collision with root package name */
    public int f34296b;

    /* renamed from: c  reason: collision with root package name */
    public int f34297c;

    /* renamed from: d  reason: collision with root package name */
    public List<Long> f34298d;

    public j() {
        this.f34298d = new ArrayList();
    }

    public j(int i2) {
        this.f34298d = new ArrayList();
        this.f34295a = true;
        this.f34296b = i2;
    }

    public j(List<AdTemplate> list) {
        this.f34298d = new ArrayList();
        this.f34295a = false;
        if (list != null) {
            this.f34297c = list.size();
            for (AdTemplate adTemplate : list) {
                this.f34298d.add(Long.valueOf(com.kwad.sdk.core.response.b.c.z(adTemplate)));
            }
        }
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "preload", this.f34295a);
        if (this.f34295a) {
            o.a(jSONObject, "requestVideoCount", this.f34296b);
        } else {
            o.a(jSONObject, "preloadedVideoCount", this.f34297c);
            JSONArray jSONArray = new JSONArray();
            for (Long l : this.f34298d) {
                jSONArray.put(l);
            }
            o.a(jSONObject, "preloadedVideoList", jSONArray);
        }
        return jSONObject;
    }
}
