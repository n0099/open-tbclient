package com.kwad.sdk.core.g.a;

import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.o;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class j implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public boolean f34393a;

    /* renamed from: b  reason: collision with root package name */
    public int f34394b;

    /* renamed from: c  reason: collision with root package name */
    public int f34395c;

    /* renamed from: d  reason: collision with root package name */
    public List<Long> f34396d;

    public j() {
        this.f34396d = new ArrayList();
    }

    public j(int i2) {
        this.f34396d = new ArrayList();
        this.f34393a = true;
        this.f34394b = i2;
    }

    public j(List<AdTemplate> list) {
        this.f34396d = new ArrayList();
        this.f34393a = false;
        if (list != null) {
            this.f34395c = list.size();
            for (AdTemplate adTemplate : list) {
                this.f34396d.add(Long.valueOf(com.kwad.sdk.core.response.b.c.z(adTemplate)));
            }
        }
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "preload", this.f34393a);
        if (this.f34393a) {
            o.a(jSONObject, "requestVideoCount", this.f34394b);
        } else {
            o.a(jSONObject, "preloadedVideoCount", this.f34395c);
            JSONArray jSONArray = new JSONArray();
            for (Long l : this.f34396d) {
                jSONArray.put(l);
            }
            o.a(jSONObject, "preloadedVideoList", jSONArray);
        }
        return jSONObject;
    }
}
